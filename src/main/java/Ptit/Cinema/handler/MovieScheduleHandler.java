//package Ptit.Cinema.handler;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.messaging.simp.SimpMessagingTemplate;
//import org.springframework.stereotype.Component;
//import org.springframework.web.socket.handler.TextWebSocketHandler;
//
//// MovieScheduleHandler.java
//@Component
//public class MovieScheduleHandler extends TextWebSocketHandler {
//
//    private final SimpMessagingTemplate messagingTemplate;
//
//    @Autowired
//    public MovieScheduleHandler(SimpMessagingTemplate messagingTemplate) {
//        this.messagingTemplate = messagingTemplate;
//    }
//
//
//    public void sendMovieScheduleUpdate(String message) {
//        messagingTemplate.convertAndSend("/topic/movie-schedule", message);
//    }
//}
//
