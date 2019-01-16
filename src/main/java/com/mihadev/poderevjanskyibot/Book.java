package com.mihadev.poderevjanskyibot;

public enum Book {
    DANKO("Данко"),
    PACAVATA_ISTORIA ("Пацавата історія"),
    HVOROBA_IVASYKA("Хвороба Івасика"),
    JAN_MARE("Жан Маре"),
    HAMLET("Гамлєт, або Феномен датського кацапізма."),
    TSIKAVI_DOSLIDY("Цікаві досліди"),
    HEROJ_NASHOGO_CHASU("Герой нашого часу");

    Book(String bookName) {
        this.bookName = bookName;
    }

    public String bookName;
}
