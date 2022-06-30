package org.darwiin.fractionsimplifier.endpoint;

import org.darwiin.fractionsimplifier.service.SimplifierService;
import org.darwiin.soap.SimplifyFractionRequest;
import org.darwiin.soap.SimplifyFractionResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class SimplifierEndpoint {
    private static final String NAMESPACE_URI = "https://java-soap-fraction-simplificat.herokuapp.com/fractions";

    private SimplifierService service;

    @Autowired
    public SimplifierEndpoint(SimplifierService service) {
        this.service = service;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "SimplifyFractionRequest")
    @ResponsePayload
    public SimplifyFractionResponse simplify(@RequestPayload SimplifyFractionRequest request) {
        SimplifyFractionResponse response = new SimplifyFractionResponse();

        response.setFraction(service.simplify(request.getFraction()));

        return response;
    }
}
