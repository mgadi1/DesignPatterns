package troubleshootsearch.tree;

import java.util.ArrayList;
import java.util.List;

import troubleshootsearch.visitor.Visitor;

public class MyTree {
	private int wordCount = 0;
	private List<Integer> linesTree = new ArrayList<>();

	public List<Integer> getAbc() {
		return linesTree;
	}

	public void setAbc(List<Integer> abc) {
		this.linesTree = abc;
	}

	public class Node {
		private String key;
		Node left, right;
		List<Integer> count = new ArrayList<>();

		public Node(String item) {
			key = item;
			left = right = null;
		}

		private List<Integer> lines;

		public String getKey() {
			return key;
		}

		public List<Integer> getCount() {
			return count;
		}
	}

	Node root;

	public MyTree() {
		root = null;
	}

	public void insert(String key, int lineNumber) {
		root = insertion(root, key, lineNumber);
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}

	public Node insertion(Node root, String key, int lineNumber) {
		if (root == null) {
			root = new Node(key);
			root.lines = new ArrayList<>();
			root.lines.add(lineNumber);
			return root;
		}
		if (key.toLowerCase().compareTo(root.key.toLowerCase()) < 0) {
			root.left = insertion(root.left, key, lineNumber);
		} else if (key.toLowerCase().compareTo(root.key.toLowerCase()) > 0) {
			root.right = insertion(root.right, key, lineNumber);
		} else if (key.toLowerCase().compareTo(root.key.toLowerCase()) == 0) {
			root.count.add(lineNumber);
		}
		return root;
	}

	public void inorder(String subStr) {
		inorder1(root, subStr);
	}

	public void inorder1(Node root, String subStr) {
		if (root != null) {
			if (!root.key.equals(subStr)) {
				if (root.key.contains(subStr)) {
					wordCount++;
					linesTree.addAll(root.lines);
				}
			}
			inorder1(root.left, subStr);
			inorder1(root.right, subStr);
		}
	}

	public int getWordCount() {
		return wordCount;
	}

	public void setWordCount(int wordCount) {
		this.wordCount = wordCount;
	}

	public void accept(Visitor vis, String subStr) {
		vis.visit(this, subStr);
	}
}
