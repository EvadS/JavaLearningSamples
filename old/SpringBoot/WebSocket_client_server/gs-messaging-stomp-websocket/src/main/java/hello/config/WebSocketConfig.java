package hello.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.AbstractWebSocketMessageBrokerConfigurer;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfig extends AbstractWebSocketMessageBrokerConfigurer {

    @Override
    public void configureMessageBroker(MessageBrokerRegistry config) {
        config.enableSimpleBroker("/topic");
        //для сообщений, привязанных к методам, аннотированными @MessageMapping
        //The application destination prefix is set to “/app“. This means WebSocket
        config.setApplicationDestinationPrefixes("/app");
    }

    @Override
    public void registerStompEndpoints(StompEndpointRegistry registry) {
        // SE from first version
        //  registry.addEndpoint("/hello").withSockJS();

        //The endpoint “/chat” is registered for starting the WebSocket protocol handshake
        //The method setAllowedOrigins("*") is used to CORS-enable the server so cross-origin clients can connect to the server.
        // If your requirements do not need cross-origin client connection, you can remove this invocation.
        registry.addEndpoint("/chat").setAllowedOrigins("*").withSockJS();
    }
}