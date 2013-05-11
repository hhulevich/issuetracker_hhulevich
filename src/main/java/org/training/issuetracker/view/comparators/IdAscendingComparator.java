package org.training.issuetracker.view.comparators;

import java.util.Comparator;

import org.training.issuetracker.issues.IssueFromList;

public class IdAscendingComparator implements Comparator<IssueFromList> {

	@Override
	public int compare(IssueFromList arg1, IssueFromList arg2) {
		return (int) (arg1.getId() - arg2.getId());
	}
}
