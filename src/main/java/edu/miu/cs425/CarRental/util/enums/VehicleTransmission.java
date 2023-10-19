package edu.miu.cs425.CarRental.util.enums;

public enum VehicleTransmission {
    AUTOMATIC("Automatic"),
    MANUAL("Manual");

    private final String transmission;

    private VehicleTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getTransmission() {
        return transmission;
    }
}
