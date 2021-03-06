CREATE TABLE atp_players (ID INTEGER NOT NULL, player_age INTEGER, player_birth DATE, player_name VARCHAR(255), player_surname VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE atp_players2 (ID INTEGER NOT NULL, player_age INTEGER, player_birth DATE, player_name VARCHAR(255), player_surname VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE atp_tournaments2 (ID INTEGER NOT NULL, TOURNAMENT VARCHAR(255), PRIMARY KEY (ID))
CREATE TABLE atp_players2_atp_tournaments2 (players_ID INTEGER NOT NULL, tournaments_ID INTEGER NOT NULL, PRIMARY KEY (players_ID, tournaments_ID))
ALTER TABLE atp_players2_atp_tournaments2 ADD CONSTRAINT tpplyrs2tptrplyrsD FOREIGN KEY (players_ID) REFERENCES atp_players2 (ID)
ALTER TABLE atp_players2_atp_tournaments2 ADD CONSTRAINT tpplyrs2tptrnmntsD FOREIGN KEY (tournaments_ID) REFERENCES atp_tournaments2 (ID)
CREATE TABLE SEQUENCE (SEQ_NAME VARCHAR(50) NOT NULL, SEQ_COUNT DECIMAL(15), PRIMARY KEY (SEQ_NAME))
INSERT INTO SEQUENCE(SEQ_NAME, SEQ_COUNT) values ('SEQ_GEN', 0)
