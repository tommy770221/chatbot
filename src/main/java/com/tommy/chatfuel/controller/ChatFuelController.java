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
    public String blockTemplate(@RequestParam(value = "test") String test, HttpServletRequest httpServletRequest) {
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
                "              \"url\": \"https://pixabay.com/zh/%E5%AE%B6%E8%9D%87-%E9%A3%9E-%E5%8A%A8%E7%89%A9-%E7%BB%BF%E8%89%B2-%E7%89%B9%E5%86%99-%E6%98%86%E8%99%AB-2221549/\",\n" +
                "              \"title\": \"Buy Item\"\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }

    @RequestMapping(value = "gallery",method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    public String gallery(HttpServletRequest httpServletRequest) {
        return "{\n" +
                " \"messages\": [\n" +
                "    {\n" +
                "      \"attachment\":{\n" +
                "        \"type\":\"template\",\n" +
                "        \"payload\":{\n" +
                "          \"template_type\":\"generic\",\n" +
                "          \"elements\":[\n" +
                "            {\n" +
                "              \"title\":\"Classic White T-Shirt\",\n" +
                "              \"image_url\":\"https://pixabay.com/zh/%E5%AE%B6%E8%9D%87-%E9%A3%9E-%E5%8A%A8%E7%89%A9-%E7%BB%BF%E8%89%B2-%E7%89%B9%E5%86%99-%E6%98%86%E8%99%AB-2221549/\",\n" +
                "              \"subtitle\":\"Soft white cotton t-shirt is back in style\",\n" +
                "              \"buttons\":[\n" +
                "                {\n" +
                "                  \"type\":\"web_url\",\n" +
                "                  \"url\":\"https://pixabay.com/zh/%E5%AE%B6%E8%9D%87-%E9%A3%9E-%E5%8A%A8%E7%89%A9-%E7%BB%BF%E8%89%B2-%E7%89%B9%E5%86%99-%E6%98%86%E8%99%AB-2221549/\",\n" +
                "                  \"title\":\"View Item\"\n" +
                "                },\n" +
                "                {\n" +
                "                  \"type\":\"web_url\",\n" +
                "                  \"url\":\"https://pixabay.com/zh/%E5%AE%B6%E8%9D%87-%E9%A3%9E-%E5%8A%A8%E7%89%A9-%E7%BB%BF%E8%89%B2-%E7%89%B9%E5%86%99-%E6%98%86%E8%99%AB-2221549/\",\n" +
                "                  \"title\":\"Buy Item\"\n" +
                "                }\n" +
                "              ]\n" +
                "            },\n" +
                "            {\n" +
                "              \"title\":\"Classic Grey T-Shirt\",\n" +
                "              \"image_url\":\"https://pixabay.com/zh/%E5%AE%B6%E8%9D%87-%E9%A3%9E-%E5%8A%A8%E7%89%A9-%E7%94%9F%E6%B4%BB-%E6%98%86%E8%99%AB-%E7%89%B9%E5%86%99-2222158/\",\n" +
                "              \"subtitle\":\"Soft gray cotton t-shirt is back in style\",\n" +
                "              \"buttons\":[\n" +
                "                {\n" +
                "                  \"type\":\"web_url\",\n" +
                "                  \"url\":\"https://pixabay.com/zh/%E5%AE%B6%E8%9D%87-%E9%A3%9E-%E5%8A%A8%E7%89%A9-%E7%94%9F%E6%B4%BB-%E6%98%86%E8%99%AB-%E7%89%B9%E5%86%99-2222158/\",\n" +
                "                  \"title\":\"View Item\"\n" +
                "                },\n" +
                "                {\n" +
                "                  \"type\":\"web_url\",\n" +
                "                  \"url\":\"https://pixabay.com/zh/%E5%AE%B6%E8%9D%87-%E9%A3%9E-%E5%8A%A8%E7%89%A9-%E7%BB%BF%E8%89%B2-%E7%89%B9%E5%86%99-%E6%98%86%E8%99%AB-2221549/\",\n" +
                "                  \"title\":\"Buy Item\"\n" +
                "                }\n" +
                "              ]\n" +
                "            }\n" +
                "          ]\n" +
                "        }\n" +
                "      }\n" +
                "    }\n" +
                "  ]\n" +
                "}";
    }
}
