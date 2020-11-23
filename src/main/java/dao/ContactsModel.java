package dao;

import entities.ContactsEntity;

//  The model required to work with the repository
public class ContactsModel extends AbstractModel<ContactsEntity>{
    public ContactsModel(){
        //  Pass the object type to the parent class
        super(ContactsEntity.class);
    }
}
