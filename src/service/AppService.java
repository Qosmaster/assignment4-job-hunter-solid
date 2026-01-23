package service;

import model.*;
import repository.AppRepo;
import exception.BadDataException;
import repository.CompanyRepo;

import java.util.ArrayList;

public class AppService {
    AppRepo appRepo = new AppRepo();
    CompanyRepo companyRepo = new CompanyRepo();

    public void saveApp(Application app) throws BadDataException {
        if (!app.checkData()) {
            throw new BadDataException("Invalid data!");
        }
        appRepo.add(app);
    }

    public void printAllApps() {
        ArrayList<Application> list = appRepo.getAll();
        System.out.println("\n--- MY APPLICATIONS ---");
        if (list.isEmpty()) {
            System.out.println("No applications yet.");
        }
        for (Application a : list) {
            System.out.println(a.getId() + ". " + a.getInfo() + " [" + a.getStatus() + "]");
        }
    }

    public void deleteApp(int id) {
        appRepo.deleteById(id);
    }

    public void createCompany(String name, String industry) throws BadDataException {
        if (name == null || name.isEmpty()) {
            throw new BadDataException("Company name can't empty");
        }
        Company c = new Company(0, name, industry);
        companyRepo.add(c);
    }

    public void printCompanies() {
        ArrayList<Company> list = companyRepo.getAll();
        System.out.println("\n--- COMPANIES ---");
        for (Company c : list) {
            System.out.println(c.getId() + ". " + c.getName() + " (" + c.getIndustry() + ")");
        }
    }

    public Company getCompanyById(int id) throws BadDataException {
        Company c = companyRepo.getById(id);
        if (c == null) {
            throw new BadDataException("Company not found!");
        }
        return c;
    }
}