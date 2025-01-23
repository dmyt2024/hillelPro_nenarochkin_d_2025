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
            try {
                throw new TypeFruitException("Not a Fruit class");
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else
            fruits.add(item);
    }

    public void addFruits(T[] items) {
        for (T fruit : items) {
            if (!this.type.equals(fruit.getClass())) {
                try {
                    throw new TypeFruitException("Not a Fruit class");

                } catch (Exception e) {
                    System.out.println(e.getMessage());

                }
                break;

            } else fruits.add(fruit);


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
        if (this.type.equals(otherBox.type)) {
            this.fruits.addAll(otherBox.fruits);
            otherBox.fruits.clear();

        } else
            try {
                throw new TypeFruitException("Not a Fruit class");
            } catch (Exception e) {
                System.out.println(e.getMessage());

            }

    }

    public boolean compareWeight(Box<?> otherBox) {
        return Float.compare(this.getWeight(), otherBox.getWeight()) == 0;
    }


}


