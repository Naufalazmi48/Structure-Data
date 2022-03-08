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
        Object[] initialValue = {"Naufal", "Okta", "Rabil", "Ziad", "Wawan"};
        overflowStack = new Stack(initialValue);
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

//            Then
            assertTrue(underflowStack.contains("Naufal"));
            assertTrue(underflowStack.contains("Reza"));

            assertFalse(underflowStack.isEmpty());

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
            Object lastElement = overflowStack.getElement(overflowStack.size() - 1);
            int size = overflowStack.size();

//            When
            overflowStack.pop();

//            Then
            assertFalse(overflowStack.contains(lastElement));
            assertEquals(size - 1, overflowStack.size());
        } catch(Exception e){
            fail();
        }
    }
}