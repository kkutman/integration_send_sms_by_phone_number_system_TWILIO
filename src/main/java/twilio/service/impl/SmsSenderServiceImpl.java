package twilio.service.impl;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.api.v2010.account.MessageCreator;
import com.twilio.type.PhoneNumber;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import twilio.config.TwilioConfiguration;
import twilio.dto.SmsRequest;
import twilio.service.SmsSenderService;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class SmsSenderServiceImpl implements SmsSenderService {
    private final TwilioConfiguration twilioConfiguration;

    @Override
    public MessageCreator smsSender(SmsRequest request) {
        PhoneNumber to = new PhoneNumber(request.getPhoneNumber());
        PhoneNumber from = new PhoneNumber(twilioConfiguration.getTrialNumber());
        String message = "Test number : "+new Random().nextInt(0,10000);
        return new MessageCreator(
                to,
                from,
                message
        );
    }
}
