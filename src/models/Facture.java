package models;

import java.sql.Date;

public abstract class Facture {


    protected int id;
    protected String code;


    protected Date date;

    public Facture(int id, String code, Date date) {
        this.id = id;
        this.code = code;
        this.date = date;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }


}
