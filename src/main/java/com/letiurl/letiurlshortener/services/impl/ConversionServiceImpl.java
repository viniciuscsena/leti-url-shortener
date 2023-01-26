package com.letiurl.letiurlshortener.services.impl;

import com.letiurl.letiurlshortener.services.ConversionService;
import org.springframework.stereotype.Service;

@Service
public class ConversionServiceImpl implements ConversionService {

    private static final String ALLOWED_STRING = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789-";
    private static final char[] allowedCharacters = ALLOWED_STRING.toCharArray();
    private static final int BASE = allowedCharacters.length;

    @Override
    public String getStringFromId(long id) {
        var encodedString = new StringBuilder();
        if(id == 0) {
            return String.valueOf(allowedCharacters[0]);
        }

        while (id > 0) {
            encodedString.append(allowedCharacters[(int) (id % BASE)]);
            id = id / BASE;
        }

        return encodedString.reverse().toString();
    }

    @Override
    public Long getIdFromString(String name) {
        var characters = name.toCharArray();
        var length = characters.length;

        long decoded = 0;

        //counter is used to avoid reversing input string
        var counter = 1;
        for (int i = 0; i < length; i++) {
            decoded += ALLOWED_STRING.indexOf(characters[i]) * Math.pow(BASE, (double) length - counter);
            counter++;
        }
        return decoded;
    }



}
