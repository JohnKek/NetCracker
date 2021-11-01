-- Table: public.ingridient

-- DROP TABLE public.ingridient;

CREATE TABLE IF NOT EXISTS public.ingridient
(
    id_ingridient integer NOT NULL DEFAULT nextval('ingridient_id_ingridient_seq'::regclass),
    weight integer NOT NULL,
    ingridient_product integer,
    CONSTRAINT ingridient_pkey PRIMARY KEY (id_ingridient),
    CONSTRAINT ingridient_ingridient_product_fkey FOREIGN KEY (ingridient_product)
        REFERENCES public.product (id_product) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE public.ingridient
    OWNER to postgres;