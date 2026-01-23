package model;

public class HardApp extends Application {
    private int roundCount;

    public HardApp(int id, String name, Company company, String status, int roundCount) {
        super(id, name, company, status);
        this.roundCount = roundCount;
    }

    public String getInfo() {
        return "HARD Job: " + name + " (" + roundCount + " interviews...)";
    }

    public String getType() {
        return "HARD";
    }

    public boolean checkData() {
        if (roundCount > 0) {
            return true;
        } else {
            return false;
        }
    }

    public int getRoundCount() { return roundCount; }
}