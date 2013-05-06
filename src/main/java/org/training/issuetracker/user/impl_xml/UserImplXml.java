package org.training.issuetracker.user.impl_xml;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.training.issuetracker.user.User;
import org.training.issuetracker.user.factory.UserDAO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;


public class UserImplXml extends DefaultHandler implements UserDAO{
	
	private List<User> users= new ArrayList<User>();
	private TagsEnum currentEnum = null;
	private User user;
	
	@Override
	public User getUser(String email, String password, String ... realPath) {
		List<User> users = getUsers(realPath[0]);
		for (User user : users) {
			if (user.getEmailAddress().equals(email) && user.getPassword().equals(password)) {
				return user;
			}
		}
		
		return null;
	}

	private List<User> getUsers(String realPath) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(this);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(realPath + "\\org\\training\\issuetracker\\res\\users.xml", this);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return users;
	}
	public void startElement(String uri, String localName, String qName, Attributes attrs) { 
		currentEnum = TagsEnum.valueOf(qName.toUpperCase());
		switch (currentEnum) { 
		case USER:
			user = new User();
			user.setId(Long.valueOf(attrs.getValue(0)));
			break;
		default:
			break;
		}
	}
	
	public void endElement(String uri, String localName, String qName) { 
		if (qName.toUpperCase().equals(TagsEnum.USER.toString())) { 
			users.add(user);
		}
		currentEnum = null;
	} 
	
	public void characters(char[] ch, int start, int length) {
		String s = new String(ch, start, length).trim();
		if (currentEnum == null) {
			return;
		}
		switch (currentEnum) { 
		case FIRST_NAME: 
			user.setFirstName(s);
			break;
		case LAST_NAME:
			user.setLastName(s);
		case EMAIL_ADDRESS:
			user.setEmailAddress(s);
		case ROLE:
			user.setRole(s);
		case PASSWORD:
			user.setPassword(s);
		default:
			break;
		}
	}
}
