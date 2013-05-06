package org.training.issuetracker.comments.impl_xml;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;

import org.training.issuetracker.comments.Comment;
import org.training.issuetracker.comments.factory.CommentDAO;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

public class CommentImplXml extends DefaultHandler implements CommentDAO{

	private List<Comment> comments= new ArrayList<Comment>();
	private TagsEnum currentEnum = null;
	private Comment comment;
	
	@Override
	public Comment getCommentById(Long id, String... realPath) {
		// TODO Auto-generated method stub
		return null;
	}
	
	private List<Comment> getComments(String realPath) {
		try {
			XMLReader reader = XMLReaderFactory.createXMLReader();
			reader.setContentHandler(this);
			SAXParserFactory factory = SAXParserFactory.newInstance();
			SAXParser parser = factory.newSAXParser();
			parser.parse(realPath + "\\org\\training\\issuetracker\\res\\comment.xml", this);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (ParserConfigurationException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		return comments;
	}
	public void startElement(String uri, String localName, String qName, Attributes attrs) { 
		currentEnum = TagsEnum.valueOf(qName.toUpperCase());
		switch (currentEnum) { 
		case COMMENT:
			comment = new Comment();
			comment.setId(Long.valueOf(attrs.getValue(0)));
			break;
		default:
			break;
		}
	}
	
	public void endElement(String uri, String localName, String qName) { 
		if (qName.toUpperCase().equals(TagsEnum.COMMENT.toString())) { 
			comments.add(comment);
		}
		currentEnum = null;
	} 
	
	public void characters(char[] ch, int start, int length) {
		String s = new String(ch, start, length).trim();
		if (currentEnum == null) {
			return;
		}
		switch (currentEnum) { 
		case ISSUE_ID: 
			comment.setIssueId(Long.valueOf(s));
			break;
		case ADDED_BY:
			comment.setAddedBy(Long.valueOf(s));
			break;
		case ADD_DATE:
			comment.setAddDate(getFormattedDate(s));
			break;
		case TEXT:
			comment.setText(s);
			break;
		default:
			break;
		}
	}
	
	private static Date getFormattedDate(String dateStr) {
		Date date = null;
		DateFormat df = new SimpleDateFormat("dd.MM.yyyy");
		try {
			date = (Date) df.parse(dateStr);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}


}
