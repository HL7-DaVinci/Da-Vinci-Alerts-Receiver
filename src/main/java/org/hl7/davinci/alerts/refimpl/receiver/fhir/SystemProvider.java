package org.hl7.davinci.alerts.refimpl.receiver.fhir;

import ca.uhn.fhir.rest.annotation.Operation;
import ca.uhn.fhir.rest.annotation.OperationParam;
import org.hl7.davinci.alerts.refimpl.receiver.service.MessageService;
import org.hl7.fhir.r4.model.Bundle;
import org.springframework.stereotype.Component;

@Component
public class SystemProvider {

    private MessageService messageService;

    SystemProvider(MessageService messageService) {
        this.messageService = messageService;
    }

    //TODO work with Eric on response code/type
    @Operation(name="$process-message")
    public Bundle closureOperation(@OperationParam(name = "someName") Bundle bundle){
        messageService.messageReceived(bundle);
        return bundle;
    }

}
