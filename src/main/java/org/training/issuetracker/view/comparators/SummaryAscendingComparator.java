package org.training.issuetracker.view.comparators;

import java.util.Comparator;

import org.training.issuetracker.issues.IssueFromList;

public class SummaryAscendingComparator implements Comparator<IssueFromList> {

	@Override
	public int compare(IssueFromList arg1, IssueFromList arg2) {
		return arg1.getSummary().compareTo(arg2.getSummary());
	}
}
