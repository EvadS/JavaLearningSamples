CREATE TABLE IF NOT EXISTS users
(
  id integer NOT NULL,
  username character varying(100) NOT NULL,
  password character varying(100) NOT NULL,
  is_active smallint NOT NULL DEFAULT 1,
  CONSTRAINT users_id_key PRIMARY KEY (id),
  CONSTRAINT username_unique UNIQUE (username)
);

CREATE TABLE IF NOT EXISTS user_roles
(
  id integer NOT NULL,
  username character varying(100) NOT NULL REFERENCES users (username),
  role character varying(100) NOT NULL,
  CONSTRAINT usroles_id_key PRIMARY KEY (id),
  CONSTRAINT rolname_unique UNIQUE (role,username)
);

CREATE TABLE IF NOT EXISTS persistent_logins
(
  series character varying(64) NOT NULL,
  token character varying(64) NOT NULL,
  last_used TIMESTAMP NOT NULL,
  username character varying(100) NOT NULL REFERENCES users (username),
  CONSTRAINT pl_series_key PRIMARY KEY (series)
);

-- admin/1 user/1 --
INSERT INTO users VALUES(1,'admin','$2a$10$OjfMhs1B.ZX0MK9RmSpHBOOgNWdm2coJDPak4qwcjqdg1MQsj8i1a',1);
INSERT INTO users VALUES(2,'user','$2a$10$OjfMhs1B.ZX0MK9RmSpHBOOgNWdm2coJDPak4qwcjqdg1MQsj8i1a',1);

INSERT INTO user_roles VALUES(1,'admin','ROLE_ADMIN');
INSERT INTO user_roles VALUES(2,'admin','ROLE_USER');
INSERT INTO user_roles VALUES(3,'user','ROLE_USER');