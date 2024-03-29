package com.teachmemaster.FT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teachmemaster.DTO.AppointmentDto;
import com.teachmemaster.domain.Teacher;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static java.time.temporal.ChronoUnit.HOURS;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
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
        this.mockMvc.perform(get("/appointments-by-teacher-and-date?startTime=2019-10-11 15:30:30" +
                "&&endTime=2019-10-11 16:30:01&&teacherId=1"))
            .andExpect(jsonPath("$[0].teacher.teacherId",is(1)))
            .andExpect(jsonPath("$[0].teacher.name",is("Anthony")))
            .andExpect(jsonPath("$[0].startTime",is("2019-10-11T15:00:00Z")))
            .andExpect(jsonPath("$[0].endTime",is("2019-10-11T16:00:00Z")))
            .andExpect(status().isOk());
    }


    @Test
    public void shouldInsertAppointment() throws Exception{
        this.mockMvc.perform(post("/appointment").content(objectMapper.writeValueAsString(AppointmentDto.builder()
                .teacher(Teacher.builder().teacherId(1L).build())
                .startTime(Instant.now())
                .endTime(Instant.now().plus(1,HOURS))
                .build())).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


}

