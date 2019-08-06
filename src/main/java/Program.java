public class Program {
    public static void main(String[] args) {
        Test("42*47=1?74", 9);
        Test("4?*47=1974", 2);
        Test("42*?7=1974", 4);
        Test("42*?47=1974", -1);
        Test("2*12?=247", -1);
        //Console.ReadKey(true);
    }
    private static void Test(String args, int expected) {
        String result = DigitFinder.FindDigit(args)==(expected) ? "PASS" : "FAIL";
        System.out.println(args+":"+ result);
    }
}
