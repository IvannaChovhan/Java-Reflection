package hw;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Main {
    public static void main(String[] args) {
        // Отримуємо ім'я класу
        Class reflected = Notebook.class;
        System.out.println("Reflected class name: " + reflected.getSimpleName());
        // Отримуємо ім'я пакету
        Package pack = reflected.getPackage();
        String packageName = pack.getName();
        System.out.println("Package: " + packageName);

        // Отримуємо суперклас
        Class reflectedSuperclass = reflected.getSuperclass();
        System.out.println("\nSubclass superclass: " + reflectedSuperclass.getName());


        // Отримуємо інтерфейси базового класу
        Class [] interfaces = reflectedSuperclass.getInterfaces();
        System.out.println("\nBaseClass interfaces:");
        for(Class interface_: interfaces){
            System.out.println(interface_.getName());
        }

        // Ініціалізуємо і викликаємо конструктор
        Constructor baseConstructor = null;
        try {
            baseConstructor = reflectedSuperclass.getConstructor(ComputerBrand.class);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        Computer baseClassObject = null;
        try {
            assert baseConstructor != null;
            baseClassObject = (Computer) baseConstructor.newInstance(ComputerBrand.LENOVO);
        } catch (InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }


        // Працюємо з усіма методами і анотацією
        Method[] methods = reflectedSuperclass.getDeclaredMethods();
        for(Method method: methods){
            Annotation annotation = method.getAnnotation(CustomNotation.class);
            if (annotation != null && annotation.annotationType() == CustomNotation.class){
                try {
                    method.invoke(baseClassObject, null);
                } catch (IllegalAccessException | InvocationTargetException e) {
                    e.printStackTrace();
                }
            }
        }

        //проксування
        Computer comp = new Computer();
        MemoryInterface proxy = (MemoryInterface) SomeProxy.newProxyInstance(comp);
        System.out.println("Get memory result: " + proxy.getMemory());
        //proxy.setMemory(5);

        //System.out.println(new Computer());
    }
}
