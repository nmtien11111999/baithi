package bt1.casemodule4.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Promotion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull(message = "Vui lòng không để trống")
    private String title;
    @Future(message = "Vui lòng chọn ngày trong tương lai")
    @NotNull(message = "Vui lòng không để trống")
    private LocalDate startDate;
    @Future(message = "Vui lòng chọn ngày trong tương lai")
    @NotNull(message = "Vui lòng không để trống")
    private LocalDate endDate;
    @NotNull(message = "Vui lòng không để trống")
    @Min(value = 10000,message = "Mức thấp nhất là 10000VNĐ")
    private Double discount;
    @NotNull(message = "Vui lòng không để trống")
    private String description;
}
