DROP TABLE IF EXISTS customer;

CREATE TABLE  customer (
  CUST_ID Bigserial  PRIMARY KEY NOT NULL,
  NAME varchar(100) NOT NULL,
  AGE smallint NOT NULL
);
