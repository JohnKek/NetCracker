-- Table: public.menu

-- DROP TABLE public.menu;

CREATE TABLE IF NOT EXISTS public.menu
(
    "id_menu" serial,
    "id_day" integer,
    PRIMARY KEY ("id_menu")
)

TABLESPACE pg_default;

ALTER TABLE public.menu
    OWNER to postgres;