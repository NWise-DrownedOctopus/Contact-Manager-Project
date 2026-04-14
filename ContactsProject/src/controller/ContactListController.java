package controller;

import java.util.List;

import javax.smartcardio.Card;

import model.Contact;
import view.ContactAddEditView;
import view.ContactListView;

public class ContactListController {
    private ContactListView view;

    public ContactListController() {
    }

    public void setView(ContactListView view) {
        this.view = view;
    }

    public void openAddDialog() {

    }

    public void openEditDialog(Contact contact) {

    }

    public void deleteContact(int id) {

    }

}
