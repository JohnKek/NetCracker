-- Table: public.user

-- DROP TABLE public.user;

CREATE TABLE IF NOT EXISTS public.user
(
    "login" varchar(20),
    "password" varchar(20),
    "user_name" varchar(20),
    "user_surname" varchar(20),
    "id_menu" serial,
    "user_rights" integer,
    PRIMARY KEY ("login"),
    CONSTRAINT fk_menu
        FOREIGN KEY(id_menu) 
            REFERENCES menu(id_menu)
)

TABLESPACE pg_default;

ALTER TABLE public.user
    OWNER to postgres;