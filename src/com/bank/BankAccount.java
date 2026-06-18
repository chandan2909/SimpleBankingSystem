package com.bank;

public class BankAccount {
	private int accountNumber;
	private String accountHolderName;
	private int pin;
	private double balance;
	
	BankAccount(int accountNumber, String accountHolderderName, int pin, double balance) {
		this.accountNumber = accountNumber;
		this.accountHolderName = accountHolderderName;
		this.balance = balance;
		this.pin = pin;
	}
	
	 boolean enteredPin(int enteredPin) {
		if(enteredPin == pin) {
			return true;
		}
		return false;
		
	}
	
	 void checkBalance () {
		System.out.println("Current Balance: " + balance);
	}
		
	 void deposit(double amount) {
		if(amount > 0) {
			balance += amount;
			System.out.println("Amount Deposited Successfully");
			System.out.println("Updated Balance: " + balance);
		}
		else {
			System.out.println("Invalid Deposite Amount");
		}
	}
	
	
	void withdraw(double amount) {
		if(amount > 0 && balance >= amount) {
			balance -= amount;
			System.out.println("Amount Withdrawn Successfully");
			System.out.println("Updated Balance: " + balance);
		}
		else if(balance <= amount){
			System.out.println("Insufficient Balance");
		} else {
			System.out.println("Invalid Withdrawal Amount");
		}
	}
	
	void displayAccountDetails() {
		
		System.out.println("Account Number: " + accountNumber);
		System.out.println("Account Holder Name: " + accountHolderName);
	}
	
	
	
		
	
	
}
