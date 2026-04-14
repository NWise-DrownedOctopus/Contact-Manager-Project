package view;

import javax.smartcardio.Card;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import java.awt.*;

import controller.ContactListController;
import model.Contact;

public class ContactListView extends JFrame{

    private JComboBox<String> cmbType = new JComboBox<>(
            new String[] { "Any", "Buisiness", "Emergency", "Individual" });

    private JButton btnAdd = new JButton("Add");
    private JButton btnEdit = new JButton("Edit");
    private JButton btnDelete = new JButton("Delete");

    private JTable tblContacts;
    private java.util.List<Contact> currentContacts = new java.util.ArrayList<>();

    private ContactListController controller;

    public ContactListView(ContactListController controller) {
        this.controller = controller;

        setTitle("Contact Manager - Nicholas Wise");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        // Filter Contact type
        cmbType.setSelectedItem("Any");

        // Table model
        DefaultTableModel tableModel = new DefaultTableModel(
                new Object[] { "#", "Name", "Primary Phone #", "email" },
                0);
        tblContacts = new JTable(tableModel);

        buildUI();
        addActionListeners();
    }

    private void buildUI() {
        setLayout(new BorderLayout(10, 10));

        // ===== Top Filter Panel =====
        JPanel filterPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        filterPanel.add(new JLabel("Game"));
        filterPanel.add(cmbType);
        filterPanel.add(Box.createHorizontalStrut(12));

        add(filterPanel, BorderLayout.NORTH);

        // ===== Center Table =====
        JScrollPane tableScroll = new JScrollPane(tblContacts);
        tableScroll.setPreferredSize(new Dimension(600, 300));
        add(tableScroll, BorderLayout.CENTER);

        // ===== Bottom Panels =====
        // Left: action buttons
        JPanel actionPanel = new JPanel();
        actionPanel.add(btnAdd);
        actionPanel.add(Box.createHorizontalStrut(10));
        actionPanel.add(btnEdit);
        actionPanel.add(Box.createHorizontalStrut(10));
        actionPanel.add(btnDelete);

        add(actionPanel, BorderLayout.SOUTH);
    }

    private void addActionListeners() {
        // Add card entry
        btnAdd.addActionListener(e -> {
            controller.openAddDialog();
            refreshTable();
        });

        // Update card entry
        btnEdit.addActionListener(e -> {
            int selectedRow = tblContacts.getSelectedRow();
            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a Contact entry to edit");
                return;
            }

            Contact selectedContact = currentContacts.get(selectedRow);
            controller.openEditDialog(selectedContact); // pass just the Card
            refreshTable(); // refresh after dialog closes
        });

        // Delete card entry
        btnDelete.addActionListener(e -> {
            int selectedRow = tblContacts.getSelectedRow();

            if (selectedRow == -1) {
                JOptionPane.showMessageDialog(this, "Please select a contact entry to delete");
                return;
            }

            // Get the actual Contact object
            Contact selectedContact = currentContacts.get(selectedRow);

            // Delete using its real ID
            controller.deleteContact(selectedContact.getId());

            refreshTable();
        });
    }
    
}
