package model;

public class EmergencyContact extends Contact implements ContactInfo, Prioritizable, Locatable {
    private int priorityLevel;
    private String address;
    private String relationship;

    public EmergencyContact(String name, String email, String phoneNum,
            int priorityLevel, String address, String relationship) {
        super(name, email, phoneNum);
        this.priorityLevel = priorityLevel;
        this.address = address;
        this.relationship = relationship;
    }

    // Prioritizable
    @Override
    public int getPriorityLevel() {
        return priorityLevel;
    }

    public void setPriorityLevel(int priorityLevel) {
        this.priorityLevel = priorityLevel;
    }

    // Locatable
    @Override
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    // EmergencyContact specific
    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    // ContactInfo
    @Override
    public String getPrimaryContactMethod() {
        return this.getPrimaryPhone();
    }

    @Override
    public String getContactType() {
        return "Emergency";
    }
}
