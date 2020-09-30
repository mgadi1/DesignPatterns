package troubleshootsearch.tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import troubleshootsearch.visitor.Visitor;

public class MyArrayList {
	private List<String> array = new ArrayList<>();
	private List<String> input = new ArrayList<>();

	public List<String> getArray() {
		return array;
	}

	public void setArray(List<String> array) {
		this.array = array;
	}
	
	public void addToList(String toBeAdded) {
		array.add(toBeAdded);
	}

	public List<String> getInput() {
		return input;
	}

	public void setInput(List<String> input) {
		this.input = input;
	}
	
	public void accept(Visitor vis, String i) {
		// TODO Auto-generated method stub
		vis.visit(this, i);
	}
	public void accept(Visitor vis, String i, Map<String,String> syn) {
		// TODO Auto-generated method stub
		vis.visit(this, i, syn);
	}
}
