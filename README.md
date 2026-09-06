# ATM Banking System — Java Project 3

## Project Overview:
This project is Project 3 completed during my Java Programming Internship at Decode Labs. It is a console-based ATM Banking System developed in Java that simulates basic banking operations such as account authentication, depositing money, withdrawing money, checking balance, and logging out.
The project uses multiple classes to organize the banking system and demonstrates the practical implementation of Object-Oriented Programming concepts.
## Objective:
The objective of this project is to develop a functional ATM system using Java while applying Object-Oriented Programming principles. The project focuses on account authentication, transaction processing, balance management, input validation, and handling multiple bank accounts.
## Features:

* Account login using account number and PIN
* Maximum of 3 login attempts
* Deposit money into an account
* Withdraw money based on available balance
* Check current account balance
* Prevents invalid or negative transactions
* Displays updated balance after transactions
* Logout functionality
* Option to login with another account
* Input validation for account numbers, PINs, menu choices, and transaction amounts
* Supports multiple bank accounts using `ArrayList`
## Concepts Used:

* **Classes and Objects:** Separate classes are used for `BankAccount`, `Bank`, and `ATM`.
* **Encapsulation:** Account details such as balance and PIN are kept private and accessed through public methods.
* **Constructors:** Used to initialize bank account objects with account information.
* **Methods:** Used to perform operations such as deposit, withdrawal, authentication, and balance checking.
* **Access Modifiers:** `private` and `public` are used to control access to class members.
* **ArrayList:** Used to store and manage multiple `BankAccount` objects.
* **Loops:** Used for login attempts, menu operations, and input validation.
* **Conditional Statements:** Used to validate PINs, transactions, and menu choices.
* **Switch Statement:** Used to handle different ATM menu operations.
## Technologies Used:
* **Programming Language:** Java
* **IDE:** Apache NetBeans / NetBeans
* **Java Libraries:** `Scanner` and `ArrayList`

## Example:

================================
       WELCOME TO ATM
================================

Enter Account Number: 1001
Enter PIN: 1234

Login successful. Welcome, Ali Khan

--------- ATM MENU ---------
1. Deposit
2. Withdraw
3. Check Balance
4. Logout
Enter choice: 1

Enter amount: 2000
Deposit successful. New balance: 7000.00
## How to Run:
1. Clone or download the repository.
2. Open the project in NetBeans or any Java-compatible IDE.
3. Open the `DecodeLab_P3` class.
4. Run the `main()` method.
5. Enter one of the predefined account numbers and PINs.
6. Select an option from the ATM menu to perform the desired operation.
### Sample Login Credentials:
| Account Number | Account Holder | PIN  | Initial Balance |
| -------------- | -------------- | ---- | --------------: |
| 1001           | Ali Khan       | 1234 |            5000 |
| 1002           | Sara Ahmed     | 4321 |           12000 |
| 1003           | Bilal Raza     | 1111 |             750 |
## Learning Outcomes:
Through this project, I gained practical experience in:

* Applying Object-Oriented Programming concepts in Java.
* Creating and managing multiple classes and objects.
* Implementing encapsulation using access modifiers.
* Working with `ArrayList` to manage multiple accounts.
* Developing authentication and transaction logic.
* Validating user input and handling invalid entries.
* Using loops and switch statements in a real-world application.
* Building a structured console-based banking system.
