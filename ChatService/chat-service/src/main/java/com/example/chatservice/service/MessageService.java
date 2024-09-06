package com.example.chatservice.service;

import com.example.chatservice.model.Message;
import com.example.chatservice.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class MessageService {

    @Autowired
    private MessageRepository messageRepository;

    public Message saveMessage(String sender, String recipient, String content) {
        Message message = new Message(sender, recipient, content, LocalDateTime.now());
        return messageRepository.save(message);
    }

    public List<Message> getMessagesBetweenUsers(String sender, String recipient) {
        return messageRepository.findBySenderAndRecipient(sender, recipient);
    }

    public List<Message> getMessagesForRecipient(String recipient) {
        return messageRepository.findByRecipient(recipient);
    }
}
