package org.training.issuetracker.view.comparators;

import java.util.Comparator;

import org.training.issuetracker.issues.IssueFromList;

/**
 * @author Hanna Hulevich
 *
 */
public class TypeAscendingComparator implements Comparator<IssueFromList> {

	/* (non-Javadoc)
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(IssueFromList arg1, IssueFromList arg2) {
		return arg1.getType().compareTo(arg2.getType());
	}
}
