package dao;

import entities.PersonEntity;

//  The model required to work with the repository
public class PersonModel extends AbstractModel<PersonEntity>{
    //  Pass the object type to the parent class
    public PersonModel(){
        super(PersonEntity.class);
    }
}
