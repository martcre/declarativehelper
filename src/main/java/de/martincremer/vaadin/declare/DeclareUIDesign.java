package de.martincremer.vaadin.declare;

import java.util.ArrayList;
import java.util.Collections;
import java.util.stream.Stream;

import org.jsoup.nodes.Element;

import com.vaadin.annotations.DesignRoot;
import com.vaadin.ui.Button;
import com.vaadin.ui.Grid;
import com.vaadin.ui.GridLayout;
import com.vaadin.ui.Label;
import com.vaadin.ui.MenuBar;
import com.vaadin.ui.Notification;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.VerticalLayout;
import com.vaadin.ui.MenuBar.MenuItem;
import com.vaadin.ui.declarative.Design;
import com.vaadin.ui.declarative.DesignContext;
import com.vaadin.ui.themes.ValoTheme;

@DesignRoot
@SuppressWarnings("serial")
public class DeclareUIDesign extends VerticalLayout {

	TextArea textareaMarkup;
	VerticalLayout designArea;
	MenuItem menuItemHome;

	public DeclareUIDesign() {
		Design.read(this);
		
		MenuBar menuBar = new MenuBar();
		menuBar.addStyleNames(ValoTheme.MENUBAR_SMALL, ValoTheme.MENUBAR_BORDERLESS);
		menuBar.addItem("Home", e-> {Notification.show("whosa");});

		GridLayout gridLayout = new GridLayout(4, 4);
		gridLayout.setSpacing(true);
		gridLayout.setMargin(true);
		gridLayout.addComponent(new Label("A1"), 0, 0);
		
		Grid<Person> grid = new Grid<Person>(Person.class);
		grid.setItems(Stream.of(new Person("Bart"), new Person("Home"), new Person("Lisa"), new Person("Marge"), new Person("Maggie")));
		gridLayout.addComponent(grid, 1, 0);
		gridLayout.addComponent(new Label("AB2"), 0, 1, 1, 1);
		
		
		designArea.addComponent(menuBar);
		designArea.addComponent(gridLayout);
		
		designArea.setExpandRatio(gridLayout, 0.5f);
		
		Element e = new Element("div");
        DesignContext d = new DesignContext();
        designArea.writeDesign(e, d);
        
        textareaMarkup.setValue(e.html());
        
	}

}
