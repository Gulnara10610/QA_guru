import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Concert {
    @Test
    public void simpleTests(){



      long actualResult= getRefundTicketPricePercent(267,true,false);
      assertEquals(100l, actualResult);

    }

    @Test
    public void tenDays(){
       long actualResult = getRefundTicketPricePercent(240, false,false);
       assertEquals(50l,actualResult);
    }

    @Test
    public void elevenDays(){
        long actualResult = getRefundTicketPricePercent(268,false, false);
        assertEquals(100l, actualResult);
    }

    @Test
    public void sixDays(){
        long actualResult = getRefundTicketPricePercent(144, false,false);
        assertEquals(50l, actualResult);
    }
    @Test
    public void fiveDays(){
        long actualResult = getRefundTicketPricePercent(120, false,false);
        assertEquals(30l, actualResult);
    }
    @Test
    public void threeDays(){
        long actualResult = getRefundTicketPricePercent(72, false,false);
        assertEquals(0, actualResult);
    }
    @Test
    public void minDays(){
        long actualResult = getRefundTicketPricePercent(4, false, false);
        assertEquals(0l,actualResult);
    }
    @Test
    public void zeroDays(){
        long actualResult = getRefundTicketPricePercent(0, false, false);
        assertEquals(0,actualResult);
    }



    private Integer getRefundTicketPricePercent(Integer hoursBeforeConcert, Boolean wasConcertCancelled, Boolean wasConcertRescheduled)

    {

        if(wasConcertCancelled && wasConcertRescheduled) return 100;

        if(hoursBeforeConcert>240) return 100;

        if(hoursBeforeConcert>=144 && hoursBeforeConcert<=240) return 50;

        if(hoursBeforeConcert>3 && hoursBeforeConcert<=144) return 30;

        return 0;

    }
}
