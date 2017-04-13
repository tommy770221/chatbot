package com.tommy.chatfuel.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Tommy on 2017/4/14.
 */
@RequestMapping("/chatfuel")
@Controller
public class ChatFuelController {
    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String create(@RequestParam(value = "test") String test, HttpServletRequest httpServletRequest) {
        return "{\n" +
                "  \"messages\": [\n" +
                "    {\n" +
                "      \"attachment\": {\n" +
                "        \"type\": \"template\",\n" +
                "        \"payload\": {\n" +
                "          \"template_type\": \"button\",\n" +
                "          \"text\": \"Hello!\",\n" +
                "          \"buttons\": [\n" +
                "            {\n" +
                "              \"type\": \"show_block\",\n" +
                "              \"block_name\": \"some block name\",\n" +
                "              \"title\": \"Show the block!\"\n" +
                "            },\n" +
                "            {\n" +
                "              \"type\": \"web_url\",\n" +
                "              \"url\": \"https://petersapparel.parseapp.com/buy_item?item_id=100\",\n" +
                "              \"title\": \"Buy Item\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
