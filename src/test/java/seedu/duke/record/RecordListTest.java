package seedu.duke.record;

import org.junit.jupiter.api.Test;
import seedu.duke.common.Messages;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RecordListTest {

    @Test
    void getRecordsToPrint() {
        RecordList list = new RecordList(RecordType.SLEEP);
        LocalDate date = LocalDate.now();
        assertEquals(Messages.MESSAGE_NO_RECORD, list.getRecordsToPrint(date));
    }
}