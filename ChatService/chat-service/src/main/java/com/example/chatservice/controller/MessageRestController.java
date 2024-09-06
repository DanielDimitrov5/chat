package com.example.chatservice.controller;

import com.example.chatservice.model.Message;
import com.example.chatservice.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/messages")
public class MessageRestController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/conversation/{sender}/{recipient}")
    public ResponseEntity<List<Message>> getMessagesBetweenUsers(@PathVariable String sender, @PathVariable String recipient) {
        List<Message> messages = messageService.getMessagesBetweenUsers(sender, recipient);
        return ResponseEntity.ok(messages);
    }

    @PostMapping("/send")
    public ResponseEntity<Message> sendMessage(@RequestBody MessageRequest request) {
        Message message = messageService.saveMessage(request.getSender(), request.getRecipient(), request.getContent());
        return ResponseEntity.ok(message);
    }

    static class MessageRequest {
        private String sender;
        private String recipient;
        private String content;

        // Getters and setters
        public String getSender() { return sender; }
        public void setSender(String sender) { this.sender = sender; }

        public String getRecipient() { return recipient; }
        public void setRecipient(String recipient) { this.recipient = recipient; }

        public String getContent() { return content; }
        public void setContent(String content) { this.content = content; }
    }
}
