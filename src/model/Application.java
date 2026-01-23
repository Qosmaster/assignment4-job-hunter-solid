package model;

import interfaces.MyValidation;

public abstract class Application extends BaseEntity implements MyValidation {
    protected Company company;
    protected String status;

    public Application(int id, String name, Company company, String status) {
        super(id, name);
        this.company = company;
        this.status = status;
    }

    public Company getCompany() { return company; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public abstract String getType();
}