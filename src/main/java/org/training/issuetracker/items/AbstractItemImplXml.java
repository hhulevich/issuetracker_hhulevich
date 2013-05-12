package org.training.issuetracker.items;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

/**
 * @author Hanna Hulevich
 *
 */
public abstract class AbstractItemImplXml extends DefaultHandler {

	/**
	 *
	 */
	private String xmlFile;


	/**
	 * @param realPath String
	 */
	protected void parse(String realPath) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(this);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(realPath + getXmlFile(), this);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param id long
	 * @param realPath realPath
	 * @return Item
	 */
	protected Item getItemById(long id, String realPath) {

		List<Item> items = getItems(realPath);
		for (Item item : items) {
			if (item.getId() == id) {
				return item;
			}
		}
		return null;
	}

	/**
	 * @param uri String
	 * @param localName String
	 * @param qName String
	 * @param attrs Attributes
	 */
	public abstract void startElement(String uri, String localName,
			String qName, Attributes attrs);

	/**
	 * @param uri String
	 * @param localName String
	 * @param qName String
	 */
	public abstract void endElement(String uri, String localName, String qName);

	/**
	 * @param ch char[]
	 * @param start int
	 * @param length int
	 */
	public abstract void characters(char[] ch, int start, int length);

	/**
	 * @param realPath String
	 * @return List<Item>
	 */
	protected abstract List<Item> getItems(String realPath);

	/**
	 * @param dateStr String
	 * @return Date
	 */
	protected static Date getFormattedDate(String dateStr) {
		Date date = null;
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		try {
			date = (Date) df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	/**
	 * @return String
	 */
	public String getXmlFile() {
		return xmlFile;
	}

	/**
	 * @param xmlFile String
	 */
	public void setXmlFile(String xmlFile) {
		this.xmlFile = xmlFile;
	}
}
