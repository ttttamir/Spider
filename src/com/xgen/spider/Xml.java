package com.xgen.spider;

import org.simpleframework.xml.Attribute;
import org.simpleframework.xml.Element;
import org.simpleframework.xml.Root;

@Root
public class Xml {

	@Element
	private String text;

	@Attribute
	private int index;

	public Xml() {
			super();
		}

	public Xml(String text, int index) {
			this.text = text;
			this.index = index;
		}

	public String getMessage() {
		return text;
	}

	public int getId() {
		return index;
	}
}
