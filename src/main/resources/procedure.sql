drop procedure generateShortUrl;
DELIMITER $$
CREATE PROCEDURE `generateShortUrl`(
    IN id_param BIGINT,
    IN long_url VARCHAR(255),
    out id BIGINT
)
BEGIN

    IF id_param IS NULL THEN
        SET id = FLOOR(RAND() * 9223372036854775807);
    ELSE
        SET id = id_param;
    END IF;

    INSERT INTO url (id, long_url, creation_date, last_access)
    VALUES (new_id, long_url, NOW(), NOW());
END $$

DELIMITER ;
