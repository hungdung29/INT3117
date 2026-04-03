package W4;

import W3.Term;
import W3.InterestCalculator;
import W3.InvalidPrincipalException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class InterestCalculatorC2Test {

    @ParameterizedTest
    @CsvFileSource(resources = "testcase/InterestCalculatorC2_valid.csv", numLinesToSkip = 1)
    void testCalculate_ValidBranches(int id, Term term, long principal, long expectedTotal) {
        long actualTotal = InterestCalculator.calculateTotalAmount(term, principal);
        Assertions.assertEquals(expectedTotal, actualTotal, "Failed at Test ID: " + id);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "testcase/InterestCalculatorC2_invalid.csv", numLinesToSkip = 1)
    void testCalculate_ExceptionBranches(int id, Term term, long principal, String expectedException) {
        if ("InvalidPrincipalException".equals(expectedException)) {
            Assertions.assertThrows(InvalidPrincipalException.class, () -> {
                InterestCalculator.calculateTotalAmount(term, principal);
            }, "Failed at Test ID: " + id);
        } else if ("IllegalArgumentException".equals(expectedException)) {
            Assertions.assertThrows(IllegalArgumentException.class, () -> {
                InterestCalculator.calculateTotalAmount(term, principal);
            }, "Failed at Test ID: " + id);
        }
    }
}