package edu.miu.cs425.CarRental.service;



import edu.miu.cs425.CarRental.dto.DiscountRequest;
import edu.miu.cs425.CarRental.model.Discount;

import java.util.List;

public interface DiscountService {

    List<Discount> getAllDiscounts();
    Discount createNewDiscount(Discount discount);
    Discount updateDiscountById(DiscountRequest discount, Long discountId);
    Discount getDiscountById(Long discountId);
    void deleteDiscountById(Long discountId);
}
