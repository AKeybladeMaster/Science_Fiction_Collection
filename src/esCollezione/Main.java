package esCollezione;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		RomanceManager obj = new RomanceManager();
		int menu_choice = 1;

		obj.loadBooks();
		
		do {
			try {
				System.out.println("0. End the program " 
						+ "\n1. Add a new romance "
						+ "\n2. Delete an existing romance " 
						+ "\n3. Find a romance by title "
						+ "\n4. Find romances by author "
						+ "\n5. Find romances by publish date "
						+ "\n6. Find romances by filters" 
						+ "\n7. Dump the data to the file");

				menu_choice = sc.nextInt();
				sc.nextLine();

				switch (menu_choice) {
				case 0:
					System.out.println("Program terminated!");
					System.exit(0);
					break;
				case 1:
					obj.addRomance();
					System.out.println("");
					break;
				case 2:
					obj.deleteRomance();
					System.out.println("");
					break;
				case 3:
					System.out.println(obj.findRomanceByTitle() + "\n");
					break;
				case 4:
					obj.findRomanceByAuthor();
					System.out.println("");
					break;
				case 5:
					obj.findRomanceByDate();
					System.out.println("");
					break;
				case 6:
					obj.findRomanceByFilter();
					System.out.println("");
					break;
				case 7:
					obj.dumpOnFile();
					break;
				default:
					System.out.println("Your number is not an option. Try again.");
					break;
				}
			} catch (InputMismatchException e) {
				System.out.println("Type a number please! Try again.\n");
				sc.nextLine();
			} catch (Exception e) {
				e.printStackTrace();
			}
		} while (menu_choice != 0);
		sc.close();
	}
}