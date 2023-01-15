import com.twilio.sdk.Twilio;
import com.twilio.sdk.resource.factory.MessageFactory;
import com.twilio.sdk.resource.instance.Message;
import java.util.ArrayList;
import java.util.List;
import org.apache.http.NameValuePair;
import org.apache.http.message.BasicNameValuePair;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

public class TwilioExample {
    public static final String ACCOUNT_SID = "ACbb99fd65920c2c4db2a6e2e0c3777671";
    public static final String AUTH_TOKEN = "eaf61a3e8d3d6896dfe66a68038d4ff0";

    public void sendSMS() {
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN);
        MessageFactory messageFactory = Twilio.createMessageFactory();
        List<NameValuePair> params = new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("To", "+16623396043")); // replace with the phone number of the recipient
        params.add(new BasicNameValuePair("From", "+16623396043")); // replace with your Twilio phone number
        params.add(new BasicNameValuePair("Body", "Hello, this is a test message!"));
        Message sms = messageFactory.create(params);
        System.out.println(sms.getSid());
    }
}

@RestController
public class SMSController {
    @PostMapping("/sms")
    public void receiveSMS(@RequestBody Map<String,String> body) {
        // code to handle incoming text message
        // use the TwilioExample class and sendSMS method created earlier
        TwilioExample twilioExample = new TwilioExample();
        twilioExample.sendSMS();
    }
}