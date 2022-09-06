# Eventer - Класс регистратор и генератор событий

```java
Eventer eventer = new Eventer();

EventHandler handler = (obj) -> {
    if (obj != null) {
        Arrays.stream(obj).forEach(o -> {
            System.out.println(o);
        });
    }
};

eventer.addEventListener("Exec", handler);

eventer.addEventListener("Exec", (obj) -> {
    System.out.println("handler");
});

eventer.addEventListener("Exec", handler);

eventer.emit("Exec", 123, "321");
```
