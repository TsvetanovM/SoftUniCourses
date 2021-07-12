#Ex 01
SELECT employee_id, job_title, a.address_id, address_text
FROM employees AS e
JOIN addresses AS a
ON e.address_id = a.address_id
ORDER BY a.address_id
LIMIT 5;

#Ex 02
SELECT first_name, last_name, `name` AS town, a.address_text
FROM addresses AS a
JOIN employees AS e
ON a.address_id = e.address_id
JOIN towns AS t
ON a.town_id = t.town_id
ORDER BY first_name, last_name
LIMIT 5;

#Ex 03
SELECT employee_id, first_name, last_name, `name`
FROM employees AS e
JOIN departments AS d
USING (department_id)
WHERE `name` = 'Sales'
ORDER BY employee_id DESC;

#Ex 04
SELECT employee_id, first_name, salary, `name`
FROM employees AS e
JOIN departments AS d
USING (department_id)
WHERE salary > 15000
ORDER BY d.department_id DESC
LIMIT 5;

#Ex 05
SELECT employee_id, first_name
FROM employees
WHERE employee_id NOT IN ((SELECT DISTINCT employee_id FROM employees_projects))
ORDER BY employee_id DESC
LIMIT 3;

#Ex 06
SELECT first_name, last_name, hire_date, `name` AS dept_name
FROM employees AS e
JOIN departments
USING (department_id)
WHERE hire_date > '1999-01-01' AND `name` IN ('Sales', 'Finance')
ORDER BY hire_date;

#Ex 07
SELECT e.employee_id, e.first_name, p.`name`
FROM employees AS e
JOIN employees_projects AS ep ON e.employee_id = ep.employee_id
JOIN projects AS p USING (project_id)
WHERE DATE(p.start_date) > '2002-08-13'
AND p.end_date IS NULL
ORDER BY e.first_name, p.`name`
LIMIT 5;


#Ex 08
SELECT employee_id, first_name, IF(YEAR(start_date) < 2005, `name`, NULL) AS project_name
FROM employees_projects AS ep
JOIN employees AS e
USING (employee_id)
JOIN projects AS p
USING (project_id)
WHERE employee_id = 24
ORDER BY project_name;

#Ex 09
SELECT e1.employee_id, e1.first_name, e1.manager_id, e2.first_name AS manager_name
FROM employees AS e1
JOIN employees AS e2
ON e1.manager_id = e2.employee_id
WHERE e1.manager_id IN (3, 7)
ORDER BY e1.first_name;

#Ex 10
SELECT e1.employee_id, CONCAT(e1.first_name, ' ', e1.last_name) AS employee_name, CONCAT(e2.first_name, ' ', e2.last_name) AS manager_name, `name` AS department_name
FROM employees AS e1
JOIN employees AS e2
ON e1.manager_id = e2.employee_id
JOIN departments AS d
ON e1.department_id = d.department_id
WHERE e1.manager_id IS NOT NULL
ORDER BY e1.employee_id
LIMIT 5;

#Ex 11
SELECT AVG(salary) AS min_average_salary
FROM employees
GROUP BY department_id
ORDER BY min_average_salary ASC
LIMIT 1;

USE geography;

#Ex 12
SELECT country_code, mountain_range, peak_name, elevation
FROM mountains AS m
JOIN mountains_countries AS mc
ON m.id = mc.mountain_id
JOIN peaks AS p
ON m.id = p.mountain_id
WHERE country_code = 'BG'
AND elevation > 2835
ORDER BY elevation DESC;

#Ex 13
SELECT DISTINCT mc.country_code, (SELECT COUNT(*) FROM mountains_countries AS mc2 WHERE mc2.country_code = mc.country_code) AS mountain_range
FROM mountains_countries AS mc
WHERE country_code IN ('BG', 'US', 'RU')
ORDER BY `mountain_range` DESC;

#Ex 14
SELECT country_name, river_name
FROM countries_rivers AS cr
RIGHT JOIN countries AS c
USING (country_code)
LEFT JOIN rivers AS r
ON r.id = cr.river_id
WHERE c.continent_code = 'AF'
ORDER BY country_name
LIMIT 5;

SELECT country_name FROM countries
WHERE currency_code = 'AUD';

#Ex 15
SELECT c1.continent_code, currency_code, COUNT(currency_code) AS `currency_usage`
FROM countries AS c1
GROUP BY continent_code, currency_code
HAVING currency_usage = 
(SELECT COUNT(currency_code) AS count
FROM countries AS c2
WHERE continent_code = c1.continent_code
GROUP BY currency_code
ORDER BY count DESC
LIMIT 1 )
AND currency_usage > 1
ORDER BY continent_code, currency_code;

#Ex 16
SELECT COUNT(*) AS country_count
FROM countries AS c
WHERE c.country_code NOT IN (SELECT cm.country_code FROM mountains_countries AS cm);

#Ex 17
SELECT 
    c.country_name,
    MAX(p.elevation) AS highest_peak_elevation,
    MAX(r.length) AS longest_river_length
FROM
    countries AS c
        JOIN
    countries_rivers AS cr USING (country_code)
        JOIN
    rivers AS r ON r.id = cr.river_id
        JOIN
    mountains_countries AS mc USING (country_code)
        JOIN
    mountains AS m ON mc.mountain_id = m.id
        JOIN
    peaks AS p ON m.id = p.mountain_id
GROUP BY c.country_code
ORDER BY highest_peak_elevation DESC , longest_river_length DESC , country_name;

