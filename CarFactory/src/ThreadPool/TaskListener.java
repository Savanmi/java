package ThreadPool;

public interface TaskListener {
    void taskInterrupted(Task t);
    void taskFinished(Task t);
    void taskStarted(Task t);
}

