package troubleshootsearch.visitor;

import java.util.Map;

import troubleshootsearch.tree.MyTree;
import troubleshootsearch.tree.MyArrayList;

public interface Visitor {
	void visit(MyArrayList str, String subStr);
	void visit(MyArrayList str, String subStr, Map<String, String> synonyms);
	void visit(MyTree binarySearchTree, String subStr);
}
