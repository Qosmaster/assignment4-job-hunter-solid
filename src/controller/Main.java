package controller;

import model.*;
import service.AppService;
import utils.ReflectionUtils;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AppService service = new AppService();
        Scanner scan = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== JOB HUNTER SOLID ===");
            System.out.println("1. Add Company");
            System.out.println("2. Add Application");
            System.out.println("3. Show Apps (Sorted)");
            System.out.println("4. Delete App");
            System.out.println("5. Reflection Demo");
            System.out.println("0. Exit");
            System.out.print("Choice: ");

            if (scan.hasNextInt()) {
                int choice = scan.nextInt();
                scan.nextLine();

                try {
                    switch (choice) {
                        case 1:
                            System.out.print("Name: ");
                            String cName = scan.nextLine();
                            System.out.print("Industry: ");
                            String cInd = scan.nextLine();
                            service.createCompany(cName, cInd);
                            break;

                        case 2:
                            service.printCompanies();
                            System.out.print("Company ID: ");
                            int cId = scan.nextInt();
                            scan.nextLine();
                            Company comp = service.getCompany(cId);

                            System.out.print("Title: ");
                            String title = scan.nextLine();
                            System.out.print("Type (1=Easy, 2=Hard): ");
                            int type = scan.nextInt();
                            scan.nextLine();

                            if (type == 1) {
                                System.out.print("Site: ");
                                String site = scan.nextLine();
                                service.saveApp(new EasyApp(0, title, comp, "New", site));
                            } else {
                                System.out.print("Stages: ");
                                int st = scan.nextInt();
                                service.saveApp(new HardApp(0, title, comp, "New", st));
                            }
                            break;

                        case 3:
                            service.printAllApps();
                            break;

                        case 4:
                            System.out.print("ID to delete: ");
                            int delId = scan.nextInt();
                            service.deleteApp(delId);
                            break;

                        case 5:
                            Company demo = new Company(1, "DemoCorp", "IT");
                            ReflectionUtils.inspectClass(demo);
                            break;

                        case 0:
                            return;
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