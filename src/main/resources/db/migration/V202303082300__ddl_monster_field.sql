CREATE TABLE monster_compendium_api.monster_field
(
 "id"          bigserial NOT NULL,
 "value"        text NOT NULL,
 monster_id bigint NOT NULL,
 field_id bigint NOT NULL,
 PRIMARY KEY ( "id" ),
 FOREIGN KEY ( monster_id ) REFERENCES monster_compendium_api.monster ( "id" ),
 FOREIGN KEY ( field_id ) REFERENCES monster_compendium_api.field ( "id" )
);

CREATE INDEX monster_field_field_id_idx ON monster_compendium_api.monster_field (field_id);
CREATE INDEX monster_field_monster_id_idx ON monster_compendium_api.monster_field (monster_id);