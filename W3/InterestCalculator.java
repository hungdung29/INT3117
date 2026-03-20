package W3;

public class InterestCalculator {
    public static long calculateTotalAmount(Term term, long principal) throws InvalidPrincipalException {
        if (principal < 500000) {
            throw new InvalidPrincipalException("Số tiền gửi tối thiểu là 500.000 VND");
        }
        
        double rate = 0;
        int months = 0;
        
        switch (term) {
            case MONTH_3:
                rate = 0.041;
                months = 3;
                break;
            case MONTH_6:
                rate = 0.052;
                months = 6;
                break;
            case MONTH_12:
                months = 12;
                if (principal >= 500000000000L) {
                    rate = 0.09;
                } else {
                    rate = 0.058;
                }
                break;
            default:
                throw new IllegalArgumentException("Kỳ hạn không hợp lệ");
        }
        
        double interest = principal * rate * months / 12.0;
        return principal + Math.round(interest);
    }
}