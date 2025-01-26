package Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> fruits = new ArrayList<>();


    public void addFruit(T item) {
        fruits.add(item);
    }

    public void addFruits(T[] items) {
        for (T fruit : items) {
            addFruit(fruit);

        }

    }

    public float getWeight() {
        float weight = 0F;
        for (T item : fruits) {
            weight += item.getWeight();
        }
        return weight;
    }

    public void fillOneBoxToOther(Box<T> otherBox) {

        this.fruits.addAll(otherBox.fruits);
        otherBox.fruits.clear();
    }

    public boolean compareWeight(Box<? extends Fruit> otherBox) {
        return Float.compare(this.getWeight(), otherBox.getWeight()) == 0;
    }
}
