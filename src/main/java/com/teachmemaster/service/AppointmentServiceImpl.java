package com.teachmemaster.service;

import com.teachmemaster.domain.Appointment;
import com.teachmemaster.repository.AppointmentRepository;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AppointmentServiceImpl implements AppointmentService{

    private AppointmentRepository appointmentRepository;

    public AppointmentServiceImpl(AppointmentRepository appointmentRepository){
        this.appointmentRepository = appointmentRepository;
    }


    @Override
    public void storeAppointment(Appointment appointment) {

       /* getAppointmentsByTeacherAtTimePeriod(appointment.getStartTime(),appointment.getEndTime(),appointment.getTeacher().getName())
        .map(list->{
                throw new RuntimeException();
            })
            .orElseGet(
            ()->
                appointmentRepository.storeAppointment(appointment)


        );*/

    }

    @Override
    public Optional<List<Appointment>> getAppointmentsByTeacherAtTimePeriod(LocalDateTime start, LocalDateTime end, Long teacherId) {
      return  appointmentRepository.getAppointmentsByTeacherAndTime(start,end,teacherId);
    }


}
