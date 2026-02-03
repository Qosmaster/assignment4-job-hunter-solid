package model;

public class Company {
    private int id;
    private String name;
    private String industry;

    public Company(int id, String name, String industry) {
        this.id = id;
        this.name = name;
        this.industry = industry;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getIndustry() { return industry; }
}