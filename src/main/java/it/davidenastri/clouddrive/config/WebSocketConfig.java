package it.davidenastri.clouddrive.config;

import it.davidenastri.clouddrive.services.OnlineStatusHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.socket.config.annotation.EnableWebSocket;
import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;

@Configuration
@EnableWebSocket
public class WebSocketConfig implements WebSocketConfigurer {

    private final OnlineStatusHandler onlineStatusHandler;

 @Autowired
    public WebSocketConfig(@Lazy OnlineStatusHandler onlineStatusHandler) {
        this.onlineStatusHandler = onlineStatusHandler;
    }

    @Override
    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
        registry.addHandler(onlineStatusHandler, "/ws/online-status").setAllowedOrigins("*");
    }
}
