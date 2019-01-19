package com.mihadev.poderevjanskyibot;

public enum Book {
    DANKO("Данко"),
    PACAVATA_ISTORIA ("Пацавата історія"),
    HVOROBA_IVASYKA("Хвороба Івасика"),
    JAN_MARE("Жан Маре"),
    HAMLET("Гамлєт, або Феномен датського кацапізма."),
    TSIKAVI_DOSLIDY("Цікаві досліди"),
    HEROJ_NASHOGO_CHASU_1("Герой нашого часу. Повість перша."),
    HEROJ_NASHOGO_CHASU_2("Герой нашого часу. Повість друга."),
    DIANA("Діана"),
    JOGI("Йоги");

    Book(String bookName) {
        this.bookName = bookName;
    }

    public String bookName;
}
