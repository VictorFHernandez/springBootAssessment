DROP DATABASE IF EXISTS springassessment_db;
CREATE DATABASE IF NOT EXISTS springassessment_db;

USE springassessment_db;

CREATE USER IF NOT EXISTS assessment_user@localhost IDENTIFIED BY 'codeup';
GRANT ALL ON springassessment_db.* TO assessment_user@localhost;

CREATE TABLE IF NOT EXISTS orders (
    id INT UNSIGNED NOT NULL AUTO_INCREMENT,
    email VARCHAR (255) NOT NULL,
    total_price DOUBLE UNSIGNED NOT NULL,
    PRIMARY KEY (id)
);