package bt1.casemodule4.controller;


import bt1.casemodule4.model.Promotion;
import bt1.casemodule4.service.PromotionService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping("/promotions")
public class PromotionController {
    private final PromotionService promotionService;

    @Autowired
    public PromotionController(PromotionService promotionService) {
        this.promotionService = promotionService;
    }

    @GetMapping
    public ResponseEntity<List<Promotion>> getAll() {
        return new ResponseEntity<>(promotionService.findAll(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Promotion> create(@Validated @RequestBody Promotion promotion, BindingResult bindingResult) {
        return new ResponseEntity<>(promotionService.save(promotion, bindingResult), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Promotion> update(@Valid @PathVariable Long id, @Validated @RequestBody Promotion promotion, BindingResult bindingResult) {
        return new ResponseEntity<>(promotionService.update(promotion, id, bindingResult), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Promotion> delete(@PathVariable Long id) {
        return new ResponseEntity<>(promotionService.delete(id), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Promotion> getById(@PathVariable Long id) {
        return new ResponseEntity<>(promotionService.findById(id).get(),HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Promotion>> searchPromotions(
            @RequestParam(required = false) Double discount,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate startDate,
            @RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)LocalDate endDate) {
        if (discount != null && startDate != null && endDate != null) {
            return new ResponseEntity<>(promotionService.findByDiscountAndStartDateAndEndDate(discount, startDate, endDate),HttpStatus.OK);
        } else if (discount != null && startDate != null) {
            return new ResponseEntity<>(promotionService.findByDiscountAndStartDate(discount, startDate),HttpStatus.OK);
        } else if (discount != null && endDate != null) {
            return new ResponseEntity<>(promotionService.findByDiscountAndEndDate(discount, endDate),HttpStatus.OK);
        } else if (startDate != null && endDate != null) {
            return new ResponseEntity<>(promotionService.findByStartDateAndEndDate(startDate, endDate),HttpStatus.OK);
        } else if (discount != null) {
            return new ResponseEntity<>(promotionService.findByDiscount(discount),HttpStatus.OK);
        } else if (startDate != null) {
            return new ResponseEntity<>(promotionService.findByStartDate(startDate),HttpStatus.OK);
        } else if (endDate != null) {
            return new ResponseEntity<>(promotionService.findByEndDate(endDate),HttpStatus.OK);
        } else {
            return new ResponseEntity<>(promotionService.findAll(),HttpStatus.OK);
        }
    }
}