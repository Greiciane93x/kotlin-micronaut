package br.com.zup.ane.autores

import io.micronaut.http.HttpResponse
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.QueryValue
import io.micronaut.http.client.annotation.Client


@Client("https://viacep.com.br/ws")
interface EnderecoClient {

    @Get("/{cep}/json")
    fun consulta(@QueryValue cep: String) : HttpResponse<EnderecoDto>
}
