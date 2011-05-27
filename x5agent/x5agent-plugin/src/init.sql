CREATE TABLE VERSION ( VALUE VARCHAR(512) );
INSERT INTO VERSION (VALUE) values ('0.0.1');

CREATE TABLE REPORTS (
  ID INTEGER NOT NULL GENERATED ALWAYS AS IDENTITY (START WITH 1, INCREMENT BY 1)
  ,CONTENT CLOB(16M) NOT NULL
  ,CREATED_AT TIMESTAMP NOT NULL
  ,SUBMITTED_AT TIMESTAMP
  ,REMOTE_ID VARCHAR(512)
);