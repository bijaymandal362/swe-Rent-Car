package edu.miu.cs425.CarRental.util.enums;

public enum ReportType {
    DAILY("Daily"), WEEKLY("Weekly"), MONTHLY("Monthly");
    private final String type;

    ReportType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return type;
    }
}
