public class WearableDevice {
    private String deviceID;
    private String model;
    private Patient assignedTo;

    public WearableDevice(String deviceID, String model, Patient assignedTo) {
        this.deviceID = deviceID;
        this.model = model;
        this.assignedTo = assignedTo;
    }

    public void recordVitals() {
        System.out.println("Device " + deviceID + " recording vitals for " + assignedTo.getName());
    }

    public VitalSignData transmitData(int heartRate, String bp, float temp) {
        System.out.println("Device transmitting data.");
        return new VitalSignData("D-001", heartRate, bp, temp, "2025-11-22", this);
    }
}