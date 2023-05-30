package com.letiurl.letiurlshortener.entities;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;


@Getter
@Setter
@Entity
@Table(name = "url")
public class Url {

    @Id //@GeneratedValue (generator = "id-generator")
    //@GenericGenerator(name = "id-generator", strategy = "com.letiurl.letiurlshortener.repositories.IdGenerator")
    private Long id;
    private String longUrl;
    private LocalDateTime creationDate;
    private LocalDateTime lastAccess;

}
