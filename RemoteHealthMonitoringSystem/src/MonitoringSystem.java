public class MonitoringSystem {
    private String systemID;

    public MonitoringSystem(String systemID) {
        this.systemID = systemID;
    }

    //Processing the data
    public void processData(VitalSignData data, Doctor doctor, Patient patient) {
        System.out.println("System " + systemID + " processing data.");

        boolean issueDetected = checkThresholds(data);

        if (issueDetected) {
            String alertMsg = generateAlert(data);

            //Trigger the Doctor actions
            doctor.reviewAlert(alertMsg);
            doctor.provideRecommendation(patient, "Please rest and take your medication.");
            doctor.scheduleFollowUp(patient, "2025-11-25");
        } else {
            System.out.println("Vitals are normal. No action needed.");
        }
    }

    public boolean checkThresholds(VitalSignData data) {
        return data.isAbnormal();
    }

    public String generateAlert(VitalSignData data) {
        System.out.println("!!!!!!!! ALERT: Abnormal Vitals Detected !!!");
        return "High Heart Rate: " + data.getHeartRate();
    }

    // This is main method of program and it helps program to work it from MonitoringSystem.java
    public static void main(String[] args) {
        System.out.println("SYSTEM STARTING");

        //Creates Patient data
        Patient patient = new Patient("P-101", "Ryan Gosling", "1990-01-01", "05397455903");
        patient.addCondition("Asthma");
        //(Its never lupus)Creates doctor data
        Doctor doctor = new Doctor("DOC-216", "Gregory House", "rheumatology(lupus)");

        WearableDevice device = new WearableDevice("W-216", "Apple Watch", patient);

        //Create an instance
        MonitoringSystem mySystem = new MonitoringSystem("SYS-Main");

        // SCENARIO 1: FINE (Normal Vitals - It's not Lupus)
        System.out.println("\n--- TEST 1: Normal Vitals (He is fine) ---");
        device.recordVitals();

        // Transmitting normal Heart Rate (70)
        VitalSignData normalData = device.transmitData(70, "120/80", 36.5f);

        // System checks it - Should result in "No action needed"
        mySystem.processData(normalData, doctor, patient);

        // SCENARIO 2: SICK (Abnormal Vitals - Maybe it is Lupus?)
        System.out.println("\n--- TEST 2: Abnormal Vitals (He is sick) ---");
        device.recordVitals();

        // Simulating high heart rate (110)
        VitalSignData sickData = device.transmitData(110, "140/90", 38.0f);

        // Pass everything to the system - Should trigger ALERT and Doctor House
        mySystem.processData(sickData, doctor, patient);

        System.out.println("\nSYSTEM FINISHED");
    }
}