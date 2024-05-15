CREATE TABLE IF NOT EXISTS public.client
(
    referenceClient SERIAL PRIMARY KEY,
    nom character(100) COLLATE pg_catalog."default",
    prenom character(100) COLLATE pg_catalog."default",
    mail character(100) COLLATE pg_catalog."default",
    telephone character(20) COLLATE pg_catalog."default",
    motDePasse character(20) COLLATE pg_catalog."default",
    role character(100) COLLATE pg_catalog."default",
    dateSuppression date
);


CREATE TABLE IF NOT EXISTS public.adresse
(
    referenceAdresse SERIAL PRIMARY KEY,
    ville character(100) COLLATE pg_catalog."default",
    rue character(100) COLLATE pg_catalog."default",
    codePostal character(20) COLLATE pg_catalog."default",
    dateSuppression date
);

CREATE TABLE IF NOT EXISTS public.vin
(
    referenceVin SERIAL PRIMARY KEY,
    nom character(100) COLLATE pg_catalog."default",
    image character(100) COLLATE pg_catalog."default",
    region character(100) COLLATE pg_catalog."default",
    famille character(100) COLLATE pg_catalog."default",
    annee date,
    quantite integer,
    format character(100) COLLATE pg_catalog."default",
    promotion float,
    prix integer,
    dateSuppression date
);

CREATE TABLE IF NOT EXISTS public.commande
(
    referenceCommande SERIAL PRIMARY KEY,
    referenceClient integer REFERENCES public.client (referenceClient),
    adresseFacturation integer REFERENCES public.adresse (referenceAdresse),
    adresseLivraison integer REFERENCES public.adresse (referenceAdresse),
    statut character(100) COLLATE pg_catalog."default",
    dateCreationCommande date,
    referenceVin integer REFERENCES public.vin (referenceVin),
    quantiteProduit integer,
    dateSuppression date
);







CREATE TABLE IF NOT EXISTS public.fournisseur
(
    referenceFournisseur SERIAL PRIMARY KEY,
    referenceVin integer REFERENCES public.vin (referenceVin),
    nom character(100) COLLATE pg_catalog."default",
    dateCreation date,
    valeursVin integer,
    dateSuppression date
);

CREATE TABLE IF NOT EXISTS public.depot
(
    referenceDepot SERIAL PRIMARY KEY,
    nomDepot character(100) COLLATE pg_catalog."default",
    dateSuppression date,
    referenceVin integer REFERENCES public.vin (referenceVin),
    referenceFournisseur integer REFERENCES public.fournisseur (referenceFournisseur)
);