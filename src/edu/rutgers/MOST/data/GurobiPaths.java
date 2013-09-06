package edu.rutgers.MOST.data;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GurobiPaths {
	private ArrayList<String> paths;
	private Iterator<String> pathIter;
	private String mostRecent;
	private Map<String,String> mapping;
	
	public GurobiPaths() {
		this.paths = new ArrayList<String>();
		this.possiblePaths();
	}
	
	public ArrayList<String> getDrives() {
		
	  File[] drives = File.listRoots();
	  ArrayList<String> drivesStr = new ArrayList<String>();
	  int i, e;
	  e = 0;
	  for (i = 0; i < drives.length; i++) {
		   
		   
		   File drive = new File(drives[i].toString());
		   long totalDriSpace = drive.getTotalSpace();
		   long freeSpace = drive.getFreeSpace();
		   
		   if (freeSpace > 0) {
			   
			   drivesStr.add(drives[i].toString());
			   //System.out.println("Drive :" + drivesStr.get(e));
			   e++;
		   }
		   
		   totalDriSpace = (totalDriSpace/1024/1024/1024); // Converting Bytes to GB
		   freeSpace = (freeSpace/1024/1024/1024); // Converting Bytes to GB
		   
	  }
	  return drivesStr;
			  
	}
	
	public ArrayList<String> getPaths() {
		return paths;
	}
	
	public String getNext() {
		if (pathIter.hasNext()) {
			String cur = (String) pathIter.next();
			return cur;
		}
		
		else {
			return null;
		}
	}
	
	
	
	public void addGurobiJava(String path) {
		
	}
	
	public void addGurobiJava() {
		
	}
	
	
	private void possiblePaths() {	
		ArrayList<String> drives = this.getDrives();
		
		for (String drive : drives) {
			String path = drive;
		    //String files;
		    ArrayList<String> paths = new ArrayList<String>();
		    //System.out.println(path);
		    File folder = new File(path);
		    
		    File[] listOfFiles = folder.listFiles(new FilenameFilter() {
		        public boolean accept(File directory, String fileName) {
		            return fileName.startsWith("gurobi") && directory.isDirectory();
		        } 
		        }
		    );
		    
		    for (File file : listOfFiles) {
		    	this.paths.add(file.getAbsolutePath());
		    }
		    
		}
	}
	
	
		
	
	
}



/*
private boolean isMoreRecent(String ver1, String ver2) {
	int verStart = ver1.indexOf("i") + 1;
	int i = 0;
	int ver1L = ver1.length();
	int ver2L = ver2.length();
	int dif = Math.abs((ver1L - ver2L));
	if (ver1L > ver2L) {
		ver2 += String.format("%0" + dif + "d", 0);
		
	}
	
	if (ver1L < ver2L) {
		ver1 += String.format("%0" + dif + "d", 0);
	}
	
	while (((int) ver1.charAt(i)) == ((int) ver2.charAt(i)) && (i < ver1L)) {
		i += 1;
	}
	
	if ((int) ver1.charAt(i) > (int) ver2.charAt(i)) {
		return true;
	}
	else {
		return false;
	}
}

public void mostRecent() {
	String curMRecent = paths.get(0);
	int verStart = curMRecent.indexOf("i") + 1;
	String curVer;
	for (String path : paths) {
		if (isMoreRecent(path,curMRecent)) {
			curMRecent = path;
		}
		curVer = path.substring(verStart);
	}
}
*/