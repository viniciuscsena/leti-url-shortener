package com.letiurl.letiurlshortener.requests;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.Setter;

@ApiModel(description = "The request to create the url to be redirected")
@Getter
@Setter
public class ShortUrlRequest {

    @ApiModelProperty(required = true, notes = "URL to be converted")
    private String longUrl;
    @ApiModelProperty(notes = "The key to call for the original url")
    private String key;

}
