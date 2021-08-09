package br.com.zup.ane.autores

class DetalhesDoAutorResponse (autor: Autor){
    val nome = autor.nome
    val email = autor.email
    val descricao = autor.descricao
}
