package com.teachmemaster.service;

import com.teachmemaster.domain.Appointment;
import java.time.LocalDateTime;
import java.util.List;


public interface AppointmentService {

     void storeAppointment(Appointment appointment);

     List<Appointment> getAppointmentsByTeacherAtTimePeriod(LocalDateTime start, LocalDateTime end,Long teacherId);
}
