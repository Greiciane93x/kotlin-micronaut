package br.com.zup.ane.autores

import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Post
import io.micronaut.validation.Validated
import javax.inject.Inject
import javax.validation.Valid

@Validated
@Controller("/autores")
class CadastroAutorController(@Inject val autorRepository: AutorRepository) {


    @Post
    fun cadastra(@Body @Valid form: NovoAutorForm ){
        println("Requisição: ${form}")
        val autor = form.converterParaAutor()
        autorRepository.save(autor)
        println("Autor: ${autor.nome}")
    }
}