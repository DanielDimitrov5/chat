package com.example.chatservice.repository;

import com.example.chatservice.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findBySenderAndRecipient(String sender, String recipient);
    List<Message> findByRecipient(String recipient);
}
