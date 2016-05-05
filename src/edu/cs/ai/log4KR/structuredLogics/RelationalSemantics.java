package edu.cs.ai.log4KR.structuredLogics;

import edu.cs.ai.log4KR.relational.classicalLogic.grounding.GroundingOperator;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.RelationalAtom;

public interface RelationalSemantics extends StructuredSemantics<RelationalAtom> {


	public GroundingOperator getGop();
	
}
