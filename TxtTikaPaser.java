package tikaPaser;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.tika.exception.TikaException;
import org.apache.tika.metadata.Metadata;
import org.apache.tika.parser.ParseContext;
import org.apache.tika.parser.html.HtmlParser;
import org.apache.tika.sax.BodyContentHandler;
import org.xml.sax.SAXException;

public class TxtTikaPaser {
	public void parseToPlainText() throws IOException, SAXException, TikaException {
	    

	    String path="/Users/sunaibo/Desktop/HW4_572/NYD/NYD";
	   //String path="/Users/sunaibo/Desktop/1";
       File fileS = new File(path);
       File[] list = fileS.listFiles();
   		int i=1;
   		
   		File f = new File("/Users/sunaibo/Desktop/big.txt");
   		f.createNewFile();
   		FileWriter fw = new FileWriter(f);	
   		BufferedWriter out = new BufferedWriter(fw);
       for (File file : list) {
	    	   BodyContentHandler handler = new BodyContentHandler(-1);
	   	   Metadata metadata = new Metadata();
	   	   ParseContext pcontext = new ParseContext();
	   	   HtmlParser htmlparser= new HtmlParser();
		   FileInputStream stream =new FileInputStream(file);
		   System.out.println(i);
		   i++;
		   htmlparser.parse(stream, handler, metadata,pcontext);  
		   out.write(handler.toString());
       }
      
       out.close();
       fw.close();
	}
	public static void main(String[] args) throws IOException, SAXException, TikaException {
		// TODO Auto-generated method stub
		
		new TxtTikaPaser().parseToPlainText();
		
	}

}
