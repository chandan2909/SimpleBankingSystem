
package com.bank;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		BankAccount[] accounts = new BankAccount[4];

		accounts[0] = new BankAccount(1001, "Rahul", 1234, 5000.0);
		accounts[1] = new BankAccount(1002, "Priya", 2345, 8000.0);
		accounts[2] = new BankAccount(1003, "Amit", 3456, 3000.0);
		accounts[3] = new BankAccount(1004, "Sneha", 4567, 10000.0);
		System.out.println("Enter Account Number");
		int accountNumber = sc.nextInt();
		
		System.out.println("Enter PIN: ");
		int pin = sc.nextInt();
		
		BankAccount loggedInAccount = null;
		
		for(int i = 0; i < accounts.length; i++) {
			if(accounts[i].login(accountNumber, pin)) {
				loggedInAccount = accounts[i];	
				break;
			}
		}
			if(loggedInAccount != null) {
				System.out.println("Login Successful");
			} else {
				System.out.println("Invalid Account number or PIN");
				return;
			}
		
		while (true) {
			System.out.println(
					"1. Check Balance \n2. Deposite Amount \n3. Withdraw Amount \n4. Display Account Details \n5. Transfer Amount \n6. Exit");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();

			switch (choice) {
				case 1: {
					loggedInAccount.checkBalance();
					break;
				}
				
				case 2: {
					System.out.println("Enter deposit amount: ");
					int depositAmount = sc.nextInt();
					loggedInAccount.deposit(depositAmount);
					break;
				}
				
				case 3: {
					System.out.println("Enter withdrawal amount:  ");
					int withdrawalAmount = sc.nextInt();
					loggedInAccount.withdraw(withdrawalAmount);
					break;
				}
				
				case 4: {
					loggedInAccount.displayAccountDetails();
					break;
				}
				
				case 5: {
					System.out.println("Enter receiver account number: ");
					int receiverAccountNumber = sc.nextInt();
					BankAccount receiverAccount = null;
					for(int i = 0; i < accounts.length; i++) {
						if(accounts[i].getAccountNumber() == receiverAccountNumber) {
						receiverAccount = accounts[i];
						break;
					}
					}
					if(receiverAccount == null) {
						System.out.println("Reciver Account Not found");
					} else if(receiverAccount == loggedInAccount) {
						System.out.println("Cannot transfer amount to the same account.");
						continue;
					}
					
					else {
						System.out.println("Enter transfer Amount");
						double transferAmount = sc.nextDouble();
						loggedInAccount.transferAmount(receiverAccount, transferAmount);
					}
					break;
				}
				case 6 : {
					System.out.println("Thank you for using this service. Have A Good Day!");
					return;
				}
				default: {
					System.out.println("Inavlid Choice.");
					break;
				}
			}
			
			System.out.println();

		}
	}

}
