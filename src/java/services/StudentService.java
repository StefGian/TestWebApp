/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import entities.Student;
import dao.StudentDAO;
import java.util.List;

/**
 *
 * @author George.Pasparakis
 */
public class StudentService {
    
    public StudentService() {
    }
    
    public String getStudents() {
       StudentDAO stuDao = new StudentDAO();
       List<Student> students = stuDao.getStudents();
       StringBuilder str = new StringBuilder(); 
       str.append("<!DOCTYPE html>")
                .append("<html>")
                .append("<head>")
                .append("<title>My First Servlet</title>")
                .append("</head>")
                .append("<body>");
        for (Student s : students) {
            str.append("<p>").append(s).append("</p>");
        }
        str.append("</body>")
                .append("</html>");
        return str.toString();
    }
}
