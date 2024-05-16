CREATE TABLE IF NOT EXISTS public.client
(
    "reference_client" SERIAL PRIMARY KEY,
    "nom" character(100) COLLATE pg_catalog."default",
    "prenom" character(100) COLLATE pg_catalog."default",
    "mail" character(100) COLLATE pg_catalog."default",
    "telephone" character(20) COLLATE pg_catalog."default",
    "mot_de_passe" character(20) COLLATE pg_catalog."default",
    "role" character(100) COLLATE pg_catalog."default",
    "date_suppression" date
);

CREATE TABLE IF NOT EXISTS public.adresse
(
    "reference_adresse" SERIAL PRIMARY KEY,
    "ville" character(100) COLLATE pg_catalog."default",
    "rue" character(100) COLLATE pg_catalog."default",
    "code_postal" character(20) COLLATE pg_catalog."default",
    "date_suppression" date
);

CREATE TABLE IF NOT EXISTS public.vin
(
    "reference_vin" SERIAL PRIMARY KEY,
    "nom" character(100) COLLATE pg_catalog."default",
    "image" character(1000) COLLATE pg_catalog."default",
    "region" character(100) COLLATE pg_catalog."default",
    "famille" character(100) COLLATE pg_catalog."default",
    "annee" date,
    "quantite" integer,
    "format" character(100) COLLATE pg_catalog."default",
    "promotion" float,
    "prix" integer,
    "date_suppression" date
);

CREATE TABLE IF NOT EXISTS public.commande
(
    "reference_commande" SERIAL PRIMARY KEY,
    "reference_client" integer REFERENCES public.client ("reference_client"),
    "adresse_facturation" integer REFERENCES public.adresse ("reference_adresse"),
    "adresse_livraison" integer REFERENCES public.adresse ("reference_adresse"),
    "statut" character(100) COLLATE pg_catalog."default",
    "date_creation_commande" date,
    "reference_vin" integer REFERENCES public.vin ("reference_vin"),
    "quantite_produit" integer,
    "date_suppression" date
);

CREATE TABLE IF NOT EXISTS public.fournisseur
(
    "reference_fournisseur" SERIAL PRIMARY KEY,
    "reference_vin" integer REFERENCES public.vin ("reference_vin"),
    "nom" character(100) COLLATE pg_catalog."default",
    "date_creation" date,
    "valeurs_vin" character(100) COLLATE pg_catalog."default",
    "adresse" integer REFERENCES public.adresse ("reference_adresse"),
    "date_suppression" date
);

CREATE TABLE IF NOT EXISTS public.depot
(
    "reference_depot" SERIAL PRIMARY KEY,
    "nom_depot" character(100) COLLATE pg_catalog."default",
    "adresse" integer REFERENCES public.adresse ("reference_adresse"),
    "reference_vin" integer REFERENCES public.vin ("reference_vin"),
    "reference_fournisseur" integer REFERENCES public.fournisseur ("reference_fournisseur"),
    "date_suppression" date
);
