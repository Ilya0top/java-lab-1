package org.example;

/**
 * Демонстрационный класс для тестирования функциональности кастомного контейнера List.
 * Показывает работу всех основных и дополнительных методов контейнера
 * на практических примерах с различными типами данных.
 *
 * @author ilabe
 * @version 1.0
 */
public class Main
{

    /**
     * Основной метод демонстрации работы кастомного контейнера List.
     * Последовательно демонстрирует все возможности контейнера:
     * - Создание и базовые операции
     * - Добавление элементов в начало и конец
     * - Доступ к элементам по индексу
     * - Поиск элементов в контейнере
     * - Удаление элементов
     * - Работу с generics и разными типами данных
     * - Очистку контейнера
     *
     * @param args аргументы командной строки (не используются)
     */
    public static void main(String[] args)
    {
        System.out.println("=== Демонстрация кастомного контейнера List ===");


        List<String> list = new List<>();
        System.out.println("\n1. Создание пустого списка:");
        System.out.println("Размер: " + list.size());
        System.out.println("Пустой: " + list.isEmpty());


        System.out.println("\n2. Добавление элементов:");
        list.add("Первый");
        list.add("Второй");
        list.add("Третий");
        list.addFirst("Нулевой"); // Демонстрация addFirst

        System.out.println("Список: " + list);
        System.out.println("Размер: " + list.size());
        System.out.println("Последний элемент: " + list.getLast());


        System.out.println("\n3. Доступ по индексу:");
        for (int i = 0; i < list.size(); i++)
            System.out.println("list.get(" + i + ") = " + list.get(i));


        System.out.println("\n4. Поиск элементов:");
        System.out.println("Содержит 'Второй': " + list.contains("Второй"));
        System.out.println("Индекс 'Третий': " + list.indexOf("Третий"));
        System.out.println("Содержит 'Несуществующий': " + list.contains("Несуществующий"));


        System.out.println("\n5. Удаление элементов:");
        list.remove(1); // Удаляем "Первый"
        System.out.println("После удаления индекса 1: " + list);


        System.out.println("\n6. Работа с числами:");
        List<Integer> numbers = new List<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        System.out.println("Числовой список: " + numbers);


        System.out.println("\n7. Очистка списка:");
        list.clear();
        System.out.println("После clear(): " + list);
        System.out.println("Пустой: " + list.isEmpty());

        System.out.println("\n===================");
    }
}