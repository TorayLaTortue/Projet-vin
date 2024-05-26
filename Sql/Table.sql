CREATE TABLE IF NOT EXISTS public.client
(
    "client_reference" SERIAL PRIMARY KEY,
    "name" character(100) COLLATE pg_catalog."default",
    "first_name" character(100) COLLATE pg_catalog."default",
    "eMail" character(100) COLLATE pg_catalog."default",
    "phone" character(20) COLLATE pg_catalog."default",
    "password" character(20) COLLATE pg_catalog."default",
    "role" character(100) COLLATE pg_catalog."default",
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.address
(
    "reference_address" SERIAL PRIMARY KEY,
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

CREATE TABLE IF NOT EXISTS public.commande
(
    "order_reference" SERIAL PRIMARY KEY,
    "client_reference" integer REFERENCES public.client ("client_reference"),
    "billing_address" integer REFERENCES public.address ("reference_address"),
    "delivery_address" integer REFERENCES public.address ("reference_address"),
    "status" character(100) COLLATE pg_catalog."default",
    "order_creation_datee" date,
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "quantity_product" integer,
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.fournisseur
(
    "supplier_reference" SERIAL PRIMARY KEY,
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "name" character(100) COLLATE pg_catalog."default",
    "date_creation" date,
    "valeurs_vin" character(100) COLLATE pg_catalog."default",
    "address" integer REFERENCES public.address ("reference_address"),
    "deletion_date" date
);

CREATE TABLE IF NOT EXISTS public.deposit
(
    "deposit_reference" SERIAL PRIMARY KEY,
    "deposit_name" character(100) COLLATE pg_catalog."default",
    "address" integer REFERENCES public.address ("reference_address"),
    "wine_reference" integer REFERENCES public.wine ("wine_reference"),
    "quantity" integer,
    "supplier_reference" integer REFERENCES public.fournisseur ("supplier_reference"),
    "deletion_date" date
);
