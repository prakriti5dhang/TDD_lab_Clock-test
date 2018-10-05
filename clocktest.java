import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class clocktest {

	@Test
	 public void clock_transiton_state() {
	        clocktime clock = new clocktime();
	        String output;

	        // S1 -> S3
	        output = clock.ready();
	        assertEquals("time is ok", output);

	        // S3 -> S1
	        output = clock.set(1, 1, 1);
	        assertEquals("1:1:1", output);

	        // S1 -> S2
	        output = clock.changeMode();
	        //assertEquals("change to date", output);
             assertEquals("2000-1-1", output);
	        // S2 -> S4
	        output = clock.ready();
	        assertEquals("date is ok", output);

	        // S4 -> S2
	        output = clock.set(2001, 1, 1);
	        assertEquals("2001-1-1", output);

	        // S2 -> S1
	        output = clock.changeMode();
	        //assertEquals("change to time", output);
			assertEquals("1:1:1", output);
	    }

	    
	    @Test
	    public   void clock_set_time_false_S1_1() {
	        clocktime clock = new clocktime();

	        // S1 -> S1 
	        String output = clock.set(1, 1, 1);
	        assertEquals("not a valid operation", output);
	    }

	    @Test
	    public   void clock_set_time_false_S1_2() {
	    	clocktime clock = new clocktime();

	        // S1 -> S3
	        String output = clock.ready();
	        assertEquals("time is ok", output);
	    }

	    @Test
	    public   void clock_set_time_false_S1_3() {
	    	clocktime clock = new clocktime();

	        // S1 -> S2
	        String output = clock.changeMode();
	        assertEquals("2000-1-1", output);
	    }

	    @Test
	    public  void clock_set_time_false_S2_1() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();

	        // S2 -> S2
	        String output = clock.set(1, 1, 1);
	        assertEquals("not a valid operation", output);
	    }

	    @Test
	    public  void clock_set_time_false_S2_2() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();

	        // S2 -> S4
	        String output = clock.ready();
	        assertEquals("date is ok", output);
	    }

	    @Test
	    public  void clock_set_time_false_S2_3() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();

	        // S2 -> S1
	        String output = clock.changeMode();
	        assertEquals("0:0:0", output);
	    }

	    @Test
	    public   void clock_set_time_false_S3_1() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        // S3 -> S1
	        String output = clock.set(1, 1, 1);
	        assertEquals("1:1:1", output);
	    }

	    @Test
	    public  void clock_set_time_false_S3_2() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        // S3 -> S2
	        String output = clock.changeMode();
	        assertEquals("not a valid operation", output);
	    }

	    @Test
	    public  void clock_set_time_false_S3_3() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        // S3 -> S3
	        String output = clock.ready();
	        assertEquals("not a valid operation", output);
	    }

	    @Test
	    public  void clock_set_time_false_S4_1() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        // S4 -> S2
	        String output = clock.set(2001, 1, 1);
	        assertEquals("2001-1-1", output);
	    }

	    @Test
	    public void clock_set_time_false_S4_2() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        // S4 -> S1
	        String output = clock.changeMode();
	        assertEquals("not a valid operation", output);
	    }

	    @Test
	    public void clock_set_time_false_S4_3() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        // S4 -> S4
	        String output = clock.ready();
	        assertEquals("not a valid operation", output);
	    }

	   
	    @Test
	    public  void clock_time_bounds_hour_over() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(24, 0, 0);
	        assertEquals("not a valid hour", output);
	    }

	    @Test
	    public  void clock_time_bounds_hour_under() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(-1, 0, 0);
	        assertEquals("not a valid hour", output);
	    }
		@Test
	    public  void clock_time_bounds_hour_obetween() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(23, 0, 0);
	        assertEquals("23:0:0", output);
	    }
		@Test
	    public  void clock_time_bounds_hour_ubetween() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, 0);
	        assertEquals("0:0:0", output);
	    }
		//inside the lower bounds

	    @Test
	    public  void clock_time_bounds_minute_over() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 60, 0);
	        assertEquals("not a valid minute", output);
	    }

	    @Test
	    public  void clock_time_bounds_minute_under() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, -1, 0);
	        assertEquals("not a valid minute", output);
	    }
		@Test
	    public  void clock_time_bounds_minute_ubetween() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, 0);
	        assertEquals("0:0:0", output);
	    }
		@Test
	    public  void clock_time_bounds_minute_obetween() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 1, 0);
	        assertEquals("0:1:0", output, output);
	    }

	    @Test
	    public void clock_time_bounds_second_over() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, 60);
	        assertEquals("not a valid second", output);
	    }

	    @Test
	    public  void clock_time_bounds_second_under() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, -1);
	        assertEquals("not a valid second", output);
	    }
		@Test
	    public  void clock_time_bounds_second_obetween() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, 59);
	        assertEquals("0:0:59", output);
	    }
		@Test
	    public  void clock_time_bounds_second_ubetween() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, 1);
	        assertEquals("0:0:1", output);
	    }

	    @Test
	    public  void clock_date_bounds_year_over() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2101, 1, 1);
	        assertEquals("not a valid year", output);
	    }

	    @Test
	    public  void clock_date_bounds_year_under() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(1999, 1, 1);
	        assertEquals("not a valid year", output);
	    }
		@Test
	    public  void clock_date_bounds_year_obetween() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2100, 1, 1);
	        assertEquals("2100-1-1", output);
	    }
		@Test
	    public  void clock_date_bounds_year_ubetween() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2000, 1, 1);
	        assertEquals("2000-1-1", output);
	    }

	    @Test
	    public void clock_date_bounds_month_over() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 13, 1);
	        assertEquals("not a valid month", output);
	    }

	    @Test
	    public void clock_date_bounds_month_under() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 0, 1);
	        assertEquals("not a valid month", output);
	    }
		@Test
	    public void clock_date_bounds_month_obetween() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 12, 1);
	        assertEquals("2001-12-1", output);
	    }
		@Test
	    public void clock_date_bounds_month_ubetween() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, 1);
	        assertEquals("2001-1-1", output);
	    }

	    @Test
	    public void clock_date_bounds_day_over() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, 32);
	        assertEquals("not a valid day", output);
	    }
		
     @Test
	    public void clock_date_bounds_day_obetween() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, 31);
	        assertEquals("2001-1-31", output);
	    }
	    @Test
	    public  void clock_date_bounds_day_under() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, 0);
	        assertEquals(output, "not a valid day", output);
	    }
		@Test
	    public  void clock_date_bounds_day_ubetween() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, 1);
	        assertEquals("2001-1-1", output);
	    }
       @Test
	    public void clock_time_bounds_hour_over_2() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(235, 0, 0);
	        assertEquals("not a valid hour", output);
	    }
       
	    @Test
	    public void clock_time_bounds_hour_under_2() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(-521, 0, 0);
	        assertEquals(output, "not a valid hour", output);
	    }

	    @Test
	    public void clock_time_bounds_minute_over_2() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 124, 0);
	        assertEquals("not a valid minute", output);
	    }

	    @Test
	    public  void clock_time_bounds_minute_under_2() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, -145, 0);
	        assertEquals("not a valid minute", output);
	    }

	    @Test
	    public  void clock_time_bounds_second_over_2() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, 235);
	        assertEquals("not a valid second", output);
	    }

	    @Test
	    public  void clock_time_bounds_second_under_2() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, -155);
	        assertEquals("not a valid second", output);
	    }

	    @Test
	    public void clock_date_bounds_year_over_2() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(240331, 1, 1);
	        assertEquals("not a valid year", output);
	    }

	    @Test
	    public  void clock_date_bounds_year_under_2() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(0, 1, 1);
	        assertEquals("not a valid year", output);
	    }

	    @Test
	    public void clock_date_bounds_month_over_2() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 24, 1);
	        assertEquals("not a valid month", output);
	    }

	    @Test
	    public  void clock_date_bounds_month_under_2() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, -1, 1);
	        assertEquals("not a valid month", output);
	    }

	    @Test
	    public  void clock_date_bounds_day_over_2() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, 35);
	        assertEquals("not a valid day", output);
	    }

	    @Test
	    public  void clock_date_bounds_day_under_2() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, -5);
	        assertEquals("not a valid day", output);
	    }
	    @Test
	    public  void clock_date_bounds_day_correct() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, 31);
	        assertEquals("2001-1-31", output);
	    }
	    @Test
	    public  void clock_date_bounds_month_correct() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 3, 1);
	        assertEquals("2001-3-1", output);
	    }
	    @Test
	    public  void clock_date_bounds_year_correct() {
	    	clocktime clock = new clocktime();
	        clock.changeMode();
	        clock.ready();

	        String output = clock.set(2001, 1, 1);
	        assertEquals("2001-1-1", output);
	    }
	    @Test
	    public  void clock_time_bounds_sec_correct() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 0, 38);
	        assertEquals("0:0:38", output);
	    }
	    @Test
	    public  void clock_time_bounds_min_correct() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(0, 38, 0);
	        assertEquals("0:38:0", output);
	    }
	   
	    @Test
	    public  void clock_time_bounds_hour_correct() {
	    	clocktime clock = new clocktime();
	        clock.ready();

	        String output = clock.set(6, 0, 0);
	        assertEquals("6:0:0", output);
	    }
}
