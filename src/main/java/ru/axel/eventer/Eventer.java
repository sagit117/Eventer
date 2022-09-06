package ru.axel.eventer;

import java.util.HashMap;
import java.util.Map;

/**
 * Класс регистратор и генератор событий
 */
public class Eventer {
    private final HashMap<String, HashMap<Integer, EventHandler>> events = new HashMap<>();

    /**
     * Добавить слушатель событий
     * @param eventName имя события
     * @param eventHandler лямбда обработчик события
     */
    public void addEventListener(String eventName, EventHandler eventHandler) {
        var item = this.events.get(eventName);
        if (item == null) {
            HashMap<Integer, EventHandler> hashMap = new HashMap<>();
            hashMap.put(eventHandler.hashCode(), eventHandler);

            this.events.put(eventName, hashMap);
        } else {
            item.put(eventHandler.hashCode(), eventHandler);
        }
    }

    /**
     * Запуск обработчиков событий
     * @param eventName имя события
     * @param params входящие параметры
     * @throws EventNotExistsException если событие не было зарегистрировано
     */
    public void emit(String eventName, Object... params) throws EventNotExistsException {
        var item = this.events.get(eventName);
        if (item == null) throw new EventNotExistsException();

        for(Map.Entry<Integer, EventHandler> event : item.entrySet()) {
            event.getValue().invoke(params);
        }
    }
}
