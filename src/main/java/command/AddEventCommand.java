package command;

import exception.DeadlineFormatException;
import exception.EventFormatException;
import exception.TaskFormatException;
import task.Deadline;
import task.Event;
import task.Task;
import task.TaskList;

public class AddEventCommand extends Command{
    private Event newEvent;
    private String feedbackFormat;

    public AddEventCommand(String name, String time){
        newEvent = new Event(name, false, time);
    }

    @Override
    public CommandResult execute() throws TaskFormatException {
        tasks.addTask(newEvent);
        feedbackFormat = "Event added:\n" + PRE_SPACE + PRE_SPACE + newEvent.getTaskInfo() + "\n" +
                PRE_SPACE + "Now you have " + tasks.getTaskCount() + " tasks in the list";
        return new CommandResult(feedbackFormat);
    }
}
