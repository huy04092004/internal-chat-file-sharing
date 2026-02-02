package it.davidenastri.clouddrive.services;

import it.davidenastri.clouddrive.model.PeerConnection;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class PeerService {

    private final Map<String, PeerConnection> peerConnections = new HashMap<>();

    public void registerPeer(String username, String ipAddress, int port) {
        peerConnections.put(username, new PeerConnection(username, ipAddress, port));
    }

    public PeerConnection getPeerConnection(String username) {
        return peerConnections.get(username);
    }
}
