package me.twinkle.consumer;

import java.util.function.Consumer;

public class Main {

    public static void main(String[] args) {
        new Main().run();
    }

    private void run() {

        Mailer.send(mailer -> mailer
                .to("twinklelahariya1@gmail.com")
                .from("jayeshpatel@gmail.com")
                .subject("hey Beautiful")
                .body("u the best"));
    }


}

class Mailer {
    public Mailer from(String address) {
        System.out.println(address);
        return this;
    }

    public Mailer to(String to) {
        System.out.println(to);
        return this;
    }

    public Mailer subject(String subject) {
        System.out.println(subject);
        return this;
    }

    public Mailer body(String body) {
        System.out.println(body);
        return this;
    }

    public static void send(Consumer<Mailer> consumer) {
        Mailer mailer = new Mailer();

        consumer.accept(mailer);
        System.out.println("Mail Sent");
    }
}
