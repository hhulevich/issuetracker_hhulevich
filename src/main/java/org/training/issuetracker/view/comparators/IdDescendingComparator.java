package org.training.issuetracker.view.comparators;

import java.util.Comparator;

import org.training.issuetracker.issues.IssueFromList;

public class IdDescendingComparator implements Comparator<IssueFromList> {

	@Override
	public int compare(IssueFromList arg1, IssueFromList arg2) {
		return (int) (arg2.getId() - arg1.getId());
	}
}
