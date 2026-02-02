package it.davidenastri.clouddrive.model;

public class PeerConnection {

    private String username;
    private String ipAddress;
    private int port;

    public PeerConnection(String username, String ipAddress, int port) {
        this.username = username;
        this.ipAddress = ipAddress;
        this.port = port;
    }

    public String getUsername() {
        return username;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public int getPort() {
        return port;
    }
}
