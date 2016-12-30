package com.springboot.dto;

import net.karneim.pojobuilder.GeneratePojoBuilder;
import org.hibernate.validator.constraints.NotEmpty;

/**
 * Created by eko.j.manurung on 12/17/2016.
 */
@GeneratePojoBuilder
public class MandatoryParameterRequest {

    @NotEmpty
    private String channelId;

    @NotEmpty
    private String requestId;

    private String username;

    public String getChannelId() {
        return channelId;
    }

    public void setChannelId(String channelId) {
        this.channelId = channelId;
    }

    public String getRequestId() {
        return requestId;
    }

    public void setRequestId(String requestId) {
        this.requestId = requestId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("MandatoryParameterRequest{");
        sb.append("channelId='").append(channelId).append('\'');
        sb.append(", requestId='").append(requestId).append('\'');
        sb.append(", username='").append(username).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
