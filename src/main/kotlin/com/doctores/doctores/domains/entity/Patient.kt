package com.doctores.doctores.domains.entity


import jakarta.persistence.*
import jakarta.persistence.Id
import jakarta.persistence.Entity
import java.time.Instant

@Entity
@Table(name="pacientes")
open class Patient (
    @Id
    @Column(name="id_paciente")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    open var idpaciente: Long=0,

    @Column(name = "nombre")
    open var nombre: String,

    @Column(name = "apellido")
    open var apellido: String,

    @Column(name = "identificacion")
    open var identificacion: String,

    @Column(name = "telefono")
    open var telefono: Long? = null,
)

