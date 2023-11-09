package ru.clevertec.proxytask.util;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

public class CheckAnnotation {
    public static List<Method> getAnnotatedMethod(Object object, Class annotationClass) {
        Method[] methods = object.getClass().getDeclaredMethods();
        return Arrays.stream(methods).filter(it -> it.getAnnotation(annotationClass) != null).toList();
    }
}
