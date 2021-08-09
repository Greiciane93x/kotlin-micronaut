package br.com.zup.ane.autores

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository

@Repository
interface AutorRepository: JpaRepository<Autor, Long>