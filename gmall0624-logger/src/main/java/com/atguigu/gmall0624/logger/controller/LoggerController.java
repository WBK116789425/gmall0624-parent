package com.atguigu.gmall0624.logger.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


//这个注释可以将return后的转成字符串,如果没有回报404
@RestController
@Slf4j
public class LoggerController {

    //()里是发送post请求  /后的第一个路径
    @PostMapping("log")
    public String log( @RequestParam("logString") String logString){
        //补时间戳
        //底层是hashmap所以可以用put
        JSONObject jsonObject = JSON.parseObject(logString);
        jsonObject.put("ts",System.currentTimeMillis());
        //落盘日志文件
        String jsonString = jsonObject.toJSONString();
        log.info(jsonString);
        //发送kafka
        System.out.println(logString);
        return " success";
    }
}
