ALTER TABLE Driver
    ADD email VARCHAR(255) NOT NULL ,
    ADD password VARCHAR(255) NOT NULL ,
    ADD phone_number VARCHAR(255) NOT NULL ,
    ADD aadhaar_number VARCHAR(255) NOT NULL ,
    MODIFY name VARCHAR(255) NOT NULL;
