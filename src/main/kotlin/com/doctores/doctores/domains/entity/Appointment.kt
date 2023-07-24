package com.doctores.doctores.domains.entity

import jakarta.persistence.*

@Entity
@Table(name="citas")
open class Appointment (
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name=" id_cita")
        open var idcita: Long=1,

        @Column(name="horario")
        open var horario: String,

        @Column(name="especialidad")
        open var especialidad: String,

        @Column(name="id_doctor")
        open var doc: Long,

        @Column(name="identificacion_paciente")
        open var idPac: String,


)