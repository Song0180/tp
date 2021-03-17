package seedu.duke.command;

import seedu.duke.account.FitCenter;
import seedu.duke.common.Messages;

public class InvalidCommand extends Command {
    private final String feedback;

    public InvalidCommand(String errorMessage) {
        feedback = errorMessage;
    }

    public InvalidCommand(CommandType commandType) {
        switch (commandType) {
        case ADD:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_INVALID_ADD_COMMAND;
            break;
        case VIEW:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_INVALID_VIEW_COMMAND;
            break;
        case DELETE:
            feedback = Messages.MESSAGE_INVALID_COMMAND_SYNTAX + Messages.MESSAGE_INVALID_DELETE_COMMAND;
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
