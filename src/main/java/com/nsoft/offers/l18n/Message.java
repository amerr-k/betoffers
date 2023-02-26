package com.nsoft.offers.l18n;

import org.springframework.context.MessageSource;
import org.springframework.context.MessageSourceAware;
import org.springframework.context.support.MessageSourceAccessor;
import org.springframework.stereotype.Component;

@Component
public class Message implements MessageSourceAware {
	
	private MessageSourceAccessor accessor;

    @Override
    public void setMessageSource(MessageSource messageSource) {
        accessor = new MessageSourceAccessor(messageSource);
    }

    public String getMessage(String code) {
        return accessor.getMessage(code);
    }

}
