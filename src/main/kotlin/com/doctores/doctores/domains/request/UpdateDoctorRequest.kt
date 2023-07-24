package com.doctores.doctores.domains.request

data class UpdateDoctorRequest (
    val nombre: String?,
    val apellido: String?,
    val especialidad: String?,
    val consultorio: Long?,
    val correo: String?
)