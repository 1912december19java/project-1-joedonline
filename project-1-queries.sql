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
	reimbursement_id VARCHAR(8) NOT NULL UNIQUE,
	reimbursement_amount NUMERIC (9, 2) NOT NULL,
	reimbursement_status VARCHAR (8) NOT NULL,
	reimbursement_date_submitted VARCHAR(10) NOT NULL,
	reimbursement_date_approved VARCHAR(10) NOT NULL,
	employee_id VARCHAR (12) NOT NULL
);

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id)
VALUES ('R1000100', 353.92, 'pending', '01/03/2020', 'tbd', '789012345678'); -- mickeymouse

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id)
VALUES ('R1000110', 190.73, 'pending', '01/08/2020', 'tbd', '789012345678'); -- mickeymouse

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id)
VALUES ('R1000103', 1002.91, 'pending', '01/15/2020', 'tbd', '789012345678'); -- mickeymouse

INSERT INTO reimbursements (reimbursement_id, reimbursement_amount, reimbursement_status, reimbursement_date_submitted, reimbursement_date_approved, employee_id)
VALUES ('R1000333', 250.00, 'resolved', '01/16/2020', '01/20/2020', '789012345678'); -- mickeymouse


SELECT * FROM reimbursements;

DROP TABLE reimbursements;







--------------------------

java.lang.NullPointerException
	at repositories.dao.ReimbursementDAOImpl.getAllPendingRequests(ReimbursementDAOImpl.java:51)
	at services.ReimbursementService.getAllPendingRequests(ReimbursementService.java:17)
	at tests.TestEmployeeHomepage.testEmployeeCanViewPendingReimbursementRequests(TestEmployeeHomepage.java:71)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at java.base/jdk.internal.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at java.base/jdk.internal.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.base/java.lang.reflect.Method.invoke(Method.java:566)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.runLeaf(ParentRunner.java:325)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:78)
	at org.junit.runners.BlockJUnit4ClassRunner.runChild(BlockJUnit4ClassRunner.java:57)
	at org.junit.runners.ParentRunner$3.run(ParentRunner.java:290)
	at org.junit.runners.ParentRunner$1.schedule(ParentRunner.java:71)
	at org.junit.runners.ParentRunner.runChildren(ParentRunner.java:288)
	at org.junit.runners.ParentRunner.access$000(ParentRunner.java:58)
	at org.junit.runners.ParentRunner$2.evaluate(ParentRunner.java:268)
	at org.junit.internal.runners.statements.RunBefores.evaluate(RunBefores.java:26)
	at org.junit.internal.runners.statements.RunAfters.evaluate(RunAfters.java:27)
	at org.junit.runners.ParentRunner.run(ParentRunner.java:363)
	at org.eclipse.jdt.internal.junit4.runner.JUnit4TestReference.run(JUnit4TestReference.java:89)
	at org.eclipse.jdt.internal.junit.runner.TestExecution.run(TestExecution.java:41)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:542)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.runTests(RemoteTestRunner.java:770)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.run(RemoteTestRunner.java:464)
	at org.eclipse.jdt.internal.junit.runner.RemoteTestRunner.main(RemoteTestRunner.java:210)
