package command;

import fileHandler.FileHandler;
import task.Task;
import task.TaskList;

import java.util.Iterator;

/**
 * Represent a command of searching tasks that contain specified keywords
 */
public class FindCommand extends Command{
    private String keyword;
    private String feedbackFormat = "Here are the matching tasks in your list:";

    public FindCommand(String keyword){
        this.keyword = keyword;
    }

    /**
     * search task list for tasks whose name contain the keyword
     * @return feedback message and the list of tasks that contain the keyword
     */
    @Override
    public CommandResult execute(){
        TaskList relevantTasks = new TaskList();
        Iterator<Task> iterator = tasks.getIterator();
        while(iterator.hasNext()){
            Task currentTask = iterator.next();
            if(currentTask.getName().contains(keyword)){
                relevantTasks.addTask(currentTask);
            }
        }
        return new CommandResult(feedbackFormat,relevantTasks);
    }
}
