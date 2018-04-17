package com.nero.liveshow.dao;

import com.nero.liveshow.model.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

     List<Room> findByType(Pageable pageable);
}
