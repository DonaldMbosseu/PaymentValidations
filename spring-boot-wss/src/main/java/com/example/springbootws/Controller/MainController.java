package com.example.springbootws.Controller;

import com.example.springbootws.Business.Model.Payment;
import com.example.springbootws.Business.PaymentManager;
import org.apache.tomcat.util.json.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Service
@Controller
public class MainController {
    private PaymentManager paymentModel = new PaymentManager();

    @KafkaListener(topics = "online", groupId="my_group_id")
    public void getMessage(String message) throws ParseException {
        paymentModel.transformTOJSON(message);
        System.out.println(message);
    }

    @PostMapping(path = "http://localhost:9000/payment", consumes = "application/json", produces="application/json")
    @ResponseBody
    public ResponseEntity fetchResponses(@RequestBody Payment payment){
        return new ResponseEntity(HttpStatus.OK);
     }
}