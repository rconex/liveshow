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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "review")
public class ReviewController {

    @Autowired
    private ReviewRepository reviewRepository;

    @ResponseBody
    @RequestMapping("/add")
    public HttpMsg add(@RequestParam(value = "uid") Integer uid, @RequestParam(value = "nickName") String nickName, @RequestParam(value = "content") String content) {
        Review review = new Review();
        review.setContent(content);
        review.setUid(uid);
        review.setNickName(nickName);

        reviewRepository.save(review);
        return new HttpMsg();
    }

    @ResponseBody
    @RequestMapping("/list")
    public Page<Review> list(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
        return reviewRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    @ResponseBody
    @RequestMapping("/detail")
    public Review detail(@RequestParam(value = "id") Long id) {
        return reviewRepository.getOne(id);
    }


}
