package by.weather.service;


import byb.weather.cadence.liba.activity.service.WeatherActivityService;
import byb.weather.cadence.liba.activity.service.WeatherActivityServiceImpl;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;

public class WeatherActivityRegister {

    public void registerActivity() {
        WorkflowClient workflowClient = WorkflowClient.newInstance(
                new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                WorkflowClientOptions.newBuilder().setDomain("test-domain").build());

        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);

        Worker worker = factory.newWorker(WeatherActivityService.activityTaskList);
        worker.registerActivitiesImplementations(new WeatherActivityServiceImpl());
        factory.start();
    }

}
