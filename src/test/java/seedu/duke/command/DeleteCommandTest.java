package seedu.duke.command;

import org.junit.jupiter.api.Test;

import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static seedu.duke.command.CommandRecordType.EXERCISE;

class DeleteCommandTest {
    @Test
    public void seleteCommand_throwsNumberFormatException() {
        HashMap<String, String> params = new HashMap<>();
        params.put("index", "abc");
        assertThrows(NumberFormatException.class, () -> {
            new DeleteCommand(EXERCISE, params);
        });
    }
}