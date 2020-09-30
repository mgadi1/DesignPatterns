package troubleshootsearch.visitor;

import java.util.Map;

import troubleshootsearch.tree.MyTree;
import troubleshootsearch.util.Results;
import troubleshootsearch.tree.MyArrayList;

public class Naive implements Visitor {

	Results r;

	public Naive(Results r) {
		this.r = r;
	}

	@Override
	public void visit(MyTree tree, String subStr) {
		// TODO Auto-generated method stub
		r.addResult("Naive stemming match\n-----------------");
		// int flag = 0;

		String[] abc = subStr.split(" ");
		String first = abc[0];

		tree.inorder(first);
		if (tree.getWordCount() == 0) {
			r.addResult("No exact match\n");
		} else {
			r.addResult("Word Count = " + tree.getWordCount());
			r.addResult("Line Numbers = " + tree.getAbc() + "\n");
		}
	}

	@Override
	public void visit(MyArrayList str, String subStr) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MyArrayList str, String subStr, Map<String, String> synonyms) {
		// TODO Auto-generated method stub
	}
}
