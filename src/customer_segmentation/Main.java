package customer_segmentation;

import java.util.*;

public class Main {
	public static Scanner sc = new Scanner(System.in);
	public static Customer ideal = new Customer();
	public static Customer likely = new Customer();
	public static Customer defect = new Customer();
	public static Customer customers[] = null;
	public static Customer[] idealCustomers = null;
	public static Customer[] likelyCustomers = null;
	public static Customer[] defectCustomers = null;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("=====================================================");
		System.out.println("Title: Customer segmentation program");
		System.out.println("Developer: Amy Lim");
		System.out.println("E-mail: amylim32897@gmail.com");
		System.out.println("=====================================================");

		while (true) {
			try {
				printMainMenu();
				String main_selected = sc.next();

				if (Integer.parseInt(main_selected) == 1) {

					while (true) {
						printParamMenu();
						String param_selected = sc.next();

						if (Integer.parseInt(param_selected) == 1)
							setEditParam();

						else if (Integer.parseInt(param_selected) == 2)
							viewParam();

						else if (Integer.parseInt(param_selected) == 3)
							setEditParam();

						else if (Integer.parseInt(param_selected) == 4)
							break;

						else {
							System.out.println("[INVALID INPUT] Choose One Integer");
							continue;
						}
					}

				} else if (Integer.parseInt(main_selected) == 2) {

					printCustomerTotal();
					String total = sc.next();
					customers = new Customer[Integer.parseInt(total)];

					for (int i = 0; i < customers.length; i++) {
						customers[i] = new Customer();
					}

					while (true) {
						printDataMenu();
						String data_selected = sc.next();
						if (Integer.parseInt(data_selected) == 1) {
							for (int i = 0; i < customers.length; i++) {
								System.out.println();
								System.out.printf("======= Customer %d Info. =======", i + 1);
								printSetParam(customers[i]);
							}
						} else if (Integer.parseInt(data_selected) == 2) {
							for (int i = 0; i < customers.length; i++) {
								System.out.println();
								System.out.printf("======= Customer %d Info. ======= \n", i + 1);
								System.out.println(customers[i]);

							}
						} else if (Integer.parseInt(data_selected) == 3) {
							System.out.println();
							System.out.println();
							System.out.printf("Which Customers Do You Want to Edit (%d ~ %d) ? ", 1,
									Integer.parseInt(total));
							String edit = sc.next();
							printSetParam(customers[Integer.parseInt(edit) - 1]);
						} else if (Integer.parseInt(data_selected) == 4) {
							break;
						} else {
							System.out.println("[INVALID INPUT] Choose One Integer");
							continue;
						}
					}
				} else if (Integer.parseInt(main_selected) == 3) {
					sortCustomerData();
					printSummary();
				} else if (Integer.parseInt(main_selected) == 4) {
					System.exit(0);
				} else {
					System.out.println("[INVALID INPUT] Choose One Integer");
					continue;
				}
			} catch (Exception e) {
				System.out.println("Exception!");
				System.out.println(e.getMessage());
				continue;
			}
		}

	}

	public static void printMainMenu() {
		System.out.println();
		System.out.println();
		System.out.println("===============================");
		System.out.println("1. Set Customer Parameter");
		System.out.println("2. Enter Customer Data");
		System.out.println("3. Summary");
		System.out.println("4. Quit");
		System.out.println("===============================");
		System.out.print("Choose One : ");
	}

	public static void printParamMenu() {
		System.out.println();
		System.out.println();
		System.out.println("===============================");
		System.out.println("1. Set Parameter");
		System.out.println("2. View Parameter");
		System.out.println("3. Edit Parameter");
		System.out.println("4. Back");
		System.out.println("===============================");
		System.out.print("Choose One : ");
	}

	public static void printInfoMenu() {
		System.out.println();
		System.out.println();
		System.out.println("===============================");
		System.out.println("1. Age");
		System.out.println("2. Gender");
		System.out.println("3. Location");
		System.out.println("4. Online Spent Time");
		System.out.println("5. Back");
		System.out.println("===============================");
		System.out.print("Choose One : ");
	}

	public static void printDataMenu() {
		System.out.println();
		System.out.println();
		System.out.println("===============================");
		System.out.println("1. Set Customer Data");
		System.out.println("2. View Customer Data");
		System.out.println("3. Edit Customer Data");
		System.out.println("4. Back");
		System.out.println("===============================");
		System.out.print("Choose One : ");
	}

	public static void printCustomerTotal() {
		System.out.println();
		System.out.println();
		System.out.println("** Press -1, if you want to exit ! **");
		System.out.print("How Many Do You Have Customer for Segmentation ? ");
	}

	public static void printWhichGroup() {
		System.out.println();
		System.out.println();
		System.out.println("** Press 'end', if you want to exit ! **");
		System.out.print("Which Group (ideal, likely, defect) ? ");
	}

	public static void printSetParam(Customer c) throws Exception {
		while (true) {
			printInfoMenu();
			String info_selected = sc.next();
			if (Integer.parseInt(info_selected) == 1) {
				System.out.println();
				System.out.print("Input Minimum Age : ");
				c.min_age = sc.nextInt();
				System.out.print("Input Maximum Age : ");
				c.max_age = sc.nextInt();
			} else if (Integer.parseInt(info_selected) == 2) {
				System.out.println();
				System.out.print("Input Gender : ");
				c.gender = sc.next();
			} else if (Integer.parseInt(info_selected) == 3) {
				System.out.println();
				System.out.print("Input Location : ");
				c.location = sc.next();
			} else if (Integer.parseInt(info_selected) == 4) {
				System.out.println();
				System.out.print("Input Online Spent Time : ");
				c.time = sc.nextInt();
			} else if (Integer.parseInt(info_selected) == 5) {
				break;
			} else {
				System.out.println("[INVALID INPUT] Choose One Integer");
				continue;
			}
		}
	}

	public static void setEditParam() throws Exception {
		while (true) {
			printWhichGroup();
			String group = sc.next();
			if (group.equals("end")) {
				break;
			} else if (group.equals("ideal")) {
				printSetParam(ideal);
			} else if (group.equals("likely")) {
				printSetParam(likely);
			} else if (group.equals("defect")) {
				printSetParam(defect);
			} else {
				System.out.println("[INVALID INPUT] Input 'ideal', 'likely to convert', or 'defect'");
				continue;
			}
		}
	}

	public static void viewParam() throws Exception {
		while (true) {
			printWhichGroup();
			String group = sc.next();
			if (group.equals("end")) {
				break;
			} else if (group.equals("ideal")) {
				System.out.println(ideal);
			} else if (group.equals("likely")) {
				System.out.println(likely);
			} else if (group.equals("defect")) {
				System.out.println(defect);
			} else {
				System.out.println("[INVALID INPUT] Input 'ideal', 'likely to convert', or 'defect'");
				continue;
			}
		}
	}

	public static void sortCustomerData() throws Exception {
		System.out.println();
		System.out.println();
		System.out.println("====== Segmentation Result ======");
		System.out.println();
		int cnt1 = 0;
		int cnt2 = 0;
		int cnt3 = 0;
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].equals(ideal)) {
				cnt1++;
			} else if (customers[i].equals(likely)) {
				cnt2++;
			} else if (customers[i].equals(defect)) {
				cnt3++;
			}
		}
		idealCustomers = new Customer[cnt1];
		likelyCustomers = new Customer[cnt2];
		defectCustomers = new Customer[cnt3];

		int idealIdx = 0;
		int likelyIdx = 0;
		int defectIdx = 0;
		for (int i = 0; i < customers.length; i++) {
			if (customers[i].equals(ideal)) {
				idealCustomers[idealIdx] = new Customer();
				idealCustomers[idealIdx] = customers[i];
				idealIdx++;
			} else if (customers[i].equals(likely)) {
				likelyCustomers[likelyIdx] = new Customer();
				likelyCustomers[likelyIdx] = customers[i];
				likelyIdx++;
			} else if (customers[i].equals(defect)) {
				defectCustomers[defectIdx] = new Customer();
				defectCustomers[defectIdx] = customers[i];
				defectIdx++;
			}
		}
	}

	public static void printSummary() throws Exception {
		for (int i = 0; i < idealCustomers.length; i++) {
			System.out.println("======== Ideal Customers ========");
			System.out.println();
			System.out.println("Customer Number : " + (i + 1));
			System.out.println(idealCustomers[i]);
			System.out.println();
		}
		for (int i = 0; i < likelyCustomers.length; i++) {
			System.out.println("======== Likely Customers ========");
			System.out.println();
			System.out.println("Customer Number : " + (i + 1));
			System.out.println(likelyCustomers[i]);
			System.out.println();
		}
		for (int i = 0; i < defectCustomers.length; i++) {
			System.out.println("======== Defect Customers ========");
			System.out.println();
			System.out.println("Customer Number : " + (i + 1));
			System.out.println(defectCustomers[i]);
		}
	}

}