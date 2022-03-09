import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QueueTest {
    Queue underflowQueue;
    Queue overflowQueue;

    @BeforeEach
    void setUp() {
        underflowQueue = new Queue();
        overflowQueue = new Queue();
        try {
            overflowQueue.push("Naufal");
            overflowQueue.push("Okta");
            overflowQueue.push("Rabil");
            overflowQueue.push("Ziad");
            overflowQueue.push("Wawan");
        } catch (Exception ignored) {

        }
    }

    @Test
    @DisplayName("Should return Exception with message \"Queue Overflow\" When push new element")
    void testPushQueueOverflow() {
//        When & Then
        assertThrows(Exception.class, () -> overflowQueue.push("Naufal"), "Queue Overflow");
    }

    @Test
    @DisplayName("Should added new element in Queue")
    void testPushQueueValid() {
        try {
//            When
            underflowQueue.push("Naufal");
            underflowQueue.push("Reza");
            Object[] elementsAfterPush = {"Naufal", "Reza", null, null, null};

//            Then
            assertTrue(underflowQueue.contains("Naufal"));
            assertTrue(underflowQueue.contains("Reza"));

            assertFalse(underflowQueue.isEmpty());
            assertArrayEquals(elementsAfterPush, underflowQueue.getElements());

            assertEquals(2, underflowQueue.size());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @DisplayName("Should added new element when queue have condition was deleted element")
    void testPushQueueValidAfterDeletedElement(){
        try {
//            Given
            Queue queue = new Queue();
            queue.push("Naufal");
            queue.push("Rara");
            queue.push("Safira");
            queue.push("Alya");

            Object[] expectedValue = {"Eka", null, "Safira", "Alya", "Nugraha"};

//            When
            queue.pop();
            queue.pop();
            queue.push("Nugraha");
            queue.push("Eka");

//            Then
            assertArrayEquals(expectedValue, queue.getElements());
        } catch (Exception e){
            fail();
        }
    }


    @Test
    @DisplayName("Should return Exception with message \"Queue Underflow\" When pop element")
    void testPopQueueUnderflow() {
//        When & Then
        assertThrows(Exception.class, () -> underflowQueue.pop(), "Queue Underflow");
    }

    @Test
    @DisplayName("Should deleted last element when Queue call function pop")
    void testPopQueueValid() {
        try {
//            Given
            Object[] afterPop = {null, "Okta", "Rabil", "Ziad", "Wawan"};
            int size = overflowQueue.size();

//            When
            overflowQueue.pop();

//            Then
            assertArrayEquals(afterPop, overflowQueue.getElements());
            assertEquals(size - 1, overflowQueue.size());
        } catch (Exception e) {
            fail();
        }
    }
}