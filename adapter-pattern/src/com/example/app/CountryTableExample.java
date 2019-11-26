package com.example.app;

import java.awt.Color;
import java.util.List;

import javax.swing.JFrame;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.example.model.Country;
import com.example.swing.JCustomTable;
import com.example.xml.parser.GenericHandler;

/**
 *
 * @author Dr. Binnur Kurt (binnur.kurt@gmail.com)
 */
@SuppressWarnings("serial")
public class CountryTableExample extends JFrame {

	private JCustomTable<Country> customTable;

	public CountryTableExample(List<Country> cities) {
		super("Custom Generic Table Application");
		customTable = new JCustomTable<>(Country.class);
		customTable.setColumnName("Continent");
		customTable.setData(cities);
		getContentPane().add(customTable);
		setSize(500, 500);
		setBackground(Color.gray);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}

	@SuppressWarnings("unused")
	public static void main(String[] args) {
		try {
			XMLReader parser = XMLReaderFactory.createXMLReader();
			GenericHandler<Country> handler = new GenericHandler<Country>(Country.class);
			parser.setContentHandler(handler);
			parser.parse("src/resources/countries.xml");
			CountryTableExample sample = new CountryTableExample(handler.getElements(Country.class));
		} catch (Exception e) {
			e.printStackTrace(System.err);
		}

	}
}
