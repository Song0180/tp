package seedu.duke.command;

import org.junit.jupiter.api.Test;

import java.text.ParseException;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.command.CommandRecordType.EXERCISE;

class ViewCommandTest {
    @Test
    public void viewCommand_throwsParseException() {
        HashMap<String, String> params = new HashMap<>();
        params.put("date", "abcde");
        assertThrows(ParseException.class, () -> {
            new ViewCommand(EXERCISE, params);
        });
    }
}