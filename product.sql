-- Table: public.product

-- DROP TABLE public.product;

CREATE TABLE IF NOT EXISTS public.product
(
    id_product integer NOT NULL DEFAULT nextval('product_id_product_seq'::regclass),
    name character varying(30) COLLATE pg_catalog."default" DEFAULT NULL::character varying,
    calories integer,
    proteins integer,
    fats integer,
    carbonydrates integer,
    CONSTRAINT product_pkey PRIMARY KEY (id_product)
)

TABLESPACE pg_default;

ALTER TABLE public.product
    OWNER to postgres;