package bt1.casemodule4.repository;

import bt1.casemodule4.model.Promotion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface PromotionRepository extends JpaRepository<Promotion,Long> {
    List<Promotion> findByDiscount(Double discount);
    List<Promotion> findByStartDate(LocalDate startDate);
    List<Promotion> findByEndDate(LocalDate endDate);
    List<Promotion> findByDiscountAndStartDate(Double discount, LocalDate startDate);
    List<Promotion> findByStartDateAndEndDate(LocalDate endDate, LocalDate startDate);
    List<Promotion> findByDiscountAndEndDate(Double discount, LocalDate endDate);
    List<Promotion> findByDiscountAndStartDateAndEndDate(Double discount, LocalDate startDate, LocalDate endDate);
}
