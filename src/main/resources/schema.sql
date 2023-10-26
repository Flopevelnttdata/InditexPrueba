drop table prices;
create table prices(
    brandId INTEGER NOT NULL,
    startDate TIMESTAMP,
    endDate TIMESTAMP,
    priceList INTEGER,
    productId INTEGER,
    priority INTEGER,
    price DOUBLE PRECISION,
    currency VARCHAR(10)
);