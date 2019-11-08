package com.teachmemaster.service;

import com.teachmemaster.domain.Appointment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentService {

     void storeAppointment(Appointment appointment);

     Optional<List<Appointment>> getAppointmentsByTeacherAtTimePeriod(LocalDateTime start, LocalDateTime end,Long teacherId);
}
