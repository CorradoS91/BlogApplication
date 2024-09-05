CREATE TABLE IF NOT EXISTS USER_BLOG (
    USER_ID INT NOT NULL AUTO_INCREMENT,
    NAME varchar(255),
    SURNAME varchar(255),
    NICKNAME varchar(255),
    EMAIL varchar(255) UNIQUE,
    PRIMARY KEY (USER_ID)
);
CREATE TABLE IF NOT EXISTS POST(
    POST_ID INT NOT NULL AUTO_INCREMENT,
    TITLE varchar(255),
    SUBTITLE varchar(255),
    BODY varchar(255),
    CREATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP,
    UPDATED_AT DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
    FK_USER_ID INT,
    CONSTRAINT FK_USER_ID FOREIGN KEY (FK_USER_ID) REFERENCES USER_BLOG(USER_ID),
    PRIMARY KEY (POST_ID)
);
CREATE TABLE IF NOT EXISTS TAG(
    TAG_ID INT NOT NULL AUTO_INCREMENT,
    TAG varchar(255) UNIQUE,
    PRIMARY KEY (TAG_ID)
);
CREATE TABLE IF NOT EXISTS POST_TAG(
    POST_TAG_ID INT NOT NULL AUTO_INCREMENT,
    FK_POST_ID INT NOT NULL,
    FK_TAG_ID INT NOT NULL,
    CONSTRAINT FK_POST_ID FOREIGN KEY (FK_POST_ID) REFERENCES POST(POST_ID),
    CONSTRAINT FK_TAG_ID FOREIGN KEY (FK_TAG_ID) REFERENCES TAG(TAG_ID),
    PRIMARY KEY(POST_TAG_ID)
);