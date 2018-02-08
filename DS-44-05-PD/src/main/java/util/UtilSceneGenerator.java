package util;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import org.jdom.Attribute;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

public class UtilSceneGenerator {
	
	private File xmlFile;
	private Document document;
	private final int CENTENAS = 0;
	private final int DECENAS = 0;
	private final int UNIDADES = 9;
	
	public UtilSceneGenerator(String docName) {
		
		Element scene  = new Element("scene");
		Element secuence = new Element("sequence");
		Element send1 = null;
		String content1="";
		String content2="";
		
			document = new Document(scene);
			document.setRootElement(scene);
			
			// BPAC
			content1 = "45554:00001:1110000";
			content2 = ":0130:1:0:01:0001";
			createLines("send", send1, secuence, content1, content2, "100", "WMS", "BPAC");
//			<send wait="500" from="WMS" type="BPAC" content="45554:00001:1100000111:0130:1:0:01:0001"/>
//			<send wait="500" type="BPAC" 			content="45554:00001:0000000111:0130:1:0:01:0001"/>
			
			// PLC > 61
			content1 = "FT2C1111******************00000000001110000";
			content2 = "**********************************01**************";
			createLines("send", send1, secuence, content1, content2, "100", "PLC", "61");
//			<send wait="500" from="PLC" type="61" content="FT2C1111******************00000000001100000111**********************************01**************"/>
//			<send wait="500" from="PLC" type="61" content="FT2C1111******************00000000009990000111**********************************01**************"/>
			
			// PLC > 01
			content1 = "FT2C1111****FT2C6666******00000000001110000";
			content2 = "**********************************01**************";
			createLines("receive", send1, secuence, content1, content2, "100", "PLC", "01");
//			<receive wait="500" from="PLC" type="01" content="FT2C1111****FT2C6666******00000000001100000111**********************************01**************"/>
//
			
			document.getRootElement().addContent(secuence);
			XMLOutputter xmlOutput = new XMLOutputter();
			xmlOutput.setFormat(Format.getPrettyFormat());
			try {
				xmlOutput.output(document, new FileWriter("E:/workspace/wms-pme-srv/src/test/java/com/inditex/wms/pme/teddy/wms/"+docName+".scene.xml"));
				System.out.println("File Saved!");
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			
	}
	
	public void createLines(String direction, Element send1, Element secuence, String content1, String content2, String wait, String from, String type){
		for(int i = 0; i <= CENTENAS; i++){
			for(int j = 0; j <= DECENAS; j++){
				for(int k = 0; k <= UNIDADES; k++){
					send1 = new Element(direction);
					send1.setAttribute(new Attribute("wait",wait));
					send1.setAttribute(new Attribute("from",from));
					send1.setAttribute(new Attribute("type",type));
					String content = content1+(i)+(j)+(k)+content2;
					send1.setAttribute(new Attribute("content",content));
					secuence.addContent(send1);
//					System.out.println(" @@## content > "+content);
				}
			}
		}
	}
}
