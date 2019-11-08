package com.teachmemaster.FT;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.teachmemaster.domain.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.hamcrest.Matchers.is;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
public class StudentWebServiceImplFT {

    @Autowired
    private MockMvc mockMvc;


    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void shouldInsertStudent() throws Exception{
        mockMvc.perform(post("/student").content(objectMapper.writeValueAsString(Student.builder()
            .name("carlos")
            .createDate(Instant.now())
            .build()))
            .contentType(MediaType.APPLICATION_JSON))
            .andExpect(status().isOk());

    }

    @Test
    public void shouldGetStudent() throws Exception{
        mockMvc.perform(get("/student?id=1"))
            .andExpect(jsonPath("$.name",is("student1")))
            .andExpect(jsonPath("$.studentId",is(1)))
            .andExpect(status().isOk());
    }
}
