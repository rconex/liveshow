package com.nero.liveshow.dao;

import com.nero.liveshow.model.Review;
import com.nero.liveshow.model.Room;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReviewRepository extends JpaRepository<Review, Long> {

//     List<Room> findByType(int type, Pageable pageable);
}
