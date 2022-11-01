package services.client;

import java.util.Map;
import java.util.HashMap;

import mock.MockData;
import stub.PersonStub;

public class ClientService {
    private Map<String, PersonStub> clients;

    public ClientService() throws Exception {
        PersonStub person = new PersonStub(MockData.makePerson());
        this.clients = new HashMap<String, PersonStub>();
        clients.put(person.getCpf(), person);
    }

    public PersonStub[] getClients() {
        PersonStub[] clientsArr = new PersonStub[this.clients.size()];
        this.clients.values().toArray(clientsArr);

        return clientsArr;
    }

    public PersonStub createClient(String name, String email, String cpf, String gender, String phoneNumber, String birthDate) throws Exception {
        PersonStub client = new PersonStub(name, email, cpf, gender, phoneNumber, birthDate);
        this.clients.putIfAbsent(client.getCpf(), client);

        return client;
    }

    public void removeClient(String cpf) {
        this.clients.remove(cpf);
    }

    public void updateClient(PersonStub client) {
        this.clients.replace(client.getCpf(), client);
    }
}
