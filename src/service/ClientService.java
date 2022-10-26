package service;

import java.util.Set;
import java.util.HashSet;

import mock.MockData;
import person.Person;

public class ClientService {
    private Set<Person> clients;

    public ClientService() throws Exception {
        this.clients = new HashSet<Person>();
        this.clients.add(MockData.makeDoctor());
    }

    public Set<Person> getClients() {
        return this.clients;
    }
}
