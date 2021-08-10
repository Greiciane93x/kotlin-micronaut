package br.com.zup.ane.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.http.uri.UriBuilder
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastroAutorController(@Inject val autorRepository: AutorRepository,
                              @Inject val enderecoClient: EnderecoClient) {

    @Post
    fun cadastra(@Body @Valid form:NovoAutorForm ):HttpResponse<Any>{
        val enderecoDto: HttpResponse<EnderecoDto> = enderecoClient.consulta(form.cep)
        val autor = form.converterParaAutor(enderecoDto.body()!!)
        autorRepository.save(autor)
        val uri = UriBuilder.of("/autores/{id}")
            .expand(mutableMapOf(Pair("id", autor.id)))

        return HttpResponse.created(uri)
    }
}