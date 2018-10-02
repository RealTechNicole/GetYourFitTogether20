/*package com.spcollege.android.getyourfittogether20;

import android.content.Context;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class ClientLab {

    private static ClientLab sClientLab;

    private List<Client> mClients;

    public static ClientLab get(Context context) {

        if (sClientLab == null) {

            sClientLab =  new ClientLab(context);

        }

        return sClientLab;

    }

    private ClientLab(Context context) {

        mClients = new ArrayList<>();

        for (int i =0; i < 100; i++) {
            Client client = new Client();
            client.setTitle("Client #" + i);
            mClients.add(client);
        }

    }

    public List<Client> getClients() {

        return mClients;

    }

    public Client getClients(UUID id) {
        for (Client client : mClients) {
            if (client.getId().equals(id)) {
                return client;
            }
        }

        return null;
    }

}*/
