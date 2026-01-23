package model;

public class EasyApp extends Application {
    private String site;

    public EasyApp(int id, String name, Company company, String status, String site) {
        super(id, name, company, status);
        this.site = site;
    }

    public String getInfo() {
        return "Job: " + name + " in " + company.getName() + " via " + site;
    }

    public String getType() {
        return "EASY";
    }

    public boolean checkData() {
        if (name == null) return false;
        if (name.length() == 0) return false;
        return true;
    }

    public String getSite() { return site; }
}