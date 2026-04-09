// For contacts with a valid birthday
interface Birthdatable {
    public String getBirthday();
    public int getAge();
    public Boolean isBirthdayToday();
}

// For contacts which need to have a priority level
interface Prioritizable {
    public int getPriorityLevel();
}

// For contacts with a valid geographic location
interface Locatable {
    public String getAddress();
}

// For contacts that have valid workplace information
interface Employable {
    public String getCompany();
    public String getJobTitle();
    public String getDepartment();
    public String getWorkEmail();
}

// Interface for common contact infgor shared accross all types
interface ContactInfo {
    public String getName();
    public String getPrimaryContactMethod();
}

