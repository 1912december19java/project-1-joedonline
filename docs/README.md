# Expense Reimbursement System (ERS)

<br><br>

---
## DOCS

### Project Motivation
- The product is done **right**
- The **right** product is produced

<br>

### Project Structure

##### *`src/main/java`*
- ##### *`cors/`*
  * | `CorsFilter.java`
- ##### `exceptions/`
  * | `InvalidRequestException.java`
  * | `InvalidUsernameOrPassword.java`
- ##### `models/`
  * | `Employee.java`
  * | `EmployeeUserInfo.java`
  * | `Reimbursement.java`
  * | `User.java`
- ##### `repositories/dao/`
  * | `EmployeeDAO.java`
  * | `EmployeeDAOImpl.java`
  * | `ReimbursementDAO.java`
  * | `ReimbursementDAOImpl.java`
  * | `UserDAO.java`
  * | `UserDAOImpl.java`
- ##### `repositories/queries/`
  * | `Actions.java`
  * | `MyStatements.java`
- ##### `repositories/utilities/`
  * | `ConnectionManager.java`
  * | `DataAccessObject.java`
  * | `RandomGenerator.java`
- ##### `services/`
  * | `EmployeeService.java`
  * | `ReimbursementService.java`
  * | `UserService.java`
- ##### `servlets/`
  * | `EmployeeServlet.java`
  * | `UserServlet.java`
  * | `UserServlet.java`

<br>

##### *`src/test/java`*
- | `TestEmployeeHomepage.java`
- | `TestLoginLogout.java`
- | `TestManagerTasks.java`

<br><br>

---

## PRODUCT BACKLOG

### < Sprint 1 > `REST API`

| User Story | Status | Date Started | Date Completed
|-|-|-|-|
| An Employee can login | done | `1/14 18:14:12` | `1/17 22:33:22` |
| A Manager can login | done | `1/14 18:14:12` | `1/17 22:33:22` |
| An Employee can logout | done | `1/15 00:18:02` | `1/17 22:33:22` |
| A Manager can logout | done | `1/15 00:18:02` | `1/17 22:33:22` |
| An Employee can view the Employee Homepage | done | `1/18 10:42:41` | `1/18 15:43:09` |
| A Manager can view the Manager Homepage | done | `1/18 10:42:41` | `1/18 15:43:09` |
| An Employee can view their information | done | `1/18 15:54:44` | `1/18 23:57:03` |
| An Employee can view their pending reimbursement requests | done | `1/18 15:54:44` | `1/19 21:14:50` |
| An Employee can view their resolved reimbursement requests | done | `1/18 15:54:44` | `1/20 04:44:21` |
| An Employee can submit a reimbursement request | done | `1/18 15:54:44` | `1/18 22:47:14` |
| An Employee can update their information | *in progress* `::` U/T completed | `1/20 11:31:50` |  |
| A Manager can view all Employees | *in progress* `::` U/T completed | `1/21 22:33:03` |  |
| A Manager can view all pending requests from all employees | *in progress* `::` U/T completed | `1/21 22:33:03` |  |
| A Manager can view reimbursement requests from a single Employee | *in progress* `::` U/T completed | `1/22 03:07:55` |  |
| A Manager can view all resolved requests from all employees and see which manager resolved it | not started |  |  |
| A Manager can view images of the receipts from reimbursement requests | not started |  |  |
| A Manager can approve/deny pending reimbursement requests | not started |  |  |
| An Employee receives an email when one of their reimbursement requests is resolved (optional) | not started |  |  |
| An Employee can upload an image of his/her receipt as part of the reimbursement request | not started |  |  |

<br><br>

### < Sprint 2 > `FRON END DEV`

| User Story | Status | Date Started | Date Completed
|-|-|-|-|
| An Employee can login | not started |  |  |
| A Manager can login | not started |  |  |
| An Employee can logout | not started |  |  |
| A Manager can logout | not started |  |  |
| An Employee can view the Employee Homepage | not started |  |  |
| A Manager can view the Manager Homepage | not started |  |  |
| An Employee can view their information | not started |  |  |
| An Employee can view their pending reimbursement requests | not started |  |  |
| An Employee can view their resolved reimbursement requests | not started |  |  |
| An Employee can submit a reimbursement request | not started |  |  |
| An Employee can update their information | not started |  |  |
| A Manager can view all Employees | not started |  |  |
| A Manager can view all pending requests from all employees | not started |  |  |
| A Manager can view all resolved requests from all employees and see which manager resolved it | not started |  |  |
| A Manager can view reimbursement requests from a single Employee | not started |  |  |
| A Manager can view images of the receipts from reimbursement requests | not started |  |  |
| A Manager can approve/deny pending reimbursement requests | not started |  |  |
| An Employee receives an email when one of their reimbursement requests is resolved (optional) | not started |  |  |
| An Employee can upload an image of his/her receipt as part of the reimbursement request | not started |  |  |

<br><br>

---
### DB Design
- ##### Users
  * db name: `ers_users`
  * columns: `username`, `userpass`, `userrole`, `email`, `employee_id`

<br>

- ##### Employees
  * db name: `employees`
  * columns: `employee_id`, `firstName`, `lastName`, `city`, `state`, `zipcode`

