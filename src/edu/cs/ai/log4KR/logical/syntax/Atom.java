package edu.cs.ai.log4KR.logical.syntax;


public interface Atom<I extends Interpretable> extends Formula<I> {

	public abstract I getInterpretable();
}
