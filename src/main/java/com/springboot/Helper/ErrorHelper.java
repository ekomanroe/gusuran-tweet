package com.springboot.Helper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.*;

/**
 * Created by eko.j.manurung on 12/17/2016.
 */
@Component
public class ErrorHelper {

    @Autowired
    private MessageSource messageSource;

    /**
     * Convert error to Map
     *
     * @param result bindingResult
     * @param locale locale
     * @return map error or not
     */
    public Map<String, List<String>> toMap(BindingResult result, Locale locale) {
        return ErrorHelper.toMap(result, messageSource, locale);
    }

    /**
     * convert from binding result to map of field error
     *
     * @param result        binding result
     * @param messageSource messagesource
     * @param locale        locale
     * @return map
     */
    public static Map<String, List<String>> toMap(BindingResult result, MessageSource messageSource, Locale locale) {
        if (result.hasFieldErrors()) {
            Map<String, List<String>> map = new HashMap<>();

            for (FieldError fieldError : result.getFieldErrors()) {
                String field = fieldError.getField();

                if (!map.containsKey(fieldError.getField()))
                    map.put(field, new ArrayList<>());

                String errorMessage = messageSource.getMessage(fieldError.getCode(), fieldError.getArguments(),
                        fieldError.getDefaultMessage(), locale);

                map.get(field).add(errorMessage);
            }

            return map;
        } else {
            return Collections.emptyMap();
        }
    }
}
