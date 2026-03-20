package W3;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class InterestCalculatorBoundaryTest {
    @ParameterizedTest
    @CsvFileSource(resources = "testcase/InterestCalculatorBoundary_validdata.csv", numLinesToSkip = 1)
    void testCalculate_ValidPrincipal(int id, Term term, long principal, long expectedTotal) {
        long actualTotal = InterestCalculator.calculateTotalAmount(term, principal);
        Assertions.assertEquals(expectedTotal, actualTotal, "Failed at Test ID: " + id);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "testcase/InterestCalculatorBoundary_invaliddata.csv", numLinesToSkip = 1)
    void testCalculate_InvalidPrincipal(int id, Term term, long principal, String expectedException) {
        Assertions.assertThrows(InvalidPrincipalException.class, () -> {
            InterestCalculator.calculateTotalAmount(term, principal);
        }, "Failed at Test ID: " + id);
    }
}