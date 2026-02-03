package model;

public class EasyApp extends Application {
    private String site;

    public EasyApp(int id, String name, Company company, String status, String site) {
        super(id, name, company, status);
        this.site = site;
    }

    @Override
    public String getInfo() {
        return "Easy Job: " + name + " at " + company.getName() + " (" + site + ")";
    }

    @Override
    public String getType() { return "EASY"; }

    @Override
    public boolean isValid() {
        return name != null && !name.isEmpty() && site != null;
    }

    public String getSite() { return site; }
}