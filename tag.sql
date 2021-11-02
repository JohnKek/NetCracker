-- Table: public.tag

-- DROP TABLE IF EXISTS public.tag;

CREATE TABLE IF NOT EXISTS public.tag
(
    tag_name character varying(20) COLLATE pg_catalog."default",
    id_tag integer NOT NULL DEFAULT nextval('tag_id_tag_seq'::regclass),
    CONSTRAINT tag_pkey PRIMARY KEY (id_tag)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.tag
    OWNER to postgres;