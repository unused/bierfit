package bierfit.mybierfit;

import java.util.Date;

/**
 * Created by kosha on 20/06/2016.
 */
public class Beer {

    private int amount_in_ml;
    private Date finished_at;
    private String size;
    private Date created_at;

    public int getAmount_in_ml() {
        return amount_in_ml;
    }

    public void setAmount_in_ml(int amount_in_ml) {
        this.amount_in_ml = amount_in_ml;
    }

    public Date getFinished_at() {
        return finished_at;
    }

    public void setFinished_at(Date finished_at) {
        this.finished_at = finished_at;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    private Date updated_at;
    private int user_id;

    public Beer(int amount_in_ml, Date finished_at, String size, Date created_at, Date updated_at, int user_id) {
        this.amount_in_ml = amount_in_ml;
        this.finished_at = finished_at;
        this.size = size;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.user_id = user_id;
    }



    public Beer() {
    }
}
