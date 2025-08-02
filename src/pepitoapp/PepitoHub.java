
package pepitoapp;

import java.util.Scanner;


public class PepitoHub {
        public static void main(String[] args) {
        Scanner reader = new Scanner(System.in);

        System.out.println("====== PEPITO'S SERVICE HUB ======");
        System.out.println("Choose a service below:");
        System.out.println("1. Access Bank");
        System.out.println("2. Schedule Doctor Visit");
        System.out.println("3. Shop for Items");

        System.out.print("Enter your selection: ");
        int selection = reader.nextInt();

        switch (selection) {
            case 1:
                PepitoBank bankModule = new PepitoBank();
                bankModule.loginToBank(reader);
                break;

            case 2:
                System.out.println("\n[Doctor Visit] Scheduling not available right now.");
                break;

            case 3:
                System.out.println("\n[Shopping] Feature will be added soon!");
                break;

            default:
                System.out.println("\nInvalid choice. Please restart and try again.");
        }

        reader.close();
    }
}