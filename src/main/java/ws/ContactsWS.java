package ws;

import entities.ContactsEntity;

import javax.jws.WebMethod;
import javax.jws.WebService;
import java.util.List;

@WebService
public interface ContactsWS {

    //  Method for finding all objects
    @WebMethod
    List<ContactsEntity> findAll();

    //  Method for adding an object
    @WebMethod
    void add(ContactsEntity contacts);

    //  Method for updating an object
    @WebMethod
    void update(ContactsEntity contacts);

    //  Method for deleting an object
    @WebMethod
    void delete(ContactsEntity contacts);
}
