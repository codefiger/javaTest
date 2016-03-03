package com.figer.Regex;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;

public class ReplaceContext {
	public static void main(String[] args) throws Exception{
		for (File file : readFile()) {
			System.out.println(file.getName());
			changeFile(file);
		}
	}
	
	public static File[] readFile(){
		File file = new File("/Users/figer/Downloads/hotel_beds_docs");
		File[] files = file.listFiles(new FileFilter() {
			
			@Override
			public boolean accept(File pathname) {
				return pathname.getName().endsWith(".html");
			}
		});
		
		return files;
	}
	
	public static void changeFile(File file) throws Exception{
		StringBuffer sb = new StringBuffer("");
		BufferedReader br = new BufferedReader(new FileReader(file));
		
		String oldLine = null;
        
        while((oldLine = br.readLine()) != null) {
        	String newLine = "";
        	boolean needChange = false;
        	String[] splitStrs = oldLine.split("\"");
    		for (String string : splitStrs) {
    			if (string.startsWith("https")) {
    				needChange = true;
    				String[] names = string.split("/");
    				newLine += "\"" + names[names.length - 1] + ".html\"";
    			}else{
    				newLine += string;
    			}
    		}
        	
    		if (needChange) {
				sb.append(newLine);
			}else{
	            sb.append(oldLine);
			}
    		
        }
       
        br.close();
		
		
        BufferedWriter bw = new BufferedWriter(new FileWriter(file));
        bw.write(sb.toString());
       
        bw.close();
	}
}
