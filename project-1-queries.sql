CREATE TABLE employees (
	employee_id VARCHAR (12) NOT NULL UNIQUE,
	firstName VARCHAR (64) NOT NULL,
	lastName VARCHAR (64) NOT NULL,
	city VARCHAR (64) NOT NULL,
	state VARCHAR (64) NOT NULL,
	zipcode VARCHAR (5) NOT NULL
);


INSERT INTO employees (employee_id, firstName, lastName, city, state, zipcode)
VALUES ('123456789012', 'Ronald', 'McDonald', 'Sacramento', 'California', '94203');

INSERT INTO employees (employee_id, firstName, lastName, city, state, zipcode)
VALUES ('567890123456', 'Babs', 'Bunny', 'Orlando', 'Florida', '32789');

INSERT INTO employees (employee_id, firstName, lastName, city, state, zipcode)
VALUES ('789012345678', 'Mickey', 'Mouse', 'Tysons Corner', 'Virginia', '22043');

-- EMPLOYEE INFORMATION JOIN
SELECT emp.employee_id, emp.firstName, emp.lastName, emp.city, emp.state, emp.zipcode, ers.email, ers.username, ers.userrole
FROM employees emp
JOIN ers_users ers
ON emp.employee_id = ers.employee_id;

SELECT * FROM employees;

DROP TABLE employees;

--------------------------------------------------------------------------------
CREATE TABLE ers_users (
	username VARCHAR (32) NOT NULL UNIQUE,
	userpass VARCHAR (64) NOT NULL,
	userrole VARCHAR (32) NOT NULL,
	email VARCHAR (128) UNIQUE,
	employee_id VARCHAR (12) NOT NULL
);

SELECT * FROM ers_users;

INSERT INTO ers_users (employee_id, username, userpass, userrole, email)
VALUES ('123456789012', 'ronaldmcdonald', 'hispassword', 'employee', 'ronald.mcdonald@fake.email');

INSERT INTO ers_users (employee_id, username, userpass, userrole, email)
VALUES ('567890123456', 'babsbunny', 'herpassword', 'employee', 'babs.bunny@fake.email');

INSERT INTO ers_users (employee_id, username, userpass, userrole, email)
VALUES ('789012345678', 'mickeymouse', 'anotherpassword123', 'manager', 'mickey@mouse.fake');

SELECT userpass FROM ers_users WHERE username = 'ronaldmcdonald';

SELECT * FROM ers_users WHERE username = 'mickeymouse';

DROP TABLE ers_users;
