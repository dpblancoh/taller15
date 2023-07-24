package com.doctores.doctores.repositories

import com.doctores.doctores.domains.entity.Doctor
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional

@Repository
interface DoctorRepository : JpaRepository<Doctor, Long> {
}