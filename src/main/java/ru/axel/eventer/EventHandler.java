package ru.axel.eventer;

/** Интерфейс для лямбды обработчика события */
public interface EventHandler {
    /**
     * Исполнение лямбды
     * @param obj входящие параметры
     */
    void invoke(Object... obj);
}

