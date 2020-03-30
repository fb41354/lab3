package lab3;

public class Teacher extends Person {
    private String courseName;
    
    public Teacher (String firstName, String lastName, String courseName, String emailAddress) {
        super(firstName, lastName, emailAddress);
        this.courseName = courseName;
    }
    
    public String getCourseName() {
        return courseName;
    }
    
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
