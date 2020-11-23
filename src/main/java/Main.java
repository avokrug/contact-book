import ws.ContactTypeWSImpl;
import ws.ContactsWSImpl;
import ws.PersonWSImpl;

import javax.xml.ws.Endpoint;

public class Main{
    public static void main(String[] args) {
        try {
            Endpoint.publish("http://localhost:8081/ws/contacts", new ContactsWSImpl());
            Endpoint.publish("http://localhost:8081/ws/contactType", new ContactTypeWSImpl());
            Endpoint.publish("http://localhost:8081/ws/person", new PersonWSImpl());
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}