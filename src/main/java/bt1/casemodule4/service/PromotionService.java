package bt1.casemodule4.service;

import bt1.casemodule4.model.Promotion;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

public interface PromotionService {
    void save(Promotion promotion , BindingResult bindingResult);
    void delete(Long id);
    List<Promotion> findAll();
    Optional<Promotion> findById(Long id);

    List<Promotion> findByDiscount(Double discount);
    List<Promotion> findByStartDate(LocalDate startDate);
    List<Promotion> findByEndDate(LocalDate endDate);
    List<Promotion> findByDiscountAndStartDate(Double discount, LocalDate startDate);
    List<Promotion> findByStartDateAndEndDate(LocalDate endDate, LocalDate startDate);
    List<Promotion> findByDiscountAndEndDate(Double discount, LocalDate endDate);
    List<Promotion> findByDiscountAndStartDateAndEndDate(Double discount, LocalDate startDate, LocalDate endDate);
}
