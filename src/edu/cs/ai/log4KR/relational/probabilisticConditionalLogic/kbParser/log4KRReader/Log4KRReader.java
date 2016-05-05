package edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.log4KRReader;

import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Constant;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Predicate;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Sort;
import edu.cs.ai.log4KR.relational.classicalLogic.syntax.signature.Variable;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.kbParser.AbstractReader;
import edu.cs.ai.log4KR.relational.probabilisticConditionalLogic.syntax.RelationalConditional;

/**
 * This class overrides AbstractReader so that it can be used with Log4KR data types.
 * 
 * @author koecher
 *
 */

public class Log4KRReader extends AbstractReader<Sort, Constant, Variable, Predicate, RelationalConditional>{
	public Log4KRReader() {
		super(new Log4KRVisitor());
	}
}
