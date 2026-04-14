package model;

public abstract class Contact {
    private String name;
    private int id;
    private String primaryEmail;
    private String primaryPhone;

    public Contact(){};
    public Contact(String name, String email, String phoneNum) {
        this.name = name;
        this.primaryEmail = email;
        this.primaryPhone = phoneNum;
    };
    
    public String getName() {
        return name;
    }

    public int getId() {
        return id;
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
        primaryPhone = phone;
    }

    public void setPriamryEmail(String email) {
        primaryEmail = email;
    }

    public abstract String getContactType();
    
}

class IndividualContact extends Contact implements ContactInfo, Birthdatable {
    private int age;
    private String birthday;

    // Constructor
    public IndividualContact(String name, String email, String phoneNum, String birthday, int age) {
        super(name, email, phoneNum);
        this.birthday = birthday;
        this.age = age;
    };    

    // Birthdateable
    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String bday) {
        this.birthday = bday;
    }

    public int getAge() {
        return age;
    }

    public Boolean isBirthdayToday() {
        return false;
    }

    // Contact Info
    public String getContactType() {
        return "Individual";
    }

    public String getPrimaryContactMethod() {
        return this.getPrimaryPhone();
    }

}

class EmergencyContact extends Contact implements ContactInfo, Prioritizable, Locatable {

    private int priorityLevel;
    private String address;
    private String relationship;

    // Constructor
    public EmergencyContact(String name, String email, String phoneNum, String primaryContactMethod,
            int priorityLevel, String address, String relationship) {
        super(name, email, phoneNum);
        this.priorityLevel = priorityLevel;
        this.address = address;
        this.relationship = relationship;
    }

    // ----- Prioritizable -----
    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    // ----- Locatable -----
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ----- EmergencyContact specific -----
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    // ----- Contact Into -----
    public String getPrimaryContactMethod() {
        return this.getPrimaryPhone();
    }

    public String getContactType() {
        return "Emergency";
    }
}

class BusinessContact extends Contact implements ContactInfo, Locatable, Employable {

    private String address;
    private String company;
    private String jobTitle;
    private String department;
    private String workEmail;

    // Constructor
    public BusinessContact(String name,
            String email, String phoneNum,
            String primaryContactMethod,
            String address,
            String company,
            String jobTitle,
            String department,
            String workEmail) {

        super(name, email,  phoneNum); // assuming Contact constructor exists
        this.address = address;
        this.company = company;
        this.jobTitle = jobTitle;
        this.department = department;
        this.workEmail = workEmail;
    }

    // ----- Locatable -----
    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // ----- Employable -----
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    // ----- Contact Into -----
    public String getPrimaryContactMethod() {
        return this.getPrimaryEmail();
    }

    public String getContactType() {
        return "Business";
    }
}