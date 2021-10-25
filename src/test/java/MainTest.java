
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {

    @Test
    void main() {
        ArrayList<String> text = new ArrayList<>();
        text.add("hi");
        text.add("hello");
        ArrayList<String> text2 = new ArrayList<>();
        text2.add("hi");
        text2.add("hello");
        Assert.assertEquals(text.get(0), text2.get(0));
    }

    @Test
    public void getIndexOutOfBoundCheck() {
        Exception exception = assertThrows(RuntimeException.class, () -> {
            ArrayList<String> text = new ArrayList<>();
            text.add("hi");
            text.add("hello");
            text.get(17);
        });
        String expected = "out of bounds";
        String actual = exception.getMessage();
        assertTrue(actual.contains(expected));
    }

    @Test
    public void quickSortInt() {
            ArrayList<Integer> numbers = new ArrayList<>();
            numbers.add(2);
            numbers.add(4);
            numbers.add(1);
            numbers.add(2);
            numbers.add(6);
            numbers.add(35);
            numbers.add(5);
            QuickSort<Integer> quickSort = new QuickSort<>();
            quickSort.sort(numbers, 0, numbers.size()-1);
            for (int i = 0; i < numbers.size(); i++)
                System.out.print(numbers.get(i) + " ");
        }



    @Test
    public void setIndexOutOfBoundsCheck() {
        Exception exception2 = assertThrows(RuntimeException.class, () -> {
            ArrayList<String> text3 = new ArrayList<>();
            text3.add("a");
            text3.add("ab");
            text3.add("abc");
            text3.add("abcd");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.add("ab");
            text3.set(64, "what");
        });
        String expected2 = "out of bounds";
        String actual2 = exception2.getMessage();

        assertTrue(actual2.contains(expected2));
    }

}