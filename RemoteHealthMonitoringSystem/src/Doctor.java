public class Doctor extends Person {
    private String specialization;

    public Doctor(String doctorID, String name, String specialization) {
        super(doctorID, name);
        this.specialization = specialization;
    }

    public void reviewAlert(String alert) {
        System.out.println("Doctor " + name + " is reviewing alert: " + alert);
    }
    public void provideRecommendation(Patient patient, String details) {
        System.out.println("Doctor " + name + " sends recommendation.");
        patient.receiveRecommendation(details);
    }

    public void scheduleFollowUp(Patient patient, String date) {
        System.out.println("Doctor " + name + " scheduled follow-up for " + patient.getName() + " on " + date);
    }
}