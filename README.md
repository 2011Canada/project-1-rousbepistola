# Employee Reimbursement System (ERS)

## Summary
The Expense Reimbursement System (ERS) is to manage the process of expense reimbursement. It is required different functionalities by Finance Managers and Employees.

## Project Description
The Expense Reimbursement System (ERS) will manage the process of reimbursing employees for expenses incurred while on company time. All employees in the company can login and submit requests for reimbursement and view their past tickets and pending requests. Finance managers can log in and view all reimbursement requests and past history for all employees in the company. Finance managers are authorized to approve and deny requests for expense reimbursement.


## Technologies Used
- Java 
- Javascript ES6
- HTML
- CSS
- Bootstrap
- PostgreSQL
- JDBC
- Tomcat
- Front Controller Pattern using Servlet


## Features
### List of Features Ready
> Employees
- can login
- can submit requests for reimbursement
- can view past tickets
- can view pending tickets
- can view rejected tickets

> Finance Managers
- can login
- can view all tickets
- can view all pending tickets
- can view all rejected tickets
- can view all approved tickets
- can sort tickets by approved, pending, or rejected

### To-do List
- Improvement to be done on UI
- Improvement to be done on the way manager approves tickets
- Can add a functionality to upload a receipt

## Getting Started
- Windows/Mac Git Clone Command:
> git clone https://github.com/2011Canada/project-1-rousbepistola.git
- Requires Java Version 8
> https://www.oracle.com/ca-en/java/technologies/javase-downloads.html
- Requires DBeaver
> https://dbeaver.io/download/
- Requires RDS on AWS
> https://aws.amazon.com/

### STEPS
- Start Java server
- Connect to database using DBeaver
- Run the included ERSScript on your database
- Go to http://localhost:8080/index.html in a Chrome incognito tab
- Login Using one of username and password provided in the script


## Usage
- Login as either an Employee or as a Manager
- Employee can apply for reimbursement
- Employee can view all personal past tickets
- Employee can logout
- Manager can view all tickets (both current and past)
- Manager can approve/decline tickets through the use of the ticket's ID number
- Manager can filter by ticket status (approved, pending, denied)
- Manager can logout


## Development Tool
- Eclipse
- VS code
- Postman
- DBeaver

## ERD
![Alt](/erd.png "ERD")

## License
- This project uses the following license: [![License](./LICENSE.md)

