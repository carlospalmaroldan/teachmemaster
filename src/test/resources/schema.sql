DROP TABLE IF EXISTS TEACHERS;
DROP TABLE IF EXISTS APPOINTMENTS;
DROP TABLE IF EXISTS STUDENTS;
DROP TABLE IF EXISTS APPOINTMENTS_STUDENTS;
DROP TABLE IF EXISTS TEACHERS_STUDENTS;

CREATE TABLE `TEACHERS` (
	`teacher_id` INT(11) NOT NULL AUTO_INCREMENT,
	`name` VARCHAR(255) NOT NULL,
	`update_date` TIMESTAMP NOT NULL DEFAULT CURRENT_TIMESTAMP,
	`create_date` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
	PRIMARY KEY (`teacher_id`)
);


CREATE TABLE `APPOINTMENTS` (
    `appointment_id` INT(11) NOT NULL AUTO_INCREMENT,
    `teacher_id` INT(11) NOT NULL,
    `start_time` TIMESTAMP NOT NULL,
    `end_time` TIMESTAMP NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES TEACHERS (teacher_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (`appointment_id`,`teacher_id`)
);

CREATE TABLE `STUDENTS` (
    `student_id` INT(11) NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(255) NOT NULL,
    `create_date` TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`student_id`)
);

CREATE TABLE `APPOINTMENTS_STUDENTS`(
    `appointment_id` INT(11) NOT NULL,
    `student_id` INT(11) NOT NULL,
    FOREIGN KEY (appointment_id) REFERENCES APPOINTMENTS (appointment_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (student_id) REFERENCES STUDENTS (student_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (appointment_id, student_id)
);

CREATE TABLE `TEACHERS_STUDENTS`(
    `student_id` INT(11) NOT NULL,
    `teacher_id` INT(11) NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES TEACHERS (teacher_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    FOREIGN KEY (student_id) REFERENCES STUDENTS (student_id) ON DELETE RESTRICT ON UPDATE CASCADE,
    PRIMARY KEY (teacher_id, student_id)
);



