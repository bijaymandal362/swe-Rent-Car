package edu.miu.cs425.CarRental.util.enums;

public enum ReportStatus {
    STARTED("Started"), FAILED("Failed"), FINISHED("Finished");
    private final String status;

    ReportStatus(String status) {
        this.status = status;
    }

    public String getStatus() {
        return status;
    }
}
