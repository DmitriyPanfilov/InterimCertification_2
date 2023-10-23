package Task1;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        ToyStore store = new ToyStore();

        // добавление игрушек
        store.addToy(1, "Task1.Toy 1", 10, 20);
        store.addToy(2, "Task1.Toy 2", 5, 10);
        store.addToy(3, "Task1.Toy 3", 20, 70);

        // устанавливаем вес игрушки
        store.setToyWeight(2, 30);

        // запуск розыгрыша
        store.play();

        // получение призовой игрушку
        try {
            store.getPrizeToy();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}