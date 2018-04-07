package com.nero.liveshow.controller;

import com.nero.liveshow.dao.RoomRepository;
import com.nero.liveshow.model.Room;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoomController {

    @Autowired
    private RoomRepository roomRepository;

    @RequestMapping("/all")
    public List<Room> all() {
        return roomRepository.findAll();
    }
}
