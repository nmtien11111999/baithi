package bt1.casemodule4.service.Impl;



import bt1.casemodule4.controller.ExceptionController;
import bt1.casemodule4.model.Promotion;
import bt1.casemodule4.repository.PromotionRepository;
import bt1.casemodule4.service.PromotionService;

import jakarta.validation.ValidationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PromotionServiceImpl implements PromotionService {
    private final PromotionRepository promotionRepository;

    @Autowired
    public PromotionServiceImpl(PromotionRepository promotionRepository) {
        this.promotionRepository = promotionRepository;
    }


    @Override
    public Promotion save(Promotion promotion, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            List<String> errors = ExceptionController.getMessageError(bindingResult);
            throw new ValidationException(errors.stream().collect(Collectors.joining("; ")));
        }
        return promotionRepository.save(promotion);
    }

    @Override
    public Promotion update(Promotion promotion, Long id, BindingResult bindingResult) {
        findById(id);
        if (bindingResult.hasErrors()) {
            List<String> errors = ExceptionController.getMessageError(bindingResult);
            throw new ValidationException(errors.stream().collect(Collectors.joining("; ")));
        }
        promotion.setId(id);
        return promotionRepository.save(promotion);
    }

    @Override
    public Optional<Promotion> findById(Long id) {
        Optional<Promotion> promotionOptional = promotionRepository.findById(id);
        if (promotionOptional.isPresent()) {
            return promotionRepository.findById(id);
        }
        throw new IllegalArgumentException();
    }


    @Override
    public Promotion delete(Long id) {
        Optional<Promotion> promotionOptional = findById(id);
        promotionRepository.deleteById(id);
        return promotionOptional.get();
    }

    @Override
    public List<Promotion> findAll() {
        if (promotionRepository.findAll().isEmpty()) {
            throw new IllegalArgumentException();
        }
        return promotionRepository.findAll();
    }


    @Override
    public List<Promotion> findByDiscount(Double discount) {
        if (promotionRepository.findByDiscount(discount).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return promotionRepository.findByDiscount(discount);
    }

    @Override
    public List<Promotion> findByStartDate(LocalDate startDate) {
        if (promotionRepository.findByStartDate(startDate).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return promotionRepository.findByStartDate(startDate);
    }

    @Override
    public List<Promotion> findByEndDate(LocalDate endDate) {
        if (promotionRepository.findByEndDate(endDate).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return promotionRepository.findByEndDate(endDate);
    }

    @Override
    public List<Promotion> findByDiscountAndStartDate(Double discount, LocalDate startDate) {
        if (promotionRepository.findByDiscountAndStartDate(discount, startDate).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return promotionRepository.findByDiscountAndStartDate(discount, startDate);
    }

    @Override
    public List<Promotion> findByStartDateAndEndDate(LocalDate endDate, LocalDate startDate) {
        if (promotionRepository.findByStartDateAndEndDate(endDate, startDate).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return promotionRepository.findByStartDateAndEndDate(endDate, startDate);
    }

    @Override
    public List<Promotion> findByDiscountAndEndDate(Double discount, LocalDate endDate) {
        if (promotionRepository.findByDiscountAndEndDate(discount, endDate).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return promotionRepository.findByDiscountAndEndDate(discount, endDate);
    }

    @Override
    public List<Promotion> findByDiscountAndStartDateAndEndDate(Double discount, LocalDate startDate, LocalDate endDate) {
        if (promotionRepository.findByDiscountAndStartDateAndEndDate(discount, startDate, endDate).isEmpty()) {
            throw new IllegalArgumentException();
        }
        return promotionRepository.findByDiscountAndStartDateAndEndDate(discount, startDate, endDate);
    }
}
