package PractoPackage;


import java.io.File;

import org.w3c.dom.*; 

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;

import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException; 



public class DataDriver{

String FirstNameValue = "";

public String  DataFetch(String filename,String pagename,String elementname) throws Exception{
try {

DocumentBuilderFactory docBuilderFactory = DocumentBuilderFactory.newInstance();
DocumentBuilder docBuilder = docBuilderFactory.newDocumentBuilder();
Document doc = docBuilder.parse (new File(filename));

// normalize text representation
doc.getDocumentElement ().normalize ();
System.out.println ("Root element of the doc is " + doc.getDocumentElement().getNodeName());


NodeList listOfPersons = doc.getElementsByTagName(pagename);
int totalPersons = listOfPersons.getLength();
//System.out.println("Total no of people : " + totalPersons);

for(int s=0; s<listOfPersons.getLength() ; s++){



Node firstPersonNode = listOfPersons.item(s);
if(firstPersonNode.getNodeType() == Node.ELEMENT_NODE){



Element firstPersonElement = (Element)firstPersonNode; 

//-------
NodeList firstNameList = firstPersonElement.getElementsByTagName(elementname);
Element firstNameElement = (Element)firstNameList.item(0);

NodeList textFNList = firstNameElement.getChildNodes();
//System.out.println("First Name : " + ((Node)textFNList.item(0)).getNodeValue().trim());
FirstNameValue = (String)textFNList.item(0).getNodeValue().trim();


}

}

}catch (SAXParseException err) {
System.out.println ("** Parsing error" + ", line " + err.getLineNumber () + ", uri " + err.getSystemId ());
System.out.println(" " + err.getMessage ());

}catch (SAXException e) {
Exception x = e.getException ();
((x == null) ? e : x).printStackTrace ();

}catch (Throwable t) {
t.printStackTrace ();
}
//System.exit (0);
return FirstNameValue;


}//end of main




}