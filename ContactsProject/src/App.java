import javax.swing.JOptionPane;

public class App {

    public static void main(String[] args) {

        ContactManager manager = new ContactManager(); // capacity = 100

        boolean running = true;

        while (running) {

            String[] options = { "Add Contact", "View All Contacts", "Exit" };

            String choice = (String) JOptionPane.showInputDialog(
                    null,
                    "Select an option",
                    "Contact Manager",
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]);

            if (choice == null || choice.equals("Exit")) {
                running = false;
            }

            // -------------------
            // Add Contact
            // -------------------
            else if (choice.equals("Add Contact")) {
                manager.addContact();
            }

            // -------------------
            // View All Contacts
            // -------------------
            else if (choice.equals("View All Contacts")) {

                Contact[] contacts = manager.getAllContacts();

                String output = "";

                for (Contact c : contacts) {
                    if (c != null) {
                        output += "Name: " + c.getName() + "\n";
                        output += "Type: " + c.getContactType() + "\n";
                        output += "-----------------------\n";
                    }
                }

                if (output.equals("")) {
                    output = "No contacts found.";
                }

                JOptionPane.showMessageDialog(null, output);
            }
        }

        JOptionPane.showMessageDialog(null, "Goodbye!");
    }
}