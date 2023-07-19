//package Ptit.Cinema.config;
//
//import Ptit.Cinema.handler.MovieScheduleHandler;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.socket.WebSocketHandler;
//import org.springframework.web.socket.config.annotation.EnableWebSocket;
//import org.springframework.web.socket.config.annotation.WebSocketConfigurer;
//import org.springframework.web.socket.config.annotation.WebSocketHandlerRegistry;
//
//// WebSocketConfig.java
//@Configuration
//@EnableWebSocket
//public class WebSocketConfig implements WebSocketConfigurer {
//
//    @Override
//    public void registerWebSocketHandlers(WebSocketHandlerRegistry registry) {
//        registry.addHandler(movieScheduleHandler(), "/ws").setAllowedOrigins("*");
//    }
//
//    @Bean
//    public WebSocketHandler movieScheduleHandler() {
//        return new MovieScheduleHandler();
//    }
//}
//
