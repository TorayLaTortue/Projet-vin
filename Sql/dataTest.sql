-- Insertion de données de test pour la table "client"
INSERT INTO public.client (nom, prenom, mail, telephone, commande, role, datesuppression)
VALUES
    ('Dupont', 'Jean', 'jean.dupont@example.com', '123456789', 'Commande1', 'Role1', NULL),
    ('Durand', 'Pierre', 'pierre.durand@example.com', '987654321', 'Commande2', 'Role2', NULL),
    ('Martin', 'Marie', 'marie.martin@example.com', '456123789', 'Commande3', 'Role3', NULL);

-- Insertion de données de test pour la table "adresse"
INSERT INTO public.adresse (ville, rue, codepostal, datesuppression)
VALUES
    ('Paris', 'Rue de la Paix', '75001', NULL),
    ('Lyon', 'Avenue des Fleurs', '69000', NULL),
    ('Marseille', 'Boulevard du Port', '13000', NULL);

-- Insertion de données de test pour la table "vin"
INSERT INTO public.vin (nom, image, region, famille, annee, quantite, format, promotion, prix, datesuppression)
VALUES
    ('Vin1', 'image1.jpg', 'Bordeaux', 'Famille1', '2020-01-01', 100, '750ml', 0.1, 20, NULL),
    ('Vin2', 'image2.jpg', 'Bourgogne', 'Famille2', '2019-01-01', 150, '750ml', 0.2, 25, NULL),
    ('Vin3', 'image3.jpg', 'Champagne', 'Famille3', '2018-01-01', 200, '750ml', 0.15, 30, NULL);

-- Insertion de données de test pour la table "commande"
INSERT INTO public.commande (referenceclient, adressefacturation, adresselivraison, statu, datecreationcommande, referencevin, quantiteproduit, datesuppression)
VALUES
    (1, 1, 2, 'En cours', '2024-05-14', 1, 5, NULL),
    (2, 2, 3, 'En attente', '2024-05-14', 2, 3, NULL),
    (3, 3, 1, 'Terminée', '2024-05-14', 3, 2, NULL);

-- Insertion de données de test pour la table "fournisseur"
INSERT INTO public.fournisseur (referencevin, nom, datecreation, valeursvin, datesuppression)
VALUES
    (1, 'Fournisseur1', '2020-01-01', 100, NULL),
    (2, 'Fournisseur2', '2019-01-01', 150, NULL),
    (3, 'Fournisseur3', '2018-01-01', 200, NULL);

-- Insertion de données de test pour la table "depot"
INSERT INTO public.depot (referencedepot, nomdepot, referencevin, referencefournisseur, datesuppression)
VALUES
    (1, 'Depot1', 1, 1, NULL),
    (2, 'Depot2', 2, 2, NULL),
    (3, 'Depot3', 3, 3, NULL);
