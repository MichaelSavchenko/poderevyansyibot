package com.mihadev.poderevjanskyibot;

public enum Book {
    DANKO("Данко"),
    PACAVATA_ISTORIA ("Пацавата історія"),
    HVOROBA_IVASYKA("Хвороба Івасика"),
    JAN_MARE("Жан Маре");

    Book(String bookName) {
        this.bookName = bookName;
    }

    public String bookName;
}
