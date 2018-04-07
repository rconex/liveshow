package com.nero.liveshow.dao;

import com.nero.liveshow.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room, Long> {
}
