public abstract class Task implements Completable {

    private int id;
    private int userId;
    private String title;
    private boolean completed;

    public Task(int id, int userId, String title) {
        this.id = id;
        this.userId = userId;
        this.title = title;
        this.completed = false;
    }

    public int getId() { return id; }
    public int getUserId() { return userId; }
    public String getTitle() { return title; }
    public boolean isCompleted() { return completed; }

    @Override
    public void markCompleted() {
        completed = true;
    }

    
    public abstract boolean isUpcoming();
    public abstract String toCSV();
    public abstract void display();
}