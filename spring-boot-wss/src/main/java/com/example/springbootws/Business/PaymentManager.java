package com.example.springbootws.Business;

import com.example.springbootws.Persistence.PaymentDAO;
import com.example.springbootws.Persistence.SQL.SQLPaymentDAO;
import com.google.gson.Gson;
import org.apache.tomcat.util.json.JSONParser;
import org.apache.tomcat.util.json.ParseException;
import org.json.JSONObject;

public class PaymentManager {
    private PaymentDAO paymentDAO;

    public PaymentManager(){
       paymentDAO = new SQLPaymentDAO();
    }

    public void validatePayment(String messageToValidate) {
        paymentDAO = new SQLPaymentDAO();
    }

    public void transformTOJSON(String message) throws ParseException {
        Gson gson = new Gson();
        JSONParser parser = new JSONParser(message);
        JSONObject json = (JSONObject) parser.parse();
        int c = 0;
    }
}
