package com.nero.liveshow.api;

import com.nero.liveshow.dao.FocusRepository;
import com.nero.liveshow.model.Focus;
import com.nero.liveshow.vo.HttpMsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "focus")
public class FocusController {

    @Autowired
    private FocusRepository focusRepository;

    @ResponseBody
    @RequestMapping("/add")
    public HttpMsg add(@RequestParam(value = "imgUrl") String imgUrl,@RequestParam(value = "redirectUrl") String redirectUrl) {
        Focus focus = new Focus();
        focus.setImgUrl(imgUrl);
        focus.setRedirectUrl(redirectUrl);

        focusRepository.save(focus);
        return new HttpMsg();
    }

    @ResponseBody
    @RequestMapping("/update")
    public HttpMsg update(@RequestParam(value = "id") Long id, @RequestParam(value = "imgUrl") String imgUrl,@RequestParam(value = "redirectUrl") String redirectUrl) {
        Focus focus = focusRepository.getOne(id);
        if (focus == null) {
            return new HttpMsg(false, "找不到当前id的焦点图信息" );
        }
        focus.setImgUrl(imgUrl);
        focus.setRedirectUrl(redirectUrl);

        focusRepository.save(focus);
        return new HttpMsg();
    }

    @ResponseBody
    @RequestMapping("/list")
    public Page<Focus> list(@RequestParam(value = "pageNum") Integer pageNum, @RequestParam(value = "pageSize") Integer pageSize) {
        return focusRepository.findAll(PageRequest.of(pageNum, pageSize));
    }

    @ResponseBody
    @RequestMapping("/detail")
    public Focus detail(@RequestParam(value = "id") Long id) {
        return focusRepository.getOne(id);
    }


}
