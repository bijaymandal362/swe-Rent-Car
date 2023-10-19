package edu.miu.cs425.CarRental.repository;

import edu.miu.cs425.CarRental.model.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface FeedbackRepository extends JpaRepository<Feedback,Long> {

}
