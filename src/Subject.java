/*
ADTS LinkedListProject
Task manager/to do list organizer
Nov/Dec 2022
Ella Chi

Subject Class
Contains data for each subject/category of tasks, including its name, to do list and completed list.
 */
public class Subject {
    private String name;
    private List toDo;
    private List completed;
    
    //constructor
    public Subject(String n){
        name = n;
        toDo = new List();
        completed = new List();
    }
    
    //add task to end of to do list
    public void addTask(Task t){
        toDo.addLast(t);
    }
    
    //complete top task of to do list and add to completed list; return completed task
    public Task completeTask(){
        Task comp = (Task)toDo.remove(0);
        completed.addLast(comp);
        return comp;
    }
    
    //add a task to completed list
    public void addCompleted(Task t){
        completed.addLast(t);
    }
    
    //clear all tasks
    public void clear(){
        toDo = new List();
        completed = new List();
    }
    
    //return number of tasks to do
    public int numTasks(){
        return toDo.size();
    }
    
    //return name of task
    public String getTitle(){
        return name;
    }
    
    //return list to do
    public List toDo(){
        return toDo;
    }
    
    //return completed list of tasks
    public List completed(){
        return completed;
    }
    
    public String toString(){
        return name;
    }
    
    
        
}
