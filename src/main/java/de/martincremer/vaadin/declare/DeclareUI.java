package de.martincremer.vaadin.declare;

import javax.servlet.annotation.WebServlet;

import com.vaadin.annotations.Theme;
import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinRequest;
import com.vaadin.server.VaadinServlet;
import com.vaadin.ui.Component;
import com.vaadin.ui.Label;
import com.vaadin.ui.UI;

/**
 * This UI is the application entry point. A UI may either represent a browser
 * window (or tab) or some part of an HTML page where a Vaadin application is
 * embedded.
 * <p>
 * The UI is initialized using {@link #init(VaadinRequest)}. This method is
 * intended to be overridden to add component to the user interface and
 * initialize non-component functionality.
 */
@SuppressWarnings("serial")
@Theme("mytheme")
public class DeclareUI extends UI {

	private DeclareUIDesign design;

	@Override
    protected void init(VaadinRequest vaadinRequest) {
        
        setContent(getDesign());
        getDesign().textareaMarkup.addValueChangeListener(e -> {
        	getDesign().designArea.removeAllComponents();
        	try {
        		Component c;
        		c = EmptyDesign.instantiate(e.getValue());
        		getDesign().designArea.addComponent(c);
        	} catch (Exception ex) {
        		getDesign().designArea.addComponent(new Label(ex.getMessage()));
			}
        });
        
        
        
    }

    @WebServlet(urlPatterns = "/*", name = "DeclareUIServlet", asyncSupported = true)
    @VaadinServletConfiguration(ui = DeclareUI.class, productionMode = false)
    public static class DeclareUIServlet extends VaadinServlet {
    }

	private DeclareUIDesign getDesign() {
		if (design == null) {
			design = new DeclareUIDesign();
		}
		return design;
	}
}
