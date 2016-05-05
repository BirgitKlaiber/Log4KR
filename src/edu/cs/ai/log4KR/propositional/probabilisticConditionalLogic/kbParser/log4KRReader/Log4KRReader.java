package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.log4KRReader;

import edu.cs.ai.log4KR.logical.syntax.probabilistic.Conditional;
import edu.cs.ai.log4KR.propositional.classicalLogic.syntax.PropositionalVariable;
import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.AbstractReader;

public class Log4KRReader extends AbstractReader<PropositionalVariable, Conditional<PropositionalVariable>>{

	public Log4KRReader() {
		super(new Log4KRVisitor());
	}

}
