CREATE TABLE IF NOT EXISTS public.client
(
    "client_reference" SERIAL PRIMARY KEY,
    "name" character(100) COLLATE pg_catalog."default",
    "first_name" character(100) COLLATE pg_catalog."default",
    "email" character(100) COLLATE pg_catalog."default",
    "phone" character(20) COLLATE pg_catalog."default",
    "password" character(20) COLLATE pg_catalog."default",
    "role" character(100) COLLATE pg_catalog."default",
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.address
(
    "address_reference" SERIAL PRIMARY KEY,
    "city" character(100) COLLATE pg_catalog."default",
    "street" character(100) COLLATE pg_catalog."default",
    "postal_code" character(20) COLLATE pg_catalog."default",
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.wine
(
    "wine_reference" SERIAL PRIMARY KEY,
    "name" character(100) COLLATE pg_catalog."default",
    "picture" character(1000) COLLATE pg_catalog."default",
    "region" character(100) COLLATE pg_catalog."default",
    "family" character(100) COLLATE pg_catalog."default",
    "year" date,
    "format" character(100) COLLATE pg_catalog."default",
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
    "status" character(100) COLLATE pg_catalog."default",
    "order_creation_date" date,
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "quantity_product" integer,
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.supplier
(
    "supplier_reference" SERIAL PRIMARY KEY,
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "name" character(100) COLLATE pg_catalog."default",
    "order_creation_date" date,
    "wine_quality" character(100) COLLATE pg_catalog."default",
    "address" integer REFERENCES public.address ("address_reference"),
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.deposit
(
    "deposit_reference" SERIAL PRIMARY KEY,
    "deposit_name" character(100) COLLATE pg_catalog."default",
    "address" integer REFERENCES public.address ("address_reference"),
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "quantity" integer,
    "supplier_reference" integer REFERENCES public.supplier ("supplier_reference"),
    "deletion_date" date
);
