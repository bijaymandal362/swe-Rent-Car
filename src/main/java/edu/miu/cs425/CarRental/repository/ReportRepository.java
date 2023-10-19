package edu.miu.cs425.CarRental.repository;

import edu.miu.cs425.CarRental.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {
}
