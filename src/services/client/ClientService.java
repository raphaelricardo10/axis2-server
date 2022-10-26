package services.client;

import mock.MockData;
import stub.PersonStub;

public class ClientService {
    private PersonStub[] clients;

    public ClientService() throws Exception {
        PersonStub person = new PersonStub(MockData.makePerson());
        this.clients = new PersonStub[] { person };
    }

    public PersonStub[] getClients() {
        return this.clients;
    }
}
