package org.example;

import java.util.Objects;

/**
 * Контейнер на основе связанного списка.
 * Позволяет хранить произвольное количество объектов.
 *
 * @param <T> тип элементов в контейнере
 * @author ilabe
 * @version 1.0
 */

public class List<T>
{
    /**
     * Внутренний класс узла связного списка.
     *
     * @param <T> тип данных узла
     */
    private static class Node<T>
    {
        T data;
        Node<T> next;

        Node(T data)
        {
            this.data = data;
            this.next = null;
        }
    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    /**
     * Создаёт пустой контейнер.
     */
    public List()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Добавляет элемент в конец контейнера.
     * Работает за O(1)
     *
     * @param element элемент для добавления
     */
    public void add(T element)
    {
        Node<T> newNode = new Node<>(element);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            tail.next = newNode;
            tail = newNode;
        }
        ++size;
    }

    /**
     * Добавляет элемент в начало контейнера.
     * Работает за O(1)
     *
     * @param element элемент для добавления
     */
    public void addFirst(T element)
    {
        Node<T> newNode = new Node<>(element);

        if (head == null)
        {
            head = newNode;
            tail = newNode;
        }
        else
        {
            newNode.next = head;
            head = newNode;
        }
        ++size;
    }

    /**
     * Возвращает элемент контейнера по указанному индексу.
     * Работает за O(n)
     *
     * @param index индекс элемента в диапазоне [0, size - 1]
     * @return элемент по указанному индексу
     * @throws IndexOutOfBoundsException индекс некорректен
     */
    public T get(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Node<T> current = head;
        for (int i=0; i<index; ++i)
            current = current.next;

        return current.data;
    }

    /**
     * Возвращает последний элемент контейнера.
     * Работает за O(1)
     *
     * @return последний элемент контейнера
     * @throws IllegalStateException контейнер пуст
     */
    public T getLast()
    {
        if (tail == null)
            throw new IllegalStateException("List is empty");

        return tail.data;
    }

    /**
     * Удаляет элемент по указанному индексу.
     * Работает за O(n)
     *
     * @param index индекс элемента в диапазоне [0, size - 1]
     * @throws IndexOutOfBoundsException индекс некорректен
     */
    public void remove(int index)
    {
        if (index < 0 || index >= size)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (index == 0)
        {
            head = head.next;
            if (head == null)
                tail = null;
        }
        else
        {
            Node<T> previous = head;
            for (int i = 0; i<index - 1; ++i)
                previous = previous.next;

            if (previous.next == tail)
                tail = previous;

            previous.next = previous.next.next;
        }
        --size;
    }

    /**
     * Удаляет все элементы контейнера.
     * Работает за O(1)
     */
    public void clear()
    {
        head = null;
        tail = null;
        size = 0;
    }

    /**
     * Возвращает количество элементов в контейнере.
     *
     * @return количество элементов в контейнере
     */
    public int size()
    {
        return size;
    }

    /**
     * Проверяет, пуст ли контейнер.
     *
     * @return true если контейнер пуст, иначе false
     */
    public boolean isEmpty()
    {
        return size == 0;
    }

    /**
     * Проверяет содержится ли указанный элемент в контейнере
     * Работает за O(n)
     *
     * @param element искомый элемент
     * @return true если элемент найден, иначе false
     */
    public boolean contains(T element)
    {
        Node<T> current = head;

        while (current != null)
        {
            if (Objects.equals(current.data, element))
                return true;
            current = current.next;
        }

        return false;
    }

    /**
     * Возвращает индекс первого вхождения указанного элемента.
     * Работает за O(n)
     *
     * @param element искомый элемент
     * @return индекс элемента или -1 если элемент не найден
     */
    public int indexOf(T element)
    {
        Node<T> current = head;
        int index = 0;

        while (current != null)
        {
            if (Objects.equals(current.data, element))
                return index;
            current = current.next;
            ++index;
        }
        return -1;
    }

    /**
     * Возвращает строковое представление контейнера.
     *
     * @return строковое представление в формате [element1, element2, ...]
     */
    @Override
    public String toString()
    {
        if (head == null)
            return "[]";

        String res = "[";
        Node<T> current = head;
        while (current != null)
        {
            res += current.data;
            if (current.next != null)
                res += ", ";
            current = current.next;
        }
        res += "]";
        return res;
    }
}
