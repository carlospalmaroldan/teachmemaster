package com.teachmemaster.FT;

import com.fasterxml.jackson.databind.ObjectMapper;
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

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class TeacherWebServiceImplFT {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldRetrieveTeacherById() throws Exception{
        this.mockMvc.perform(get("/teacher?id=1"))
            .andExpect(status().isOk());
    }


    @Test
    public void shouldInsertTeacher() throws Exception{

        this.mockMvc.perform(post("/teacher")
            .content(objectMapper.writeValueAsString(Teacher.builder()
                .name("carlos")
                .createDate(Instant.now())
                .build()))
            .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(status().isOk());

        this.mockMvc.perform(get("/teacher?name=carlos"))
            .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnListOfStudentsOfTeacher() throws Exception{
        this.mockMvc.perform( get("/studentsbyteacherid?teacherId=1"))
            .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnListOfStudentsOfTeacherGivenTeacherName() throws Exception{
        this.mockMvc.perform(get("/studentsbyTeacherName?teacherName=Anthony"))
            .andExpect(status().isOk());
    }
}
