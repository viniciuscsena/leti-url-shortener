package com.letiurl.letiurlshortener.repositories;

import com.letiurl.letiurlshortener.entities.Url;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.time.LocalDateTime;

@Repository
public interface UrlRepository extends JpaRepository<Url, Long> {

    @Modifying
    @Transactional
    @Query( nativeQuery = true, value = "delete from url where last_access <= :date ")
    void deleteAllNotAccessedSince(@Param("date") LocalDateTime date);
}
