package model;

import javax.swing.JOptionPane;

public class ContactManager {
    private Contact[] contacts;

    public ContactManager() {
        contacts = new Contact[100];
    }

    public void addContact() {

        // Find open slot first
        int openIndex = -1;
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] == null) {
                openIndex = i;
                break;
            }
        }

        if (openIndex == -1) {
            JOptionPane.showMessageDialog(null, "Contact list is full.");
            return;
        }

        // Choose contact type
        String[] options = { "Individual", "Emergency", "Business" };
        String type = (String) JOptionPane.showInputDialog(
                null,
                "Select Contact Type",
                "Add Contact",
                JOptionPane.QUESTION_MESSAGE,
                null,
                options,
                options[0]);

        if (type == null) return;

        String name = JOptionPane.showInputDialog("Enter name:");
        String phoneNum = JOptionPane.showInputDialog("Primary Phone:");
        String email = JOptionPane.showInputDialog("Primary Email:");

        Contact newContact = null;

        if (type.equals("Individual")) {
            String birthday = JOptionPane.showInputDialog("Enter birthday:");
            int age = Integer.parseInt(JOptionPane.showInputDialog("Enter age:"));
            newContact = new IndividualContact(name, email, phoneNum, birthday, age);
        }

        else if (type.equals("Emergency")) {
            int priority = Integer.parseInt(JOptionPane.showInputDialog("Priority Level:"));
            String address = JOptionPane.showInputDialog("Address:");
            String relationship = JOptionPane.showInputDialog("Relationship:");
            newContact = new EmergencyContact(name, email, phoneNum, priority, address, relationship);
        }

        else if (type.equals("Business")) {
            String address = JOptionPane.showInputDialog("Address:");
            String company = JOptionPane.showInputDialog("Company:");
            String jobTitle = JOptionPane.showInputDialog("Job Title:");
            String department = JOptionPane.showInputDialog("Department:");
            String workEmail = JOptionPane.showInputDialog("Work Email:");
            newContact = new BusinessContact(name, email, phoneNum, address, company, jobTitle, department, workEmail);
        }

        if (newContact != null) {
            contacts[openIndex] = newContact;
            JOptionPane.showMessageDialog(null, "Contact added.");
        }
    }

    public void removeContact(String name) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null && contacts[i].getName().equalsIgnoreCase(name)) {
                contacts[i] = null;
                return;
            }
        }
    }

    public void removeContactById(int id) {
        for (int i = 0; i < contacts.length; i++) {
            if (contacts[i] != null && contacts[i].getId() == id) {
                contacts[i] = null;
                return;
            }
        }
    }

    public Contact[] findContactByName(String name) {
        int count = 0;
        for (Contact c : contacts) {
            if (c != null && c.getName().equalsIgnoreCase(name)) count++;
        }

        if (count == 0) return new Contact[0];

        Contact[] foundContacts = new Contact[count];
        int index = 0;
        for (Contact c : contacts) {
            if (c != null && c.getName().equalsIgnoreCase(name)) {
                foundContacts[index++] = c;
            }
        }
        return foundContacts;
    }

    public Contact[] getAllContacts() {
        return contacts;
    }

    public Contact[] getContactsByType(String type) {
        int count = 0;
        for (Contact c : contacts) {
            if (c != null && c.getContactType().equalsIgnoreCase(type)) count++;
        }

        if (count == 0) return new Contact[0];

        Contact[] filtered = new Contact[count];
        int index = 0;
        for (Contact c : contacts) {
            if (c != null && c.getContactType().equalsIgnoreCase(type)) {
                filtered[index++] = c;
            }
        }
        return filtered;
    }
}