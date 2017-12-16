package com.sampleXMLParse.pojo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name="node", namespace="http://www.jcp.org/jcr/sv/1.0")
public class SVNode {

	@XmlAttribute(name="name", namespace="http://www.jcp.org/jcr/sv/1.0")
	private String svName;
	
	@XmlElement(name="property", namespace="http://www.jcp.org/jcr/sv/1.0")
	private List<SVProperty> svPropertys;
	
	@XmlElement(name="node", namespace="http://www.jcp.org/jcr/sv/1.0")
	private List<SVNode> svNodes;
	
	public String getSvName() {
		return svName;
	}

	public void setSvName(String svName) {
		this.svName = svName;
	}

	public List<SVProperty> getSvPropertys() {
		return svPropertys;
	}

	public void setSvPropertys(List<SVProperty> svPropertys) {
		this.svPropertys = svPropertys;
	}

	public List<SVNode> getSvNodes() {
		return svNodes;
	}

	public void setSvNodes(List<SVNode> svNodes) {
		this.svNodes = svNodes;
	}
	
	

}
