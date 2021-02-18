package com.trading.dashboard.dashboard.controllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.google.gson.Gson;
import com.trading.dashboard.dashboard.pojos.Ltp.LtpDto;
import com.trading.dashboard.dashboard.pojos.Ltp.LtpList;
import com.trading.dashboard.dashboard.services.LtpPushService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@Slf4j
@Validated
public class LtpController {

    private final LtpPushService ltpPushService;

    public LtpController(LtpPushService ltpPushService) {
        this.ltpPushService = ltpPushService;
    }

    @PostMapping(value = "/data", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> pushLtp(@RequestBody @Valid LtpDto ltp) throws JsonProcessingException {
        ltpPushService.pushLtpData(ltp);
        return new ResponseEntity<>(HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/stocker/{stock}")
    public ResponseEntity<String> getLtpList(@PathVariable("stock") String stock) {
        List<LtpDto> ltpLists = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            LtpDto ltpDto = LtpDto.builder()
                    .ltp((float) (Math.random() % 10))
                    .time(new Date(System.currentTimeMillis() + i))
                    .type( i%2 ==0 ? "ltp" : "random")
                    .name(stock)
                    .mark(i % 2 == 0)
                    .build();
            ltpLists.add(ltpDto);
        }
        Gson gson = new Gson();
        String json = gson.toJson(ltpLists);
        return new ResponseEntity<>(json, HttpStatus.OK);
    }
}
