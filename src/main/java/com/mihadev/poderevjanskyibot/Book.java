package com.mihadev.poderevjanskyibot;

public enum Book {
    DANKO("Данко"),
    PACAVATA_ISTORIA ("Пацавата історія"),
    HVOROBA_IVASYKA("Хвороба Івасика"),
    JAN_MARE("Жан Маре"),
    HAMLET("Гамлєт, або Феномен датського кацапізма"),
    TSIKAVI_DOSLIDY("Цікаві досліди"),
    HEROJ_NASHOGO_CHASU_1("Герой нашого часу. Повість перша"),
    HEROJ_NASHOGO_CHASU_2("Герой нашого часу. Повість друга"),
    DIANA("Діана"),
    JOGI("Йоги"),
    KACAPY("Кацапи. Присвячується національному питанню"),
    KOROL_LITR("Король Літр. Трагедія"),
    DO_HUYA_MASLA("До хуя масла"),
    OSTANOVIS_MGNOVENJE_TY_PREKRASNO("Остановісь, мгновєньє – ти прєкрасно!"),
    MISCE_VSTRECHI("Місце встрєчі ізмєніть ніззя, блядь!"),
    MNOJENNJA_V_UMI("Множення в умі, або Плинність часу"),
    NIRVANA("Нірвана"),
    PIZDEC("Піздєц"),
    REPKA("Казка про рєпку, або Хулі не ясно?");

    Book(String bookName) {
        this.bookName = bookName;
    }

    public String bookName;
}
