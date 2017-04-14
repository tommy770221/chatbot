package com.tommy.chatfuel.controller;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;

/**
 * Created by Tommy on 2017/4/14.
 */
@RequestMapping("/line")
@Controller
public class LineBotController {
    @RequestMapping(value = "block",method ={RequestMethod.GET,RequestMethod.POST}, produces = "application/json")
    @ResponseBody
    public String blockTemplate(HttpServletRequest httpServletRequest) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(httpServletRequest.getInputStream(), writer, "utf-8");
        String theString = writer.toString();
        System.out.println(theString);


        return "{\"test\":\""+theString+"\"}";
    }
}
