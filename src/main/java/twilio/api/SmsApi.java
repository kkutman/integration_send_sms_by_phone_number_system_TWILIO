package twilio.api;

import com.twilio.rest.api.v2010.account.MessageCreator;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import twilio.dto.SmsRequest;
import twilio.service.SmsSenderService;

@RestController
@RequestMapping("/api/sms")
@RequiredArgsConstructor
@Tag(name = "Sens sms")
@CrossOrigin(origins = "*", maxAge = 3600)
@Slf4j
public class SmsApi {
    private final SmsSenderService service;

    @PostMapping
    @Operation(summary = "Send sms by phone number", description = "This method send sms.")
    public MessageCreator sendSms(SmsRequest request){
        MessageCreator creator = service.smsSender(request);
        creator.create();
        return creator;
    }

}
