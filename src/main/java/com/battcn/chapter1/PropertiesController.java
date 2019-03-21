package com.battcn.chapter1;

import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * @description:日志系统
 * @author : 00222 [liu.yang@unisinsight.com]
 * @date : 2019/3/19 10:02
 * @since: 1.0
 */

@RequestMapping("/properties")
@RestController
public class PropertiesController {

    public static final Logger log = LoggerFactory.getLogger(PropertiesController.class);

    public final MyProperties1 myProperties1;
    public final MyProperties2 myProperties2;

    @Autowired
    public PropertiesController(MyProperties1 myProperties1, MyProperties2 myProperties2, MyProperties2 myProperties21, MyProperties2 myProperties22) {
        this.myProperties1 = myProperties1;
        this.myProperties2 = myProperties2;
    }

    @GetMapping("/1")
    public MyProperties1 myProperties1(){
        //将信息打印在控制台上
        log.info("=================================================================================================");
        log.info(myProperties1.toString());
        log.info("=================================================================================================");
        return myProperties1;

    }

    @GetMapping("2")
    public MyProperties2 myProperties2() {
        //将信息打印在控制台上
        log.info("=================================================================================================");
        log.info(myProperties2.toString());
        log.info("=================================================================================================");
        return myProperties2;
    }
}

