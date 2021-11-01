-- Table: public.recipe_ingridient

-- DROP TABLE public.recipe_ingridient;

CREATE TABLE IF NOT EXISTS public.recipe_ingridient
(
    recipe_id integer NOT NULL,
    ingridient_id integer NOT NULL,
    CONSTRAINT recipe_ingridient_pk PRIMARY KEY (recipe_id, ingridient_id),
    CONSTRAINT recipe_ingridient_ingridient_id_fkey FOREIGN KEY (ingridient_id)
        REFERENCES public.ingridient (id_ingridient) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT recipe_ingridient_recipe_id_fkey FOREIGN KEY (recipe_id)
        REFERENCES public.recipe (id_recipe) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.recipe_ingridient
    OWNER to postgres;