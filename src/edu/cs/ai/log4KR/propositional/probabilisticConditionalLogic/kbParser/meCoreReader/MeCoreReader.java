package edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.meCoreReader;

import edu.cs.ai.log4KR.propositional.probabilisticConditionalLogic.kbParser.AbstractReader;
import edu.cs.ai.mecore.logic.Conditional;
import edu.cs.ai.mecore.logic.Variable;

public class MeCoreReader extends AbstractReader<Variable, Conditional>{

	public MeCoreReader() {
		super(new MeCoreVisitor());
	}
}
