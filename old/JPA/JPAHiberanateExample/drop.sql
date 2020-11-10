ALTER TABLE atp_players2_atp_tournaments2 DROP CONSTRAINT tpplyrs2tptrplyrsD
ALTER TABLE atp_players2_atp_tournaments2 DROP CONSTRAINT tpplyrs2tptrnmntsD
DROP TABLE atp_players
DROP TABLE atp_players2
DROP TABLE atp_tournaments2
DROP TABLE atp_players2_atp_tournaments2
DELETE FROM SEQUENCE WHERE SEQ_NAME = 'SEQ_GEN'
