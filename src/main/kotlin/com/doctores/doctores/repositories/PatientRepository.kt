package com.doctores.doctores.repositories

import com.doctores.doctores.domains.entity.Patient
import org.springframework.transaction.annotation.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation

@Repository
interface PatientRepository: JpaRepository<Patient, Long> {
    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Query("select * from pacientes where id_paciente = :id", nativeQuery = true)
    fun getPatientById(id:Long): List<Patient>

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
    @Query("select * from pacientes where identificacion=:identificacion", nativeQuery = true)
    fun getPatientByIdentificacion(identificacion:String): Patient

}