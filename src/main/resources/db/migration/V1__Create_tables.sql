CREATE TABLE users (
	id serial4 NOT NULL,
	"name" varchar NULL,
	email varchar NULL,
	phone varchar NULL,
	CONSTRAINT user_pk PRIMARY KEY (id)
);

CREATE TABLE address (
	id serial4 NOT NULL,
	street varchar NULL,
	"number" varchar NULL,
	state varchar NULL,
	zip_code varchar NULL,
	country varchar NULL,
	user_id int4 NOT NULL,
	CONSTRAINT address_pk PRIMARY KEY (id),
	CONSTRAINT address_users_fk FOREIGN KEY (user_id) REFERENCES public.users(id) ON DELETE CASCADE ON UPDATE CASCADE
);

CREATE TABLE product (
	id serial4 NOT NULL,
	"name" varchar NULL,
	code varchar NULL,
	price varchar NULL,
	CONSTRAINT product_pk PRIMARY KEY (id)
);