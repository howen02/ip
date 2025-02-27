import commands.Command;
import exception.DukeException;
import main.Parser;
import main.Storage;
import objects.TaskList;

/**
 * The Duke class serves as the main entry point for the Duke application.
 * It initializes the necessary components, interacts with the user through the command-line interface,
 * and manages the parsing and storage of tasks.
 */
public class Duke {
    public Duke() {}

    /**
     * The main method serves as the entry point for the Duke application.
     * It initializes the necessary components, interacts with the user through the command-line interface,
     * and manages the parsing and storage of tasks.
     * @param args Command-line arguments.
     */
    public static void main(String[] args) {
        Launcher.main(args);
    }

    /**
     * Processes user input and generates a response accordingly.
     * @param input User input to process.
     * @return Response generated by Duke based on the input.
     */
    public String getResponse(String input) {
        TaskList tasks = Storage.load();
        String response;
        Command c;

        try {
            c = Parser.parse(input, tasks);
            response = c.execute();
            Storage.save(tasks);

        } catch (DukeException e) {
            response = e.getMessage();

        }

        return response;
    }
}
