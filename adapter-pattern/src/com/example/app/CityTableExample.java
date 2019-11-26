package com.example.app;

import java.awt.Color;
import java.util.List;
import javax.swing.JFrame;

import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

import com.example.model.City;
import com.example.swing.JCustomTable;
import com.example.xml.parser.GenericHandler;

/**
 *
 * @author Dr. Binnur Kurt (binnur.kurt@gmail.com)
 */
@SuppressWarnings("serial")
public class CityTableExample extends JFrame {

	private JCustomTable<City> customTable;

	public CityTableExample(List<City> cities) {
		super("Custom Generic Table Application");
		customTable = new JCustomTable<>(City.class);
		customTable.setColumnName("Name");
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
			GenericHandler<City> handler = new GenericHandler<City>(City.class);
			parser.setContentHandler(handler);
			parser.parse("src/resources/cities.xml");
			CityTableExample sample = new CityTableExample(handler.getElements(City.class));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
