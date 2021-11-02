-- Table: public.day

-- DROP TABLE IF EXISTS public.day;

CREATE TABLE IF NOT EXISTS public.day
(
    day_name character varying(20) COLLATE pg_catalog."default",
    day_menu integer,
    id_day integer NOT NULL DEFAULT nextval('day_id_day_seq'::regclass),
    CONSTRAINT day_pkey PRIMARY KEY (id_day)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.day
    OWNER to postgres;