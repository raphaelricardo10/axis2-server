package services.client;

import java.util.ArrayList;
import java.util.List;

import mock.MockData;
import stub.PersonStub;

public class ClientService {
    private List<PersonStub> clients;

    public ClientService() throws Exception {
        PersonStub person = new PersonStub(MockData.makePerson());
        this.clients = new ArrayList<PersonStub>();
        clients.add(person);
    }

    public PersonStub[] getClients() {
        PersonStub[] clientsArr = new PersonStub[this.clients.size()];
        this.clients.toArray(clientsArr);

        return clientsArr;
    }
}
