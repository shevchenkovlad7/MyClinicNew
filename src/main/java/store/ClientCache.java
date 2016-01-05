package store;

import model.Client;

import java.util.Collection;
import java.util.HashMap;

/**
 * Created by Влад on 04.01.2016.
 */
public class ClientCache {
    private static final ClientCache INSTANCE = new ClientCache();
    private final HashMap<Integer, Client> clients = new HashMap<>();

    public static ClientCache getInstance(){
        return INSTANCE;
    }
    public Collection<Client> values(){
        return this.clients.values();
    }
    public void add(final Client client){
        this.clients.put(client.getId(),client);
    }
    public void edit(final Client client){
        this.clients.replace(client.getId(),client);
    }
    public void delete(final int id){
        this.clients.remove(id);
    }
    public Client get(final int id){
        return this.clients.get(id);
    }

}
