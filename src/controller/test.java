package controller;

public abstract class test<Partner> {
    protected String tablename = null;

    public String getTablename() {
        return tablename;
    }

    public void setTablename(String tablename) {
        this.tablename = tablename;
    }

    public boolean add(Partner P) {
        return false;
    }
}
