/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lab3;

import java.util.ArrayList;
import java.util.List;

public class Faculty implements EmailRecipient {
    
    private String facultyName;
    private String emailAddress;
    private List<Teacher> teachers;
    
    public Faculty(String facultyName, String emailAddress) {
        this.facultyName = facultyName;
        this.emailAddress = emailAddress;
        this.teachers = new ArrayList<>();
    }
    
    public String getEmailAddress() {
        return emailAddress;
    }
    
    private void addTeacher(String firstName, String lastName, String courseName, String emailAddress) {
        teachers.add(new Teacher(firstName, lastName, courseName, emailAddress));
    }
    
     private void addTeacher(Teacher teacher) {
        teachers.add(teacher);
    }
     
    @Override
    public String toString() {
        return facultyName + " " + emailAddress;
    }
}
