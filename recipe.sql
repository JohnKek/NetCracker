-- Table: public.recipe

-- DROP TABLE public.recipe;

CREATE TABLE IF NOT EXISTS public.recipe
(
    recipe_name character varying(20) COLLATE pg_catalog."default",
    recipe_time integer,
    recipe_desc character varying(20) COLLATE pg_catalog."default",
    energy_value integer,
    recipe_img_path character varying(20) COLLATE pg_catalog."default",
    id_recipe integer NOT NULL DEFAULT nextval('recipe_id_recipe_seq'::regclass),
    CONSTRAINT recipe_pkey PRIMARY KEY (id_recipe)
)

TABLESPACE pg_default;

ALTER TABLE public.recipe
    OWNER to postgres;