package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

public class InvalidCommand extends Command {

    public InvalidCommand(String errorMessage) {
        feedback = errorMessage;
    }

    public InvalidCommand(CommandType commandType) {
        switch (commandType) {
        case ADD:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_ADD_COMMAND;
            break;
        case VIEW:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_VIEW_COMMAND;
            break;
        case DELETE:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_SYNTAX_DELETE_COMMAND;
            break;
        default:
            feedback = Messages.MESSAGE_SYSTEM_ERROR;
        }
    }

    @Override
    public CommandResult execute(FitCenter fitCenter) {
        return new CommandResult(feedback);
    }
}
