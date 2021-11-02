-- Table: public.day_recipe

-- DROP TABLE IF EXISTS public.day_recipe;

CREATE TABLE IF NOT EXISTS public.day_recipe
(
    day_id integer NOT NULL,
    recipe_id integer NOT NULL,
    CONSTRAINT day_recipe_pk PRIMARY KEY (day_id, recipe_id),
    CONSTRAINT day_recipe_day_id_fkey FOREIGN KEY (day_id)
        REFERENCES public.day (id_day) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT day_recipe_recipe_id_fkey FOREIGN KEY (recipe_id)
        REFERENCES public.recipe (id_recipe) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.day_recipe
    OWNER to postgres;