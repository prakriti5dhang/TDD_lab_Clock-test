
public class clocktime {
	enum clock_state {display_time, display_date, change_time, change_date;}
	
	time m_time;
	date m_date;

	private clock_state m_state = clock_state.display_time; 

	public clocktime(){
		
		this.m_time = new time();
		this.m_date = new date();
	}
	
public String changeMode(){
	
	 switch (this.m_state) {
    case display_time:
        this.m_state = clock_state.display_date;
        return m_date.showDate();
    case display_date:
        this.m_state = clock_state.display_time;
        return m_time.showTime();
    default:
        return "not a valid operation";
	}
}

public String ready(){
	
	 switch (this.m_state) {
     case display_time:
         this.m_state = clock_state.change_time;
         return "time is ok";
     case display_date:
         this.m_state = clock_state.change_date;
         return "date is ok";
     default:
         return "not a valid operation";
	}
	
}
public String set(int p1, int p2, int p3){

	 switch (this.m_state) {
     case change_time:
		m_state = clock_state.display_time;
		 return m_time.timeSet(p1, p2, p3);
		 /*if (!check_hour(p1)) return "not a valid hour";
         if (!check_minute(p2)) return "not a valid minute";
         if (!check_second(p3)) return "not a valid second";

         this.m_time.m_hour = p1;
         this.m_time.m_minute = p2;
         this.m_time.m_seconds = p3;

         this.m_state = clock_state.display_time;

         return p1+":"+p2+":"+p3";*/

         case change_date:
		m_state = clock_state.display_date;
		return m_date.dateSet(p1, p2, p3);
		 
		 
         /*if (!check_year(p1)) return "not a	valid year";
         if (!check_month(p2)) return "not a valid month";
         if (!check_day(p3)) return "not a valid day";

         this.m_date.m_year = p1;
         this.m_date.m_months = p2;
         this.m_date.m_days = p3;

         this.m_state = clock_state.display_date;

         return p1+"-"+p2+"-"+p3;*/

     default:
         return "not a valid operation";
 }
	
}

//Functions

/*private boolean check_hour(int _hour) {
    if (_hour < 0 || _hour >= 24) {
        return false;
    }
    return true;
}

private boolean check_minute(int _minute) {
    if (_minute < 0 || _minute >= 60) {
        return false;
    }
    return true;
}

private boolean check_second(int _seconds) {
    if (_seconds < 0 || _seconds >= 60) {
        return false;
    }
    return true;
}

private boolean check_year(int _year) {
    if (_year < 2000 || _year > 2100) {
        return false;
    }
    return true;
}

private boolean check_month(int _month) {
    if (_month < 1 || _month > 12) {
        return false;
    }
    return true;
}

private boolean check_day(int _day) {
    if (_day < 1 || _day > 31) {
        return false;
    }
    return true;
}*/


}

