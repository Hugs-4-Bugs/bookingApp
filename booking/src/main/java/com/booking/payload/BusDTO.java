package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
public class BusDTO {
    private Long id;
    private Long operatorId;

    @NotEmpty(message = "Bus type cannot be empty")
    @Size(min = 2, max = 50, message = "Bus type must be between 2 and 50 characters")
    private String busType;

    @NotNull(message = "Total seats cannot be empty")
    @Min(value = 1, message = "Total seats must be greater than 0")
    private Integer totalSeats;

    private String amenities;
}

