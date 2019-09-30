CREATE TABLE IF NOT EXISTS Organization(
    id INTEGER                           COMMENT 'уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL          COMMENT 'служебное поле hibernate',
    name VARCHAR(10) NOT NULL            COMMENT 'имя компании',
    full_name VARCHAR(50) NOT NULL       COMMENT 'полное имя компании',
    inn   VARCHAR(15) NOT NULL           COMMENT 'ИНН компании',
    kpp    VARCHAR(15) NOT NULL          COMMENT 'КПП компании',
    address VARCHAR(50) NOT NULL         COMMENT 'адрес компании',
    phone  VARCHAR(15)  NULL             COMMENT 'телефон компании',
    is_active BOOLEAN     NULL           COMMENT 'активность фирмы'
);
COMMENT ON TABLE Organization IS 'Организация';

CREATE TABLE IF NOT EXISTS Office(
    id INTEGER                           COMMENT 'уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL          COMMENT 'служебное поле hibernate',
    name VARCHAR(20)     NULL            COMMENT 'имя офиса',
    address VARCHAR(50)     NULL         COMMENT 'адрес офиса',
    phone  VARCHAR(15) NULL              COMMENT 'телефон офиса',
    is_active BOOLEAN     NULL           COMMENT 'активность офиса',
    org_id INTEGER NOT NULL              COMMENT 'идентификатор организации'
);
COMMENT ON TABLE Office IS 'Офис';

CREATE TABLE IF NOT EXISTS User(
    id INTEGER                           COMMENT 'уникальный идентификатор' PRIMARY KEY AUTO_INCREMENT ,
    version    INTEGER NOT NULL          COMMENT 'служебное поле hibernate',
    first_name VARCHAR(20) NOT NULL      COMMENT 'имя пользователя',
    second_name VARCHAR(20) NULL         COMMENT 'фамилия пользователя',
    middle_name VARCHAR(20) NULL         COMMENT 'отчество пользователя',
    position VARCHAR(50) NOT NULL        COMMENT 'должность',
    phone  VARCHAR(15) NULL              COMMENT 'телефон',
    office_id INTEGER NOT NULL           COMMENT 'идентификатор офиса',
    citizenship_code INTEGER     NULL    COMMENT 'гражданство'
);
COMMENT ON TABLE User IS 'Пользователь';

CREATE TABLE IF NOT EXISTS Doc(
    id INTEGER                           COMMENT 'уникальный идентификатор' PRIMARY KEY,
    version    INTEGER NOT NULL          COMMENT 'служебное поле hibernate',
    doc_date DATE NULL                   COMMENT 'дата документа',
    doc_number  VARCHAR(15) NULL         COMMENT 'номер документа',
    doc_code INTEGER NOT NULL            COMMENT 'идентификатор типа документа',
    is_identified BOOLEAN     NULL       COMMENT 'идентифицированный',
);
COMMENT ON TABLE Doc IS 'Документ';

CREATE TABLE IF NOT EXISTS Doc_Type(
    code INTEGER                         COMMENT 'уникальный идентификатор' PRIMARY KEY,
    version    INTEGER NOT NULL          COMMENT 'служебное поле hibernate',
    name VARCHAR(50) NOT NULL            COMMENT 'имя документа'
);
COMMENT ON TABLE Doc_Type IS 'Тип документа';

CREATE TABLE IF NOT EXISTS Country(
    code INTEGER                         COMMENT 'уникальный идентификатор' PRIMARY KEY,
    version    INTEGER NOT NULL          COMMENT 'служебное поле hibernate',
    name VARCHAR(50) NOT NULL            COMMENT 'имя страны'
);
COMMENT ON TABLE Country IS 'Страна';

CREATE INDEX IX_User_citizenship_code ON User (citizenship_code);
ALTER TABLE User ADD FOREIGN KEY (citizenship_code) REFERENCES Country(code);

CREATE INDEX IX_Doc_doc_code ON Doc (doc_code);
ALTER TABLE Doc ADD FOREIGN KEY (doc_code) REFERENCES Doc_Type(code);

CREATE INDEX IX_Doc_id ON Doc (id);
ALTER TABLE Doc ADD FOREIGN KEY (id) REFERENCES User(id);

CREATE INDEX IX_User_office_id ON User (office_id);
ALTER TABLE User ADD FOREIGN KEY (office_id) REFERENCES Office(id);

CREATE INDEX IX_Office_org_id ON Office (org_id);
ALTER TABLE Office ADD FOREIGN KEY (org_id) REFERENCES Organization(id);