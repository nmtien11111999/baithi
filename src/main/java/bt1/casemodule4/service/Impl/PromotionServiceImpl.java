package bt1.casemodule4.service.Impl;

import bt1.casemodule4.controller.ExceptionController;
import bt1.casemodule4.model.Promotion;
import bt1.casemodule4.repository.PromotionRepository;
import bt1.casemodule4.service.PromotionService;
import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Transactional
public class PromotionServiceImpl implements PromotionService {
    @Autowired
    private PromotionRepository promotionRepository;



    @Override
    public void save(Promotion promotion, BindingResult bindingResult) {
        LocalDate timeFirst = promotion.getStartDate();
        LocalDate timeLast = promotion.getEndDate();
        if (bindingResult.hasErrors()) {
            List<String> errors = ExceptionController.getMessageError(bindingResult);
            if (promotion.getName() == null) {
                errors.add("message: Tên không được để trống");
            }
            if (promotion.getStartDate() == null) {
                errors.add("message: Thời gian bắt đầu không được để trống");
            }
            if (promotion.getEndDate() == null) {
                errors.add("message: Thời gian kết thúc không được để trống");
            }
            if (promotion.getDiscount() == null) {
                errors.add("message: Mức giảm giá không được để trống");
            }
            if (promotion.getDetail() == null) {
                errors.add("message: Mức giảm giá không được để trống");
            }
            throw new ValidationException(errors.stream().collect(Collectors.joining("; ")));
        }
        List<String> errors = ExceptionController.getMessageError(bindingResult);
        if (timeFirst.isAfter(timeLast)) {
            errors.add("message: Thời gian bắt đầu phải nhỏ hơn thời gian kết thúc");
        }
        if (promotion.getDiscount() < 10000) {
            errors.add("message: Mức giảm giá phải lớn hơn 10.000 VNĐ");
        }

        if (errors.size() > 0) {
            throw new ValidationException(errors.stream().collect(Collectors.joining("; ")));
        }
        promotionRepository.save(promotion);
    }

    @Override
    public void delete(Long id) {
        promotionRepository.deleteById(id);
    }

    @Override
    public List<Promotion> findAll() {
        return promotionRepository.findAll();
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        return promotionRepository.findById(id);
    }

    @Override
    public List<Promotion> findByDiscount(Double discount) {
        return promotionRepository.findByDiscount(discount);
    }

    @Override
    public List<Promotion> findByStartDate(LocalDate startDate) {
        return promotionRepository.findByStartDate(startDate);
    }

    @Override
    public List<Promotion> findByEndDate(LocalDate endDate) {
        return promotionRepository.findByEndDate(endDate);
    }

    @Override
    public List<Promotion> findByDiscountAndStartDate(Double discount, LocalDate startDate) {
        return promotionRepository.findByDiscountAndStartDate(discount, startDate);
    }

    @Override
    public List<Promotion> findByStartDateAndEndDate(LocalDate endDate, LocalDate startDate) {
        return promotionRepository.findByStartDateAndEndDate(endDate, startDate);
    }

    @Override
    public List<Promotion> findByDiscountAndEndDate(Double discount, LocalDate endDate) {
        return promotionRepository.findByDiscountAndEndDate(discount, endDate);
    }

    @Override
    public List<Promotion> findByDiscountAndStartDateAndEndDate(Double discount, LocalDate startDate, LocalDate endDate) {
        return promotionRepository.findByDiscountAndStartDateAndEndDate(discount, startDate, endDate);
    }
}
