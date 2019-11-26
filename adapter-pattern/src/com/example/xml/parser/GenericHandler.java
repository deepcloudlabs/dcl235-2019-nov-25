package com.example.xml.parser;

import java.lang.reflect.Field;
import java.util.*;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

/**
 *
 * @author Binnur Kurt <binnur.kurt@gmail.com>
 */
public class GenericHandler<T> extends DefaultHandler {

	private List<T> elements;
	private T activeElement;
	private Field field;
	private Map<String, Field> fieldMap;
	private Class<?> elementClass;
	private String tag;

	public GenericHandler(Class<T> elementClass) {
		this.elementClass = elementClass;
		tag = elementClass.getSimpleName();
		tag = Character.toLowerCase(tag.charAt(0)) + tag.substring(1);
		fieldMap = new HashMap<String, Field>();
		for (Field field : elementClass.getDeclaredFields()) {
			fieldMap.put(field.getName(), field);
		}
	}

	@Override
	public void endDocument() throws SAXException {
	}

	@Override
	public void startDocument() throws SAXException {
		elements = new ArrayList<T>();
	}

	@Override
	public void characters(char[] ch, int start, int length) throws SAXException {
		if (Character.isWhitespace(ch[start])) {
			return;
		}
		String s = new String(ch);
		if (field != null && activeElement != null) {
			try {
				if (field.getGenericType() == int.class) {
					int val = Integer.parseInt(s.substring(start, start + length));
					field.setAccessible(true);
					field.setInt(activeElement, val);
				} else if (field.getGenericType() == double.class) {
					double val = Double.parseDouble(s.substring(start, start + length));
					field.setAccessible(true);
					field.setDouble(activeElement, val);
				} else if (field.getGenericType() == String.class) {
					field.setAccessible(true);
					field.set(activeElement, s.substring(start, start + length));
				}
			} catch (Exception ex) {
			}
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		if (localName.equals(tag)) {
			try {
				activeElement = (T) elementClass.newInstance();
				for (int i = 0; i < attributes.getLength(); ++i) {
					Field f = fieldMap.get(attributes.getLocalName(i));
					if (f != null && activeElement != null) {
						try {
							if (field.getGenericType() == int.class) {
								int val = Integer.parseInt(attributes.getValue(i));
								field.setAccessible(true);
								field.setInt(activeElement, val);
							} else if (field.getGenericType() == double.class) {
								double val = Double.parseDouble(attributes.getValue(i));
								field.setAccessible(true);
								field.setDouble(activeElement, val);
							} else if (field.getGenericType() == String.class) {
								field.setAccessible(true);
								field.set(activeElement, attributes.getValue(i));
							}
						} catch (Exception ex) {
						}
					}
				}
			} catch (Exception ex) {
			}
		} else {
			for (int i = 0; i < attributes.getLength(); ++i) {
				Field f = fieldMap.get(attributes.getLocalName(i));
				if (f != null && activeElement != null) {
					try {
						if (field.getGenericType() == int.class) {
							int val = Integer.parseInt(attributes.getValue(i));
							field.setAccessible(true);
							field.setInt(activeElement, val);
						} else if (field.getGenericType() == double.class) {
							double val = Double.parseDouble(attributes.getValue(i));
							field.setAccessible(true);
							field.setDouble(activeElement, val);
						} else if (field.getGenericType() == String.class) {
							field.setAccessible(true);
							field.set(activeElement, attributes.getValue(i));
						}
					} catch (Exception ex) {
					}
				}
			}
			field = fieldMap.get(localName);

		}
	}

	@Override
	public void endElement(String uri, String localName, String qName) throws SAXException {
		if (localName.equals(tag)) {
			elements.add(activeElement);
		}
	}

	public List<T> getElements(Class<?> cls) {
		return (List<T>) elements;
	}
}
