/*
lc
Contains data for each individual task including its name, description, subject, and estimated completion time.

 */
public class Task {
    private int length;
    private String title;
    private String description;
    private Subject sub;
    
    public Task(String t, String d, int l, Subject s){
        length = l;
        title = t;
        description = d;
        sub = s;
    }
    
    public int getLength(){
        return length;
    }
    
    public String getTitle(){
        return title;
    }
    
    public String getDescription(){
        return description;
    }
        
    public void editTask(String t, String d, int time){
        title = t;
        description = d;
        length = time;
    }
    
    
    public Subject getSub(){
        return sub;
    }
    
    public String toString(){
        return title + ": /n" + description + "/nEstimated time: " + length + " minutes";
    }
    
}
