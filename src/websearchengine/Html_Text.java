package websearchengine;


import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import org.jsoup.Jsoup;

public class Html_Text {

	public void convert(ArrayList<String> fileList) throws IOException{
		
		for(String fileName:fileList){
		
			File in=new File("E:/W3C Web Pages/"+fileName);
			org.jsoup.nodes.Document doc = Jsoup.parse(in, "UTF-8");
			String text = doc.text();
			PrintWriter out = new PrintWriter("E:/W3C Web Pages/Text/"+fileName.replace(".html",".txt"));
			out.println(text);
			out.close();
		
			
		}
	
	}
	
	
	
	
}
