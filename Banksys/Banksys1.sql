CREATE DATABASE Banksys;

USE BankSys;

CREATE TABLE Users (
    username VARCHAR(50) PRIMARY KEY,
    password VARCHAR(50)
);

CREATE TABLE Accounts (
    account_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    account_type VARCHAR(50),
    balance DOUBLE,
    FOREIGN KEY (username) REFERENCES Users(username)
);


CREATE TABLE Loans (
    loan_id INT AUTO_INCREMENT PRIMARY KEY,
    username VARCHAR(50),
    loan_type VARCHAR(50),
    loan_amount DOUBLE,
    interest_rate DOUBLE,
    FOREIGN KEY (username) REFERENCES Users(username)
);

CREATE TABLE Transactions (
    transaction_id INT AUTO_INCREMENT PRIMARY KEY,
    account_id INT,
    transaction_type VARCHAR(50),
    amount DOUBLE,
    date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    FOREIGN KEY (account_id) REFERENCES Accounts(account_id)
);

SELECT * FROM Users
INSERT INTO Users (username, password) VALUES ('admin123', 'admin');
SELECT * FROM Users WHERE username = 'admin123';
SELECT * FROM Accounts WHERE username = 'admin123';
ALTER TABLE Accounts ADD COLUMN username VARCHAR(50);

ALTER TABLE Accounts ADD FOREIGN KEY (username) REFERENCES Users(username);
SELECT * FROM Accounts WHERE username = 'admin123';
SELECT * FROM Users WHERE username = 'admin';
SELECT * FROM Accounts WHERE username = 'admin123';
INSERT INTO Accounts (username, account_type, balance) VALUES ('admin123', 'savings', 0.00);
SELECT * FROM Accounts WHERE username = 'admin123';
SELECT * FROM Users WHERE username = 'admin';
DELETE FROM Users WHERE username = 'admin';
SELECT * FROM Users WHERE username = 'admin';
