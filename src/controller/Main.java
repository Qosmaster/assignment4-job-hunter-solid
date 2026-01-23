package controller;

import model.*;
import service.AppService;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppService service = new AppService();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== JOB HUNTER MENU ===");
            System.out.println("1. Add Company");
            System.out.println("2. Add Application");
            System.out.println("3. Show All Applications");
            System.out.println("4. Delete Application");
            System.out.println("0. Exit");
            System.out.print("Select option: ");

            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                scan.nextLine();

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Enter Company Name: ");
                            String cName = scan.nextLine();
                            System.out.print("Enter Industry: ");
                            String cInd = scan.nextLine();
                            service.createCompany(cName, cInd);
                            System.out.println("Company added!");
                            break;

                        case 2:
                            service.printCompanies();
                            System.out.print("Enter Company ID from list above: ");
                            int cId = scan.nextInt();
                            scan.nextLine();
                            Company selectedCompany = service.getCompanyById(cId);

                            System.out.print("Enter Job Title: ");
                            String title = scan.nextLine();

                            System.out.print("Type (1 for Easy, 2 for Hard): ");
                            int type = scan.nextInt();
                            scan.nextLine();

                            if (type == 1) {
                                System.out.print("Enter Site (e.g. LinkedIn): ");
                                String site = scan.nextLine();
                                EasyApp app = new EasyApp(0, title, selectedCompany, "Applied", site);
                                service.saveApp(app);
                            } else {
                                System.out.print("Number of stages: ");
                                int stages = scan.nextInt();
                                HardApp app = new HardApp(0, title, selectedCompany, "Applied", stages);
                                service.saveApp(app);
                            }
                            System.out.println("Application saved!");
                            break;

                        case 3:
                            service.printAllApps();
                            break;

                        case 4:
                            service.printAllApps();
                            System.out.print("Enter ID to delete: ");
                            int delId = scan.nextInt();
                            service.deleteApp(delId);
                            System.out.println("Deleted.");
                            break;

                        case 0:
                            System.out.println("Bye!");
                            return;

                        default:
                            System.out.println("Wrong option.");
                    }
                } catch (Exception e) {
                    System.out.println("Error: " + e.getMessage());
                }
            } else {
                scan.next();
            }
        }
    }
}