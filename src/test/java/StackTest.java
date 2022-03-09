import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StackTest {
    Stack underflowStack;
    Stack overflowStack;

    @BeforeEach
    void setUp() {
        underflowStack = new Stack();
        overflowStack = new Stack();
        try {
            overflowStack.push("Naufal");
            overflowStack.push("Okta");
            overflowStack.push("Rabil");
            overflowStack.push("Ziad");
            overflowStack.push("Wawan");
        } catch (Exception ignored) {

        }
    }

    @Test
    @DisplayName("Should return Exception with message \"Stack Overflow\" When push new element")
    void testPushStackOverflow() {
//        When & Then
        assertThrows(Exception.class, () -> overflowStack.push("Naufal"), "Stack Overflow");
    }

    @Test
    @DisplayName("Should added new element in stack")
    void testPushStackValid() {
        try {
//            When
            underflowStack.push("Naufal");
            underflowStack.push("Reza");
            Object[] elementsAfterPush = {"Naufal", "Reza", null, null, null};

//            Then
            assertTrue(underflowStack.contains("Naufal"));
            assertTrue(underflowStack.contains("Reza"));

            assertFalse(underflowStack.isEmpty());
            assertArrayEquals(elementsAfterPush, underflowStack.getElements());

            assertEquals(2, underflowStack.size());
        } catch (Exception e) {
            fail();
        }
    }

    @Test
    @DisplayName("Should return Exception with message \"Stack Underflow\" When pop element")
    void testPopStackUnderflow(){
//        When & Then
        assertThrows(Exception.class, () -> underflowStack.pop(), "Stack Underflow");
    }

    @Test
    @DisplayName("Should deleted last element when stack call function pop")
    void testPopStackValid(){
        try {
//            Given
            Object[] afterPop = {"Naufal", "Okta", "Rabil", "Ziad", null};
            int size = overflowStack.size();

//            When
            overflowStack.pop();

//            Then
            assertArrayEquals(afterPop, overflowStack.getElements());
            assertEquals(size - 1, overflowStack.size());
        } catch(Exception e){
            fail();
        }
    }
}