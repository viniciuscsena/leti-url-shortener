package com.letiurl.letiurlshortener.services;

public interface ConversionService {

    String getStringFromId(long id);

    Long getIdFromString(String name);

}
