package com.springboot.beta.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.springboot.beta.entity.Seat;
import com.springboot.beta.model.ResponseData;
import com.springboot.beta.repository.SeatRepository;
@Service
public class SeatService {
    @Autowired
    SeatRepository seatRepository;


    public ResponseData<Integer> getSeatEmpty(Integer schedule_id){

        if(seatRepository.getSeatEmptyBySchedule(schedule_id).size() == 0){
            return new ResponseData(HttpStatus.NOT_FOUND, "failed", null);
        }else{
            return new ResponseData(HttpStatus.OK, "success", seatRepository.getSeatEmptyBySchedule(schedule_id));
        }
    }
}
