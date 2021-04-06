package com.controller;

import com.subject.LoginRequired;
import com.subject.MyLog;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PageController {
    @RequestMapping(value = "a")
    public String a(){
        return "a";
    }
    @LoginRequired
    @RequestMapping(value = "b")
    public String b(){
        return "b";
    }
    @MyLog
    @RequestMapping(value = "/sourceC/{source_name}")
    @ResponseBody
    public String sourceC(@PathVariable("source_name") String sourceName){
        return "你正在访问sourceC资源";
    }
}
