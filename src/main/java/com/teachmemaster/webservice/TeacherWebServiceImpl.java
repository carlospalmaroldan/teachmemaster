package com.teachmemaster.webservice;

import com.teachmemaster.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.teachmemaster.service.TeacherService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@RestController
public class TeacherWebServiceImpl {


    TeacherService teacherService;

    private static final String template = "Hello, %s!";

    @Autowired
    public TeacherWebServiceImpl(TeacherService teacherService){
        this.teacherService=teacherService;
    }


    @RequestMapping("/teacher")
    public Optional<Teacher> getTeacherById(@RequestParam(value="id") Integer id) {
        List<Optional<Teacher>> list=teacherService.getTeacherById(id);
        return list.stream().filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst();

    }
}
