package com.springboot.beta.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.beta.entity.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Integer> {

}
