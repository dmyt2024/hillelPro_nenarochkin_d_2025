package org.lesson_21_Annotation;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {



        ArrayUtils arrayUtils = new ArrayUtils();

        int[] masiv = {2, 5, 7, 3, 12, 25};
        int target = 12;

        Class<?> aClass = Class.forName("org.lesson_21_Annotation.ArrayUtils");

        System.out.println(aClass);
        System.out.println(aClass.getName());
        System.out.println();


//      МЕТОДИ І АННОТАЦІЇ

        Method[] methods = aClass.getDeclaredMethods();
        Arrays.stream(methods)
                .forEach(method -> {System.out.println("Method: " + method);
                    Arrays.stream(method.getDeclaredAnnotations())
                            .forEach(annotation -> System.out.printf("Author: %s\n", annotation));
                    System.out.println();
                });

        //      ВИКЛИК МЕТОДІВ ЧЕРЕЗ ЕКЗЕМПЛЯР КЛАСУ

        int i = arrayUtils.sumArray(masiv);
        System.out.println("Sum array: " + i);

        int index = arrayUtils.findTarget(masiv, target);
        System.out.println("Target index: " + index);

        System.out.println();


//      ВИКЛИК МЕТОДІВ ЧЕРЕЗ РЕФЛЕКСІЮ

        Method methodSum = ArrayUtils.class.getMethod("sumArray", int[].class);
        Object invoke1 = methodSum.invoke(arrayUtils, (Object) masiv);
        System.out.println("Sum array: " + invoke1);


        Method methodFindTarget = ArrayUtils.class.getMethod("findTarget", int[].class, int.class);
        Object invoke2 = methodFindTarget.invoke(arrayUtils, masiv, target);
        System.out.println("Target index: " + invoke2);

        System.out.println();

//      ВИКЛИК ПАРАМЕТРІВ АННОТАЦІЇ

        for (Method method:methods){
            if (method.isAnnotationPresent(Author.class)){
                Author author = method.getAnnotation(Author.class);
                System.out.printf("Method: %s\n",method.getName());
                System.out.printf("   Author: %s %s\n ",author.firstName(), author.lastName());
            }
        }
    }
}
