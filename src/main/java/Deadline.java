import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 * Represents a Deadline task.
 * A Deadline task is a simple task with a description and a deadline.
 */
public class Deadline extends Task {

    protected LocalDate by;

    /**
     * Constructs a new Deadline task with the specified description and deadline.
     *
     * @param description The description of the Deadline task.
     * @param by The deadline of the Deadline task.
     */
    public Deadline(String description, LocalDate by) {
        super(description);
        this.by = by;
    }

    /**
     * Returns a string representation of the Deadline task.
     *
     * @return A string in the format "[D][statusIcon] description (by: date)".
     */
    @Override
    public String toString() {
        return "[D]" + super.toString() + " (by: " + this.by.format(DateTimeFormatter.ofPattern("MMM d yyyy")) + ")";
    }
}
