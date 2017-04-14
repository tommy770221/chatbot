package com.tommy.chatfuel.controller;

import com.linecorp.bot.client.LineMessagingServiceBuilder;
import com.linecorp.bot.model.ReplyMessage;
import com.linecorp.bot.model.event.CallbackRequest;
import com.linecorp.bot.model.event.Event;
import com.linecorp.bot.model.event.MessageEvent;
import com.linecorp.bot.model.message.TextMessage;
import com.linecorp.bot.model.response.BotApiResponse;
import com.linecorp.bot.servlet.LineBotCallbackException;
import com.linecorp.bot.servlet.LineBotCallbackRequestParser;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import retrofit2.Response;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;

/**
 * Created by Tommy on 2017/4/14.
 */
@RequestMapping("/line")
@Controller
public class LineBotController {
    @Autowired
    private LineBotCallbackRequestParser lineBotCallbackRequestParser;


    @RequestMapping(value = "block",method ={RequestMethod.GET,RequestMethod.POST}, produces = "application/json")
    @ResponseBody
    public String blockTemplate(HttpServletRequest httpServletRequest) throws IOException {
        StringWriter writer = new StringWriter();
        IOUtils.copy(httpServletRequest.getInputStream(), writer, "utf-8");
        String theString = writer.toString();
        System.out.println(theString);
        try {
            CallbackRequest callbackRequest = lineBotCallbackRequestParser.handle(httpServletRequest);
            List<Event> events= callbackRequest.getEvents();
            for(Event event:events){
                MessageEvent env=(MessageEvent) event;
                TextMessage textMessage = new TextMessage("hello");
                ReplyMessage replyMessage = new ReplyMessage(
                        env.getReplyToken() ,
                        textMessage
                );
                Response<BotApiResponse> response =
                        LineMessagingServiceBuilder
                                .create("hhNohi5sJV4/yj1tvTCvBPrxSop6WKo+GsxOCbE7dI8tYc1+8xbUIFm7raVZ7CrBpkt2N29F3QngT7HyEC/OOi1Tw+n281xb7YOwXku1c1SnK4FAbkpa0J+Vzy5Xz3/6+uCw9JMjibkIjY3nilOg6wdB04t89/1O/w1cDnyilFU=")
                                .build()
                                .replyMessage(replyMessage)
                                .execute();
                System.out.println(response.code() + " " + response.message());
            }
        } catch (LineBotCallbackException e) {
            e.printStackTrace();
        }

        return "{\"test\":\""+theString+"\"}";
    }
}
