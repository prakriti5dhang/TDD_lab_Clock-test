
public class time {
	int m_hour;
	int m_minute;
	int m_seconds;
	
	public time() {
		this.m_hour =0;
		this.m_minute =0;
		this.m_seconds=0;
	}
	
	public String timeSet(int hour, int min, int sec){
		if (hour < 0 || hour >= 24)
			return "not a valid hour";
		if (min < 0 || min >= 60)
			return "not a valid minute";
		if (sec < 0 || sec >= 60)
			return "not a valid second";
		m_hour = hour;
		m_minute = min;
		m_seconds = sec;
		

		return showTime();
		
	}
	public String showTime(){
		return "" + m_hour + ":" + m_minute + ":" + m_seconds;
	}
}
