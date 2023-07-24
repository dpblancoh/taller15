package com.doctores.doctores.domains.request

import org.jetbrains.annotations.NotNull

data class PatientRequest (
    @field:NotNull("Cedula is required")
    val nombre: String,
    val apellido: String,
    val identificacion: String,
    val telefono: Long,
)
