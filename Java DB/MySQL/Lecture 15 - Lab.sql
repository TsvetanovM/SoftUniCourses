#Ex 01

DELIMITER $$
CREATE FUNCTION ufn_count_employees_by_town(town_name VARCHAR(20))
RETURNS INT
DETERMINISTIC
BEGIN
	DECLARE e_count INT;
    SET e_count := (
    SELECT COUNT(employee_id) FROM employees AS e
    JOIN addresses AS a ON a.address_id = e.address_id
    JOIN towns AS t USING (town_id)
    WHERE t.name = town_name
    );
    RETURN e_count;
END $$

DELIMITER ;

SELECT ufn_count_employees_by_town(NULL);

#Ex 02

DELIMITER ##

DROP PROCEDURE usp_raise_salaries;

CREATE PROCEDURE usp_raise_salaries(department_name VARCHAR(45))
BEGIN
	UPDATE employees AS e
    SET salary = salary * 1.05
    WHERE e.department_id = 
    (SELECT d.department_id 
    FROM departments AS d
    WHERE d.`name` = department_name);
END 

DELIMITER ;

CALL usp_raise_salaries('Finance');

SELECT first_name, salary FROM employees AS e
JOIN departments AS d
USING (department_id)
WHERE `name` = 'Finance';

#Ex 03
DELIMITER ##

CREATE PROCEDURE usp_raise_salary_by_id(employee_id_param INT)
BEGIN
	START TRANSACTION;
	IF((SELECT COUNT(employee_id) FROM employees 
    WHERE employee_id LIKE employee_id_param) <> 1) 
    THEN ROLLBACK;
    ELSE 
    UPDATE employees
	SET salary = salary * 1.05
	WHERE employee_id = employee_id_param;
    END IF;
END ##

DELIMITER ;

SELECT employee_id, salary 
FROM employees
WHERE employee_id = 7;

CALL usp_raise_salary_by_id(-3);

#Ex 04

CREATE TABLE deleted_employees (
employee_id INT PRIMARY KEY,
first_name VARCHAR(45),
last_name VARCHAR(45),
middle_name VARCHAR(45),
job_title VARCHAR(45), 
department_id INT,
salary DECIMAL(10,2));

DELETE FROM employees WHERE employee_id = 3;

SELECT * FROM deleted_employees;

