package troubleshootsearch.visitor;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import troubleshootsearch.tree.MyTree;
import troubleshootsearch.util.Results;
import troubleshootsearch.tree.MyArrayList;

public class Exact implements Visitor {

	Results r;

	public Exact(Results r) {
		this.r = r;
	}

	// @Override
	public void visit(MyArrayList str, String subStr) {
		r.addResult("Exact Match\n-----------------");
		int flag = 0;
		for (String s : str.getArray()) {
			if (contains(s, subStr)) {
				flag = flag + 1;
				r.addResult(flag + ". " + s + "\n");
			}
		}
		if (flag == 0) {
			r.addResult("No exact match\n");
		}
	}

	private static boolean contains(String str, String subStr) {
		str = str.toLowerCase();
		String pattern = "\\b" + subStr + "\\b";
		Pattern p = Pattern.compile(pattern);
		Matcher m = p.matcher(str);
		return m.find();
	}

	@Override
	public void visit(MyArrayList str, String subStr, Map<String, String> synonyms) {
		// TODO Auto-generated method stub

	}

	@Override
	public void visit(MyTree binarySearchTree, String subStr) {
		// TODO Auto-generated method stub

	}
}
