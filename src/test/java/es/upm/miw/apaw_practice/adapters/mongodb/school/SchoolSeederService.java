package es.upm.miw.apaw_practice.adapters.mongodb.school;

import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.CourseRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.StudentRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.SubjectRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.daos.TeacherRepository;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.CourseEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.StudentEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.SubjectEntity;
import es.upm.miw.apaw_practice.adapters.mongodb.school.entities.TeacherEntity;
import es.upm.miw.apaw_practice.domain.models.school.TeacherCreation;
import es.upm.miw.apaw_practice.domain.models.shop.ArticleCreation;
import org.apache.logging.log4j.LogManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;

@Service
public class SchoolSeederService {

    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private SubjectRepository subjectRepository;
    @Autowired
    private TeacherRepository teacherRepository;

    public void seedDatabase() {
        LogManager.getLogger(this.getClass()).warn("------- School Initial Load -----------");
        StudentEntity[] students = {
                new StudentEntity("Pepe", "Gutierrez", false, "48767689X", "pepitoju@gmail.com"),
                new StudentEntity("Juan", "Vidal", true, "49967689A", "vidalio@gmail.com"),
                new StudentEntity("Luis", "Peral", false, "99767689D", "luisper@gmail.com"),
                new StudentEntity("Joaquín", "Arcángel", false, "48797089Y", "durum@gmail.com"),
                new StudentEntity("Doraemon", "Lucasio", false, "11117689V", "ldr@gmail.com")
        };
        this.studentRepository.saveAll(Arrays.asList(students));
        TeacherEntity[] teachers = {
                new TeacherEntity(new TeacherCreation("Jose", "Fridge", true, "33667788R", "dsfsdf@gmail.com")),
                new TeacherEntity(new TeacherCreation("Pablo", "Terra", false, "35557788B", "lushf@gmail.com")),
                new TeacherEntity(new TeacherCreation("Teresa", "Fridge", true, "33645788R", "teref@gmail.com")),
                new TeacherEntity(new TeacherCreation("Tomato", "Zacar", false, "87653788L", "toma@gmail.com"))
        };
        this.teacherRepository.saveAll(Arrays.asList(teachers));
        SubjectEntity[] subjects = {
                new SubjectEntity(teachers[0], "Maths", "Science"),
                new SubjectEntity(teachers[1], "English", "Language"),
                new SubjectEntity(teachers[2], "Chinese", "Language"),
                new SubjectEntity(teachers[3], "Music", "Art")
        };
        this.subjectRepository.saveAll(Arrays.asList(subjects));
        CourseEntity[] courses = {
                new CourseEntity(Arrays.asList(students), Arrays.asList(subjects), 1, "B", "Primary", LocalDate.of(2020, 12, 3), LocalDate.of(2021, 11, 13)),
                new CourseEntity(Arrays.asList(students), Arrays.asList(subjects), 2, "C", "Secondary", LocalDate.of(2020, 11, 7), LocalDate.of(2022, 1, 15)),
                new CourseEntity(Arrays.asList(students), Arrays.asList(subjects), 3, "B", "Primary", LocalDate.of(2020, 12, 3), LocalDate.of(2023, 10, 17))
        };
        this.courseRepository.saveAll(Arrays.asList(courses));
    }

    public void deleteAll() {
        this.courseRepository.deleteAll();
        this.subjectRepository.deleteAll();
        this.teacherRepository.deleteAll();
        this.studentRepository.deleteAll();
    }
}


