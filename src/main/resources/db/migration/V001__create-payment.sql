CREATE TABLE payment(
    id VARCHAR(36) PRIMARY KEY,
    origin_agency VARCHAR(4) NOT NULL, 
    origin_account VARCHAR(6) NOT NULL, 
    destination_agency VARCHAR(4) NOT NULL, 
    destination_account VARCHAR(6) NOT NULL,
    transfer_amount DECIMAL(10, 2) NOT NULL,
    tax DECIMAL(10, 2) NOT NULL,
    transfer_date DATE NOT NULL,
    scheduling_date DATE NOT NULL
);
