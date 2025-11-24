import java.util.ArrayList;
import java.util.List;

public class Patient extends Person {
    private String dateOfBirth;
    private String contactInfo;
    private List<String> chronicConditions;

    public Patient(String patientID, String name, String dateOfBirth, String contactInfo) {
        super(patientID, name);
        this.dateOfBirth = dateOfBirth;
        this.contactInfo = contactInfo;
        //Initialize the empty list so we can add to it later
        this.chronicConditions = new ArrayList<>();
    }

    public void addCondition(String condition) {
        chronicConditions.add(condition);
    }

    public void viewData() {
        System.out.println("Patient Name: " + name);
        System.out.println("Conditions: " + chronicConditions);
    }

    public void receiveRecommendation(String recommendation) {
        System.out.println("   -> Notification for " + name + ": " + recommendation);
    }
}