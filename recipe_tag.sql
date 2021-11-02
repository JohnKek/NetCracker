-- Table: public.recipe_tag

-- DROP TABLE IF EXISTS public.recipe_tag;

CREATE TABLE IF NOT EXISTS public.recipe_tag
(
    recipe_id integer NOT NULL,
    tag_id integer NOT NULL,
    CONSTRAINT recipe_tag_pk PRIMARY KEY (recipe_id, tag_id),
    CONSTRAINT recipe_tag_recipe_id_fkey FOREIGN KEY (recipe_id)
        REFERENCES public.recipe (id_recipe) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT recipe_tag_tag_id_fkey FOREIGN KEY (tag_id)
        REFERENCES public.tag (id_tag) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.recipe_tag
    OWNER to postgres;