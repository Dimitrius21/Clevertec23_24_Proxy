package ru.clevertec.proxytask;

import ru.clevertec.proxytask.annotation.Log;
import ru.clevertec.proxytask.util.CheckAnnotation;
import ru.clevertec.proxytask.util.LogHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        MathInteger testClass = new MathIntTestClass();
        List<Method> annotatedMethod = CheckAnnotation.getAnnotatedMethod(testClass, Log.class);
        InvocationHandler handler = new LogHandler(testClass, annotatedMethod);
        MathInteger proxy = (MathInteger) Proxy.newProxyInstance(testClass.getClass().getClassLoader(),
                new Class[]{MathInteger.class},
                handler);

        int max = proxy.max(9, 15);
        int min = proxy.min(9, 15);
        int[] ar = {8, 5, 3, 11};
        int sum = proxy.sum(ar);
    }
}

