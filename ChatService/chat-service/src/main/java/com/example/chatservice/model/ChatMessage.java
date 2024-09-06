package com.example.chatservice.model;

import java.time.LocalDateTime;

public class ChatMessage {

    private String sender;        // The user who sent the message
    private String recipient;     // The user receiving the message
    private String content;       // The actual message content
    private MessageType messageType;  // Message type (e.g., CHAT, JOIN, LEAVE)
    private LocalDateTime timestamp;  // The time the message was sent

    // Enum to represent different types of messages (e.g., chat, joining, leaving)
    public enum MessageType {
        CHAT,
        JOIN,
        LEAVE
    }

    public ChatMessage() {
        this.timestamp = LocalDateTime.now(); // Set the default timestamp to the current time
    }

    // Getters and Setters
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public MessageType getMessageType() {
        return messageType;
    }

    public void setMessageType(MessageType messageType) {
        this.messageType = messageType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
