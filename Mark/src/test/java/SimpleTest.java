import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SimpleTest {

    @Test
    public void rightMarkTwo() {
        var actualResult = getMarkResult(35);
        assertEquals(2, actualResult);
    }

    @Test
    public void minusMark() {
        var actualResult = getMarkResult(-4);
       assertEquals("no mark result", actualResult);
    }

    @Test
    public void bigMark() {
        var actualResult = getMarkResult(7896544);
        assertEquals("no mark result", actualResult);
    }

    @Test
    public void zeroMark() {
        var actualResult = getMarkResult(0);
        assertEquals("2", actualResult);
    }
    @Test
    public void rightMarkThree(){
        var actualResult = getMarkResult(36);
            assertEquals("3", actualResult);
    }

    @Test
    public void markThree(){
        var actualResult = getMarkResult(56);
        assertEquals("3", actualResult);
    }

    @Test
    public  void rightMarkFour(){
        var actualResult = getMarkResult(57);
       assertEquals("4", actualResult);
    }

    @Test
    public void markFour(){
        var actualResult = getMarkResult(71);
        assertEquals("4", actualResult);
    }

    @Test
    public void rightMarkFive(){
        var actualResult = getMarkResult(72);
        assertEquals("5", actualResult);
    }

    @Test
    public void markFive(){
        var actualResult = getMarkResult(100);
        assertEquals("5", actualResult);
    }

    @Test
    public void negativeMark(){
        var actualResult = getMarkResult(101);
        assertEquals("no mark result", actualResult);
    }







    private String getMarkResult(Integer mark) {

        if(mark>=0 && mark <=35) return "2";

        if(mark>35 && mark <=56) return "3";

        if(mark>56 && mark<71) return "4";

        if(mark>72 && mark<100) return "5";

        return "no mark result";
    }
}
