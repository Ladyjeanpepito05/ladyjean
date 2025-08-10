package pepitoapp;

import java.util.Scanner;

public class PepitoHub {
    public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);
        PepitoBank[] accounts = new PepitoBank[10];
        int accountCount = 0;
        boolean running = true;

        while (running) {
            System.out.println("\n====== PEPITO'S SERVICE HUB ======");
            System.out.println("How are you feeling today?");
            System.out.println("1. Banking");
            System.out.println("2. Schedule Doctor Visit");
            System.out.println("3. Shop for Items");
            System.out.println("4. Exit");

            System.out.print("Enter your selection: ");
            int selection = reader.nextInt();

            switch (selection) {
                case 1:
                    int resp;
                    do {
                        System.out.println("\n--- BANKING MENU ---");
                        System.out.println("1. Register Account");
                        System.out.println("2. Login Account");
                        System.out.println("3. View All Accounts");
                        System.out.print("Enter Selection: ");
                        int action = reader.nextInt();

                        switch (action) {
                            case 1:
                                if (accountCount < accounts.length) {
                                    accounts[accountCount] = new PepitoBank();
                                    System.out.print("Enter Account No.: ");
                                    accounts[accountCount].setAccountNo(reader.nextInt());
                                    System.out.print("Enter Account Pin: ");
                                    accounts[accountCount].setPin(reader.nextInt());
                                    System.out.println("✅ Account Registered!");
                                    accountCount++;
                                } else {
                                    System.out.println("⚠️ Account storage full.");
                                }
                                break;

                            case 2:
                                int attempts = 3;
                                boolean loggedIn = false;

                                while (attempts > 0 && !loggedIn) {
                                    System.out.print("Enter your Account No: ");
                                    int accNo = reader.nextInt();
                                    System.out.print("Enter your Pin: ");
                                    int pin = reader.nextInt();

                                    for (int i = 0; i < accountCount; i++) {
                                        if (accounts[i] != null && accounts[i].verifyAccount(accNo, pin)) {
                                            System.out.println("✅ LOGIN SUCCESSFUL!");
                                            loggedIn = true;
                                            break;
                                        }
                                    }

                                    if (!loggedIn) {
                                        attempts--;
                                        System.out.println("❌ INVALID ACCOUNT! Attempts left: " + attempts);
                                        if (attempts == 0) {
                                            System.out.println("🚫 ATTEMPT LIMIT REACHED!");
                                            break;
                                        }
                                    }
                                }
                                break;

                            case 3:
                                System.out.println("\n📋 Registered Accounts:");
                                for (int i = 0; i < accountCount; i++) {
                                    if (accounts[i] != null) {
                                        System.out.println("• Account No: " + accounts[i].getAccountNo());
                                    }
                                }
                                break;

                            default:
                                System.out.println("⚠️ Invalid banking option.");
                        }

                        System.out.print("\nDo you want to continue banking? (1 = Yes / 0 = No): ");
                        resp = reader.nextInt();
                    } while (resp == 1);
                    break;

                case 2:
                    System.out.println("\n🩺 Doctor Visit scheduling coming soon!");
                    break;

                case 3:
                    System.out.println("\n🛍️ Shopping feature will be added soon!");
                    break;

                case 4:
                    System.out.println("\n👋 Thank you for using Pepito's Service Hub. Goodbye!");
                    running = false;
                    break;

                default:
                    System.out.println("\n⚠️ Invalid choice. Please select between 1 and 4.");
            }
        }

        reader.close();
    }
}
