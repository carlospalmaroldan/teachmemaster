package com.teachmemaster.repository;

import com.teachmemaster.domain.Appointment;

import java.time.Instant;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface AppointmentRepository {

     void storeAppointment(Appointment appointment);

     Optional<List<Appointment>> getAppointmentsByTeacherAndTime(LocalDateTime startTime, LocalDateTime endTime, Long teacherId);


}
