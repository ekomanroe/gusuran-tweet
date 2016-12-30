package com.springboot.controller;

import com.springboot.dto.MandatoryParameterRequest;
import com.springboot.interceptor.MandatoryParameterInterceptor;
import org.springframework.web.bind.annotation.ModelAttribute;

import javax.servlet.http.HttpServletRequest;

/**
 * Please extends this class while creating Controller
 */

/**
 * Created by eko.j.manurung on 12/17/2016.
 */
public class AbstractController {

    /**
     * Get Mandatory parameter from http servlet request
     *
     * @param request http servlet request
     * @return mandatory parameter or null
     */

    @ModelAttribute
    public MandatoryParameterRequest getMandatoryParameter(HttpServletRequest request) {
        return (MandatoryParameterRequest) request.getAttribute(MandatoryParameterInterceptor.PARAMETER);
    }
}
