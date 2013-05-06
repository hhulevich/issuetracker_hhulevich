package org.training.issuetracker.comments.factory;

import org.training.issuetracker.comments.Comment;

public interface CommentDAO {

	public Comment getCommentById(Long id, String ...realPath);
}
