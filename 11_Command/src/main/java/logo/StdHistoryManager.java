package logo;

import logo.commands.turtle.TurtleCommand;

public class StdHistoryManager implements HistoryManager {
	private final LogoInterpreter interpreter;

	public StdHistoryManager(LogoInterpreter interpreter) {
		this.interpreter = interpreter;
	}

	/**
	 * Adds a command to the history. The invoker of the add method is responsible
	 * to execute the command, method add only registers the command in the
	 * history for a subsequent undo/redo call.
	 */
	@Override
	public void addCommand(TurtleCommand command) {
		// TODO implement registration of a new command
	}

	/**
	 * Clears the history.
	 */
	@Override
	public void clear() {
		// TODO implement clearing of the command list
	}

	/**
	 * Performs an undo operation with the effect, that method getCommand returns
	 * a list which does not contain the latest operation. If an undo is not
	 * possible as the list of commands is empty, a message should be printed on
	 * the console. Method undo is also responsible to actualize the window by
	 * invoking interpreter.repaint().
	 */
	@Override
	public void undo() {
		// TODO update public view of command list as provided by getCommands and
		// initiate redrawing of entire graphics by calling interpreter.repaint()
	}

	/**
	 * Restores the least recently undone operation. If a redo is not possible as
	 * no pending undone commands are available, a message should be printed on
	 * the console. Method redo is also responsible to actualize the window by
	 * executing the command to redo.
	 */
	@Override
	public void redo() {
		// TODO update public view, provided through getCommands and execute command
		// to redo
	}

	/**
	 * Returns all commands which have been registered. This method is used by
	 * method LogoInterpreter.repaint().
	 */
	@Override
	public Iterable<TurtleCommand> getCommands() {
		// TODO return a list of commands to be executed to redraw the current state
		return null;
	}
}
