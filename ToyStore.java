package Task1;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ToyStore {
    private List<Toy> toys;
    private List<Toy> prizeToys;

    public ToyStore() {
        toys = new ArrayList<>();
        prizeToys = new ArrayList<>();
    }

    public void addToy(int id, String name, int quantity, double weight) {
        Toy toy = new Toy(id, name, quantity, weight);
        toys.add(toy);
    }

    public void setToyWeight(int id, double weight) {
        for (Toy toy : toys) {
            if (toy.getId() == id) {
                toy.setWeight(weight);
                break;
            }
        }
    }

    public void play() {
        // расчет веса
        double totalWeight = 0;
        for (Toy toy : toys) {
            totalWeight += toy.getWeight();
        }

        // генерация случайного числа
        Random rand = new Random();
        double randomNumber = rand.nextDouble() * totalWeight;

        // определение выигравшей игрушки
        Toy prizeToy = null;
        for (Toy toy : toys) {
            if (randomNumber < toy.getWeight()) {
                prizeToy = toy;
                break;
            }
            randomNumber -= toy.getWeight();
        }

        // добавлене призовой игрушки в список
        if (prizeToy != null && prizeToy.getQuantity() > 0) {
            prizeToys.add(prizeToy);


            prizeToy.setQuantity(prizeToy.getQuantity() - 1);
        }
    }

    public void getPrizeToy() throws IOException {
        if (prizeToys.size() > 0) {

            Toy prizeToy = prizeToys.remove(0);

            // запись призовой игрушки в файл
            FileWriter writer = new FileWriter("prize_toys.txt", true);
            writer.write(prizeToy.getId() + "," + prizeToy.getName() + "\n");
            writer.close();
        }
    }
}