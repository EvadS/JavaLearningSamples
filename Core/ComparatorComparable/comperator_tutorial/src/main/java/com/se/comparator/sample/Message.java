package com.se.comparator.sample;

import java.util.Comparator;
import java.util.Random;


public  class Message implements Comparator<Message> {
        private String message;
        private int id;

        public Message(String message) {
            this.message = message;
            this.id = new Random().nextInt(1000);
        }
        public String getMessage() {
            return message;
        }
        public Integer getId() {
            return id;
        }
        public String toString() {
            return "[" + id + "] " + message;
        }

    @Override
    public int compare(Message message, Message t1) {
         return message.getId().compareTo(t1.getId());
    }


    public static Comparator<Person> NameComparator
            = new Comparator<Person>() {

        @Override
        public int compare(Person person, Person t1) {
            return person.getName().compareTo(t1.getName());
        }
    };
}
