package ua.edu.sumdu.j2se.nikolaienko.tasks;

public class Task {
    private String title;
    private int time;
    private int start;
    private int end;
    private int interval;
    private boolean active;
    private boolean repeated;

    // Конструктор для неактивної задачі, що виконується
    // у заданий час без повторень

    public Task (String title, int time){
        this.title = title;
        this.time = time;
    }

    // Конструктор для неактивної задачі, що виконується у заданому
    // проміжку часу (початок і кінець) із заданим інтервалом

    public Task (String title, int start, int end, int interval){
        this.title = title;
        this.start = start;
        this.end = end;
        this.interval = interval;
        this.repeated = true;
    }

    // Методи для зчитування та встановлення назви задачі

    public String getTitle(){
        return title;
    }

    public void setTitle(String title){
        this.title = title;
    }

    // Метод для зчитування стану задачі

    public boolean isActive(){
        return active;
    }

    //Метод встановлення стану задвчі

    public void setActive(boolean active){
        this.active = active;
    }

    // Методи для зчитування та зміни часу виконання неповторюваних задач
    public int getTime(){
        if(repeated) return start;
        else return time;

    }

    public void setTime(int time) {
        this.time = time;
        if(repeated){
            this.repeated = false;
            this.interval = 0;
            this.start = 0;
            this.end = 0;
        }
    }

    // Методи для зчитування та зміни часу виконання задач, що повторюються

    public int getStartTime(){
        if(repeated) return start;
        else return time;
    }
    public int getEndTime(){
        if(repeated) return end;
        else return time;
    }

    // (повертає 0 для неповторюваної задачі)
    public int getRepeatInterval(){
        if(repeated) return interval;
        else return 0;
    }

    // (перетворює неповторювану задачу в повторювану)
    public void setTime(int start, int end, int interval){
        if(repeated){
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
        else {
            this.repeated = true;
            this.start = start;
            this.end = end;
            this.interval = interval;
        }
    }

    // метод для перевірки повторюваності задач
    public boolean isRepeated() {
        return repeated;
    }

    //Метод для повернення часу наступного виконання задачі
    public int nextTimeAfter(int current){
        if (current < (end-interval)){
            return (((current-start)/interval+1)*interval+start);
        }
        else return -1;
    }
}