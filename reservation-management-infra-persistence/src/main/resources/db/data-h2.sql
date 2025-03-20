INSERT INTO BRANDS (id, name)
VALUES
(1, 'ZARA');

INSERT INTO PRICES (id, brand_id, product_id, price_list, start_date, end_date, priority, price, curr)
VALUES
(nextval('sq_prices'), 1, 35455, 1, '2020-06-14 00:00:00', '2020-12-31 23:59:59', 0, 35.50, 'EUR'),
(nextval('sq_prices'), 1, 35455, 2, '2020-06-14 15:00:00', '2020-06-14 18.30.00', 1, 25.45, 'EUR'),
(nextval('sq_prices'), 1, 35455, 3, '2020-06-15 00:00:00', '2020-06-15 11.00.00', 1, 30.50, 'EUR'),
(nextval('sq_prices'), 1, 35455, 4, '2020-06-15 16:00:00', '2020-12-31 23:59:59', 1, 38.95, 'EUR');