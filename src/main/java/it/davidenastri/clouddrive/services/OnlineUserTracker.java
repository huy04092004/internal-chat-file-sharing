//package it.davidenastri.clouddrive.services;
//
//import it.davidenastri.clouddrive.P2PClient;
//import org.springframework.stereotype.Service;
//
//import java.util.Set;
//import java.util.concurrent.ConcurrentHashMap;
//
//@Service
//public class OnlineUserTracker {
//
//    private final Set<String> onlineUsers = ConcurrentHashMap.newKeySet();
//    private final P2PClient p2pClient = new P2PClient();
//
//    public void checkAndUpdateOnlineStatus(String username, String ip, int port) {
//        if (p2pClient.isOnline(ip, port)) {
//            setUserOnline(username);
//        } else {
//            setUserOffline(username);
//        }
//    }
//
//    public void setUserOnline(String username) {
//        onlineUsers.add(username);
//    }
//
//    public void setUserOffline(String username) {
//        onlineUsers.remove(username);
//    }
//
//    public boolean isUserOnline(String username) {
//        return onlineUsers.contains(username);
//    }
//
//    public Set<String> getOnlineUsers() {
//        return onlineUsers;
//    }
//}
