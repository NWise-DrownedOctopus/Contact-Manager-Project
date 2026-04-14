package model;

public abstract class Contact {
    private static int nextId = 1;

    private final int id;
    private String name;
    private String primaryEmail;
    private String primaryPhone;

    public Contact() {
        this.id = nextId++;
    }

    public Contact(String name, String email, String phoneNum) {
        this.id = nextId++;
        this.name = name;
        this.primaryEmail = email;
        this.primaryPhone = phoneNum;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPrimaryPhone() {
        return primaryPhone;
    }

    public String getPrimaryEmail() {
        return primaryEmail;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrimaryPhone(String phone) {
        this.primaryPhone = phone;
    }

    public void setPrimaryEmail(String email) {
        this.primaryEmail = email;
    }

    public abstract String getContactType();
}