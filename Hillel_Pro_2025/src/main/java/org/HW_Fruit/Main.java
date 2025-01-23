package org.HW_Fruit;

public class Main {
    public static void main(String[] args) {
        Box<Apple> appleBox1 = new Box<>(Apple.class);
        appleBox1.addFruit(new Apple());
        System.out.println(appleBox1.getWeight());

        Box<Apple> appleBox2 = new Box<>(Apple.class);
        appleBox2.addFruit(new Apple());
        System.out.println(appleBox2.getWeight());

        appleBox1.fillOneBoxToOther(appleBox2);
        System.out.println(appleBox1.getWeight());


        Apple[] apples = {new Apple(), new Apple(), new Apple(), new Apple()};
        appleBox1.addFruits(apples);
        System.out.println(appleBox1.getWeight());

        Box<Orange> orangeBox1 = new Box<>(Orange.class);
        Box<Orange> orangeBox2 = new Box<>(Orange.class);
        orangeBox1.addFruit(new Orange());
        orangeBox1.addFruit(new Orange());
        System.out.println(orangeBox1.getWeight());

        Orange[] oranges = {new Orange(), new Orange()};
        orangeBox2.addFruits(oranges);
        System.out.println(orangeBox2.getWeight());

        orangeBox1.fillOneBoxToOther(orangeBox2);
        System.out.println(orangeBox1.getWeight());

        Box box = new Box<>(Apple.class);

        box.addFruit(new Orange());
        System.out.println(box.getWeight());

        box.addFruits(oranges);
        System.out.println(box.getWeight());

        box.addFruit(new Orange());
        System.out.println(box.getWeight());


        box.fillOneBoxToOther(orangeBox1);
        System.out.println(box.getWeight());


        System.out.println(appleBox1.compareWeight(orangeBox1));
    }


}
