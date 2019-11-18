package com.teachmemaster.repository;

import com.teachmemaster.domain.Appointment;
import java.time.LocalDateTime;
import java.util.List;


public interface AppointmentRepository {

     void storeAppointment(Appointment appointment);

     List<Appointment> getAppointmentsByTeacherAndTime(LocalDateTime startTime, LocalDateTime endTime, Long teacherId);


}
