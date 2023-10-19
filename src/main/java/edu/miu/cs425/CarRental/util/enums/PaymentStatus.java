package edu.miu.cs425.CarRental.util.enums;

public enum PaymentStatus {
    PENDING("Pending"), FINISHED("Finished");

    private final String status;

    PaymentStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
