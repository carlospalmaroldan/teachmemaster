package com.teachmemaster.repository;

import com.teachmemaster.domain.Appointment;
import com.teachmemaster.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
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

    private static final String GET_APPOINTMENTS_BY_TEACHER_AND_TIME="select a.appointment_id,a.teacher_id," +
            "a.start_time, a.end_time, t.name, t.update_date, t.create_date"
        + " FROM APPOINTMENTS a INNER JOIN TEACHERS t ON a.teacher_id=t.teacher_id"
        + " WHERE a.teacher_id = ?"
        + " AND ( a.start_time < ? AND ? < a.end_time)"
        + " OR ( a.start_time < ? AND ? < a.end_time)";




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


        jdbcTemplate.query(GET_APPOINTMENTS_BY_TEACHER_AND_TIME,new Object[]{1,startTime,startTime,
                endTime,endTime}, rs->{
            while(rs.next()){
                appointments.add( Appointment.builder().teacher(
                        Teacher.builder().name(rs.getString("name"))
                                .createDate(rs.getTimestamp("create_date").toInstant())
                                .teacherId(rs.getLong("teacher_id")).build())
                        .endTime(rs.getTimestamp("end_time").toLocalDateTime().toInstant(ZoneOffset.UTC))
                        .startTime(rs.getTimestamp("start_time").toLocalDateTime().toInstant(ZoneOffset.UTC))
                        .build());
            }
            return appointments;
        });
        return Optional.ofNullable(appointments);
    }

}
