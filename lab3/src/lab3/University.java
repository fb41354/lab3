package lab3;

import java.util.ArrayList;
import java.util.List;

public class University implements EmailRecipient {

    private List<Faculty> faculties;
    private String emailAddress;
    private String name;

    public University(String name, String emailAddress) {
        this.name = name;
        this.emailAddress = emailAddress;
        this.faculties = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public List<Faculty> getFaculties() {
       return faculties;
    }

    public void addFaculty(String facultyName, String emailAddress) {
        faculties.add(new Faculty(facultyName, emailAddress));
    }
    
    @Override
    public String getEmailAddress() {
        return emailAddress;
    }
}