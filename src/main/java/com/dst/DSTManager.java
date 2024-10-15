package com.dst;
import java.sql.Time;
import java.util.Scanner;
public class DSTManager
{
		static boolean dstStatus = false;
		static Time time = new Time(20, 0, 0);
		static Time getExpiry() {
			return time;
		}

		@SuppressWarnings("deprecation")
		static void enableDST() {

			Time time = getExpiry();
			if(dstStatus == false){ 
				int hour = time.getHours();
				time.setHours(hour + 1);
				dstStatus = true;
			}
			
			System.out.println("DST Enabled - Current Expiry Time : " + time);
			
		}

		@SuppressWarnings("deprecation")
		static void disableDST() {
			
			Time time = getExpiry();
			if(dstStatus == true){ 
				int hour = time.getHours();
				time.setHours(hour - 1);
				dstStatus = false;
			}
			System.out.println("DST Disabled - Current Expiry Time : " + time);
			
		}

		public static void main(String[] args) {
			int month = 1;
			Scanner sc = new Scanner(System.in);
			while(true){
				//LocalDateTime date = LocalDateTime.now();
				//month = date.getMonthValue();
				
				month = sc.nextInt();
				
				switch (month) {

					case 1: disableDST(); break;
					case 2: disableDST(); break;
					case 3: disableDST(); break;
					case 10: disableDST(); break;
					case 11: disableDST(); break;
					case 12: disableDST(); break;
					
					case 4: enableDST(); break;
					case 5: enableDST(); break;
					case 6: enableDST(); break;
					case 7: enableDST(); break;
					case 8: enableDST(); break;
					case 9: enableDST(); break;
					
					case 0: System.exit(0);
				}
			}
			
		}
	}



