package br.com.zup.ane.autores

import javax.persistence.Embeddable

@Embeddable
class Endereco(
    enderecoDto: EnderecoDto,
    val numero: String,
    val cep: String
) {


}
