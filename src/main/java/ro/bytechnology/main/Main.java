package ro.bytechnology.main;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ro.bytechnology.config.ProjectConfig;
import ro.bytechnology.service.StudentService;

import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException {
        try(AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ProjectConfig.class)){
            StudentService studentService = context.getBean(StudentService.class);
            studentService.addStudent("Dorin","Simion",6);
            studentService.addStudent("Mihai","Gruianu",9);
            studentService.getStudentsName().forEach(System.out::println);
            studentService.addStudent("Silviu","Chivu",8);
            studentService.getStudentsName().forEach(System.out::println);
        }
    }
}
