package com.nero.liveshow.api;

import com.nero.liveshow.util.tls_sigature;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.io.IOException;
import java.util.UUID;

@Controller
public class HomeController {

    @GetMapping("/")
    public String list() {
        return "index";
    }

    @GetMapping("detail")
    public String detail(Model model) {
        try {
            String testName = UUID.randomUUID().toString().replaceAll("\\-", "").substring(0, 8);
            tls_sigature.GenTLSSignatureResult checkResult = tls_sigature.GenTLSSignatureEx(testName);
            model.addAttribute("identifier",testName);
            model.addAttribute("userSig",checkResult.urlSig);
            System.out.println(checkResult.urlSig);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return "detail";

    }
}
