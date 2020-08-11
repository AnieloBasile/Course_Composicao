package Applications;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

//import com.sun.tools.javac.util.StringUtils;

import Entities.Departament;
import Entities.HourContract;
import Entities.Worker;
import Entities.Enums.WorkerLevel;

public class Program {

	public static void main(String[] args) throws ParseException {
		
		//sets the parameter ".,"  to the "US" standard
		Locale.setDefault(Locale.US);
		
		//instantiates the "scanner" of what was typed(enter) on the screen
		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		
		//-----------------------------------------------------------------------------------------
		//  Variables 
		//-----------------------------------------------------------------------------------------
		Calendar cal = Calendar.getInstance(); //assign current time to decide settlement
		int  intHORA = cal.get(Calendar.HOUR);
		int  intMINU = cal.get(Calendar.HOUR);
		int  intAMPM = cal.get(Calendar.AM_PM);
		//-----------------------------------------------------------------------------------------
		

		
		//-----------------------------------------------------------------------------------------
		//  print screen 
		//-----------------------------------------------------------------------------------------
		System.out.println();
		System.out.println("************************************************************************");
		System.out.println("*                                                                      *");
		
		if (intAMPM == 0) {

			if ((intHORA >= 1 && intHORA <= 5 ) || (intHORA == 12 && intMINU < 60)) {
				System.out.println("*                      GOOD NIGHT  !!!!                                *");
			} else if (intHORA > 5 && intHORA <= 11 ) {
				System.out.println("*                      GOOD MORNING  !!!!                              *");
			}
		} else if (intAMPM == 1) {
			if ((intHORA >= 1 && intHORA <= 5 ) || (intHORA == 12 && intMINU < 60)) {
				System.out.println("*                      GOOD AFTERNOON  !!!!                            *");
			} else if (intHORA > 5 && intHORA <= 11 ) {
				System.out.println("*                      GOOD EVENING  !!!!                              *");
			}

		}
		 
		System.out.println("*                                                                      *");
		System.out.println("************************************************************************");
		System.out.println("*                                                                      *");
		System.out.println("*                     REGISTRATION OF EMPLOYEES                        *");
		System.out.println("*                                                                      *");
		System.out.println("************************************************************************");
		System.out.println("*                                                                      *");
		System.out.println("*                                                                      *");
		
		
		System.out.println("*  -- Enter Worker data                                                *");  
		System.out.print("*      - Name...............: ");   // Alex
		String strEmployeeName    = sc.nextLine();
		System.out.print("*      - Department.........: ");   // Design
		String strDepartamentName = sc.nextLine();
		System.out.print("*      - Level..............: ");   // MID_LEVEL 
		String strLevel           = sc.nextLine();
		System.out.print("*      - Base salary........: ");   // 12000,00 
		Double dblBaseSalary      = sc.nextDouble();
		
		Worker wWorker = new Worker(strEmployeeName, WorkerLevel.valueOf(strLevel), dblBaseSalary, new Departament(strDepartamentName));

		System.out.println("*                                                                      *");
		System.out.print("*  -- How many contracts to this worker ? : ");  // 1, 2, 3.....
		int    intContrats        = sc.nextInt();
		System.out.println("*                                                                      *");
		
		for (int i = 1; i < intContrats+1; i++) {
			System.out.println("*  -- Enter contract # " + i + " data                                          *");  
		    
			System.out.print("*     - Date (DD/MM/YYYY)..: ");   // Alex
		    Date    dteContractDate   = sdf.parse(sc.next());

		    System.out.print("*     - Value per hour.....: ");   // Alex
		    Double  dblValuePerHour   = sc.nextDouble();
		    
		    System.out.print("*     - Duration (hours)...: ");   // Alex
		    int     intDurationHour   = sc.nextInt();
			
		    HourContract hctContract = new HourContract(dteContractDate, dblValuePerHour, intDurationHour);
		    wWorker.addContract(hctContract);
		}
		
		System.out.println("*                                                                      *");
		System.out.print("*  -- Enter month and year to calculate income (MM/YYYY): ");                                          
		String strMonthAndYear  = sc.next();
		int    intMonth         = Integer.parseInt(strMonthAndYear.substring(0, 2));
		int    intYear          = Integer.parseInt(strMonthAndYear.substring(3));
		
		System.out.println("*                                                                      *");

		//com
		//int intSizeReplice = 41 - wWorker.getName().length();
        //String strReplice1 = String.format("%1$-" + intSizeReplice + "s *", " ");
		String strReplice1 = String.format("%1$-" + (41 - wWorker.getName().length()) + "s *", " ");
		System.out.println("*  -- Name.................: " +  wWorker.getName()                  + strReplice1 );

		String strReplice2 = String.format("%1$-" + (41 - wWorker.getDepartament().getName().length()) + "s *", " ");
		System.out.println("*  -- Department...........: " +  wWorker.getDepartament().getName() + strReplice2 );

		String strReplice3 = String.format("%1$-" + (41 - String.format("%.2f",wWorker.income(intYear, intMonth)).length()) + "s *", " ");
		System.out.println("*  -- Income for " + strMonthAndYear + "...: " +  String.format("%.2f",wWorker.income(intYear, intMonth)) + strReplice3 );
		
	
		System.out.println("*                                                                      *");		
		System.out.println("*                                                                      *");
		System.out.println("************************************************************************");
		System.out.println("*                                                                      *");
		System.out.println("*                     End of program                                   *");
		System.out.println("*                                                                      *");
		System.out.println("************************************************************************");
		
		//scanner finalized
		sc.close();

	}

}
