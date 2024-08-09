package telran.time;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class DayOfWeekTRest {
    private static final String ISRAEL_WEEKEND = "Israel weekend day";
    private static final String WEEKEND = "Weekend day";
    private static final String NOT_ISRAEL_WEEKEND = "Weekend day not in Israel";
    private static final String WORKING_DAY = "Working day";
  
   
    String getComment( DayOfWeek dayOfWeek) {
        String comment = switch(dayOfWeek){
            case FRI -> ISRAEL_WEEKEND;
            case SAT -> WEEKEND;
            case SUN -> NOT_ISRAEL_WEEKEND;
            default -> WORKING_DAY;
        };
        return comment;
    }

    @Test 
    void getCommentTest() {
        assertEquals(WORKING_DAY, getComment(DayOfWeek.MON));
        assertEquals(WORKING_DAY, getComment(DayOfWeek.TUE));
        assertEquals(WORKING_DAY, getComment(DayOfWeek.WED));
        assertEquals(WORKING_DAY, getComment(DayOfWeek.THU));
        assertEquals(ISRAEL_WEEKEND, getComment(DayOfWeek.FRI));
        assertEquals(WEEKEND, getComment(DayOfWeek.SAT));
        assertEquals(NOT_ISRAEL_WEEKEND, getComment(DayOfWeek.SUN));
    }


    @Test 
    void enumExistingMethodsTest() {
        DayOfWeek[] expected = {DayOfWeek.MON, DayOfWeek.TUE, DayOfWeek.WED, DayOfWeek.THU, DayOfWeek.FRI, DayOfWeek.SAT, DayOfWeek.SUN};
        assertArrayEquals(expected, DayOfWeek.values());
        assertEquals("MON", DayOfWeek.MON.toString());
        assertEquals(DayOfWeek.MON, DayOfWeek.valueOf("MON"));
        assertThrowsExactly(IllegalArgumentException.class, () -> DayOfWeek.valueOf("ku-ku"));
    }
}
