package com.doctores.doctores.domains.responses

import com.doctores.doctores.domains.entity.Doctor
data class DoctorResponse(
    val message: String?,
    val doctor: Doctor? = null,
)
