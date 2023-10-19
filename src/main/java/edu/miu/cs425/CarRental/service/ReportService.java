package edu.miu.cs425.CarRental.service;

import edu.miu.cs425.CarRental.dto.ReportRequest;
import edu.miu.cs425.CarRental.model.Report;

import java.util.List;
import java.util.Optional;

public interface ReportService {

    List<Report> getAllReports();

    Optional<Report> getReportById(Long reportId);

    Report addNewReport(ReportRequest newReportRequest);

    void deleteReportById(Long reportId);
}
