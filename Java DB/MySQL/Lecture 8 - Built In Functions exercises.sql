SELECT first_name, last_name FROM employees
WHERE first_name LIKE 'Sa%'
ORDER BY `employee_id`;

SELECT first_name, last_name FROM employees
WHERE LOWER(last_name) LIKE '%ei%'
ORDER BY `employee_id`;

SELECT first_name FROM employees
WHERE department_id IN (3,10) AND EXTRACT(YEAR FROM hire_date) BETWEEN 1995 AND 2005;

SELECT first_name, last_name FROM employees
WHERE job_title NOT LIKE '%engineer%';

SELECT `name` FROM towns
WHERE CHAR_LENGTH(`name`) IN (5,6)
ORDER BY `name`;

SELECT * FROM towns
WHERE `name` REGEXP '^[MKBE]'
ORDER BY `name`;

SELECT * FROM towns
WHERE `name` NOT REGEXP '^[RBD]'
ORDER BY `name`;

CREATE VIEW v_employees_hired_after_2000 
AS
SELECT first_name, last_name FROM employees
WHERE YEAR(hire_date) > 2000;

SELECT * FROM v_employees_hired_after_2000;

SELECT first_name, last_name FROM employees
WHERE YEAR(hire_date) >= 2000
ORDER BY `employee_id`;

SELECT first_name, last_name FROM employees
WHERE CHAR_LENGTH(last_name) = 5;

USE geography;

SELECT country_name, iso_code FROM countries
WHERE country_name REGEXP '.*[Aa].*[Aa].*[Aa].*'
ORDER BY iso_code;

SELECT peak_name, river_name, LOWER(CONCAT(peak_name, SUBSTR(river_name, 2))) AS `mix`
FROM peaks, rivers
WHERE RIGHT(peak_name, 1) = LEFT(river_name, 1)
ORDER BY `mix`;

USE diablo;

SELECT `name`, DATE_FORMAT(DATE(`start`), '%Y-%m-%d') AS `start` FROM games
WHERE YEAR(`start`) IN (2011, 2012)
ORDER BY `start`, `name`
LIMIT 50;

SELECT email FROM users;

SELECT user_name, SUBSTR(email, LOCATE('@', email) + 1) AS `Email Provider` FROM users
ORDER BY `Email Provider`, user_name;

SELECT user_name, ip_address FROM users
WHERE ip_address LIKE '___.1%.%.___'
ORDER BY user_name;

SELECT `start`, `duration` FROM games;

SELECT `name` AS `game`, 
IF(HOUR(`start`) < 12, 'Morning', IF(HOUR(`start`) < 18, 'Afternoon', 'Evening')) AS `Part of the Day`,
IF(`duration` <= 3, 'Extra Short', IF(`duration` <= 6, 'Short', IF(`duration` <= 10, 'Long', 'Extra Long'))) AS `Duration`
FROM games;

/*Alternative Solution - Using Case instead of nested IFs
*/

SELECT `name` as `game`, 
(CASE 
	WHEN HOUR(`start`) BETWEEN 0 AND 11 THEN 'Morning'
	WHEN HOUR(`start`) BETWEEN 12 AND 17 THEN 'Afternoon'
	ELSE 'Evening'
END) AS `Part of the Day`,
(CASE
	WHEN duration <= 3 THEN 'Extra Short'
	WHEN duration <= 6 THEN 'Short'
	WHEN duration <= 10 THEN 'Long'
	ELSE 'Extra Long'
END) AS `Duration`
FROM games;

USE orders;

SELECT product_name, order_date, 
ADDDATE(order_date, INTERVAL 3 DAY) AS `pay_due`, 
ADDDATE(order_date, INTERVAL 1 MONTH) AS `deliver_due`
FROM orders;



