package com.springboot.controller;

import com.springboot.Helper.BusinessException;
import com.springboot.Helper.ErrorHelper;
import com.springboot.dto.BaseResponse;
import com.springboot.dto.BaseResponseBuilder;
import com.springboot.dto.MandatoryParameterRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**
 * Created by eko.j.manurung on 12/17/2016.
 */
@ApiIgnore
@RestControllerAdvice
public class ErrorHandlerController extends AbstractController {

    private static final Logger LOG = LoggerFactory.getLogger(ErrorHandlerController.class);

    @Autowired
    private ErrorHelper errorHelper;

    /**
     * Handler for validation error if user send bad request body
     *
     * @param ex exception
     * @return http response bad request
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public BaseResponse<Object> badRequest(MethodArgumentNotValidException ex, HttpServletRequest request) {
        MandatoryParameterRequest parameterRequest = getMandatoryParameter(request);

        LOG.error("BadRequest " + parameterRequest.toString() + " cause : " + ex.getMessage(), ex);

        return new BaseResponseBuilder<>()
                .withCode(HttpStatus.BAD_REQUEST.value())
                .withErrorCode(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .withErrorMessage(ex.getMessage())
                .withSuccess(false)
                .withErrors(errorHelper.toMap(ex.getBindingResult(), Locale.getDefault()))
                .build();
    }

    /**
     * Handler for validation error if user send invalid mandatory parameter
     *
     * @param ex exception
     * @return http response unauthorized
     */
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    @ExceptionHandler(BindException.class)
    public BaseResponse<Object> unauthorized(BindException ex, HttpServletRequest request) {
        MandatoryParameterRequest parameter = getMandatoryParameter(request);
        LOG.error("Unauthorized " + parameter.toString() + " cause : " + ex.getMessage(), ex);
        return new BaseResponseBuilder<>()
                .withCode(HttpStatus.UNAUTHORIZED.value())
                .withErrorCode(HttpStatus.UNAUTHORIZED.getReasonPhrase())
                .withErrorMessage(ex.getMessage())
                .withSuccess(false)
                .withErrors(errorHelper.toMap(ex.getBindingResult(), Locale.getDefault()))
                .build();
    }

    /**
     * Handler for message not readable exception
     *
     * @param t exception
     * @return http response bad request
     */
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public BaseResponse<Object> messageNotReadable(Throwable t, HttpServletResponse response, HttpServletRequest request) {
        MandatoryParameterRequest parameter = getMandatoryParameter(request);
        LOG.error("MessageNotReadable " + parameter.toString() + " cause : " + t.getMessage(), t);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new BaseResponseBuilder<>()
                .withCode(HttpStatus.BAD_REQUEST.value())
                .withErrorCode(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .withSuccess(false)
                .withErrorMessage(t.getMessage())
                .build();
    }

    /**
     * Handler for business exception
     *
     * @param t exception
     * @return http response bad request
     */
    @ExceptionHandler(BusinessException.class)
    public BaseResponse<Object> businessException(BusinessException t, HttpServletResponse response, HttpServletRequest request) {
        MandatoryParameterRequest parameter = getMandatoryParameter(request);
        LOG.error("BusinessException " + parameter.toString() + " cause : " + t.getMessage(), t);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new BaseResponseBuilder<>()
                .withErrorCode(t.getErrorCode())
                .withSuccess(false)
                .withErrorMessage(t.getErrorMessage())
                .build();
    }

    /**
     * Handler for internal server error
     *
     * @param t exception
     * @return http response internal server error
     */
    @ExceptionHandler(Throwable.class)
    public BaseResponse<Object> internalServerError(Throwable t, HttpServletResponse response, HttpServletRequest request) {
        MandatoryParameterRequest parameter = getMandatoryParameter(request);
        LOG.error("InternalServerError " + parameter.toString() + " cause : " + t.getMessage(), t);
        response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new BaseResponseBuilder<>()
                .withCode(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .withErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.getReasonPhrase())
                .withErrorMessage(t.getMessage())
                .withSuccess(false)
                .build();
    }

    /**
     * Handler for servlet request binding exception
     *
     * @param t exception
     * @return http response bad request
     */
    @ExceptionHandler(ServletRequestBindingException.class)
    public BaseResponse<Object> servletRequestBindingError(ServletRequestBindingException t, HttpServletResponse response,
                                                           HttpServletRequest request) {
        MandatoryParameterRequest parameter = getMandatoryParameter(request);
        LOG.error("ServletRequestBindingError " + parameter.toString() + " cause : " + t.getMessage(), t);
        response.setStatus(HttpStatus.BAD_REQUEST.value());
        return new BaseResponseBuilder<>()
                .withCode(HttpStatus.BAD_REQUEST.value())
                .withErrorCode(HttpStatus.BAD_REQUEST.getReasonPhrase())
                .withErrorMessage(t.getMessage())
                .withSuccess(false)
                .build();
    }
}
