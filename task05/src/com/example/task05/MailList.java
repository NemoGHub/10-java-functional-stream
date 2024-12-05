package com.example.task05;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MailList<T> extends HashMap<String, List<T>> {
    @Override
    public List<T> get(Object to) {
        List<T> mail = super.get(to);
        if (mail == null) return new ArrayList<>();
        else return mail;
    }
}
