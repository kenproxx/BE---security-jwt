package com.example.airbnb.service;

import com.example.airbnb.model.UserDetail;
import com.twilio.Twilio;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class SmsService {

    private String ACCOUNT_SID = "ACb404818affd545ab02647a41b6e59d51";

    private String TOKEN = "96961b67910e0f1aa49eb26292f223cd";

    public String sendSMS(List<UserDetail> userDetails, String numberPhone, String message) {

        Twilio.init(ACCOUNT_SID, TOKEN);
        Message.creator(new PhoneNumber("+" + numberPhone),
                new PhoneNumber("+16086101069"), message).create();

        return "Message sent successfully";
    }
}
