DROP TABLE mitrais.t_usr;

CREATE TABLE mitrais.t_usr
(
    id character varying(50) COLLATE pg_catalog."default" NOT NULL,
    mobile_no character varying(20) COLLATE pg_catalog."default" NOT NULL,
	first_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
    last_name character varying(100) COLLATE pg_catalog."default" NOT NULL,
	date_of_birth date,
	gender character varying(1) COLLATE pg_catalog."default",
	email character varying(200) COLLATE pg_catalog."default" NOT NULL,
    dt_create date,
    CONSTRAINT t_usr_pk PRIMARY KEY (id)
)
WITH (
    OIDS = FALSE
)
TABLESPACE pg_default;

ALTER TABLE mitrais.t_usr
    OWNER to postgres;

GRANT ALL ON TABLE mitrais.t_usr TO postgres;
