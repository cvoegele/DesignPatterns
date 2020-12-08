package logo;

import logo.commands.Command;
import logo.commands.control.NotFoundCommand;
import logo.commands.turtle.CompositeCommand;
import logo.commands.turtle.TurtleCommand;

import java.util.HashMap;
import java.util.Map;

public class StdMacroManager implements MacroManager {
    private final LogoInterpreter interpreter;

    public StdMacroManager(LogoInterpreter interpreter) {
        this.interpreter = interpreter;
        macros = new HashMap<>();
    }

    private final Map<String, CompositeCommand> macros;
    private boolean isRecording = false;
    private CompositeCommand recording;

    /**
     * Indicates whether a macro is currently being recorded.
     */
    @Override
    public boolean isRecordingMacro() {
        return isRecording;
    }

    /**
     * Adds a command to the current macro. If this method is invoked while no
     * macro is being recorded, then a NullPointerException should be thrown.
     */
    @Override
    public void addCommand(TurtleCommand command) {
        // TODO store the command provided by the parameter in the list of commands
        if (!isRecording) throw new NullPointerException("No macro is being recorded");
        recording.add(command);
    }

    /**
     * Starts the recording of a new macro.
     */
    @Override
    public void startMacro(String name) {
        // TODO generate a new data structure to store a sequence of TurtleCommands
        isRecording = true;
        recording = new CompositeCommand(name);
    }

    /**
     * Closes the recording of the current macro and registers the macro under its
     * name.
     */
    @Override
    public void endMacro() {
        isRecording = false;
        macros.put(recording.getName(), recording);
    }

    /**
     * Returns the macro command with a given name. If no macro can be found with
     * this name, then a NotFoundCommand is returned.
     */
    @Override
    public Command getCommand(String name) {
        // TODO retrieve the macro with the name provided from the store (e.g. a map)
        if (!macros.containsKey(name)) {
            return macros.get(name);
        } else {
            return new NotFoundCommand(name);
        }
    }
}
