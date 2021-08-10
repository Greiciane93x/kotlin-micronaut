package br.com.zup.ane.autores

import org.hibernate.annotations.CreationTimestamp
import java.time.LocalDateTime
import javax.persistence.Embedded
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity
class Autor (val nome: String,
             val email: String,
             var descricao: String,
             @field: Embedded val endereco: Endereco
){
    @Id
    @GeneratedValue
    var id: Long? = null

    @CreationTimestamp
    val criadoEm: LocalDateTime = LocalDateTime.now()

}