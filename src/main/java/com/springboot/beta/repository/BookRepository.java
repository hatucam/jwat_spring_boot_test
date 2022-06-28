package com.springboot.beta.repository;

import com.springboot.beta.entity.Booking;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BookRepository extends JpaRepository<Booking, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE `booking` SET `seat_status`= '1' WHERE `user_id`= ?1 AND `booking_id`= ?2", nativeQuery = true)
    Integer updateStatus(Integer user_id, Integer booking_id);

    @Transactional
    @Modifying
    @Query(value = "INSERT INTO `booking`(`user_id`,`price`) VALUES (?1, ?2)", nativeQuery = true)
    Integer bookTicket(Integer user_id, Double price);
}
