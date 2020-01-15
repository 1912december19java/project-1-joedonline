# Expense Reimbursement System (ERS) 

---

## Project Tracker

| User Story | Status | Date Started | Date Completed
|-|-|-|-|
| An Employee can login | *in progress* | 1/14/2020 |  |
| A Manager can login | *in progress* | 1/14/2020 |  |

<br><br>

### DB Design
- ##### Users
  * db name: `ers_users`
  * columns: `employee_id`, `username`, `userpass`, `userrole`

<br><br>

### Backend stuff
- ##### TestCases: Users
  * `testEmployeeCanLogin()`

<br><br>

---
## User stories:
- ~~An Employee can login~~
- An Employee can view the Employee Homepage
- An Employee can logout
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
- A Manager can logout
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