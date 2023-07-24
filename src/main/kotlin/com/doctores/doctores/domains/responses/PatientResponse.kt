package com.doctores.doctores.domains.responses
import com.doctores.doctores.domains.entity.Patient

data class PatientResponse (
        val message: String?,
        val patient: Patient? = null,
)
