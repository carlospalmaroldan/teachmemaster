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

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

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
            .andExpect(jsonPath("$",hasSize(2)))
            .andExpect(jsonPath("$[0].name",is("student1")))
            .andExpect(jsonPath("$[1].name",is("student2")))
            .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnListOfStudentsOfTeacherGivenTeacherName() throws Exception{
        this.mockMvc.perform(get("/studentsbyTeacherName?teacherName=Anthony"))
            .andExpect(jsonPath("$",hasSize(2)))
            .andExpect(jsonPath("$[0].name",is("student1")))
            .andExpect(jsonPath("$[1].name",is("student2")))
            .andExpect(status().isOk());
    }
}
