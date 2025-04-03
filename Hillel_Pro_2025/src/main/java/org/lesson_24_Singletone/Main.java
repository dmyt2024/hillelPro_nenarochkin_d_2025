package org.lesson_24_Singletone;

public class Main {
    public static void main(String[] args) {

        // Перевірка, що у нас єдиний єкземпляр:

        System.out.println(Logger.getInstance().toString()); // Єдиний Хеш код незалежно
        System.out.println(Logger.getInstance().toString()); //скількі раз робимо єкземрлярів
        System.out.println(Logger.getInstance().toString());
        System.out.println(Logger.getInstance().toString());
        System.out.println();

        Logger.getInstance().logInfo();

        // Записуємо в private static String logFile = "This is a log file\n"; додадково текст:

        Logger.getInstance().addMsg("First");
        Logger.getInstance().addMsg("Second");
        Logger.getInstance().logInfo();
    }
}
