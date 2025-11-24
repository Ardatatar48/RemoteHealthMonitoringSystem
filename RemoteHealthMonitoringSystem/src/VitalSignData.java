public class VitalSignData {
    private String dataID;
    private int heartRate;
    private String bloodPressure;
    private float temperature;
    private String timestamp;
    private WearableDevice sourceDevice;

    public VitalSignData(String dataID, int heartRate, String bloodPressure, float temperature, String timestamp, WearableDevice sourceDevice) {
        this.dataID = dataID;
        this.heartRate = heartRate;
        this.bloodPressure = bloodPressure;
        this.temperature = temperature;
        this.timestamp = timestamp;
        this.sourceDevice = sourceDevice;
    }

    public boolean isAbnormal() {
        //Heart rate above 100 or Temp above 37.5 is abnormal
        if (heartRate > 100 || temperature > 37.5) {
            return true;
        }
        return false;
    }

    public int getHeartRate() { return heartRate; }
}