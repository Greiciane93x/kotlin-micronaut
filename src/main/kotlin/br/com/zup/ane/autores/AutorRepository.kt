package br.com.zup.ane.autores

import io.micronaut.data.annotation.Repository
import io.micronaut.data.jpa.repository.JpaRepository
import java.util.*

@Repository
interface AutorRepository: JpaRepository<Autor, Long> {
//    @Query("SELECT a FROM Autor a WHERE a.email = :email")
//    fun buscaPorEmail(email: String) : Optional<0Autor>

    fun findByEmail(email: String): Optional<Autor>
}