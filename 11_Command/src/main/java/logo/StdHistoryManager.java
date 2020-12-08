package logo;

import logo.commands.turtle.TurtleCommand;

import java.util.Stack;

public class StdHistoryManager implements HistoryManager {
    private final LogoInterpreter interpreter;

    public StdHistoryManager(LogoInterpreter interpreter) {
        this.interpreter = interpreter;
        undoStack = new Stack<>();
        redoStack = new Stack<>();
    }

    private final Stack<TurtleCommand> undoStack;
    private final Stack<TurtleCommand> redoStack;

    /**
     * Adds a command to the history. The invoker of the add method is responsible
     * to execute the command, method add only registers the command in the
     * history for a subsequent undo/redo call.
     */
    @Override
    public void addCommand(TurtleCommand command) {
        undoStack.add(command);
        redoStack.clear();
    }

    /**
     * Clears the history.
     */
    @Override
    public void clear() {
        undoStack.clear();
        redoStack.clear();
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
        // initiate redrawing of entire graphics by calling interpreter.repaint()
        if (!undoStack.isEmpty()) {
            redoStack.add(undoStack.pop());
            interpreter.repaint();
        } else {
            System.out.println("No Commands in Undo Stack");
        }
    }

    /**
     * Restores the least recently undone operation. If a redo is not possible as
     * no pending undone commands are available, a message should be printed on
     * the console. Method redo is also responsible to actualize the window by
     * executing the command to redo.
     */
    @Override
    public void redo() {
        if (!redoStack.isEmpty()){
            var redo = redoStack.pop();
            redo.execute();
            undoStack.add(redo);
        } else {
            System.out.println("No Commands in Redo Stack");
        }
    }

    /**
     * Returns all commands which have been registered. This method is used by
     * method LogoInterpreter.repaint().
     */
    @Override
    public Iterable<TurtleCommand> getCommands() {
        return undoStack;
    }
}
