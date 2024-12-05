package com.example.task05;

public class MailMessage extends MailUnit<String> {

    MailMessage(String sender, String recipient, String message){
        super(sender, recipient, message);
    }
}
