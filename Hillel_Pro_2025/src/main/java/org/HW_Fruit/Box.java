package org.HW_Fruit;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private List<T> fruits = new ArrayList<>();
    private Class<T> type;


    public Box(Class<T> type) {
        this.type = type;
    }

    public void addFruit(T item) {
        if (!this.type.equals(item.getClass())) {
            throw new IllegalArgumentException("Not a Fruit class");
        }
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
    }

    public boolean compareWeight(Box<?> otherBox) {
        return Float.compare(this.getWeight(), otherBox.getWeight()) == 0;

    }

}


