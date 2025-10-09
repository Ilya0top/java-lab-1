package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Набор unit-тестов для проверки функциональности кастомного контейнера List.
 * Тестирует основные операции, граничные случаи и обработку исключений.
 *
 * @author ilabe
 * @version 1.0
 */
public class Test_ {

    @Test
    void testEmptyList()
    {
        List<Integer> list = new List<>();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testAddAndGet()
    {
        List<String> list = new List<>();
        list.add("first");
        list.add("second");

        assertEquals("first", list.get(0));
        assertEquals("second", list.get(1));
        assertEquals(2, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    void testAddFirst()
    {
        List<Integer> list = new List<>();
        list.add(1);
        list.addFirst(0);

        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void testContains()
    {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(2);

        assertTrue(list.contains(1));
        assertTrue(list.contains(2));
        assertFalse(list.contains(3));
    }

    @Test
    void testIndexOf()
    {
        List<Integer> list = new List<>();
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(0, list.indexOf(10));
        assertEquals(1, list.indexOf(20));
        assertEquals(2, list.indexOf(30));
        assertEquals(-1, list.indexOf(99));
    }

    @Test
    void testRemove()
    {
        List<String> list = new List<>();
        list.add("a");
        list.add("b");
        list.add("c");

        list.remove(1);
        assertEquals("a", list.get(0));
        assertEquals("c", list.get(1));
        assertEquals(2, list.size());
    }

    @Test
    void testClear() {
        List<Integer> list = new List<>();
        list.add(1);
        list.add(2);

        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    void testToString()
    {
        List<String> list = new List<>();
        list.add("a");
        list.add("b");

        assertEquals("[a, b]", list.toString());

        List<String> emptList = new List<>();
        assertEquals("[]", emptList.toString());
    }

    @Test
    void testGetLast()
    {
        List<String> list = new List<>();
        list.add("first");
        list.add("last");

        assertEquals("last", list.getLast());
    }

    /**
     * Тестирует обработку исключений при обращении к неверному индексу.
     * Проверяет что get() бросает IndexOutOfBoundsException для пустого списка.
     */
    @Test
    void testGetInvalidIndexThrowsException()
    {
        List<String> list = new List<>();
        assertThrows(IndexOutOfBoundsException.class, () -> {
            list.get(0);
        });
    }

    /**
     * Тестирует обработку исключений при получении последнего элемента пустого списка.
     * Проверяет что getLast() бросает IllegalStateException для пустого списка.
     */
    @Test
    void testGetLastEmptyListThrowsException()
    {
        List<String> list = new List<>();
        assertThrows(IllegalStateException.class, () -> {
            list.getLast();
        });
    }
}
