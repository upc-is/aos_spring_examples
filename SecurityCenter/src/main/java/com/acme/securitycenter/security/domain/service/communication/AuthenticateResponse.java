package com.acme.securitycenter.security.domain.service.communication;

import com.acme.securitycenter.security.resource.AuthenticateResource;
import com.acme.securitycenter.shared.domain.service.communication.BaseResponse;

public class AuthenticateResponse extends BaseResponse<AuthenticateResource> {
    public AuthenticateResponse(String message) {
        super(message);
    }

    public AuthenticateResponse(AuthenticateResource resource) {
        super(resource);
    }
}
