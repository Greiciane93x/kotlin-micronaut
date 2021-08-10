package br.com.zup.ane.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.validation.Validated
import javax.transaction.Transactional
import javax.validation.constraints.NotBlank


@Controller("/autores")
@Validated
class BuscaDetalheDeAutoresController (val autorRepository: AutorRepository){

    @Get
    @Transactional
    fun lista(@NotBlank @QueryValue(defaultValue ="") email: String ) : HttpResponse<Any> {

        if(email.isBlank()){
            val autores = autorRepository.findAll()
            val resposta = autores.map { autor -> DetalhesDoAutorResponse(autor)}
            return HttpResponse.ok()
        }
        val possivelAutor = autorRepository.findByEmail(email)
        if(possivelAutor.isEmpty){
            return HttpResponse.notFound()
        }
        val autor = possivelAutor.get()
        return HttpResponse.ok(DetalhesDoAutorResponse(autor))
    }
}