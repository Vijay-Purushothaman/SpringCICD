package vj.com.demo.clg3.clgdemo.controller;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
@RestController
public class MsgController {

    private static final Logger logger = LoggerFactory.getLogger(MsgController.class);
    @GetMapping("/msg")
    public String getDept(){
        logger.info("MsgController ... getDept method calling with msg path");
        return "Welcome to SpringBoot";
    }

}
