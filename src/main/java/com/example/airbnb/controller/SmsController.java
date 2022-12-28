package com.example.airbnb.controller;

import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsController {

    private String ACCOUNT_SID = "ACb404818affd545ab02647a41b6e59d51";

    private String TOKEN = "96961b67910e0f1aa49eb26292f223cd";

    @GetMapping(value = "/sendSMS")
    public ResponseEntity<String> sendSMS(@RequestParam String numberPhone, @RequestParam String message) {

        Twilio.init(ACCOUNT_SID, TOKEN);
        Message.creator(new PhoneNumber("+" + numberPhone),
                new PhoneNumber("+16086101069"), message).create();

        return new ResponseEntity<String>("Message sent successfully", HttpStatus.OK);
    }

}
