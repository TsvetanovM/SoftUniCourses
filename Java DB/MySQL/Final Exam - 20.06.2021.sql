# SECTION 01 - DDL

CREATE DATABASE stc;

USE stc;

CREATE TABLE addresses (
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(100) NOT NULL
);

CREATE TABLE clients(
id INT PRIMARY KEY AUTO_INCREMENT,
`full_name` VARCHAR(50) NOT NULL,
phone_number VARCHAR(20) NOT NULL
);

CREATE TABLE categories(
id INT PRIMARY KEY AUTO_INCREMENT,
`name` VARCHAR(10) NOT NULL
);

CREATE TABLE cars(
id INT PRIMARY KEY AUTO_INCREMENT,
make VARCHAR(20) NOT NULL,
model VARCHAR(20),
`year` INT NOT NULL DEFAULT 0,
mileage INT DEFAULT 0,
`condition` CHAR(1) NOT NULL,
category_id INT NOT NULL,
CONSTRAINT fk_cars_categories
FOREIGN KEY (category_id)
REFERENCES categories(id)
);

CREATE TABLE courses(
id INT PRIMARY KEY AUTO_INCREMENT,
from_address_id INT NOT NULL,
`start` DATETIME NOT NULL,
car_id INT NOT NULL,
client_id INT NOT NULL,
bill DECIMAL(10,2) DEFAULT 10,
CONSTRAINT fk_courses_addresses
FOREIGN KEY (from_address_id)
REFERENCES addresses(id),
CONSTRAINT fk_courses_clients
FOREIGN KEY (client_id)
REFERENCES clients(id),
CONSTRAINT fk_courses_cars
FOREIGN KEY (car_id)
REFERENCES cars(id)
);

CREATE TABLE drivers (
id INT PRIMARY KEY AUTO_INCREMENT,
first_name VARCHAR(30) NOT NULL,
last_name VARCHAR(30) NOT NULL,
age INT NOT NULL,
rating FLOAT DEFAULT 5.5
);

CREATE TABLE cars_drivers (
car_id INT,
driver_id INT,
PRIMARY KEY(car_id, driver_id),
CONSTRAINT fk_cars_drivers_drivers
FOREIGN KEY (driver_id)
REFERENCES drivers(id),
CONSTRAINT fk_cars_drivers_cars
FOREIGN KEY (car_id)
REFERENCES cars(id)
);

#SECTION 2 DML

INSERT INTO clients (full_name, phone_number)
SELECT CONCAT(first_name, ' ', last_name), CONCAT('(088) 9999', id*2)
FROM drivers
WHERE id BETWEEN 10 AND 20;

UPDATE cars
SET `condition` = 'C'
WHERE (mileage >= 800000 OR mileage IS NULL)
AND `year` <= 2010;

DELETE FROM clients
WHERE id NOT IN ((SELECT DISTINCT client_id FROM courses))
AND CHAR_LENGTH(full_name) > 3;

DROP SCHEMA stc;

# SECTION 3 DQL

CREATE SCHEMA stc;

USE stc;

SELECT make, model, `condition`
FROM cars
ORDER BY id;

SELECT d.first_name, d.last_name, c.make, c.model, c.mileage
FROM drivers AS d
JOIN cars_drivers AS cd ON d.id = cd.driver_id
JOIN cars AS c ON c.id = cd.car_id
WHERE c.mileage IS NOT NULL
ORDER BY c.mileage DESC, d.first_name ASC;

SELECT c.id, c.make, c.mileage, COUNT(co.id) AS count_of_courses, ROUND(AVG(bill), 2) AS avg_bill
FROM cars AS c
LEFT JOIN courses AS co ON co.car_id = c.id
GROUP BY c.id
HAVING count_of_courses <> 2
ORDER BY count_of_courses DESC, c.id;

SELECT full_name, COUNT(co.car_id) AS count_of_cars, SUM(bill) AS total_sum
FROM clients AS cl
JOIN courses AS co ON cl.id = co.client_id
JOIN cars AS c ON co.car_id = c.id
WHERE full_name LIKE '_a%'
GROUP BY co.client_id
HAVING count_of_cars > 1
ORDER BY full_name;

SELECT a.`name`, IF(HOUR(co.`start`) BETWEEN 6 AND 20, 'Day', 'Night') AS day_time, co.bill, cl.full_name, c.make, c.model, ca.`name` 
FROM courses AS co
JOIN addresses AS a ON co.from_address_id = a.id
JOIN clients AS cl ON co.client_id = cl.id
JOIN cars AS c ON co.car_id = c.id
JOIN categories AS ca ON c.category_id = ca.id
ORDER BY co.id;


#SECTION 4 PROGRAMMABILITY

DELIMITER $$

CREATE FUNCTION udf_courses_by_client(phone_num VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE result INT;
	SET result = (SELECT COUNT(co.id)
	FROM clients AS cl
    JOIN courses AS co ON cl.id = co.client_id
    WHERE cl.phone_number = phone_num
    GROUP BY co.client_id);
	IF 
		result IS NOT NULL
		THEN 
		RETURN result;
    ELSE 
		RETURN 0;
    END IF;
    
END$$

SELECT udf_courses_by_client ('(831) 1391236') as `count`$$



CREATE PROCEDURE udp_courses_by_address(address_name VARCHAR(100))
BEGIN

		SELECT a.`name`, cl.full_name, 
        (CASE 
			WHEN bill <= 20 THEN 'Low'
            WHEN bill BETWEEN 20 AND 30 THEN 'Medium'
            ELSE 'High'
		END) AS level_of_bill, c.make, c.`condition`, ca.`name`
        FROM addresses AS a
        JOIN courses AS co ON a.id = co.from_address_id
        JOIN clients AS cl ON co.client_id = cl.id
        JOIN cars AS c ON co.car_id = c.id
        JOIN categories AS ca ON c.category_id = ca.id
        WHERE a.`name` = address_name
        ORDER BY c.make, cl.full_name;
        

END$$

DELIMITER ;

CALL udp_courses_by_address('700 Monterey Avenue');


ALTER USER `root`