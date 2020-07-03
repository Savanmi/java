package Collector;

import Details.AccessoryDetail;
import Details.BodyDetail;
import Details.MotorDetail;
import ThreadPool.Task;

public class CollectorTask implements Task {
    Collector collector;

    public CollectorTask(Collector collector) {
        this.collector = collector;
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public void performWork() throws InterruptedException {
        BodyDetail bodyDetail = collector.getBodyStorage().poll();
        MotorDetail motorDetail = collector.getMotorStorage().poll();
        AccessoryDetail accessoryDetail = collector.getAccessoryStorage().poll();

        collector.getAutoStorage().addAuto(bodyDetail, motorDetail, accessoryDetail);
    }
}
