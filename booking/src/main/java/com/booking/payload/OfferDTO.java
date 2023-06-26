package com.booking.payload;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@NoArgsConstructor
public class OfferDTO {
    private Long id;

    @NotEmpty(message = "Offer name cannot be empty")
    @Size(min = 2, max = 100, message = "Offer name must be between 2 and 100 characters")
    private String offerName;

    @NotEmpty(message = "Promo code cannot be empty")
    @Size(min = 2, max = 50, message = "Promo code must be between 2 and 50 characters")
    private String promoCode;

    @NotEmpty(message = "Discount type cannot be empty")
    private String discountType;

    @NotNull(message = "Discount value cannot be empty")
    private Double discountValue;

    @NotNull(message = "Start date cannot be empty")
    private Date startDate;

    @NotNull(message = "End date cannot be empty")
    private Date endDate;


}

