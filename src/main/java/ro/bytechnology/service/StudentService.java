package ro.bytechnology.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ro.bytechnology.dao.StudentDao;

import java.sql.SQLException;
import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentDao studentDao;

    public void addStudent(String firstname,String lastname,int grade) throws SQLException {
        studentDao.addStudent(firstname,lastname,grade);
    }

    public List<String> getStudentsName() throws SQLException {
        return studentDao.getStudentsName();
    }
}
