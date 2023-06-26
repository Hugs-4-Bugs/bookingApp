package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class BookingDTO {
    private Long id;
    private Long userId;
    private Long scheduleId;

    @NotNull(message = "Total passengers cannot be empty")
    @Min(value = 1, message = "Total passengers must be greater than 0")
    private Integer totalPassengers;

    @NotNull(message = "Total amount cannot be empty")
    @Min(value = 0, message = "Total amount must be greater than or equal to 0")
    private Double totalAmount;

    private Long paymentMethodId;
    private String status;
}
