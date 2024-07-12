package bt1.casemodule4.service;

import bt1.casemodule4.model.Promotion;


import java.time.LocalDate;
import java.util.List;

public interface PromotionService extends IService<Promotion>{
    List<Promotion> findByDiscount(Double discount);
    List<Promotion> findByStartDate(LocalDate startDate);
    List<Promotion> findByEndDate(LocalDate endDate);
    List<Promotion> findByDiscountAndStartDate(Double discount, LocalDate startDate);
    List<Promotion> findByStartDateAndEndDate(LocalDate endDate, LocalDate startDate);
    List<Promotion> findByDiscountAndEndDate(Double discount, LocalDate endDate);
    List<Promotion> findByDiscountAndStartDateAndEndDate(Double discount, LocalDate startDate, LocalDate endDate);

}