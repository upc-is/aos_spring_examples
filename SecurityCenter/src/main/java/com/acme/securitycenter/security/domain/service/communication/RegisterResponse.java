package com.acme.securitycenter.security.domain.service.communication;

import com.acme.securitycenter.security.resource.UserResource;
import com.acme.securitycenter.shared.domain.service.communication.BaseResponse;

public class RegisterResponse extends BaseResponse<UserResource> {
    public RegisterResponse(String message) {
        super(message);
    }

    public RegisterResponse(UserResource resource) {
        super(resource);
    }
}
