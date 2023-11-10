package ru.clevertec.proxytask.util;

import ru.clevertec.proxytask.exception.UnsupportedClass;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class CheckAnnotation {
    public static List<Method> getAnnotatedMethod(Class clazz, Class annotationClass) {
        if (clazz.isPrimitive()) {
            throw new UnsupportedClass("Primitive can't be processed");
        }
        Method[] methods = clazz.getDeclaredMethods();
        List<Method> annotatedMethods = Arrays.stream(methods).filter(it -> it.getAnnotation(annotationClass) != null).toList();
        Class parent = clazz.getSuperclass();
        if (parent!= Object.class) {
            annotatedMethods.addAll(getAnnotatedMethod(parent, annotationClass));
        }
        return annotatedMethods;
    }
}
