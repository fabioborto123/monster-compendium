CREATE TABLE monster_compendium_api.template
(
 "id"   bigserial NOT NULL,
 name text NOT NULL,
 CONSTRAINT template_pkey PRIMARY KEY ( "id" )
);


CREATE TABLE monster_compendium_api.monster
(
 "id"          bigserial NOT NULL,
 name        text NOT NULL,
 template_id bigint NOT NULL,
 CONSTRAINT monster_pkey PRIMARY KEY ( "id" ),
 CONSTRAINT monster_template_fkey FOREIGN KEY ( template_id ) REFERENCES monster_compendium_api.template ( "id" )
);

CREATE INDEX monster_template_id_idx ON monster_compendium_api.monster
(
 template_id
);


CREATE TABLE monster_compendium_api.field
(
 "id"          bigserial NOT NULL,
 name        text NOT NULL,
 template_id bigint NOT NULL,
 CONSTRAINT field_pkey PRIMARY KEY ( "id" ),
 CONSTRAINT field_template_fkey FOREIGN KEY ( template_id ) REFERENCES monster_compendium_api.template ( "id" )
);

CREATE INDEX field_template_id_idx ON monster_compendium_api.field
(
 template_id
);
