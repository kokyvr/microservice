CREATE TABLE tbl_invoce_items (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  quantity DOUBLE NOT NULL,
  price DOUBLE,
  product_id BIGINT,
  invoice_id BIGINT
);


DROP TABLE IF EXISTS tlb_invoices;

CREATE TABLE tlb_invoices (
  id BIGINT AUTO_INCREMENT  PRIMARY KEY,
  number_invoice VARCHAR(250) ,
  description VARCHAR(250) ,
  customer_id BIGINT,
  create_at TIMESTAMP,
  invoice_id BIGINT,
  state VARCHAR(250)
  
);