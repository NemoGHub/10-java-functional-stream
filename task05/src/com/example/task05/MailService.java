package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Consumer;

public class MailService<T> implements Consumer<MailUnit<T>> {
    Map<String, List<T>> mailBox = new MailList<>();

    @Override
    public void accept(MailUnit<T> mailUnit){
        String from = mailUnit.getFrom();
        String to = mailUnit.getTo();
        T content = mailUnit.getContent();

        if (!mailBox.containsKey(to)) mailBox.put(to, new ArrayList<>());
        mailBox.get(to).add(content);
    }

    public Map<String, List<T>> getMailBox(){ return mailBox; }
}
