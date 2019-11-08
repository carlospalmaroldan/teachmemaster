package com.teachmemaster.FT;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.Matchers.is;
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class AppointmentWebServiceImplFT {


    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;


    @Test
    public void shouldRetrieveAppointmentsByTeacherIdAndTime() throws Exception{
       /* this.mockMvc.perform(get("/appointments-by-teacher-and-date?startTime=2019-10-11 12:30:00Z&&endTime=2019-10-11 13:30:00Z&&teacherId=1"))
            .andExpect(jsonPath("$.name",is(1)))
            .andExpect(status().isOk());*/
    }



}
/*
    select appointment_id,teacher_id,start_time,end_time
    FROM APPOINTMENTS
    WHERE teacher_id = 1
    AND ( start_time < '2019-10-11T12:30:00Z' AND  '2019-10-11T12:30:00Z' < end_time)
    OR (start_time < '2019-10-11T13:30:00Z' AND  '2019-10-11T13:30:00Z' < end_time);*/
