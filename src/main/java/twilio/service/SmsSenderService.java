package twilio.service;

import com.twilio.rest.api.v2010.account.MessageCreator;
import twilio.dto.SmsRequest;

public interface SmsSenderService {
    MessageCreator smsSender(SmsRequest request);
}
