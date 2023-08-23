package twilio.config;

import com.twilio.Twilio;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Configuration;

@Configuration
@Slf4j
public class TwilioInitiazer {
    public TwilioInitiazer(TwilioConfiguration twilioConfiguration) {
        Twilio.init(
                twilioConfiguration.getAccountSid(),
                twilioConfiguration.getAuthToken()
        );
        log.info("Twilio sid .... {}",twilioConfiguration.getAccountSid());
    }
}
