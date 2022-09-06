package ru.axel.eventer;

/** Ошибка отсутствия события */
public class EventNotExistsException extends Exception {
    public EventNotExistsException() {
        super("Слушатель на событие не был добавлен!");
    }
    public EventNotExistsException(String msg) {
        super(msg);
    }
}
