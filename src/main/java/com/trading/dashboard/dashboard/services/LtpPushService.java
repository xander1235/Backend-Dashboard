package com.trading.dashboard.dashboard.services;

import com.google.gson.Gson;
import com.trading.dashboard.dashboard.pojos.Ltp.LtpDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Slf4j
public class LtpPushService {

    private final SimpMessagingTemplate simpMessagingTemplate;

    @Autowired
    public LtpPushService(SimpMessagingTemplate simpMessagingTemplate) {
        this.simpMessagingTemplate = simpMessagingTemplate;
    }

    public void pushLtpData(LtpDto ltp) {
        ltp.time(new Date());
        Gson gson = new Gson();
        String json = gson.toJson(ltp);
        log.info("ltp data: {}", json);
        simpMessagingTemplate.convertAndSend("/ltp/" + ltp.name(), json);
    }
}
