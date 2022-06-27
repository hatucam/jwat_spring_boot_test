package com.springboot.beta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.springboot.beta.entity.Seat;
import com.springboot.beta.model.ResponseSeat;
import com.springboot.beta.model.ResponseSeatEmpty;

import java.util.List;

@Repository
public interface SeatRepository extends JpaRepository<Seat, Integer> {
    //lấy ghế trống theo id film và id schedule
    @Query(name = "getSeatEmpty", nativeQuery = true)
    List<ResponseSeat> getSeatEmptyBySchedule(Integer schedule_id);
}
