package edu.miu.cs425.CarRental.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FeedbackRequest {
    private Integer rating;
    private String comment;
    private Long customerId;
}
