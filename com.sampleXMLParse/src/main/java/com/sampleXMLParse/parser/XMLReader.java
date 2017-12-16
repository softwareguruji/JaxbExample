package com.sampleXMLParse.parser;

import java.io.File;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;

import com.sampleXMLParse.pojo.SVNode;
import com.sampleXMLParse.pojo.SVProperty;

/*
 * This one is responsible for read XML file and parse it to Object.
 * We used JAXB to read XML files.
 */
public class XMLReader {

	private static final JAXBContext CONTEXT_XML;

	static {
		try {
			CONTEXT_XML = JAXBContext.newInstance(SVNode.class);
		} catch (JAXBException e) {
			e.printStackTrace();
			throw new Error(e);
		}
	}

	/*
	 * Need XML file to read and convert same to FRLManifoldBean POJO.
	 */
	public static SVNode loadProduct(File file) throws JAXBException {
		Unmarshaller u = CONTEXT_XML.createUnmarshaller();
		return (SVNode) u.unmarshal(file);
	}

	// This is to test the xml for Product.
	public static void exportXML(SVNode frlManifoldBean, File file) {
		try {
			Marshaller m = CONTEXT_XML.createMarshaller();
			/*PrintStream ps = System.out;
			FileOutputStream fos = new FileOutputStream(file);
			*/
			m.marshal(frlManifoldBean, file);

		} catch (JAXBException e) {
			e.printStackTrace();
		} 
	}
	
	public static void main(String[] args) {
		File file = new File("common.API.xml");
		try {
			SVNode obj = loadProduct(file);
			if(obj.getSvNodes() != null){
				if(obj.getSvNodes().size()>0){
					for (SVNode svNodeObj : obj.getSvNodes()) {
						System.out.println(svNodeObj.getSvName());
						if(svNodeObj.getSvPropertys() != null){
							if(svNodeObj.getSvPropertys().size() > 0){
								for (SVProperty svProperty : svNodeObj.getSvPropertys()) {
									System.out.println("\t\t"+svProperty.getSvName());
								}
							}
						}
					}
				}
			}
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		File writeFile = new File("D:\\ToUpload\\testGenerated.xml");
		SVNode ndObj = new SVNode();
		ndObj.setSvName("PianosControllerAPI");
		exportXML(ndObj, writeFile);
	}

}
