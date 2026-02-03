package model;

public class HardApp extends Application {
    private int stages;

    public HardApp(int id, String name, Company company, String status, int stages) {
        super(id, name, company, status);
        this.stages = stages;
    }

    @Override
    public String getInfo() {
        return "Hard Job: " + name + " at " + company.getName() + " (" + stages + " stages)";
    }

    @Override
    public String getType() { return "HARD"; }

    @Override
    public boolean isValid() {
        return name != null && !name.isEmpty() && stages > 0;
    }

    public int getStages() { return stages; }
}