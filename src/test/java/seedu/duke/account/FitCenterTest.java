package seedu.duke.account;

import org.junit.jupiter.api.Test;
import seedu.duke.command.CommandRecordType;
import seedu.duke.common.Messages;

import static org.junit.jupiter.api.Assertions.*;

class FitCenterTest {

    @Test
    void getRecordListString() {
        FitCenter fitCenter = new FitCenter();
        CommandRecordType type = CommandRecordType.SLEEP;
        assertEquals(Messages.MESSAGE_NO_RECORD, fitCenter.getRecordListString(type));
    }
}