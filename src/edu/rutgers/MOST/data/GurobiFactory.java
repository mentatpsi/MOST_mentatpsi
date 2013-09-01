package edu.rutgers.MOST.data;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;

public class GurobiFactory {
	private ArrayList<String> paths;
	public GurobiFactory() throws Exception {
		
		this.possiblePaths();
	}
	
	public ArrayList<String> getPaths() {
		return paths;
	}
	
	
	
	
	private void possiblePaths() {	
		String path = "C:\\"; 
	    
	    String files;
	    ArrayList<String> paths = new ArrayList<String>();
	    
	    File folder = new File(path);
	    File[] listOfFiles = folder.listFiles(); 
	    
	    for (int i = 0; i < listOfFiles.length; i++) 
	    {
	   
		     if (listOfFiles[i].isDirectory()) 	{
			     files = listOfFiles[i].getName();
			     
				 if (files.matches("gurobi*")) {
					 System.out.println(files);
					 paths.add(files);
				 }
		     }
		
	    }
	}
	
	
}

