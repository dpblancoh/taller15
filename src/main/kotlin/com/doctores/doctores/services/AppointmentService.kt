package com.doctores.doctores.services

import com.doctores.doctores.domains.entity.Appointment
import com.doctores.doctores.domains.request.CreateAppointmentRequest
import com.doctores.doctores.domains.request.UpdateAppointmentRequest
import com.doctores.doctores.domains.responses.CreateAppointmentResponse
import com.doctores.doctores.repositories.AppointmentRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.dao.EmptyResultDataAccessException
import org.springframework.data.repository.findByIdOrNull
import org.springframework.stereotype.Service

@Service
class AppointmentService {
    @Autowired
    private lateinit var patientService: PatientService

    @Autowired
    private lateinit var doctorService: DoctorService

    @Autowired
    private lateinit var appointmentRepository: AppointmentRepository

    fun createAppointment(request: CreateAppointmentRequest): String {
        try {
            var doctor = doctorService.getDoctorById(request.idDoctor)
            var patient = patientService.getPatientByIdentificacion(request.idPaciente)
            val especialidad = appointmentRepository.getDoctorEspecialidad(request.idDoctor)
            if (especialidad.equals(request.especialidad)) {
                val appointment = appointmentRepository.save(
                    Appointment(
                        horario = request.horario,
                        especialidad = request.especialidad,
                        doc = request.idDoctor,
                        idPac = request.idPaciente,
                    )
                )
                return "Appointment created successfully"
            }
            return "Ups, something was wrong"
        }catch(e: EmptyResultDataAccessException){
            throw Error("Patient not found")
        }catch(e: Error){
            throw Error(e.message)
        }
    }

    fun getAllAppointments(): List<Appointment>{
        var response = appointmentRepository.findAll()
        return response
    }

    fun getAppointmentById(id: Long): Appointment {
        var appointment = appointmentRepository.findByIdOrNull(id)
        if (appointment !== null){
            return appointment
        }
        throw Error("Appointment not found")
    }

    fun updateAppointment(id: Long, request: UpdateAppointmentRequest): CreateAppointmentResponse {
        try{
            val appointment = getAppointmentById(id)
            appointment.horario = request.horario
            val updateAppointment = appointmentRepository.save(appointment)
            val doctor = doctorService.getDoctorById(updateAppointment.doc)
            return CreateAppointmentResponse(
                idPaciente = updateAppointment.idPac,
                horario = updateAppointment.horario,
                doctor = doctor.nombre,
                especialidad = updateAppointment.especialidad,
                consultorio = doctor.consultorio
            )
        } catch (e: Error){
            throw Error(e.message)
        }
    }
    fun deleteAppointment(id: Long): String {
        try {
            getAppointmentById(id)
            appointmentRepository.deleteAppointmentByById(id)
            return "El registro se ha borrado con exito"
        } catch (e: DataAccessException) {
            return "El registro se ha borrado con exito"
        } catch (e: Error) {
            return "El registro no existe en la base de datos"
        }
    }
}