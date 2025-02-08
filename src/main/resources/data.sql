INSERT INTO TBL_CATEGORY (NAME) VALUES ('Produção Própria');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('Nacional');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('Importado');
INSERT INTO TBL_CATEGORY (NAME) VALUES ('Premium');  

INSERT INTO TBL_PRODUCT (CATEGORY_ID, NEW_PRODUCT, PRICE, PROMOTION, DESCRIPTION, NAME) 
VALUES 
(1, TRUE, 49.99, FALSE, 'Produto artesanal feito com materiais recicláveis.', 'EcoBag Premium'),
(2, FALSE, 79.90, TRUE, 'Produto nacional em promoção, qualidade garantida.', 'Fone de Ouvido X200'),
(3, TRUE, 199.50, FALSE, 'Importado diretamente da Alemanha, alta performance.', 'Cafeteira Elétrica Turbo'),
(4, FALSE, 499.99, TRUE, 'Produto premium com 2 anos de garantia.', 'Relógio SmartLux 5.0'),
(2, TRUE, 29.99, TRUE, 'Produto nacional recém-lançado com desconto.', 'Garrafa Térmica Inox 750ml');