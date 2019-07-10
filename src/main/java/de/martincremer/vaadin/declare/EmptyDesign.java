package de.martincremer.vaadin.declare;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.declarative.Design;

@SuppressWarnings("serial")
@DesignRoot
public class EmptyDesign extends VerticalLayout{

	public static EmptyDesign instantiate(String componentTree) {
		String declarativeDesign = "<vaadin-vertical-layout>" + componentTree + "</vaadin-vertical-layout>";
		return new EmptyDesign(new ByteArrayInputStream(declarativeDesign.getBytes(StandardCharsets.UTF_8)));
	}
	
	
	public EmptyDesign(InputStream stream) {
		Design.read(stream, this);
	}
}
