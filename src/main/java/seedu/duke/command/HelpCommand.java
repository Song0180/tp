package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

public class HelpCommand extends Command {
    public HelpCommand() {
        feedback = Messages.MESSAGE_HELP_GREETINGS + "\n"
                + Messages.MESSAGE_SYNTAX_ADD_COMMAND + "\n\n"
                + Messages.MESSAGE_SYNTAX_VIEW_COMMAND + "\n\n"
                + Messages.MESSAGE_SYNTAX_DELETE_COMMAND;
    }

    @Override
    public CommandResult execute(FitCenter fitCenter) {
        return new CommandResult(feedback);
    }
}
