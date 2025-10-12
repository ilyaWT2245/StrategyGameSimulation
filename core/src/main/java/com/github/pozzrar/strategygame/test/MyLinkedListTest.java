package com.github.pozzrar.strategygame.test;

import com.github.pozzrar.strategygame.structures.MyLinkedList;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Iterator;

class MyLinkedListTest {

    private MyLinkedList<Integer> list;
    private MyLinkedList<String> stringList;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList<>();
        stringList = new MyLinkedList<>();
    }

    // Тестирование конструктора копирования из другой коллекции
    @Test
    void testConstructorWithCollection() {
        MyLinkedList<Integer> sourceList = new MyLinkedList<>();
        sourceList.add(1);
        sourceList.add(2);
        sourceList.add(3);

        MyLinkedList<Integer> newList = new MyLinkedList<>(sourceList);
        assertEquals(3, newList.size());
        assertEquals(1, newList.get(0));
        assertEquals(2, newList.get(1));
        assertEquals(3, newList.get(2));
    }

    // Тестирование добавления в начало и получения первого/последнего элемента
    @Test
    void testAddFirstAndGetFirstLast() {
        list.addFirst(10);
        assertEquals(10, list.getFirst());
        assertEquals(10, list.getLast());

        list.addFirst(5);
        assertEquals(5, list.getFirst());
        assertEquals(10, list.getLast());

        list.add(20);
        assertEquals(5, list.getFirst());
        assertEquals(20, list.getLast());
    }

    // Тестирование оптимизации поиска элементов с двух сторон списка
    @Test
    void testGetNodeOptimization() {
        for (int i = 0; i < 10; i++) {
            list.add(i);
        }

        // Первые элементы ищем с начала
        assertEquals(0, list.get(0));
        assertEquals(1, list.get(1));
        assertEquals(4, list.get(4));

        // Последние элементы ищем с конца
        assertEquals(9, list.get(9));
        assertEquals(8, list.get(8));
        assertEquals(5, list.get(5));
    }

    // Тестирование поиска элементов включая null значения
    @Test
    void testContainsWithNull() {
        MyLinkedList<String> listWithNull = new MyLinkedList<>();
        listWithNull.add("a");
        listWithNull.add(null);
        listWithNull.add("c");

        assertTrue(listWithNull.contains(null));
        assertTrue(listWithNull.contains("a"));
        assertTrue(listWithNull.contains("c"));
        assertFalse(listWithNull.contains("nonexistent"));
    }

    // Тестирование удаления элементов из разных позиций списка
    @Test
    void testRemoveFromDifferentPositions() {
        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        // Удаление из середины
        assertTrue(list.remove(20));
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
        assertEquals(40, list.get(2));

        // Удаление первого элемента
        assertTrue(list.remove(10));
        assertEquals(2, list.size());
        assertEquals(30, list.getFirst());

        // Удаление последнего элемента
        assertTrue(list.remove(40));
        assertEquals(1, list.size());
        assertEquals(30, list.getFirst());
    }

    // Тестирование последовательного извлечения элементов из начала списка
    @Test
    void testPopMultipleElements() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(10, list.pop());
        assertEquals(2, list.size());
        assertEquals(20, list.getFirst());

        assertEquals(20, list.pop());
        assertEquals(1, list.size());
        assertEquals(30, list.getFirst());

        assertEquals(30, list.pop());
        assertEquals(0, list.size());
        assertNull(list.getFirst());
        assertNull(list.getLast());
    }

    // Тестирование извлечения из списка с одним элементом и пустого списка
    @Test
    void testPopFromSingleElementList() {
        list.add(10);

        assertEquals(10, list.pop());
        assertEquals(0, list.size());
        assertNull(list.getFirst());
        assertNull(list.getLast());

        // Попытка pop из пустого списка
        assertNull(list.pop());
    }

    // Тестирование итератора со списком содержащим null значения
    @Test
    void testIteratorWithNullValues() {
        MyLinkedList<String> listWithNull = new MyLinkedList<>();
        listWithNull.add("a");
        listWithNull.add(null);
        listWithNull.add("c");

        Iterator<String> iterator = listWithNull.iterator();
        assertEquals("a", iterator.next());
        assertNull(iterator.next());
        assertEquals("c", iterator.next());
        assertFalse(iterator.hasNext());
    }

    // Тестирование преобразования списка в массив точного размера
    @Test
    void testToArrayWithExactSize() {
        list.add(10);
        list.add(20);
        list.add(30);

        Integer[] array = new Integer[3];
        Integer[] result = list.toArray(array);

        assertArrayEquals(new Integer[]{10, 20, 30}, result);
        assertSame(array, result);
    }

    // Тестирование добавления всех элементов из непустой коллекции
    @Test
    void testAddAllWithNonEmptyCollection() {
        MyLinkedList<Integer> sourceList = new MyLinkedList<>();
        sourceList.add(1);
        sourceList.add(2);
        sourceList.add(3);

        assertTrue(list.addAll(sourceList));
        assertEquals(3, list.size());
        assertEquals(1, list.get(0));
        assertEquals(2, list.get(1));
        assertEquals(3, list.get(2));
    }

    // Комплексное тестирование смешанных операций над списком
    @Test
    void testComplexMixedOperations() {
        list.addFirst(20);    // [20]
        list.add(30);         // [20, 30]
        list.addFirst(10);    // [10, 20, 30]
        list.add(40);         // [10, 20, 30, 40]

        assertEquals(4, list.size());
        assertEquals(10, list.getFirst());
        assertEquals(40, list.getLast());

        // Удаление из середины
        assertTrue(list.remove(20)); // [10, 30, 40]
        assertEquals(3, list.size());
        assertEquals(10, list.get(0));
        assertEquals(30, list.get(1));
        assertEquals(40, list.get(2));

        // Pop первого элемента
        assertEquals(10, list.pop()); // [30, 40]
        assertEquals(2, list.size());
        assertEquals(30, list.getFirst());
        assertEquals(40, list.getLast());

        // Добавление в начало после pop
        list.addFirst(25); // [25, 30, 40]
        assertEquals(25, list.getFirst());
        assertEquals(40, list.getLast());

        // Очистка и проверка
        list.clear();
        assertEquals(0, list.size());
        assertTrue(list.isEmpty());
    }

    // Тестирование получения элементов из пустого списка
    @Test
    void testGetFromEmptyList() {
        assertNull(list.get(0));
        assertNull(list.get(-1));
        assertNull(list.get(5));
    }

    // Тестирование удаления несуществующего элемента
    @Test
    void testRemoveNonExistentElement() {
        list.add(10);
        list.add(20);

        assertFalse(list.remove(30));
        assertEquals(2, list.size());
        assertTrue(list.contains(10));
        assertTrue(list.contains(20));
    }

    // Тестирование итератора на пустом списке
    @Test
    void testIteratorOnEmptyList() {
        Iterator<Integer> iterator = list.iterator();
        assertFalse(iterator.hasNext());
    }

    // Тестирование множественных операций добавления в начало списка
    @Test
    void testMultipleAddFirstOperations() {
        list.addFirst(30);
        list.addFirst(20);
        list.addFirst(10);

        assertEquals(3, list.size());
        assertEquals(10, list.getFirst());
        assertEquals(30, list.getLast());
        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }
}
