//package it.davidenastri.clouddrive.services;
//
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.CloseStatus;
//import org.springframework.web.socket.TextMessage;
//import org.springframework.web.socket.WebSocketSession;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//import java.util.concurrent.ConcurrentHashMap;
//import java.util.Map;
//
//@Component
//public class WebSocketHandler extends TextWebSocketHandler {
//
//    private final Map<String, WebSocketSession> sessions = new ConcurrentHashMap<>();
//
//    @Override
//    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
//        sessions.put(session.getId(), session);
//        broadcast("User " + session.getId() + " is online");
//    }
//
//    @Override
//    public void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
//        broadcast("Message from " + session.getId() + ": " + message.getPayload());
//    }
//
//    @Override
//    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
//        sessions.remove(session.getId());
//        broadcast("User " + session.getId() + " is offline");
//    }
//
//    private void broadcast(String message) {
//        sessions.values().forEach(session -> {
//            try {
//                session.sendMessage(new TextMessage(message));
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        });
//    }
//}
