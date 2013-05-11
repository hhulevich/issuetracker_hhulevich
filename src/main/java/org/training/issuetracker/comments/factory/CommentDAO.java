package org.training.issuetracker.comments.factory;

import java.util.List;

import org.training.issuetracker.comments.Comment;

public interface CommentDAO {

	public Comment getCommentById(long id, String... realPath);

	public List<Comment> getCommentsByIssueId(long issueId, String... realPath);

}
