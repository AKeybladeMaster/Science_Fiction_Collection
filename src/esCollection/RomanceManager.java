package esCollection;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class RomanceManager {

	Scanner sc = new Scanner(System.in);
	private List<Romance> list_of_romances = new ArrayList<Romance>();

	// main type of romance
	String title, author, editor;
	int publish_date;

	// paper
	String cover_type, conservation_state;
	int number_of_pages;

	// digital
	String format, dimension_choice, memorization;
	int dimension_temp, byte_dimension;

	int menu_choice = 0, sub_choice = 0;

	public void addRomance() {
		do {
			try {
				System.out.println("Is it a paper or digital romance? " + "\n 1. Paper " + "\n 2. Digital");
				menu_choice = sc.nextInt();
				sc.nextLine();

				System.out.print("Type the romance title: ");
				title = sc.nextLine();
				System.out.print("Type the romance author: ");
				author = sc.nextLine();
				System.out.print("Type the publish date (int): ");
				publish_date = sc.nextInt();
				sc.nextLine();
				System.out.print("Type the editor: ");
				editor = sc.nextLine();

				if (menu_choice == 1) {
					System.out.println(
							"What's its conservation state? " + "\n 1. Excellent " + "\n 2. Good" + "\n 3. Terrible");
					sub_choice = sc.nextInt();
					sc.nextLine();
					if (sub_choice == 1)
						conservation_state = "Excellent";
					else if (sub_choice == 2)
						conservation_state = "Good";
					else if (sub_choice == 3)
						conservation_state = "Terrible";
					else
						throw new InputMismatchException();
					System.out.print("Type the number of pages the romance is composed of: ");
					number_of_pages = sc.nextInt();
					sc.nextLine();
					System.out.println("What cover type does it have?" + "\n 1. Stiff " + "\n 2. Soft");
					sub_choice = sc.nextInt();
					sc.nextLine();
					if (sub_choice == 1)
						cover_type = "Stiff";
					else if (sub_choice == 2)
						cover_type = "Soft";
					else
						throw new InputMismatchException();
					list_of_romances.add(new PaperRomance(title, author, publish_date, editor, cover_type,
							conservation_state, number_of_pages));
					System.out.println("Romance added!");
				} else if (menu_choice == 2) {
					System.out.println("What's its format? " + "\n 1. EPUB " + "\n 2. MOBI" + "\n 3. PDF" + "\n 4. AZW");
					sub_choice = sc.nextInt();
					sc.nextLine();
					if (sub_choice == 1)
						format = "EPUB";
					else if (sub_choice == 2)
						format = "MOBI";
					else if (sub_choice == 3)
						format = "PDF";
					else if (sub_choice == 4)
						format = "AZW";
					else
						throw new InputMismatchException();

					System.out.println("What's its unit of measurement? " + "\n 1. MB " + "\n 2. KB" + "\n 3. Bytes ");
					sub_choice = sc.nextInt();
					sc.nextLine();
					if (sub_choice == 1) {
						dimension_choice = "MB";
						System.out.print("How many MBs?");
						byte_dimension = sc.nextInt();
						byte_dimension = byte_dimension * 1024 * 1024;
						System.out.println("Dimension in bytes = " + byte_dimension);
					} else if (sub_choice == 2) {
						dimension_choice = "KB";
						System.out.print("How many KBs?");
						byte_dimension = sc.nextInt();
						byte_dimension = byte_dimension * 1024 * 1024;
						System.out.println("Dimension in bytes = " + byte_dimension);
					} else if (sub_choice == 3) {
						dimension_choice = "Bytes";
						System.out.print("How many bytes?");
						byte_dimension = sc.nextInt();
					} else
						throw new InputMismatchException();
					sc.nextLine();

					System.out.println("What kind of memorization does it use? " + "\n 1. CD-ROM " + "\n 2. Storage(HDD) ");
					sub_choice = sc.nextInt();
					sc.nextLine();
					if (sub_choice == 1)
						memorization = "CD-ROM";
					else if (sub_choice == 2)
						memorization = "Storage";
					else
						throw new InputMismatchException();
					list_of_romances.add(new DigitalRomance(title, author, publish_date, editor, format, byte_dimension,
							memorization));
					System.out.println("Romance added!");
				} else
					throw new InputMismatchException();
				System.out.print("Do you want to add another romance? (y/n) ");
			} catch (NumberFormatException e) {
				e.printStackTrace();
			} catch (InputMismatchException e) {
				System.out.println("\nYou typed something wrong. Sending you to the start...");
			}
		} while (sc.nextLine().equalsIgnoreCase("y"));
	}

	public void deleteRomance() {
		try {
			if (list_of_romances.size() != 0) {
				for (int i = 0; i < list_of_romances.size(); i++) {
					System.out.println((i + 1) + ". " + list_of_romances.get(i));
				}
				System.out.print("\nType a number from 1 to " + list_of_romances.size() + " to delete a romance: ");
				sub_choice = sc.nextInt();
				sc.nextLine();
				if (sub_choice >= 1 && sub_choice <= list_of_romances.size()) {
					list_of_romances.remove(sub_choice - 1);
					System.out.println("Romance deleted successfully!");
				} else
					System.out.println("The number is not within the correct range.");
			} else {
				System.out.println("You haven't added a romance yet!");
			}
		} catch (InputMismatchException i) {
			System.out.println("\nYou have to type numbers only!");
			sc.nextLine();
		}
	}

	public String findRomanceByTitle() {
		list_of_romances.forEach(s -> System.out.println(s));
		System.out.print("\nType the title of a romance to find it: ");
		title = sc.nextLine();
		System.out.println("");
		for (Romance r : list_of_romances) {
			if (title.equalsIgnoreCase(r.getTitle())) {
				return r.toString();
			}
		}
		return "Romance not found.";
	}

	public void findRomanceByAuthor() {
		int cont = 0;
		list_of_romances.forEach(s -> System.out.println(s));
		System.out.print("\nType the author of romance to find his works: ");
		author = sc.nextLine();
		System.out.println("");
		for (Romance r : list_of_romances) {
			if (author.equalsIgnoreCase(r.getAuthor())) {
				cont++;
				System.out.println(r.toString());
			}
		}
		if (cont == 0)
		System.out.println("Romances not found.");
	}

	public void findRomanceByDate() {
		do {
			try {
				System.out.println("Find romances: " + "\n 1. before a certain year " + "\n 2. after a certain year");
				sub_choice = sc.nextInt();
				sc.nextLine();

				System.out.print("Type the year: ");
				publish_date = sc.nextInt();
				sc.nextLine();

				if (sub_choice == 1) {
					for (int i = 0; i < list_of_romances.size(); i++) {
						if (list_of_romances.get(i).getPublish_date() < publish_date) {
							System.out.println(list_of_romances.get(i));
						}
					}
				} else if (sub_choice == 2) {
					for (int i = 0; i < list_of_romances.size(); i++) {
						if (list_of_romances.get(i).getPublish_date() > publish_date) {
							System.out.println(list_of_romances.get(i));
						}
					}
				} else
					throw new InputMismatchException();
				System.out.print("\nDo you want to start another search? (y/n) ");
			} catch (InputMismatchException e) {
				System.out.println("\nYour input is not an option. Try again.");
			}
		} while (sc.nextLine().equalsIgnoreCase("y"));
	}

	public void findRomanceByFilter() {
		System.out.println("Type the author and the format (paper/digital) of the romances you want to find: ");
		String userSearch = sc.nextLine();

		for (int i = 0; i < list_of_romances.size(); i++) {
			boolean isPresent = userSearch.toLowerCase()
					.indexOf(list_of_romances.get(i).getAuthor().toLowerCase()) != -1 ? true : false;
			if (isPresent) {
				if (list_of_romances.get(i) instanceof PaperRomance
						&& userSearch.toLowerCase().contains("paper")) {
					System.out.println(list_of_romances.get(i));
				} else if (list_of_romances.get(i) instanceof DigitalRomance
						&& userSearch.toLowerCase().contains("digital")) {
					System.out.println(list_of_romances.get(i));
				}
			}
		}
	}

	@SuppressWarnings("unchecked")
	public void loadBooks() {
		FileInputStream file;
		try {
			file = new FileInputStream("Collection.txt");
			ObjectInputStream in = new ObjectInputStream(file);
			List<Romance> list_of_romances = (List<Romance>) in.readObject();
			this.list_of_romances = list_of_romances;
			in.close();
			System.out.println("File loaded with all the saved romances!\n");
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist (yet) \n");
		} catch (IOException e) {
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void dumpOnFile() {
		try {
			FileOutputStream fileOut = new FileOutputStream("Collection.txt");
			ObjectOutputStream out = new ObjectOutputStream(fileOut);
			out.writeObject(list_of_romances);
			out.close();
			System.out.println("Data dumped on a txt file \n");
		} catch (FileNotFoundException e) {
			System.out.println("The file doesn't exist.");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
