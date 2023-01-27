package com.letiurl.letiurlshortener.repositories;

import com.letiurl.letiurlshortener.entities.Url;
import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.io.Serializable;
import java.math.BigInteger;

public class IdGenerator implements IdentifierGenerator {


    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object obj) throws HibernateException {
        if (!(obj instanceof Url url))
            throw new ResponseStatusException(HttpStatus.INTERNAL_SERVER_ERROR);

        if (url.getId() != null)
            return url.getId();

        String query = "select nextval('letiurl_sequence')";

        BigInteger id = (BigInteger) session.createNativeQuery(query).stream().findAny().orElse(0);

        return  id.longValueExact();
    }
}
