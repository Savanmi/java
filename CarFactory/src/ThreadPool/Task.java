package ThreadPool;

public interface Task {
    String getName();
    void performWork() throws InterruptedException;
}