
package com.bank;

import java.util.Scanner;

public class BankApp {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		BankAccount account = new BankAccount(1001, "Rahul", 1234, 5000.0);

		System.out.println("Enter PIN: ");
		int pin = sc.nextInt();

		if (account.enteredPin(pin)) {
			System.out.println("Login Successful");
		} else {
			System.out.println("Invalid PIN");
			return;
		}
		while (true) {
			System.out.println(
					"1. Check Balance \n2. Deposite Amount \n3. Withdraw Amount \n4. Display Account Details \n5. Exit");
			System.out.println("Enter your choice: ");
			int choice = sc.nextInt();
			
			switch (choice) {
			case 1: {
				account.checkBalance();
				break;
			}
			case 2: {
				System.out.println("Enter deposite amount: ");
				int depositeAmount = sc.nextInt();
				account.deposit(depositeAmount);
				break;
			}
			case 3: {
				System.out.println("Enter withdrawal amount:  ");
				int withdrawalAmount = sc.nextInt();
				account.withdraw(withdrawalAmount);
				break;
			}
			case 4: {
				account.displayAccountDetails();
				break;
			}
			case 5: {
				System.out.println("Thanks for using this service. Goodbye 🙋‍♂️");
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
