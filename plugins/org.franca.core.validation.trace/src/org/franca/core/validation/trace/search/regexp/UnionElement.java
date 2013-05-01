package org.franca.core.validation.trace.search.regexp;


public class UnionElement extends CompoundElement {
	
	public UnionElement(RegexpElement... elements) {
		super(elements);
	}
	
	@Override
	public String toString() {
		return "("+elements[0].toString()+"+"+elements[1].toString()+")";
	}
}