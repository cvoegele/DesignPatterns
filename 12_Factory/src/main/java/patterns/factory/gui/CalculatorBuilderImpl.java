package patterns.factory.gui;

import patterns.factory.gui.Components.Frame;

public class CalculatorBuilderImpl implements CalculatorBuilder {

	public void setComponentFactory(Object fact) {
		// TODO this method is invoked by Spring in order to set the property "componentFactory".
		//      Change the type of the argument of this method from Object to something more concrete.
	}

	public Frame newCalculatorFrame() {
		// TODO this method is invoked by the main program to get the frame to be shown.
		return null;
	}

}
