package com.letiurl.letiurlshortener.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel(description = "Request to create the")
public class RedirectRequest {

    @ApiModelProperty(required = true, notes = "URL to be converted")
    private String longUrl;
    @ApiModelProperty(notes = "The key to call for the original url")
    private String key;

}
