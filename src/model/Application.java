package model;

import interfaces.Validatable;

public abstract class Application extends BaseEntity implements Validatable {
    protected Company company;
    protected String status;

    public Application(int id, String name, Company company, String status) {
        super(id, name);
        this.company = company;
        this.status = status;
    }

    public Company getCompany() { return company; }
    public String getStatus() { return status; }

    public abstract String getType();
}