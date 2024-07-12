package bt1.casemodule4.controller;


import bt1.casemodule4.model.Promotion;
import bt1.casemodule4.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/api/promotions")
public class PromotionController {

    @Autowired
    private PromotionService promotionService;

    @GetMapping("/List")
    public ResponseEntity<List<Promotion>> showAllPromotion(){
        return ResponseEntity.ok(promotionService.findAll());
    }

    @PostMapping("/create")
    public ResponseEntity<?> createPromotion(@Valid @RequestBody Promotion promotion, BindingResult bindingResult){
        promotionService.save(promotion, bindingResult);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deletePromotion(@PathVariable Long id){
        promotionService.delete(id);
        return ResponseEntity.noContent().build();
    }

    // Tìm promotion theo discount
    @GetMapping("/by-discount")
    public ResponseEntity<List<Promotion>> findByDiscount(@RequestParam("discount") Double discount) {
        List<Promotion> promotions = promotionService.findByDiscount(discount);
        return ResponseEntity.ok(promotions);
    }

    // Tìm promotion theo startDate
    @GetMapping("/by-start-date")
    public ResponseEntity<List<Promotion>> findByStartDate(@RequestParam("startDate") LocalDate startDate) {
        List<Promotion> promotions = promotionService.findByStartDate(startDate);
        return ResponseEntity.ok(promotions);
    }

    // Tìm promotion theo endDate
    @GetMapping("/by-end-date")
    public ResponseEntity<List<Promotion>> findByEndDate(@RequestParam("endDate") LocalDate endDate) {
        List<Promotion> promotions = promotionService.findByEndDate(endDate);
        return ResponseEntity.ok(promotions);
    }

    // Tìm promotion theo discount và startDate
    @GetMapping("/by-discount-and-start-date")
    public ResponseEntity<List<Promotion>> findByDiscountAndStartDate(@RequestParam("discount") Double discount,
                                                                      @RequestParam("startDate") LocalDate startDate) {
        List<Promotion> promotions = promotionService.findByDiscountAndStartDate(discount, startDate);
        return ResponseEntity.ok(promotions);
    }

    // Tìm promotion theo startDate và endDate
    @GetMapping("/by-start-date-and-end-date")
    public ResponseEntity<List<Promotion>> findByStartDateAndEndDate(@RequestParam("startDate") LocalDate startDate,
                                                                     @RequestParam("endDate") LocalDate endDate) {
        List<Promotion> promotions = promotionService.findByStartDateAndEndDate(startDate, endDate);
        return ResponseEntity.ok(promotions);
    }

    // Tìm promotion theo discount và endDate
    @GetMapping("/by-discount-and-end-date")
    public ResponseEntity<List<Promotion>> findByDiscountAndEndDate(@RequestParam("discount") Double discount,
                                                                    @RequestParam("endDate") LocalDate endDate) {
        List<Promotion> promotions = promotionService.findByDiscountAndEndDate(discount, endDate);
        return ResponseEntity.ok(promotions);
    }

    // Tìm promotion theo discount, startDate và endDate
    @GetMapping("/by-discount-and-start-date-and-end-date")
    public ResponseEntity<List<Promotion>> findByDiscountAndStartDateAndEndDate(@RequestParam("discount") Double discount,
                                                                                @RequestParam("startDate") LocalDate startDate,
                                                                                @RequestParam("endDate") LocalDate endDate) {
        List<Promotion> promotions = promotionService.findByDiscountAndStartDateAndEndDate(discount, startDate, endDate);
        return ResponseEntity.ok(promotions);
    }
}