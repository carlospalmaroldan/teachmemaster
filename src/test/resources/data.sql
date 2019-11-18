INSERT INTO TEACHERS(teacher_id,name) VALUES(1,'Anthony');
INSERT INTO STUDENTS(student_id,name) VALUES(1,'student1');
INSERT INTO STUDENTS(student_id,name) VALUES(2,'student2');
INSERT INTO TEACHERS_STUDENTS(student_id,teacher_id) VALUES (1,1);
INSERT INTO TEACHERS_STUDENTS(student_id,teacher_id) VALUES (2,1);

insert into APPOINTMENTS(teacher_id,start_time,end_time) VALUES(1,'2019-10-11 15:00:00','2019-10-11 16:00:00')
