package br.com.zup.ane.autores

import io.micronaut.core.annotation.Introspected
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

@Introspected // o micronaut vai conseguir acessar o código da classe no momento de compilação
data class NovoAutorForm(
    @field:NotBlank val nome: String,
    @field:NotBlank @field:Email val email: String,
    @field:NotBlank @field:Size(max = 400) val descricao: String,
    @field:NotBlank val cep: String,
    @field:NotBlank val numero: String) {

    fun  converterParaAutor(enderecoDto: EnderecoDto): Autor {
        val endereco = Endereco(enderecoDto, numero, cep)
        return Autor(nome, email, descricao, endereco)
    }
}