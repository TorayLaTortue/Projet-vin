CREATE TABLE IF NOT EXISTS public.client
(
    "client_reference" SERIAL PRIMARY KEY,
    "name" varchar(100) COLLATE pg_catalog."default",
    "first_name" varchar(100) COLLATE pg_catalog."default",
    "email" varchar(100) COLLATE pg_catalog."default",
    "phone" varchar(20) COLLATE pg_catalog."default",
    "password" varchar(20) COLLATE pg_catalog."default",
    "role" varchar(100) COLLATE pg_catalog."default",
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.address
(
    "address_reference" SERIAL PRIMARY KEY,
    "city" varchar(100) COLLATE pg_catalog."default",
    "street" varchar(100) COLLATE pg_catalog."default",
    "postal_code" varchar(20) COLLATE pg_catalog."default",
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.wine
(
    "wine_reference" SERIAL PRIMARY KEY,
    "name" varchar(100) COLLATE pg_catalog."default",
    "wine_quality" varchar(100) COLLATE pg_catalog."default",
    "picture" varchar(1000) COLLATE pg_catalog."default",
    "region" varchar(100) COLLATE pg_catalog."default",
    "family" varchar(100) COLLATE pg_catalog."default",
    "year" date,
    "format" varchar(100) COLLATE pg_catalog."default",
    "discount" float,
    "price" integer,
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.orders
(
    "order_reference" SERIAL PRIMARY KEY,
    "client_reference" integer REFERENCES public.client ("client_reference"),
    "billing_address" integer REFERENCES public.address ("address_reference"),
    "delivery_address" integer REFERENCES public.address ("address_reference"),
    "status" varchar(100) COLLATE pg_catalog."default",
    "order_creation_date" date,
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "quantity_product" integer,
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.supplier
(
    "supplier_reference" SERIAL PRIMARY KEY,
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "client_reference" integer REFERENCES public.client ("client_reference"),
    "name" varchar(100) COLLATE pg_catalog."default",
    "address" integer REFERENCES public.address ("address_reference"),
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.deposit
(
    "deposit_reference" SERIAL PRIMARY KEY,
    "deposit_name" varchar(100) COLLATE pg_catalog."default",
    "address" integer REFERENCES public.address ("address_reference"),
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "quantity" integer,
    "supplier_reference" integer REFERENCES public.supplier ("supplier_reference"),
    "deletion_date" date
);
