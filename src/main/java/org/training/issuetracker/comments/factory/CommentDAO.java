package org.training.issuetracker.comments.factory;

import java.util.List;

import org.training.issuetracker.comments.Comment;

/**
 * @author Hanna Hulevich
 *
 */
public interface CommentDAO {

	/**
	 * @param id long
	 * @param realPath String[]
	 * @return Comment
	 */
	Comment getCommentById(long id, String... realPath);

	/**
	 * @param issueId long
	 * @param realPath String[]
	 * @return List<Comment>
	 */
	List<Comment> getCommentsByIssueId(long issueId, String... realPath);

}
