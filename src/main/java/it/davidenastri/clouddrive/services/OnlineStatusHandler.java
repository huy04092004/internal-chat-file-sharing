package it.davidenastri.clouddrive.services;

import org.springframework.stereotype.Component;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class OnlineStatusHandler extends TextWebSocketHandler {

    private final Map<String, WebSocketSession> activeSessions = new ConcurrentHashMap<>();

    @Override
    public void afterConnectionEstablished(WebSocketSession session) throws Exception {
        String username = session.getPrincipal().getName();
        activeSessions.put(username, session);
        broadcastOnlineStatus(username, true); // Thông báo bạn online
    }

    @Override
    protected void handleTextMessage(WebSocketSession session, TextMessage message) throws Exception {
        // Xử lý tin nhắn nếu cần
    }

    @Override
    public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
        String username = session.getPrincipal().getName();
        activeSessions.remove(username);
        broadcastOnlineStatus(username, false); // Thông báo bạn offline
    }

    private void broadcastOnlineStatus(String username, boolean isOnline) {
        String statusMessage = String.format("{\"username\":\"%s\", \"online\":%b}", username, isOnline);
        activeSessions.values().forEach(session -> {
            try {
                session.sendMessage(new TextMessage(statusMessage));
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
