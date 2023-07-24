package com.doctores.doctores.controllers
import com.doctores.doctores.constants.*
import com.doctores.doctores.domains.entity.Appointment
import com.doctores.doctores.domains.request.CreateAppointmentRequest
import com.doctores.doctores.domains.request.CreateDoctorRequest
import com.doctores.doctores.domains.request.UpdateAppointmentRequest
import com.doctores.doctores.domains.responses.CreateAppointmentResponse
import com.doctores.doctores.domains.responses.DoctorResponse
import com.doctores.doctores.domains.responses.HealthCheckResponse
import com.doctores.doctores.services.AppointmentService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpMessage
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class AppointmentController {
    @Autowired
    private lateinit var appointmentService: AppointmentService
    @GetMapping(Appointment)
    fun getAllAppointments(): List<Appointment> = appointmentService.getAllAppointments()

    @PostMapping(CreateAppointments)
    fun createAppointment(
        @RequestBody request: CreateAppointmentRequest
    ): ResponseEntity<String> {
        try{
            return ResponseEntity(appointmentService.createAppointment(request), HttpStatus.OK)
        }catch(e: Error){
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }


    @GetMapping(GetAppointmentById)
    fun getAppointmentById(@PathVariable("id") id: Long): ResponseEntity<Any>{
        try{
            return ResponseEntity(appointmentService.getAppointmentById(id), HttpStatus.OK)
        }catch (e: Error){
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }
    @PutMapping(UpdateAppointment)
    fun updateAppointment(
        @PathVariable("id") id: Long,
        @RequestBody request: UpdateAppointmentRequest
    ): ResponseEntity<Any>  {
        try{
            return ResponseEntity(appointmentService.updateAppointment(id, request), HttpStatus.OK)
        }catch(e: Error){
            return ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }

    @DeleteMapping(DeleteAppointment)
    fun deleteAppointment(@PathVariable("id") id: Long): ResponseEntity<String> {
        return try{
            ResponseEntity(appointmentService.deleteAppointment(id), HttpStatus.ACCEPTED)
        }catch (e: Error){
            ResponseEntity(e.message, HttpStatus.BAD_REQUEST)
        }
    }

}