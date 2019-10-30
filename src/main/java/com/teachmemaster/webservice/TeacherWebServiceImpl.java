package com.teachmemaster.webservice;

import com.teachmemaster.domain.Student;
import com.teachmemaster.domain.Teacher;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.teachmemaster.service.TeacherService;

import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@RestController
public class TeacherWebServiceImpl {


    TeacherService teacherService;

    private static final String template = "Hello, %s!";

    @Autowired
    public TeacherWebServiceImpl(TeacherService teacherService){
        this.teacherService=teacherService;
    }


    @GetMapping("/teacher")
    public Optional<Teacher> getTeacherById(@RequestParam(value="id") Integer id) {
        List<Optional<Teacher>> list=teacherService.getTeacherById(id);
        return list.stream().filter(Optional::isPresent)
            .map(Optional::get)
            .findFirst();

    }

    @PostMapping("/teacher")
    public void storeTeacher(@RequestBody Teacher teacher){
            teacherService.storeTeacher(teacher);
    }


    @GetMapping(value="/teacher", params = "name")
    public Set<Teacher> getTeacherByName(@RequestParam(value="name") String name){
        List<Teacher> list = teacherService.getTeacherByName(name);
        return list.stream().collect(Collectors.toSet());
    }

    @GetMapping(value="/studentsbyteacherid", params="teacherId")
    public Set<Student> getStudentsByTeacherId(@RequestParam(value="teacherId") int teacherId){
        Set<Student> studentsOfTeacher = teacherService.getStudentsByTeacherId(teacherId);
        return studentsOfTeacher;
    }


}
