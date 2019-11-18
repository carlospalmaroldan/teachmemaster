package com.teachmemaster.service;

import com.teachmemaster.domain.Appointment;
import com.teachmemaster.repository.AppointmentRepository;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;


@Component
public class AppointmentServiceImpl implements AppointmentService{

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public void storeAppointment(Appointment appointment) {

       List<Appointment> appointmentList= getAppointmentsByTeacherAtTimePeriod(LocalDateTime.ofInstant(appointment.getStartTime(),ZoneId.of("UTC")),
               LocalDateTime.ofInstant(appointment.getEndTime(), ZoneId.of("UTC")),
               appointment.getTeacher().getTeacherId());
       if(appointmentList.isEmpty()) {
           appointmentRepository.storeAppointment(appointment);
       }else{
           throw new RuntimeException();
       }



    }

    @Override
    public List<Appointment> getAppointmentsByTeacherAtTimePeriod(LocalDateTime start, LocalDateTime end, Long teacherId) {
      return  appointmentRepository.getAppointmentsByTeacherAndTime(start,end,teacherId);
    }


}
