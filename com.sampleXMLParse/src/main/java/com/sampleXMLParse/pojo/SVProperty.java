package com.sampleXMLParse.pojo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="property", namespace="http://www.jcp.org/jcr/sv/1.0")
public class SVProperty {

	@XmlAttribute(name="name", namespace="http://www.jcp.org/jcr/sv/1.0")
	private String svName;

	@XmlAttribute(name="type", namespace="http://www.jcp.org/jcr/sv/1.0")
	private String svType;
	
	@XmlElement(name="value")
	private String svValue;
	
	public String getSvName() {
		return svName;
	}

	public void setSvName(String svName) {
		this.svName = svName;
	}

	public String getSvType() {
		return svType;
	}

	public void setSvType(String svType) {
		this.svType = svType;
	}
	
	
}