<br><br>

### Unit Testing
- ##### TestCases: Users
  * `testWrongPasswordFailsToAuthenticate()`
  * `testRightPasswordSuccessfullyAuthenticates()`
  * `testLoginPathIsSentBackToUserAfterSuccessfulLogIn()`
  * `testLogoutPathIsSentBackToUserAfterSuccessfulLogOut()`
  * `testEmployeeCanLogout()`
  * `testTheRightHomepageURLIsSentBackToClientAfterEmployeeLogsIn()`

<br>

- ##### TestCases: Employee
  * `testEmployeeCanViewOnlyTheirInformationOnEmployeePageAccordingToEmployeeIdURL()`
  * `testEmployeeCanViewPendingReimbursementRequests()`
  * `testEmployeeCanViewResolvedReimbursementRequests()`
  * `testEmployeeReceivesConfirmationAfterSubmittingAReimbursementRequest()`
  * `testEmployeeInformationReceivedAreNotEmptyAndNotWhiteSpaces()`

<br>

- ##### TestCases: Manager
  * `testManagerIsAbleToRetrieveAllEmployeeInformation()`
  * `testManagerIsAbleToRetrieveAllPendingRequestsWithEmployeeNames()`
  * `testManagerCanViewReimbursementRequestsFromASingleEmployee()`
  * `testManagerCanViewAllResolvedRequestsAndWhoResolvedIt()`

<br><br>

---
## User stories:
- ~~An Employee can login~~
- ~~An Employee can view the Employee Homepage~~
- ~~An Employee can logout~~
- ~~An Employee can submit a reimbursement request~~
- An Employee can upload an image of his/her receipt as part of the reimbursement request
- ~~An Employee can view their pending reimbursement requests~~
- ~~An Employee can view their resolved reimbursement requests~~
- ~~An Employee can view their information~~
- ~~An Employee can update their information~~
- An Employee receives an email when one of their reimbursement requests is resolved (optional)

<br>

- ~~A Manager can login~~
- ~~A Manager can view the Manager Homepage~~
- ~~A Manager can logout~~
- A Manager can approve/deny pending reimbursement requests
- ~~A Manager can view all pending requests from all employees~~
- A Manager can view images of the receipts from reimbursement requests
- ~~A Manager can view all resolved requests from all employees and see which manager resolved it~~
- ~~A Manager can view all Employees~~
- A Manager can view reimbursement requests from a single Employee

## Technologies:
- Java 1.8
- Maven
- JDBC
- SQL
- Servlet
- HTML/JS/CSS
- JUnit

<br><br>

---
### REST API Documentation
- [Docs Page:  TBD](#tbd)

- ##### Employee Information
  * **Request method:** `GET`
  * **Request endpoint:** `v2/user/employee`
  * **Response body:**

    ```
    {
      "employee_id": <employee_id>,
      "firstName": <firstname>,
      "lastName": <lastname>,
      "city": <city>,
      "state": <state>,
      "zipcode": <zipcode>,
      "email": <email>,
      "username": <username>,
      "userrole": <userrole>
    }
    ```

<br>

- ##### Employee Reimbursements: `getAllPendingRequests` | `getAllResolvedRequests`
  * **Request method:** `POST`
  * **Request endpoint:** `v2/reimbursements/pending` | `v2/reimbursements/resolved`
  * **Request body:**

    ```
    {
      "employeeId": "999999999999"
    }
    ```

  * **Request Content-Type:** `application/json`
  * **Response body:**

    ```
    [
      {
        "id": <reimbursement_id>,
        "amount": <reimbursement_amount>,
        "status": <"pending" or "resolved">,
        "dateSubmitted": Date -> string,
        "dateApproved": Date -> string,
        "employeeId": <employee_id>
      },
      {
        "id": <reimbursement_id>,
        "amount": <reimbursement_amount>,
        "status": <"pending" or "resolved">,
        "dateSubmitted": Date -> string,
        "dateApproved": Date -> string,
        "employeeId": <employee_id>
      },
      {...},
      {...}
    ]
    ```

<br>

- ##### Employee Reimbursements: `submitReimbursementRequest`
  * **Request method:** `POST`
  * **Request endpoint:** `v2/reimbursements/submit`
  * **Request params:**

    ```
    [Employee ID]: string
    [Date]: string
    [Amount]: double
    [Receipt Image URL]: string
    ```
  * **Response body:**

    ```
    {
      "isSubmitted": true | false
    }
    ```

<br>

- ##### Login
  * **Request method:** `POST`
  * **Request endpoint:** `v2/user/login`
  * **Request body:**

    ```
    {
      "username": "name",
      "password": "password"
    }
    ```

  * **Request Content-Type:** `application/json`
  * **Response body:**

    ```
    {
      "path": "/logout",
      "homepage": "/user/employee",
      "isLoggedIn": true,
      "message": "User is logged in."
    }
    ```

<br>

- ##### Logout
  * **Request method:** `GET`
  * **Request endpoint:** `v2/user/logout`
  * **Response body:**

    ```
    {
      "path": "/login",
      "isLoggedIn": false,
      "message": "User is logged out."
    }
    ```

<br><br>
