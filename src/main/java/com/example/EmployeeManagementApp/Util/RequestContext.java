package com.example.EmployeeManagementApp.Util;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.annotation.RequestScope;

import java.util.UUID;

@Component
@RequestScope//@scope(value=WebApplicationContext.Scope_Request
//proxyMode=ScopedProxyMode.TARGET_CLASS)
public class RequestContext {
    private final String requestId;

    public RequestContext() {
        this.requestId= UUID.randomUUID().toString();
        System.out.println("New RequestContext Created");
        System.out.println("Request Id :"+requestId);
    }
    public String getRequestId()
    {
        return requestId;
    }
}
