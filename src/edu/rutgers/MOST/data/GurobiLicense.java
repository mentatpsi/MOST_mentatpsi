package edu.rutgers.MOST.data;

import java.io.File;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class GurobiLicense {
	private String path;
	private ArrayList<String> keys;
	private Map<String,String> status;
	
	public GurobiLicense() {
		status = new HashMap<String,String>();
		this.find();
		try {
			this.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public GurobiLicense(String loc) {
		status = new HashMap<String,String>();
		this.path = loc;
		try {
			this.read();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public String get(String key) {
		return status.get(key);
	}
	
	public ArrayList<String> getKeys() {
		return keys;
	}
	
	private String[] getDrives() {
		/*Returns list of drives*/
	  File[] drives = File.listRoots();
	  String[] drivesStr = new String[drives.length];
	  for (int i = 0; i < drives.length; i++) {
		   System.out.println("Drive :" + drives[i]);
		   drivesStr[i] = drives[i].toString();
		   File drive = new File(drives[i].toString());
		   long totalDriSpace = drive.getTotalSpace();
		   long freeSpace = drive.getFreeSpace();
		   
		   totalDriSpace = (totalDriSpace/1024/1024/1024); // Converting Bytes to GB
		   freeSpace = (freeSpace/1024/1024/1024); // Converting Bytes to GB	   
	  }
	  
	  return drivesStr;
				  
	}
	
	public boolean isActive() {
		String expDate = status.get("EXPIRATION");
		
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Calendar cal = Calendar.getInstance();
		String curTime = dateFormat.format(cal.getTime());
		
		String[] exp = expDate.split("-");
		String[] cur = curTime.split("-");
		
		int curE, curC;
		
		for (int i=0;i<3;i++) {
			curE = Integer.parseInt(exp[i]);
			curC = Integer.parseInt(cur[i]);
			
			if (curC > curE) {
				return false;
			}
		}
		return true;
	}
	
	private void find() {
		String cPath = System.getenv("GRB_LICENSE_FILE");
		if (cPath == null) {
			String curName = System.getProperty("user.name");
			cPath = "C:\\Users\\" + curName + "\\gurobi.lic";
		}
		
		File cLic = new File(cPath);
		if (cLic.exists()) {
			path = cPath;
		}
	}
	
	public void setEnv() {
		
	}
	
	public String toString() {
		if (keys.isEmpty()) {
			return "";
		}
		else {
			String cur = "";
			for (String key : keys) {
				cur += key + "= " + status.get(key) + "\n";
			}
			return cur;
		}
	}
	
	private void read() throws Exception{
		File file = new File(path);
		Scanner input = new Scanner(file);
		keys = new ArrayList<String>();
		
		
		while(input.hasNextLine()) {
		    String nextLine = input.nextLine();
		    String[] cur = nextLine.split("=");
		    if (cur.length == 2) {
		    	status.put(cur[0], cur[1]);
		    	keys.add(cur[0]);
		    }
		}

		input.close();
	}
	
}

