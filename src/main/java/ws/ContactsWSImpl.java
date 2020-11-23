package ws;

import dao.ContactsModel;
import entities.ContactsEntity;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ws.ContactsWS")
public class ContactsWSImpl implements ContactsWS{

    //  Method for finding all objects
    @Override
    public List<ContactsEntity> findAll() {
        ContactsModel contactsModel = new ContactsModel();
        return contactsModel.findAll();
    }

    //  Method for adding an object
    @Override
    public void add(ContactsEntity contacts) {
        ContactsModel contactsModel = new ContactsModel();
        try {
            contactsModel.add(contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Method for updating an object
    @Override
    public void update(ContactsEntity contacts) {
        ContactsModel contactsModel = new ContactsModel();
        try {
            contactsModel.update(contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Method for deleting an object
    @Override
    public void delete(ContactsEntity contacts) {
        ContactsModel contactsModel = new ContactsModel();
        try {
            contactsModel.delete(contacts);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
