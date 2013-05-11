package org.training.issuetracker.comments.impl_xml;

import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.comments.Comment;
import org.training.issuetracker.comments.factory.CommentDAO;
import org.training.issuetracker.items.AbstractItemImplXml;
import org.training.issuetracker.items.Item;
import org.training.issuetracker.res.Constants;
import org.xml.sax.Attributes;

public class CommentImplXml extends AbstractItemImplXml implements CommentDAO {

	private List<Comment> comments = new ArrayList<Comment>();
	private TagsEnum currentEnum = null;
	private Comment comment;

	public CommentImplXml() {
		super();
		this.xmlFile = Constants.COMMENTS_FILE_XML;
	}

	@Override
	public Comment getCommentById(long id, String... realPath) {
		return (Comment) getItemById(id, realPath[0]);
	}

	private List<Comment> getComments(String realPath) {
		if (comments.isEmpty()) {
			parse(realPath);
		}
		return comments;
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
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

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.toUpperCase().equals(TagsEnum.COMMENT.toString())) {
			comments.add(comment);
		}
		currentEnum = null;
	}

	@Override
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

	@Override
	protected List<Item> getItems(String realPath) {
		return new ArrayList<Item>(getComments(realPath));
	}

	@Override
	public List<Comment> getCommentsByIssueId(long issueId, String... realPath) {
		List<Comment> issueComments = new ArrayList<Comment>();
		List<Comment> comments = getComments(realPath[0]);
		for (Comment comment : comments) {
			if (comment.getIssueId() == issueId) {
				issueComments.add(comment);
			}
		}
		return issueComments;
	}
}
