-- Tabla users
CREATE SEQUENCE sq_prices;

-- Tabla users
CREATE TABLE BRANDS (	
    id bigint NOT NULL,
    name varchar(255) NOT NULL,
    description varchar(255) NULL
);
ALTER TABLE BRANDS
    ADD CONSTRAINT brands_pk PRIMARY KEY (id);
    
CREATE TABLE PRICES (
	id bigint NOT NULL, 
	brand_id bigint NOT NULL,  
	product_id bigint NOT NULL,
	price_list bigint NOT NULL,
    start_date timestamp NOT NULL,
    end_date timestamp NOT NULL,
    priority integer NOT NULL,
    price numeric(20, 3) NOT NULL,
    curr varchar(3) NOT NULL   
);
ALTER TABLE PRICES
    ADD CONSTRAINT prices_pk PRIMARY KEY (id);
ALTER TABLE PRICES
    ADD FOREIGN KEY (brand_id) 
    REFERENCES BRANDS(id);
    
CREATE UNIQUE INDEX prices_idx ON PRICES(brand_id, product_id, price_list);

