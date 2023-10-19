package edu.miu.cs425.CarRental.util.enums;

public enum ReservationStatus {
    ACTIVE("Active"),
    CANCELLED("Cancelled"),
    PENDING_PAYMENT("Pending Payment"),
    COMPLETED("Completed");

    private final String status;

    ReservationStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}