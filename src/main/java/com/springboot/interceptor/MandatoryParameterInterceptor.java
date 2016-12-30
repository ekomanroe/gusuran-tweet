package com.springboot.interceptor;

import com.springboot.dto.MandatoryParameterRequest;
import com.springboot.dto.MandatoryParameterRequestBuilder;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by eko.j.manurung on 12/17/2016.
 */
public class MandatoryParameterInterceptor extends HandlerInterceptorAdapter {

    public static final String PARAMETER = "mandatory";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,
                             Object handler) throws Exception {
        MandatoryParameterRequest mandatoryParameter = getMandatoryParameter(request);
        request.setAttribute(PARAMETER, mandatoryParameter);

        return true;
    }

    /**
     * Get Mandatory parameter from httpservlet request
     *
     * @param request servlet
     * @return mandatory param
     */
    protected MandatoryParameterRequest getMandatoryParameter(HttpServletRequest request) {
        return new MandatoryParameterRequestBuilder()
                .withChannelId(request.getHeader("channelId"))
                .withRequestId(request.getHeader("requestId"))
                .withUsername(request.getHeader("username"))
                .build();
    }
}
