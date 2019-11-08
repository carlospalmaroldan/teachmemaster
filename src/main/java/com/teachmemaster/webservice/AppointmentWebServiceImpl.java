package com.teachmemaster.webservice;

import com.teachmemaster.DTO.AppointmentDto;
import com.teachmemaster.domain.Appointment;
import com.teachmemaster.domain.Teacher;
import com.teachmemaster.service.AppointmentService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@RestController
public class AppointmentWebServiceImpl {


    AppointmentService appointmentService;

    public AppointmentWebServiceImpl(AppointmentService appointmentService){
        this.appointmentService=appointmentService;
    }


    @PostMapping("/appointment")
    public void storeAppointment(@RequestBody AppointmentDto appointmentDto){
        Appointment appointment= mapAppointmentToAppointmentDto(appointmentDto);
        appointmentService.storeAppointment(appointment);
    }

    @GetMapping("/appointments-by-teacher-and-date")
    public List<Appointment> getAppointmentsByTeacherAtTimePeriod(
        @RequestParam("startTime") String startTime,
        @RequestParam(value="endTime") String endTime,
        @RequestParam(value="teacherId") Long teacherId){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
       return  appointmentService.getAppointmentsByTeacherAtTimePeriod(LocalDateTime.parse(startTime,formatter),LocalDateTime.parse(endTime,formatter),teacherId)
             .orElseGet(null);
    }

    private Appointment mapAppointmentToAppointmentDto(AppointmentDto appointmentDto){
      return  Appointment.builder()
            .endTime(appointmentDto.getEndTime())
            .startTime(appointmentDto.getStartTime())
            .teacher(appointmentDto.getTeacher())
            .withAllTheseStudents(appointmentDto.getStudents())
            .build();
    }
}
