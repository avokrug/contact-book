package ws;

import entities.ContactTypeEntity;
import entities.PersonEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface PersonWS {

    //  Method for finding all objects
    @WebMethod
    List<PersonEntity> findAll();

    //  Method for adding an object
    @WebMethod
    void add(PersonEntity person);

    //  Method for updating an object
    @WebMethod
    void update(PersonEntity person);

    //  Method for deleting an object
    @WebMethod
    void delete(PersonEntity person);
}
