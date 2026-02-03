package service;

import interfaces.CrudRepository;
import model.*;
import repository.AppRepo;
import repository.CompanyRepo;
import exception.BadDataException;
import utils.SortUtils;
import java.util.ArrayList;

public class AppService {
    private CrudRepository<Application> appRepo = new AppRepo();
    private CrudRepository<Company> companyRepo = new CompanyRepo();

    public void createCompany(String name, String industry) {
        Company c = new Company(0, name, industry);
        companyRepo.add(c);
    }

    public void printCompanies() {
        ArrayList<Company> list = companyRepo.getAll();
        System.out.println("\n--- COMPANIES ---");
        for (Company c : list) {
            System.out.println(c.getId() + ". " + c.getName());
        }
    }

    public Company getCompany(int id) {
        return companyRepo.getById(id);
    }

    public void saveApp(Application app) throws BadDataException {
        app.printValidationStatus();

        if (!app.isValid()) {
            throw new BadDataException("Invalid Data!");
        }
        appRepo.add(app);
    }

    public void printAllApps() {
        ArrayList<Application> list = appRepo.getAll();

        SortUtils.sortById(list);

        System.out.println("\n--- APPLICATIONS ---");
        for (Application a : list) {
            System.out.println(a.getId() + ". " + a.getInfo());
        }
    }

    public void deleteApp(int id) {
        appRepo.delete(id);
    }
}