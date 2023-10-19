package edu.miu.cs425.CarRental.service.impl;


import edu.miu.cs425.CarRental.dto.DiscountRequest;
import edu.miu.cs425.CarRental.model.Discount;
import edu.miu.cs425.CarRental.repository.DiscountRepository;
import edu.miu.cs425.CarRental.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {

    private DiscountRepository discountRepository;

    public DiscountServiceImpl(DiscountRepository discountRepository) {
        this.discountRepository = discountRepository;
    }

    @Override
    public List<Discount> getAllDiscounts() {
        return this.discountRepository.findAll();
    }

    @Override
    public Discount createNewDiscount(Discount discount) {
        return this.discountRepository.save(discount);
    }

    @Override
    public Discount updateDiscountById(DiscountRequest discountRequest, Long discountId) {
        Discount discount = this.discountRepository.findById(discountId).get();
        if(discount != null) {
            discount.setCode(discountRequest.getCode());
            discount.setTitle(discountRequest.getTitle());
            discount.setPercentage(discountRequest.getPercentage());
            discount.setDescription(discountRequest.getDescription());
            discount.setVehicleMake(discountRequest.getVehicleMake());
            return this.discountRepository.save(discount);
        }
        return null;
    }

    @Override
    public Discount getDiscountById(Long discountId) {
        return discountRepository.findById(discountId).get();
    }

    @Override
    public void deleteDiscountById(Long discountId) {
        this.discountRepository.deleteById(discountId);
    }
}
