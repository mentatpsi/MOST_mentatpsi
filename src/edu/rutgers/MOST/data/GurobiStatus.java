package edu.rutgers.MOST.data;

import java.io.File;
import java.io.FileFilter;
import java.io.FilenameFilter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class GurobiStatus {
	private ArrayList<String> paths;
	private Iterator<String> pathIter;
	private String mostRecent;
	private Map<String,String> mapping;
	public GurobiLicense License;
	public GurobiPaths Paths;
	
	public GurobiStatus() {
		this.paths = new ArrayList<String>();
		this.Paths = new GurobiPaths();
		this.License = new GurobiLicense();
	}
	
	
	public ArrayList<String> getPaths() {
		return Paths.toArrayList();
	}
			
	public void addGurobiJava(String path) {
		
	}
	
	public void addGurobiJava() {
		
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