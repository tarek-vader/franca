/*
 * generated by Xtext
 */
package org.franca.core.dsl.formatting;

import org.eclipse.xtext.formatting.impl.AbstractDeclarativeFormatter;
import org.eclipse.xtext.formatting.impl.FormattingConfig;
import org.eclipse.xtext.Keyword;
import org.eclipse.xtext.util.Pair;
import org.franca.core.dsl.services.FrancaIDLGrammarAccess;

/**
 * This class contains custom formatting description.
 * 
 * see : http://www.eclipse.org/Xtext/documentation/latest/xtext.html#formatting
 * on how and when to use it 
 * 
 * Also see {@link org.eclipse.xtext.xtext.XtextFormattingTokenSerializer} as an example
 */
public class FrancaIDLFormatter extends AbstractDeclarativeFormatter {
	
	@Override
	protected void configureFormatting(FormattingConfig c) {
		FrancaIDLGrammarAccess f = (FrancaIDLGrammarAccess) getGrammarAccess();
		
		for(Pair<Keyword, Keyword> pair: f.findKeywordPairs("{", "}")) {
			c.setIndentation(pair.getFirst(), pair.getSecond());
			c.setLinewrap(1).after(pair.getFirst());
			c.setLinewrap(1).before(pair.getSecond());
			c.setLinewrap(1).after(pair.getSecond());
		}
		
		for(Keyword comma: f.findKeywords(",")) {
			c.setNoLinewrap().before(comma);
			c.setNoSpace().before(comma);
			c.setLinewrap().after(comma);
		}

		for(Pair<Keyword, Keyword> pair: f.findKeywordPairs("<**", "**>")) {
			c.setIndentationIncrement().after(pair.getFirst());
			c.setIndentationDecrement().before(pair.getSecond());
		}
		c.setLinewrap(2).before(f.getFAnnotationBlockRule());
		c.setLinewrap(1).after(f.getFAnnotationBlockRule());
		c.setLinewrap(1).bounds(f.getFAnnotationRule(), f.getFAnnotationRule());
		
		c.setLinewrap(0, 1, 2).before(f.getSL_COMMENTRule());
		c.setLinewrap(0, 1, 2).before(f.getML_COMMENTRule());
		c.setLinewrap(0, 1, 1).after(f.getML_COMMENTRule());
		
		// interface in general
		c.setLinewrap(2).around(f.getFInterfaceRule());
		
		// attributes
		c.setLinewrap(2).around(f.getFAttributeRule());

		// methods and broadcasts
		c.setLinewrap(1).around(f.getFMethodRule());
		c.setLinewrap(1).around(f.getFBroadcastRule());
		c.setLinewrap(1).around(f.getFArgumentRule());

		// types
		c.setLinewrap(2).around(f.getFTypeRule());
		c.setLinewrap(2).around(f.getFArrayTypeRule());
		c.setLinewrap(2).around(f.getFEnumerationTypeRule());
		c.setLinewrap(1).around(f.getFEnumeratorRule());
		c.setLinewrap(1).around(f.getFFieldRule());
		c.setLinewrap(2).around(f.getFStructTypeRule());
		c.setLinewrap(1).after(f.getFTypedElementRule());
		c.setLinewrap(2).around(f.getFMapTypeRule());
		c.setLinewrap(2).around(f.getFTypeDefRule());
		
		//version information
		c.setLinewrap(1).after(f.getFVersionAccess().getMajorAssignment_2_1());
		c.setLinewrap(1).after(f.getFVersionAccess().getMinorAssignment_3_1());
	}
}
