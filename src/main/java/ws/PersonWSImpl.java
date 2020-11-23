package ws;

import dao.ContactTypeModel;
import dao.PersonModel;
import entities.ContactTypeEntity;
import entities.PersonEntity;

import javax.jws.WebService;
import java.util.List;

@WebService(endpointInterface = "ws.PersonWS")
public class PersonWSImpl implements PersonWS{

    //  Method for finding all objects
    @Override
    public List<PersonEntity> findAll() {
        PersonModel personModel = new PersonModel();
        return personModel.findAll();
    }

    //  Method for adding an object
    @Override
    public void add(PersonEntity person) {
        PersonModel personModel = new PersonModel();
        try {
            personModel.add(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Method for updating an object
    @Override
    public void update(PersonEntity person) {
        PersonModel personModel = new PersonModel();
        try {
            personModel.update(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //  Method for deleting an object
    @Override
    public void delete(PersonEntity person) {
        PersonModel personModel = new PersonModel();
        try {
            personModel.delete(person);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
