package lab3;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person {

    private String groupId;
    private List<Double> grades;

    public Student(String firstName, String lastName, String groupId, String emailAddress) {
        
        super(firstName, lastName, emailAddress);
        this.groupId = groupId;
        grades = new ArrayList<>();
    }

    public String getGroupId() {
        return groupId;
    }

    public void setGroupId(String groupId) {
        this.groupId = groupId;
    }
    
    public List<Double> getGrades() {
        return grades;
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }
    
    public double getGradesAverage() {
        double gradesSum = 0;
        for (int i = 0; i < grades.size(); i++) {
            gradesSum += grades.get(i);
        }
        
        return gradesSum / grades.size();
    }
}