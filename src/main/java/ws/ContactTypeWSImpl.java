package ws;

import dao.ContactTypeModel;
import dao.ContactsModel;
import entities.ContactTypeEntity;
import entities.ContactsEntity;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ws.ContactTypeWS")
public class ContactTypeWSImpl implements ContactTypeWS{

    //  Method for finding all objects
    @Override
    public List<ContactTypeEntity> findAll() {
        ContactTypeModel contactsModel = new ContactTypeModel();
        return contactsModel.findAll();
    }

    //  Method for adding an object
    @Override
    public void add(ContactTypeEntity contactType) {
        ContactTypeModel contactTypeModel = new ContactTypeModel();
        try {
            contactTypeModel.add(contactType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Method for updating an object
    @Override
    public void update(ContactTypeEntity contactType) {
        ContactTypeModel contactTypeModel = new ContactTypeModel();
        try {
            contactTypeModel.update(contactType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Method for deleting an object
    @Override
    public void delete(ContactTypeEntity contactType) {
        ContactTypeModel contactTypeModel = new ContactTypeModel();
        try {
            contactTypeModel.update(contactType);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
