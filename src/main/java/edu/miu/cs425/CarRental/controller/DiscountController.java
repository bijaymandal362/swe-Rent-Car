package edu.miu.cs425.CarRental.controller;

import edu.miu.cs425.CarRental.dto.DiscountRequest;
import edu.miu.cs425.CarRental.model.Discount;
import edu.miu.cs425.CarRental.service.DiscountService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(value = "/api/car-rental/discounts")
public class DiscountController {

    private DiscountService discountService;

    @Autowired
    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping()
    public List<Discount> listAllDiscounts() {
        return discountService.getAllDiscounts();
    }

    @GetMapping(value = "/{discountId}")
    public Discount getDiscountById(@PathVariable Long discountId) {
        return discountService.getDiscountById(discountId);
    }

    @PostMapping()
    public Discount createNewDiscount(@Valid @RequestBody Discount discount) {
        return discountService.createNewDiscount(discount);
    }
    @PutMapping(value = "/{discountId}")
    public Discount updateDiscountById(DiscountRequest discountRequest, @PathVariable Long discountId) {
        return discountService.updateDiscountById(discountRequest,discountId);
    }

    @DeleteMapping(value = "/{discountId}")
    public void deleteDiscountById(@PathVariable Long discountId) {
        discountService.deleteDiscountById(discountId);
    }

}
