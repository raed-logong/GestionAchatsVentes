package models;

public class FamilleProduit {
    private int code;
    private String designation;

    public FamilleProduit(int code, String designation) {
        this.code = code;
        this.designation = designation;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    @Override
    public String toString() {
        return designation;
    }
}
