import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

public class mainMethodTester {
    @Test
    public void maintester()
    {
        String [] a=new String[2];
        assertEquals(1,Program.main(a));
    }
}
