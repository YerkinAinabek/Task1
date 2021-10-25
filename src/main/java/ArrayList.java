/**
 * Данный класс представляет собой минимальную реализацию коллекции ArrayList, и содержит в себе
 * реализацию операций чтения/записи/удаления/изменения объектов из списка
 *
 *
 *
 *
 */

public class ArrayList  <T extends Comparable<T>> {
    private final int startSize = 16;           // Начальный размер массива, являющегося основой ArrayList'а
    private final int cutSize = 4;              // Коэффициент урезания массива
    private Object[] array = new Object[startSize]; //Объявление внутреннего массива
    private int pointer = 0;            // Объявление указателя индекса

    /**
     * Метод add добавляет в конец существующего списка элемент element
     * @param element это элемент типа Т, который мы хотим "положить" в наш ArrayList
     */
    public void add(T element) {
        if (pointer == array.length - 1)        // Если элемент не помещается во внутреннем массива,
            resize(array.length * 2);   // метод resize (см. внизу) увеличивает размер массива вдвое
        array[pointer++] = element;         // Добавленный элемент в новом массиве сдвигается вправо (во вторую половину)
    }

    /**
     * Метод set заменяет элемент списка по индексу указанным значением, если заменяемый элемент существует
     * @param index это индекс элемента в списке
     * @param element это новое значение элемента
     * @return Value возвращает новое значение элемента списка
     */
    public T set(int index, T element) {
        if (index > array.length - 1)   // Если индекс заменяемого элемента не в диапазоне размера массива,
            System.out.println("Out of bounds"); // метод возвращает "Out of bounds"

        T Value = (T) array[index]; // Указывается тип заменяющего элемента, приведение к типу значений списка
        array[index] = element; // Присваиваем элементу массива значение заменяющего элемента
        return Value; // Возвращает новое значение элемента списка
    }

    /**
     * Метод resize создает новый массив, копируя в него элементы внутреннего массива и используется при расширении списка
     * @param newLength это размер нового массива
     */
    private void resize(int newLength) {
        Object[] newArray = new Object[newLength]; // Создаём новый массив для расширения
        System.arraycopy(array, 0, newArray, 0, pointer); // Копируем в него начальный массив
        array = newArray; // Изменяем указатель на массив
    }

    /**
     * Метод get возвращает элемент списка
     * @param index это индекс возвращаемого элемента
     * @return возвращает элемент массива, с приведением к типу данных списка
     */
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * Метод size возвращает текущий размер списка
     * @return возвращает pointer переменную, отслеживающую количество занятых индексов
     */

    public int size() {
        return pointer;
    }

    /**
     * Метод remove удаляет элемент списка по индексу index
     * @param index это индекс элемента списка, который будет удален
     */
        public void remove(int index) {
        for (int i = index; i < pointer; i++)
            array[i] = array[i + 1]; // Элементы справа от удаленного встают на 1 индекс влево
        array[pointer] = null; // Освобожденный элемент в конце списка становится null
        pointer--; // Список сокращается на 1 элемент
        if (array.length > startSize && pointer < array.length / cutSize) // Если длина внутреннего массива больше начальной и текущий размер меньше отношения array.length к коэффиценту урезания списка,
            resize(array.length / 2); // список уменьшается
    }



}






