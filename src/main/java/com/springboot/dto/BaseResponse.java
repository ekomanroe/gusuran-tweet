package com.springboot.dto;

import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.springframework.http.HttpStatus;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * Created by eko.j.manurung on 11/11/2016.
 */
@GeneratePojoBuilder
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 2410345913983043723L;

    private Integer code = HttpStatus.OK.value();
    private boolean success;
    private String errorCode;
    private String errorMessage;
    private Map<String, List<String>> errors;
    private T value;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Map<String, List<String>> getErrors() {
        return errors;
    }

    public void setErrors(Map<String, List<String>> errors) {
        this.errors = errors;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BaseResponse)) return false;

        BaseResponse<?> that = (BaseResponse<?>) o;

        if (isSuccess() != that.isSuccess()) return false;
        if (getCode() != null ? !getCode().equals(that.getCode()) : that.getCode() != null) return false;
        if (getErrorCode() != null ? !getErrorCode().equals(that.getErrorCode()) : that.getErrorCode() != null)
            return false;
        if (getErrorMessage() != null ? !getErrorMessage().equals(that.getErrorMessage()) : that.getErrorMessage() != null)
            return false;
        if (getErrors() != null ? !getErrors().equals(that.getErrors()) : that.getErrors() != null) return false;
        return getValue() != null ? getValue().equals(that.getValue()) : that.getValue() == null;

    }

    @Override
    public int hashCode() {
        int result = getCode() != null ? getCode().hashCode() : 0;
        result = 31 * result + (isSuccess() ? 1 : 0);
        result = 31 * result + (getErrorCode() != null ? getErrorCode().hashCode() : 0);
        result = 31 * result + (getErrorMessage() != null ? getErrorMessage().hashCode() : 0);
        result = 31 * result + (getErrors() != null ? getErrors().hashCode() : 0);
        result = 31 * result + (getValue() != null ? getValue().hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("BaseResponse{");
        sb.append("code=").append(code);
        sb.append(", success=").append(success);
        sb.append(", errorCode='").append(errorCode).append('\'');
        sb.append(", errorMessage='").append(errorMessage).append('\'');
        sb.append(", errors=").append(errors);
        sb.append(", value=").append(value);
        sb.append('}');
        return sb.toString();
    }
}
