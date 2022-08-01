CREATE TABLE CD (ID BIGINT NOT NULL, DESCRIPTION VARCHAR, GENRE VARCHAR, TITLE VARCHAR, TOTALDURATION DOUBLE, UNITCOST DOUBLE, MUSICIAN_ID BIGINT, PRIMARY KEY (ID))
CREATE TABLE MUSICIAN (ID BIGINT NOT NULL, BIO VARCHAR(5000), date_of_birth DATE, first_name VARCHAR(50), last_name VARCHAR(50), preferred_instrument VARCHAR, PRIMARY KEY (ID))
ALTER TABLE CD ADD CONSTRAINT FK_CD_MUSICIAN_ID FOREIGN KEY (MUSICIAN_ID) REFERENCES MUSICIAN (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT NUMERIC(38), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
