package com.nero.liveshow.api;

import com.nero.liveshow.dao.ReviewRepository;
import com.nero.liveshow.dao.RoomRepository;
import com.nero.liveshow.model.Review;
import com.nero.liveshow.model.Room;
import com.nero.liveshow.vo.HttpMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @RequestMapping("/add")
    public HttpMsg add(@RequestParam(value = "uid") Integer uid, @RequestParam(value = "nickName") String nickName, @RequestParam(value = "content") String content) {
        Review review = new Review();
        review.setContent(content);
        review.setUid(uid);
        review.setNickName(nickName);

        reviewRepository.save(review);
        return new HttpMsg();
    }


    @RequestMapping("/update")
    public HttpMsg update(@RequestParam(value = "id") Long id, @RequestParam(value = "name") String name, @RequestParam(value = "priority") Integer priorit, @RequestParam(value = "cover") String cover) {
        Room room = roomRepository.getOne(id);
        if (room == null) {
            return new HttpMsg(false, "找不到当前id的房间信息");
        }
        room.setName(name);
        room.setPriority(priorit);
        room.setCover(cover);
        roomRepository.save(room);
        return new HttpMsg();
    }


    @RequestMapping("/list")
    public Page<Room> list(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
        return roomRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    @RequestMapping("/detail")
    public Room detail(@RequestParam(value = "id") Long id) {
        return roomRepository.getOne(id);
    }


}
