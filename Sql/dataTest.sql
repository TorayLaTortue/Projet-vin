-- Insertion de données de test pour la table "client"
INSERT INTO public.client (name, first_name, email, phone, password, role, deletion_date)
VALUES
    ('Dupont', 'Jean', 'jean.dupont@example.com', '123456789', 'passWord123', 'Admin', NULL),
    ('Durand', 'Pierre', 'pierre.durand@example.com', '987654321', 'passWord3210', 'User', NULL),
    ('Martin', 'Marie', 'marie.martin@example.com', '456123789', 'passWord123456', 'Supplier', NULL);

-- Insertion de données de test pour la table "address"
INSERT INTO public.address (city, street, postal_code, deletion_date)
VALUES
    ('Paris', 'Street de la Paix', '75001', NULL),
    ('Lyon', 'Avenue des Fleurs', '69000', NULL),
    ('Marseille', 'Boulevard du Port', '13000', NULL);

-- Insertion de données de test pour la table "wine"
INSERT INTO public.wine (name, picture, wine_quality, region, family, year, format, discount, price, deletion_date)
VALUES
    ('Vin1', 'picture1.jpg', 'High','Bordeaux', 'Family1', '2020-01-01', '750ml', 0.1, 20, NULL),
    ('Vin2', 'picture2.jpg', 'Low','Bourgogne', 'Family2', '2019-01-01', '750ml', 0.2, 25, NULL),
    ('Vin3', 'picture3.jpg', 'Medium','Champagne', 'Family3', '2018-01-01', '750ml', 0.15, 30, NULL),
    ('Vin4', 'https://www.lepressoirdesgourmands.fr/5282-large_default/vin-rouge-de-bordeaux-chateau-d-arcins-75cl.jpg','High', 'Bordeaux', 'Famille4', '2020-01-01', '750ml', 0.1, 20, NULL),
    ('Vin5', 'https://chateaudeportets.fr/wp-content/uploads/2021/01/Grand-Vin-du-Cht-de-Portets-2018-Pro-600x1056.png','High', 'Bourgogne', 'Famille5', '2019-01-01','750ml', 0.2, 25, NULL),
    ('Vin6', 'https://es.gerard-bertrand.com/cdn/shop/products/chateau_des_karantes_rouge_7f1a347e-8ee5-4738-8b86-c1a3286fc23b.jpg?v=1658262221', 'High','Champagne', 'Famille6', '2018-01-01', '750ml', 0.15, 30, NULL);
-- Insertion de données de test pour la table "orders"
INSERT INTO public.orders (client_reference, billing_address, delivery_address, status, order_creation_date, wine_reference, quantity_product, deletion_date)
VALUES
    (1, 1, 2, 'En cours', '2024-05-14', 1, 5, NULL),
    (2, 2, 3, 'En attente', '2024-05-14', 2, 3, NULL),
    (3, 3, 1, 'Terminée', '2024-05-14', 3, 2, NULL);

-- Insertion de données de test pour la table "supplier"
INSERT INTO public.supplier (wine_reference, client_reference, name, address, deletion_date)
VALUES
    (1, 3, 'Supplier1', 3, NULL),
    (2, 2, 'Supplier2', 2, NULL),
    (3, 1, 'Supplier3', 1, NULL);

-- Insertion de données de test pour la table "deposit"
INSERT INTO public.deposit (deposit_name, address, wine_reference, quantity, supplier_reference, deletion_date)
VALUES
    ('Deposit1', 1, 1, 100, 1, NULL),
    ('Deposit2', 2, 2, 400, 2, NULL),
    ('Deposit3', 3, 3, 200, 3, NULL);
