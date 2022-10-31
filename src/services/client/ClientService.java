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

    public PersonStub createClient(String name, String email, String cpf, String gender, String phoneNumber, String birthDate) throws Exception {
        PersonStub client = new PersonStub(name, email, cpf, gender, phoneNumber, birthDate);
        this.clients.add(client);

        return client;
    }
}
