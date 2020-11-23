package ws;

import entities.ContactTypeEntity;
import entities.ContactsEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ContactTypeWS {

    //  Method for finding all objects
    @WebMethod
    List<ContactTypeEntity> findAll();

    //  Method for adding an object
    @WebMethod
    void add(ContactTypeEntity contactType);

    //  Method for updating an object
    @WebMethod
    void update(ContactTypeEntity contactType);

    //  Method for deleting an object
    @WebMethod
    void delete(ContactTypeEntity contactType);
}
