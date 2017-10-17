package 结对编程;

import java.util.*;

import javax.swing.JFileChooser;
import javax.swing.JFrame;

import java.io.*;
import java.lang.Character;

public class file_read {
    private ArrayList<String> words;
    private String file_name;
    public file_read() {
    	file_name = "";
    	words = new ArrayList<String>();
    }
    public void get_filename() {
    	int result = 0;
    	//File file = null;
    	JFrame frame = new JFrame();
    	JFileChooser fileChooser = new JFileChooser();
//    	FileSystemView fsv = FileSystemView.getFileSystemView();  //注意了，这里重要的一句
//    	System.out.println(fsv.getHomeDirectory());                //得到桌面路径
//    	fileChooser.setCurrentDirectory(fsv.getHomeDirectory());
    	fileChooser.setDialogTitle("请选择要上传的文件...");
    	fileChooser.setApproveButtonText("确定");
    	fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
    	result = fileChooser.showOpenDialog(frame);
    	if (JFileChooser.APPROVE_OPTION == result) {
    	    	   file_name=fileChooser.getSelectedFile().getPath();
    	   }
    }
    public ArrayList<String> read() throws IOException{
    	get_filename();
    	System.out.println(file_name);
    	if(file_name == "" || file_name.length()<=3 || !file_name.substring(file_name.length()-3).equals("txt")) {
    		System.out.println("it is a wrong file name or not txt,input the file name");
    		Scanner inn = new Scanner(System.in);
    		file_name = inn.nextLine();
    	}
    	Scanner in = new Scanner(new File(file_name));
    	String[] word;
    	String temp = "";
    	while(in.hasNext()) {
    		String str = in.next();
    		str = str.toLowerCase();
    		str = str.replaceAll("[,!！，。.?？————\"\'‘”“’]", " ");
    		char[] ch = str.toCharArray();
    		for (int i = 0; i < ch.length; i++) {
    		 if (Character.isLetter(ch[i])) {
    			temp = temp + ch[i];
    		 }
    		else if (ch[i] == ' ') {
    				if (!temp.equals("")) {
    					words.add(temp);
    					temp = "";
    				}
    			}
    		}
    		if (!temp.equals("")) {
    			words.add(temp);
    			temp = "";
    		}
    	}
//    	for(int i = 0 ; i < words.size(); i++) {
//    		System.out.println(words.get(i));
//    	}
    	return words;
    }
	public static void main(String[] args) throws IOException{
		// TODO Auto-generated method stub
         file_read file = new file_read();
         file.read();
         System.out.println(11);
//     	String str = ",,.!，，D_NAME。！；‘’”“**dfs  #$%^&()-+1431221\"\"中           国123漢字かどうかのjavaを決定";
//     	str = str.replaceAll("[\\pP]", "");
//    	System.out.println(str);
		
          
	}

}
