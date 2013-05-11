package org.training.issuetracker.user.impl_xml;

import java.util.ArrayList;
import java.util.List;

import org.training.issuetracker.items.AbstractItemImplXml;
import org.training.issuetracker.items.Item;
import org.training.issuetracker.res.Constants;
import org.training.issuetracker.user.User;
import org.training.issuetracker.user.factory.UserDAO;
import org.xml.sax.Attributes;

public class UserImplXml extends AbstractItemImplXml implements UserDAO {

	private List<User> users = new ArrayList<User>();
	private User user;
	private TagsEnum currentEnum = null;

	public UserImplXml() {
		super();
		this.xmlFile = Constants.USERS_FILE_XML;
	}

	@Override
	public User getUser(String email, String password, String... realPath) {
		List<User> users = getUsers(realPath[0]);
		for (User user : users) {
			if (user.getEmailAddress().equals(email)
					&& user.getPassword().equals(password)) {
				return user;
			}
		}
		return null;
	}

	private List<User> getUsers(String realPath) {
		if (users.isEmpty()) {
			parse(realPath);
		}
		return users;
	}

	@Override
	public User getUserById(long id, String... realPath) {
		return (User) getItemById(id, realPath[0]);
	}

	@Override
	public void startElement(String uri, String localName, String qName,
			Attributes attrs) {
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

	@Override
	public void endElement(String uri, String localName, String qName) {
		if (qName.toUpperCase().equals(TagsEnum.USER.toString())) {
			users.add(user);
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

	@Override
	protected List<Item> getItems(String realPath) {
		return new ArrayList<Item>(getUsers(realPath));
	}
}
