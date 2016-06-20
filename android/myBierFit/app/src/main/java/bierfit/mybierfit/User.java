package bierfit.mybierfit;

import java.util.Date;

/**
 * Created by kosha on 20/06/2016.
 */
public class User {


    private String email = "";
    private String encrypted_password = "";
    private String reset_password_token;
    private Date reset_password_sent_at;
    private Date remember_created_at;
    private int sign_in_count = 0;
    private Date current_sign_in_at;
    private Date last_sign_in_at;
    private String current_sign_in_ip;
    private String last_sign_in_ip;
    private Date created_at;
    private Date updated_at;
    private String confirmation_token;
    private Date confirmed_at;

    private Date confirmation_sent_at;
    private boolean isAdmin = false;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEncrypted_password() {
        return encrypted_password;
    }

    public void setEncrypted_password(String encrypted_password) {
        this.encrypted_password = encrypted_password;
    }

    public String getReset_password_token() {
        return reset_password_token;
    }

    public void setReset_password_token(String reset_password_token) {
        this.reset_password_token = reset_password_token;
    }

    public Date getReset_password_sent_at() {
        return reset_password_sent_at;
    }

    public void setReset_password_sent_at(Date reset_password_sent_at) {
        this.reset_password_sent_at = reset_password_sent_at;
    }

    public Date getRemember_created_at() {
        return remember_created_at;
    }

    public void setRemember_created_at(Date remember_created_at) {
        this.remember_created_at = remember_created_at;
    }

    public int getSign_in_count() {
        return sign_in_count;
    }

    public void setSign_in_count(int sign_in_count) {
        this.sign_in_count = sign_in_count;
    }

    public Date getCurrent_sign_in_at() {
        return current_sign_in_at;
    }

    public void setCurrent_sign_in_at(Date current_sign_in_at) {
        this.current_sign_in_at = current_sign_in_at;
    }

    public Date getLast_sign_in_at() {
        return last_sign_in_at;
    }

    public void setLast_sign_in_at(Date last_sign_in_at) {
        this.last_sign_in_at = last_sign_in_at;
    }

    public String getCurrent_sign_in_ip() {
        return current_sign_in_ip;
    }

    public void setCurrent_sign_in_ip(String current_sign_in_ip) {
        this.current_sign_in_ip = current_sign_in_ip;
    }

    public String getLast_sign_in_ip() {
        return last_sign_in_ip;
    }

    public void setLast_sign_in_ip(String last_sign_in_ip) {
        this.last_sign_in_ip = last_sign_in_ip;
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

    public String getConfirmation_token() {
        return confirmation_token;
    }

    public void setConfirmation_token(String confirmation_token) {
        this.confirmation_token = confirmation_token;
    }

    public Date getConfirmed_at() {
        return confirmed_at;
    }

    public void setConfirmed_at(Date confirmed_at) {
        this.confirmed_at = confirmed_at;
    }

    public Date getConfirmation_sent_at() {
        return confirmation_sent_at;
    }

    public void setConfirmation_sent_at(Date confirmation_sent_at) {
        this.confirmation_sent_at = confirmation_sent_at;
    }

    public boolean isAdmin() {
        return isAdmin;
    }

    public void setAdmin(boolean admin) {
        isAdmin = admin;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public boolean isPublic() {
        return isPublic;
    }

    public void setPublic(boolean aPublic) {
        isPublic = aPublic;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    private String username;
    private boolean isPublic;
    private String slug;

    public User(String email, String encrypted_password, String reset_password_token,
                Date reset_password_sent_at, Date remember_created_at, int sign_in_count,
                Date current_sign_in_at, Date last_sign_in_at, String current_sign_in_ip,
                String last_sign_in_ip, Date created_at, Date updated_at, String confirmation_token,
                Date confirmed_at, Date confirmation_sent_at, boolean isAdmin, String username,
                boolean isPublic, String slug) {

        this.email = email;
        this.encrypted_password = encrypted_password;
        this.reset_password_token = reset_password_token;
        this.reset_password_sent_at = reset_password_sent_at;
        this.remember_created_at = remember_created_at;
        this.sign_in_count = sign_in_count;
        this.current_sign_in_at = current_sign_in_at;
        this.last_sign_in_at = last_sign_in_at;
        this.current_sign_in_ip = current_sign_in_ip;
        this.last_sign_in_ip = last_sign_in_ip;
        this.created_at = created_at;
        this.updated_at = updated_at;
        this.confirmation_token = confirmation_token;
        this.confirmed_at = confirmed_at;
        this.confirmation_sent_at = confirmation_sent_at;
        this.isAdmin = isAdmin;
        this.username = username;
        this.isPublic = isPublic;
        this.slug = slug;
    }

    //constructor
    public User() {
    }

    public User(String name_, String email_, String password_) {
        username = name_;
        email = email_;
        //TODO passwort verschlüsseln
        encrypted_password = password_;

    }
}
