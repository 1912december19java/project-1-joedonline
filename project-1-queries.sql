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

-- GET EMPLOYEE BY ID
SELECT employee_id, firstName, lastName, city, state, zipcode
FROM employees
WHERE employee_id = '123456789012';

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

SELECT email, username, userrole FROM ers_users WHERE employee_id = '789012345678';

INSERT INTO ers_users (employee_id, username, userpass, userrole, email)
VALUES ('123456789012', 'ronaldmcdonald', 'hispassword', 'employee', 'ronald.mcdonald@fake.email');

INSERT INTO ers_users (employee_id, username, userpass, userrole, email)
VALUES ('567890123456', 'babsbunny', 'herpassword', 'employee', 'babs.bunny@fake.email');

INSERT INTO ers_users (employee_id, username, userpass, userrole, email)
VALUES ('789012345678', 'mickeymouse', 'anotherpassword123', 'manager', 'mickey@mouse.fake');

SELECT userpass FROM ers_users WHERE username = 'ronaldmcdonald';

SELECT * FROM ers_users WHERE username = 'mickeymouse';

DROP TABLE ers_users;


--------------------------------------------------------------------------------
CREATE TABLE reimbursements (
	reimbursement_id VARCHAR(64) NOT NULL UNIQUE,
	reimbursement_amount NUMERIC (32, 2) NOT NULL,
	reimbursement_status VARCHAR (64) NOT NULL,
	reimbursement_date_submitted VARCHAR(64) NOT NULL,
	reimbursement_date_approved VARCHAR(64) NOT NULL,
	employee_id VARCHAR (64) NOT NULL,
	receipt_url VARCHAR (255)
);

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)
VALUES ('R1000100', 353.92, 'pending', '01/03/2020', 'tbd', '789012345678', 'https://picsum.photos/id/237/300/200'); -- mickeymouse

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)
VALUES ('R1000110', 190.73, 'pending', '01/08/2020', 'tbd', '789012345678', 'https://picsum.photos/id/237/300/200'); -- mickeymouse

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)
VALUES ('R1000103', 1002.91, 'pending', '01/15/2020', 'tbd', '789012345678', 'https://picsum.photos/id/237/300/200'); -- mickeymouse

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)
VALUES ('R1000333', 250.00, 'resolved', '01/16/2020', '01/20/2020', '789012345678', 'https://picsum.photos/id/237/300/200'); -- mickeymouse

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)
VALUES ('R3284552', 300.19, 'resolved', '01/15/2020', '01/17/2020', '789012345678', 'https://picsum.photos/id/237/300/200'); -- mickeymouse


INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)
VALUES ('R1004198', 250.00, 'pending', '01/12/2020', 'tbd', '567890123456', 'https://picsum.photos/id/237/300/200'); -- babsbunny

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)
VALUES ('R1004100', 333.33, 'resolved', '01/12/2020', '01/12/2020', '567890123456', 'https://picsum.photos/id/237/300/200'); -- babsbunny

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id, receipt_url)
VALUES ('R1005507', 1521.21, 'resolved', '12/14/2019', '01/17/2020', '123456789012', 'https://picsum.photos/id/237/300/200'); -- ronaldmcdonald

DELETE FROM reimbursements WHERE reimbursement_id = 'R1005507';


-- all pending requests
SELECT * FROM reimbursements WHERE employee_id = '789012345678' AND reimbursement_status = 'pending';


SELECT * FROM reimbursements;

ALTER TABLE reimbursements ALTER COLUMN reimbursement_id varchar (15);

DROP TABLE reimbursements;
