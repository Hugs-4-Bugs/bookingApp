package com.booking.repository;

import com.booking.entities.UserOffer;
import com.booking.util.UserOfferId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface UserOfferRepository extends JpaRepository<UserOffer, UserOfferId> {
}


