package com.doctores.doctores.domains.request

data class UpdatePatientRequest (
    val nombre: String?,
    val apellido: String?,
    val identificacion: String?,
    val telefono: Long?,
)
