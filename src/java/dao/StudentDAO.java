/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import entities.Student;
import controllers.MyServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author George.Pasparakis
 */
public class StudentDAO extends Database {
    
    String server = "localhost:3306";
        String database = "bootcampdb";
        String username = "root";
        String password = "root";
    
    
    public StudentDAO() {
        super();
    }
    
    public List<Student> getStudents() {
        Student st;
        List<Student> students = new ArrayList<>();
        String query = "SELECT * FROM `bootcampdb`.`students`";
        setOptions("?zeroDateTimeBehavior=convertToNull&serverTimezone=Europe/Athens&useSSL=false&useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false");
        ResultSet rs = Database(server, database, username, password, query);
        if(rs == null) { System.out.println("Error to the database");} 
        try {
            while(rs.next()) {
                st = new Student(rs.getInt("ID"), rs.getString("SURNAME"), 
                                         rs.getString("NAME"), rs.getFloat("GRADE"), 
                                         rs.getString("BIRTHDATE")); 
                students.add(st);
            }
        } catch (SQLException ex) {
            Logger.getLogger(MyServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return students;
    }
    
    public boolean InsertStudent(Student st){
        String query = "INSERT INTO `bootcamp`.`students`(SURNAME, NAME, GRADE, BIRTHDATE) VALUES (\"" + st.getSurname()+ "\",\"" + st.getName()+ "\"," + st.getGrade()+ "," + "\"" + st.getBirthDate()+ "\" )";
        int i = Database(server, database, username, password, query, (byte)1); // me to byte 1 kanw execute update
        if (i >= 1) return true;
        else return false;
    }
    
    public boolean DeleteStudent(int id){
        
        return false;
    }
    
}
