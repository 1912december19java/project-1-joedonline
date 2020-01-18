# Expense Reimbursement System (ERS)

<br><br>

---
## DOCS

### Project Structure

##### *`src/main/java`*
- ##### `exceptions/`
- ##### `models/`
  * | `User.java`
- ##### `repositories/dao/`
  * | `UserDAO.java`
  * | `UserDAOImpl.java`
- ##### `repositories/queries/`
  * | `Actions.java`
  * | `MyStatements.java`
- ##### `repositories/utilities/`
  * | `ConnectionManager.java`
  * | `DataAccessObject.java`
- ##### `services/`
  * | `UserService.java`
- ##### `servlets/`

<br>

##### *`src/test/java`*
- | `TestLoginLogout.java`

<br><br>

---

## PROJECT TRACKER

### `REST API`

| User Story | Status | Date Started | Date Completed
|-|-|-|-|
| An Employee can login | done | `1/14 :: 18:14:12` | `1/17 :: 22:33:22` |
| A Manager can login | done | `1/14 :: 18:14:12` | `1/17 :: 22:33:22` |
| An Employee can logout | done | `1/15 :: 00:18:02` | `1/17 :: 22:33:22` |
| A Manager can logout | done | `1/15 :: 00:18:02` | `1/17 :: 22:33:22` |
|  |  |  |  |

<br><br>

---
### DB Design
- ##### Users
  * db name: `ers_users`
  * columns: `employee_id`, `username`, `userpass`, `userrole`

<br><br>

### Backend stuff
- ##### TestCases: Users
  * `testEmployeeCanLogin()`
  * `testWrongPasswordFailsToAuthenticate()`

<br><br>

---
## User stories:
- ~~An Employee can login~~
- An Employee can view the Employee Homepage
- ~~An Employee can logout~~
- An Employee can submit a reimbursement request
- An Employee can upload an image of his/her receipt as part of the reimbursement request
- An Employee can view their pending reimbursement requests
- An Employee can view their resolved reimbursement requests
- An Employee can view their information
- An Employee can update their information
- An Employee receives an email when one of their reimbursement requests is resolved (optional)

<br>

- ~~A Manager can login~~
- A Manager can view the Manager Homepage
- ~~A Manager can logout~~
- A Manager can approve/deny pending reimbursement requests
- A Manager can view all pending requests from all employees
- A Manager can view images of the receipts from reimbursement requests
- A Manager can view all resolved requests from all employees and see which manager resolved it
- A Manager can view all Employees
- A Manager can view reimbursement requests from a single Employee

## Technologies:
- Java 1.8
- Maven
- JDBC
- SQL
- Servlet
- HTML/JS/CSS
- JUnit
