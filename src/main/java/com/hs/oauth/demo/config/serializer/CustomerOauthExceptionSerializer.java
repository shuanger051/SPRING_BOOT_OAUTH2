package com.hs.oauth.demo.config.serializer;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.ser.std.StdSerializer;
import com.hs.oauth.demo.exception.BizException;
import com.hs.oauth.demo.exception.CustomerOauthException;
import com.hs.oauth.demo.exception.builder.ErrorBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomerOauthExceptionSerializer extends StdSerializer<CustomerOauthException> {

    private static final Logger logger = LoggerFactory.getLogger(CustomerOauthExceptionSerializer.class);

    public CustomerOauthExceptionSerializer() {
        super(CustomerOauthException.class);
    }

    @Override
    public void serialize(CustomerOauthException value, JsonGenerator gen, SerializerProvider provider) {
        throw new BizException(ErrorBuilder.buildBizError(value.getHttpErrorCode(),"200006",value.getMessage()));
    }


}
