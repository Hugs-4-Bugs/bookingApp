package com.booking.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.booking.util.UserOfferId;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "user_offers")
@IdClass(UserOfferId.class)
@Data
@NoArgsConstructor
public class UserOffer implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;

    @Id
    @ManyToOne
    @JoinColumn(name = "offer_id", referencedColumnName = "id")
    private Offer offer;
}
