package edu.miu.cs425.CarRental.controller;

import edu.miu.cs425.CarRental.dto.ReportRequest;
import edu.miu.cs425.CarRental.model.Report;
import edu.miu.cs425.CarRental.service.ReportService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/car-rental/reports")
public class ReportController {

    private ReportService reportService;

    public ReportController(ReportService reportService) {
        this.reportService = reportService;
    }

    @PostMapping()
    public ResponseEntity<Report> createReport(@RequestBody ReportRequest reportRequest){
        return ResponseEntity.ok(reportService.addNewReport(reportRequest));
    }

    @GetMapping()
    public ResponseEntity<List<Report>> listReport(){
        return ResponseEntity.ok(reportService.getAllReports());
    }

    @GetMapping("/{reportId}")
    public ResponseEntity<Optional<Report>> getReportById(@PathVariable Long reportId){
        return ResponseEntity.ok(reportService.getReportById(reportId));
    }

    @DeleteMapping ("/{reportId}")
    public ResponseEntity<Void> deleteReportById(@PathVariable Long reportId){
        reportService.deleteReportById(reportId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
