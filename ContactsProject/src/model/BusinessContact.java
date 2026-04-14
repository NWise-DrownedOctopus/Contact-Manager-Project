package model;

public class BusinessContact extends Contact implements ContactInfo, Locatable, Employable {
    private String address;
    private String company;
    private String jobTitle;
    private String department;
    private String workEmail;

    public BusinessContact(String name, String email, String phoneNum,
            String address, String company, String jobTitle,
            String department, String workEmail) {
        super(name, email, phoneNum);
        this.address = address;
        this.company = company;
        this.jobTitle = jobTitle;
        this.department = department;
        this.workEmail = workEmail;
    }

    // Locatable
    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // Employable
    @Override
    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    @Override
    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    @Override
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    @Override
    public String getWorkEmail() {
        return workEmail;
    }

    public void setWorkEmail(String workEmail) {
        this.workEmail = workEmail;
    }

    // ContactInfo
    @Override
    public String getPrimaryContactMethod() {
        return this.getPrimaryEmail();
    }

    @Override
    public String getContactType() {
        return "Business";
    }
}
