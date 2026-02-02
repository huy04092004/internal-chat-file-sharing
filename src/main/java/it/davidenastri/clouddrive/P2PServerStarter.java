package it.davidenastri.clouddrive;

import it.davidenastri.clouddrive.P2PServer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
public class P2PServerStarter {

    @PostConstruct
    public void startP2PServer() {
        int port = 12345; // Cổng cho P2P
        new Thread(new P2PServer(port)).start();
        System.out.println("P2P Server started on port " + port);
    }
}
