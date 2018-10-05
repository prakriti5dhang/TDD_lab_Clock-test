
public class date {
	int m_year ;
	int m_months ;
	int m_days ;
	
	public date() {
		this.m_year= 2000;
		this.m_months= 1;
		this.m_days= 1;
	}
	
	public String dateSet(int year, int month, int day){
		if (year < 2000 || year > 2100)
			return "not a valid year";
		if (month < 1 || month > 12)
			return "not a valid month";
		if (day < 1 || day > 31)
			return "not a valid day";
		
		m_year = year;
		m_months = month;
		m_days = day;
		
		return showDate();
	}
	public String showDate(){
		return "" + m_year + "-" + m_months + "-" + m_days;
	}
}

