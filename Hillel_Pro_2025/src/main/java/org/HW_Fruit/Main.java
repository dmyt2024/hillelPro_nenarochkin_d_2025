package org.HW_Fruit;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>(Apple.class);
        appleBox1.addFruit(new Apple());
        System.out.println(appleBox1.getWeight());

        Box<Apple> appleBox2 = new Box<>(Apple.class);
        appleBox2.addFruit(new Apple());
        System.out.println(appleBox2.getWeight());

        Apple[] apples = {new Apple(), new Apple()};
        appleBox1.addFruits(apples);
        System.out.println(appleBox1.getWeight());

        Box<Orange> orangeBox = new Box<>(Orange.class);
        orangeBox.addFruit(new Orange());
        System.out.println(orangeBox.getWeight());

        Orange[] oranges = {new Orange(), new Orange(), new Orange()};

        appleBox1.fillOneBoxToOther(appleBox2);
        System.out.println(appleBox1.getWeight());

        Box box = new Box<>(Apple.class);
        try {
            box.addFruit(new Orange());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(box.getWeight());

        try {
            box.addFruits(oranges);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(box.getWeight());
        box.addFruit(new Apple());
        System.out.println(box.getWeight());


        box.fillOneBoxToOther(appleBox1);
        System.out.println(box.getWeight());

        System.out.println(appleBox1.compareWeight(orangeBox));
    }


}
