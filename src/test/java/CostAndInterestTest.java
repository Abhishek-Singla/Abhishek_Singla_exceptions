import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class CostAndInterestTest {

    // ---- Cost / HouseConstruction tests ----

    @Test
    void standardManualCostPerUnit1200() {
        Cost cost = new Cost("standard", 10, "manual");
        assertEquals(12000, cost.calculateCost());
    }

    @Test
    void standardFullyAutomatedCostPerUnit1900() {
        Cost cost = new Cost("standard", 10, "fully");
        assertEquals(19000, cost.calculateCost());
    }

    @Test
    void aboveStandardManualCostPerUnit1500() {
        Cost cost = new Cost("above standard", 5, "manual");
        assertEquals(7500, cost.calculateCost());
    }

    @Test
    void aboveStandardFullyAutomatedCostPerUnit2200() {
        Cost cost = new Cost("above standard", 5, "fully");
        assertEquals(11000, cost.calculateCost());
    }

    @Test
    void highStandardManualCostPerUnit1800() {
        Cost cost = new Cost("high standard", 4, "manual");
        assertEquals(7200, cost.calculateCost());
    }

    @Test
    void highStandardFullyAutomatedCostPerUnit2500() {
        Cost cost = new Cost("high standard", 4, "fully");
        assertEquals(10000, cost.calculateCost());
    }

    @Test
    void unknownMaterialReturnsZero() {
        Cost cost = new Cost("luxury", 10, "manual");
        assertEquals(0, cost.calculateCost());
    }

    @Test
    void materialMatchingIsCaseInsensitive() {
        Cost cost = new Cost("STANDARD", 1, "manual");
        assertEquals(1200, cost.calculateCost());
    }

    // ---- Calculate / Interest tests ----

    @Test
    void simpleInterestBasicCase() {
        Calculate calc = new Calculate(1000, 5, 2);
        assertEquals(100.0, calc.SimpleInterest(), 0.001);
    }

    @Test
    void simpleInterestZeroRate() {
        Calculate calc = new Calculate(1000, 0, 5);
        assertEquals(0.0, calc.SimpleInterest(), 0.001);
    }

    @Test
    void simpleInterestZeroTime() {
        Calculate calc = new Calculate(1000, 5, 0);
        assertEquals(0.0, calc.SimpleInterest(), 0.001);
    }

    @Test
    void compoundInterestDoesNotThrow() {
        Calculate calc = new Calculate(1000, 5, 3);
        assertDoesNotThrow(calc::CompoundInterest);
    }
}
