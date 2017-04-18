package com.crazybunqnq.other;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class Dom4jXml {
	public void readXML() {
		SAXReader sax = new SAXReader();
		Document doc = null;
		try {
			 doc = sax.read("users.xml");
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}
}
