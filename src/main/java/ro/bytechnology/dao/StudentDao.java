package ro.bytechnology.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class StudentDao {

    @Autowired
    private DataSource dataSource;

    public void addStudent(String firstname,String lastname,int grade) throws SQLException {
        try(Connection con = dataSource.getConnection()){
            String sql="INSERT INTO student VALUES(NULL,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setString(1,firstname);
            stmt.setString(2,lastname);
            stmt.setInt(3,grade);
            stmt.executeUpdate();
        }
    }

    public List<String> getStudentsName() throws SQLException {
        try(Connection con = dataSource.getConnection()){
            String sql="SELECT FirstName FROM student";
            PreparedStatement stmt = con.prepareStatement(sql);
            ResultSet resultSet = stmt.executeQuery();
            List<String> list = new ArrayList<>();
            while (resultSet.next()) {
                String name = resultSet.getString(1);
                list.add(name);
            }
            return list;
        }
    }
}
