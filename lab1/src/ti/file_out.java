package ½á¶Ô±à³Ì;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;


public class file_out {
	private String solution;
    public file_out(String solution) {
    	this.solution = solution;
    }
    public void output() {
    	File file = new File("D:/output.txt");
        FileWriter fw = null;
        BufferedWriter writer = null;
        try {
        	fw = new FileWriter(file);
        	writer = new BufferedWriter(fw);
        	writer.write(solution);
        	writer.flush();
        }catch(FileNotFoundException e) {
        	e.printStackTrace();
        }catch(IOException e) {
        	e.printStackTrace();
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String solution = "nimeideadea";
        file_out f = new file_out(solution);
        f.output();
        
	}

}
