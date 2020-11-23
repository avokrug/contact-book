package dao;

import entities.ContactTypeEntity;

//  The model required to work with the repository
public class ContactTypeModel extends AbstractModel<ContactTypeEntity>{
    //  Pass the object type to the parent class
    public ContactTypeModel(){
        super(ContactTypeEntity.class);
    }
}
