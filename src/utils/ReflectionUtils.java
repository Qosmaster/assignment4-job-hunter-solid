package utils;

import java.lang.reflect.Field;

public class ReflectionUtils {
    public static void inspectClass(Object obj) {
        Class<?> clazz = obj.getClass();
        System.out.println("--- REFLECTION ---");
        System.out.println("Class: " + clazz.getSimpleName());
        System.out.println("Fields:");
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println("- " + field.getName());
        }
        System.out.println("------------------");
    }
}