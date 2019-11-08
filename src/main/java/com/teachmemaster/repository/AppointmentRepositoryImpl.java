package com.teachmemaster.repository;

import com.teachmemaster.domain.Appointment;
import com.teachmemaster.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import java.time.Instant;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class AppointmentRepositoryImpl implements AppointmentRepository {

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public AppointmentRepositoryImpl(JdbcTemplate jdbcTemplate){

        this.jdbcTemplate=jdbcTemplate;
    }

    private static final String STORE_APPOINTMENT="insert into APPOINTMENTS(teacher_id,start_time,end_time) VALUES(:teacherId,:startTime,:endTime)";

    private static final String GET_APPOINTMENTS_BY_TEACHER_AND_TIME="select appointment_id,teacher_id,start_time,end_time"
        + " FROM APPOINTMENTS"
        + " WHERE teacher_id = ?"
        + " AND ( start_time < ? AND ? < end_time)"
        + " OR (start_time < ? AND ? < end_time)";

    @Override
    public void storeAppointment(Appointment appointment) {
        SqlParameterSource parameters = new MapSqlParameterSource()
            .addValue("teacherId", appointment.getTeacher().getTeacherId())
            .addValue("startTime", appointment.getStartTime())
            .addValue("endTime", appointment.getEndTime());

        jdbcTemplate.update(STORE_APPOINTMENT,parameters);
    }

    @Override
    public Optional<List<Appointment>> getAppointmentsByTeacherAndTime(LocalDateTime startTime, LocalDateTime endTime, Long teacherId){
        List<Appointment> appointments = new ArrayList<>();
        SqlParameterSource parameters = new MapSqlParameterSource()
            .addValue("teacherId", teacherId)
            .addValue("startTime", startTime)
            .addValue("endTime", endTime);
        jdbcTemplate.query(GET_APPOINTMENTS_BY_TEACHER_AND_TIME, new Object[]{teacherId,startTime,startTime,endTime, endTime}, rs->{
            while(rs.next()){
                appointments.add( Appointment.builder()
                    .build());
            }

        });
        return Optional.ofNullable(appointments);
    }
}
