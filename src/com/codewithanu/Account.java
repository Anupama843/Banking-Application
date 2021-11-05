package com.codewithanu;

import java.util.Scanner;

public class Account {
        int balance;
        int previousTransaction;
        String customerName;
        String customerId;
        Account(String name, String id){
            this.customerName = name;
            this.customerId = id;
        }
        private void deposit(int amount){
            if(amount != 0){
                balance = balance + amount;
                previousTransaction = amount;
            }
        }
        private void withdrawn(int amount){
            if(amount != 0){
                balance = balance - amount;
                previousTransaction = -amount;
            }
        }
        private void getPreviousTransaction(){
            if(previousTransaction < 0){
                System.out.println("Withdrawn amount is" + Math.abs(previousTransaction));
            }else if(previousTransaction > 0){
                System.out.println("Deposit amount is" + previousTransaction);
            }else {
                System.out.println("No Transaction have been occurred");
            }
        }
        private void calculateInterest(int years){
            double interestRate = .12;
            double newBalance = balance * interestRate * years + balance;
            System.out.println("Current interest rate is " + 100 * interestRate + "per year");
            System.out.println("After " + years + " years, your account balance will be " + newBalance);
        }
        void showMenu(){
            char option = 'a';
            Scanner scanner = new Scanner(System.in);
            System.out.println("Welcome " + customerName +"!");
            System.out.println("Your ID is " + customerId);
            System.out.println("=========================================");
            System.out.println("What would you like to do?");
            System.out.println("1. Check your balance");
            System.out.println("2. Make a deposit");
            System.out.println("3. Make a withdrawal");
            System.out.println("4. View previous transactions");
            System.out.println("5. Calculate interest ");
            System.out.println("6. Exit");
            do{
                System.out.println();
                System.out.println("Enter an option: ");
                char option1 = scanner.next().charAt(0);
                option = Character.toUpperCase(option1);
                switch (option){
                    case '1':
                        System.out.println("=========================================");
                        System.out.println("Balance = $" + balance);
                        System.out.println("=========================================");
                        break;
                    case '2':
                        System.out.println("Enter an amount you want to deposit: ");
                        int amount = scanner.nextInt();
                        deposit(amount);
                        System.out.println("Deposite amount is = $" + amount);
                        System.out.println("=========================================");
                        break;
                    case '3':
                        System.out.println("Enter an amount you want to withdraw: ");
                        int amount2 = scanner.nextInt();
                        withdrawn(amount2);
                        System.out.println("Withdraw amount is = $" + amount2);
                        System.out.println("=========================================");
                        break;
                    case '4':
                        getPreviousTransaction();
                        System.out.println();
                        System.out.println("=========================================");
                        break;
                    case '5':
                        System.out.println("Enter number of years for interest : ");
                        int year = scanner.nextInt();
                        calculateInterest(year);
                        break;
                    case '6':
                        System.out.println("=========================================");
                        break;
                    default:
                        System.out.println("Error: Invalid input given. Please enter 1, 2, 3, 4, 5 0r 6");
                        break;
                }
            }while (option != '6');
            System.out.println("Thank you for banking with us");
        }
    }


