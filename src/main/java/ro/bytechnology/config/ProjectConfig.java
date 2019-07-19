package ro.bytechnology.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Configuration
@ComponentScan(basePackages = {"ro.bytechnology.service","ro.bytechnology.dao","ro.bytechnology.aspects"})
@EnableAspectJAutoProxy
public class ProjectConfig {
    
    @Bean
    public DataSource dataSource(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("org.h2.Driver");
        ds.setUrl("jdbc:h2:./test;DB_CLOSE_ON_EXIT=FALSE");
        ds.setUsername("sa");
        ds.setPassword("");
        try (Connection con = ds.getConnection()){
            String sql = "CREATE TABLE STUDENT (\n" +
                    "    ID INT AUTO_INCREMENT PRIMARY KEY,\n" +
                    "    FirstName varchar(255),\n" +
                    "    LastName varchar(255),\n" +
                    "    Grade int,\n" +
                    ");";
            Statement stmt = con.createStatement();
            stmt.execute("DROP TABLE IF EXISTS STUDENT;");
            stmt.execute(sql);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return ds;
    }
}
