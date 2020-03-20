package eg.edu.alexu.csd.datastructure.linkedList.cs;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class SingleLinkedListTest
{
    SingleLinkedList test = new SingleLinkedList();
    @BeforeEach
    public void addition(){
        test.add(5);
        test.add(20);
        test.add(30);
        test.add(70);
        test.add(8);
    }
    @Test
    void addTest1(){
        assertEquals(5,test.get(0));
        assertEquals(20,test.get(1));
        assertEquals(30,test.get(2));
        assertEquals(70,test.get(3));
        assertEquals(8,test.get(4));
        assertThrows(RuntimeException.class,()->{test.get(9);});
        assertThrows(RuntimeException.class,()->{test.get(-3);});

    }

    @Test
    void addTest2(){
        test.add(2,9);
        assertEquals(9,test.get(2));
        assertEquals(30,test.get(3));
    }

    @Test
    void setTest(){
        test.set(4,18);
        assertEquals(18,test.get(4));
        assertThrows(RuntimeException.class,()->{test.set(8,5);});
        assertThrows(RuntimeException.class,()->{test.set(-2,3);});

    }

    @Test
    void sublistTest(){
        assertEquals(20,test.sublist(1,3).get(0));
        assertEquals(30,test.sublist(1,3).get(1));
        assertEquals(70,test.sublist(1,3).get(2));
        assertEquals(3,test.sublist(1,3).size());
        assertThrows(RuntimeException.class,()->{test.sublist(9,12);});
        assertThrows(RuntimeException.class,()->{test.sublist(3,0);});
        assertThrows(RuntimeException.class,()->{test.sublist(-2,3);});

    }

    @Test
    void RemoveTest(){
        assertEquals(5,test.size());
        test.remove(2);
        assertEquals(4,test.size());
        assertEquals(70,test.get(2));
        assertThrows(RuntimeException.class,()->{test.remove(5);});

    }

    @Test
    void containsTest(){
        assertTrue(test.contains(8));
        assertFalse(test.contains(0));
    }

    @Test
    void isEmptyTest(){
        test.clear();
        assertTrue(test.isEmpty());

    }
}