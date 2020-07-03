package Collector;

import Details.AccessoryDetail;
import Details.BodyDetail;
import Details.MotorDetail;
import Storage.AutoStorage;
import Storage.Storage;
import ThreadPool.ThreadPool;

public class Collector {
    private Storage<BodyDetail> bodyStorage;
    private Storage<MotorDetail> motorStorage;
    private Storage<AccessoryDetail> accessoryStorage;
    private AutoStorage carStorage;

    private ThreadPool threadPool;

    public Collector(Storage<BodyDetail> bodyStorage, Storage<MotorDetail> motorStorage,
                     Storage<AccessoryDetail> accessoryStorage, AutoStorage carStorage) {
        this.bodyStorage = bodyStorage;
        this.motorStorage = motorStorage;
        this.accessoryStorage = accessoryStorage;
        this.carStorage = carStorage;
        threadPool = new ThreadPool();
    }

    public void collectAuto() {
        if (threadPool.getTaskQueue().size() < 1000) {
            threadPool.addTask(new CollectorTask(this));
        }
    }

    public Storage<BodyDetail> getBodyStorage() {
        return bodyStorage;
    }

    public Storage<MotorDetail> getMotorStorage() {
        return motorStorage;
    }

    public Storage<AccessoryDetail> getAccessoryStorage() {
        return accessoryStorage;
    }

    public AutoStorage getAutoStorage() {
        return carStorage;
    }
}
