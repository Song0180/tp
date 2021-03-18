package seedu.duke.command;

import org.junit.jupiter.api.Test;
import seedu.duke.exception.TypeException;

import java.text.ParseException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.command.CommandRecordType.EXERCISE;

public class AddCommandTest {
    @Test
    public void addCommand_throwsParseException() {
        HashMap<String, String> params = new HashMap<>();
        params.put("activity", "dance");
        params.put("duration", "50");
        params.put("date", "abcde");
        assertThrows(ParseException.class, () -> {
            new AddCommand(EXERCISE, params);
        });
    }

    @Test
    public void addCommand_throwsNumberFormatException() {
        HashMap<String, String> params = new HashMap<>();
        params.put("activity", "dance");
        params.put("duration", "50min");
        assertThrows(NumberFormatException.class, () -> {
            new AddCommand(EXERCISE, params);
        });
    }
}
