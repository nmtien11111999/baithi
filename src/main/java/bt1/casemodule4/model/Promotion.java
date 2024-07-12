package bt1.casemodule4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;


import java.time.LocalDate;

@Entity
@Table(name = "promotion")
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;

    @NotNull(message = "Ngày bắt đầu không được để trống")
    private LocalDate startDate;

    @NotNull(message = "Ngày hết hạn không được để trống")
    private LocalDate endDate;

    @NotNull(message = "Mức giảm giá không được để trống")
    @DecimalMin(value = "10000", message = "Mức giá phải lớn hơn hoặc bằng 10.000 VNĐ")
    private Double discount;

    @NotNull(message = "Chi tiết đơn hàng không được để trống")
    private String detail;

    public Promotion() {
    }

    public Promotion(Long id, String name, LocalDate startDate, LocalDate EndDate, Double discount, String detail) {
        this.id = id;
        this.name = name;
        this.startDate = startDate;
        this.endDate = EndDate;
        this.discount = discount;
        this.detail = detail;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate timeFirst) {
        this.startDate = timeFirst;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate timeLast) {
        this.endDate = timeLast;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscountRate(Double discount) {
        this.discount = discount;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
