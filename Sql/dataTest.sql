-- Insertion de données de test pour la table "client"
INSERT INTO public.client (name, first_name, eMail, phone, password, role, deletion_date)
VALUES
    ('Dupont', 'Jean', 'jean.dupont@example.com', '123456789', 'passWord123', 'Role1', NULL),
    ('Durand', 'Pierre', 'pierre.durand@example.com', '987654321','passWord3210', 'Role2', NULL),
    ('Martin', 'Marie', 'marie.martin@example.com', '456123789','passWord123456', 'Role3', NULL);

-- Insertion de données de test pour la table "address"
INSERT INTO public.address (city, street, postal_code, deletion_date)
VALUES
    ('Paris', 'Street de la Paix', '75001', NULL),
    ('Lyon', 'Avenue des Fleurs', '69000', NULL),
    ('Marseille', 'Boulevard du Port', '13000', NULL);

-- Insertion de données de test pour la table "wine"
INSERT INTO public.wine (name, picture, region, family, year, format, discount, price, deletion_date)
VALUES
    ('Vin1', 'picture1.jpg', 'Bordeaux', 'Family1', '2020-01-01', '750ml', 0.1, 20, NULL),
    ('Vin2', 'picture2.jpg', 'Bourgogne', 'Family2', '2019-01-01', '750ml', 0.2, 25, NULL),
    ('Vin3', 'picture3.jpg', 'Champagne', 'Family3', '2018-01-01', '750ml', 0.15, 30, NULL);

-- Insertion de données de test pour la table "commande"
INSERT INTO public.commande (client_reference, billing_address, delivery_address, status, order_creation_datee, wine_reference, quantity_product, deletion_date)
VALUES
    (1, 1, 2, 'En cours', '2024-05-14', 1, 5, NULL),
    (2, 2, 3, 'En attente', '2024-05-14', 2, 3, NULL),
    (3, 3, 1, 'Terminée', '2024-05-14', 3, 2, NULL);

-- Insertion de données de test pour la table "fournisseur"
INSERT INTO public.fournisseur (wine_reference, name, date_creation, valeurs_vin, address, deletion_date)
VALUES
    (1, 'Fournisseur1', '2020-01-01', 'cher', 3, NULL),
    (2, 'Fournisseur2', '2019-01-01', 'pas cher', 2, NULL),
    (3, 'Fournisseur3', '2018-01-01', 'j y connais rien', 1, NULL);

-- Insertion de données de test pour la table "deposit"
INSERT INTO public.deposit (deposit_reference, deposit_name, address, wine_reference, quantity, supplier_reference, deletion_date)
VALUES
    (1, 'Deposit1', 1, 1, 100, 1, NULL),
    (2, 'Deposit2', 2, 2, 400, 2, NULL),
    (3, 'Deposit3', 3, 3, 200, 3, NULL);
