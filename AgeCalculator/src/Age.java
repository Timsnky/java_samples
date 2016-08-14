
public class Age {
	public static void main(String [] args){
		getAge(1992,8,23);
		getAge(1992,12,31);
		getAge(1992,12,1);
		getAge(1992,1,1);
		getAge(1992,1,31);
		getAge(1992,4,2);
		
	}
	
	
	public static void getAge(int year, int month, int day ){
		int dnow = 23;
		int mnow = 8;
		int ynow = 2014;
		
		int t0 = year*12+month-1;
		int t = ynow * 12 + mnow -1;
		int dm = t - t0;
		if( dnow >= day){
			System.out.print(dm/12 + "  ");
			System.out.print(dm%12 + "  ");
			System.out.println(dnow - day);
		}else{
			dm--;
			t--;
			System.out.print(dm/12 + "  ");
			System.out.print(dm%12 + "  " );	
			if((month == 4) || (month == 6) || (month == 9) || (month == 11)){
				System.out.println(30 - day + dnow);			
			}
			else if((month == 2) && (ynow%4 == 0)){
				System.out.println(29 - day + dnow);
			}
			else if((month == 2) && ynow%4 != 0){
				System.out.println(28 - day + dnow);
			}
			else{
				System.out.println(31 - day + dnow);
			}
		}
		getBdays(month,mnow,ynow,day,dnow);
	}

	public static void getBdays(int month,int mnow, int ynow, int day, int dnow){
		int daysToBday = 0;
		if( month < mnow){
			System.out.println(daysToDec(mnow, dnow, ynow)+ daysfromJan(month, day, ynow));
		}
		else if(month == mnow){
			if( dnow < day){
				System.out.println(day - dnow);
			}else{
				if( (ynow + 1) % 4 == 0){
					System.out.println(366 - (dnow - day) );
				}else{
					System.out.println(365 - (dnow - day) );
				}
			}
		}else{
			System.out.println(daysToDec(mnow, dnow, ynow)- daysToDec(month, day, ynow));
		}
	}
	public static int daysToDec(int month, int day, int ynow){
		int month1 = month;
		int days = 0;
		if((month == 4) || (month == 6) || (month == 9) || (month == 11)){
			days = days + 30 - day;			
		}
		else if((month == 2) && (ynow%4 == 0)){
			days = days + 29 - day;
		}
		else if((month == 2) && ynow%4 != 0){
			days = days + 28 - day;
		}
		else{
			days = days + 31 - day;
		}
		month1 ++;
		while(month1 < 13){
			if((month1 == 4) || (month1 == 6) || (month1 == 9) || (month1 == 11)){
				days = days + 30;		
			}
			else if((month1 == 2) && (ynow%4 == 0)){
				days = days + 29;
			}
			else if((month1 == 2) && ynow%4 != 0){
				days = days + 28;
			}
			else{
				days = days + 31;
			}
			month1++;
		}
		return days;
	}
	public static int daysfromJan(int month, int day, int ynow){
		int month1 = 1;
		int days = 0;
		while(month1 < month){
			if((month1 == 4) || (month1 == 6) || (month1 == 9) || (month1 == 11)){
				days = days + 30;		
			}
			else if((month1 == 2) && (ynow%4 == 0)){
				days = days + 29;
			}
			else if((month1 == 2) && ynow%4 != 0){
				days = days + 28;
			}
			else{
				days = days + 31;
			}
			month1++;
		}
		days = days + day;
		return days;
	}
}
