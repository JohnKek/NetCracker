-- Table: public.day

-- DROP TABLE public.day;

CREATE TABLE IF NOT EXISTS public.day
(
    "id_day" serial,
    "day_name" varchar(20),
    "id_menu" serial,
    "id_recipe" integer,
    PRIMARY KEY ("id_day"),
    CONSTRAINT "FK_day.id_menu"
        FOREIGN KEY ("id_menu")
            REFERENCES "menu"("id_menu")
)

TABLESPACE pg_default;

ALTER TABLE public.day
    OWNER to postgres;