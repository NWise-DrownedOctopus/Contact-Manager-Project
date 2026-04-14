package model;

public class IndividualContact extends Contact implements ContactInfo, Birthdatable {
    private int age;
    private String birthday;

    public IndividualContact(String name, String email, String phoneNum, String birthday, int age) {
        super(name, email, phoneNum);
        this.birthday = birthday;
        this.age = age;
    }

    // Birthdatable
    @Override
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String bday) {
        this.birthday = bday;
    }

    @Override
    public int getAge() {
        return age;
    }

    @Override
    public Boolean isBirthdayToday() {
        return false;
    }

    // ContactInfo
    @Override
    public String getContactType() {
        return "Individual";
    }

    @Override
    public String getPrimaryContactMethod() {
        return this.getPrimaryPhone();
    }
}
