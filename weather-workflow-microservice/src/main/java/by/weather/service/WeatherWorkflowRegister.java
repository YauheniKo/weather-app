package by.weather.service;



import byb.weather.cadence.liba.activity.service.WeatherActivityService;
import byb.weather.cadence.liba.workflow.service.WeatherWorkflowService;
import byb.weather.cadence.liba.workflow.service.WeatherWorkflowServiceImpl;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import com.uber.cadence.worker.Worker;
import com.uber.cadence.worker.WorkerFactory;

public class WeatherWorkflowRegister {


    public void registerWorkFlow() {

        WorkflowClient workflowClient = WorkflowClient.newInstance(
                new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                WorkflowClientOptions.newBuilder().setDomain("test-domain").build());

        WorkerFactory factory = WorkerFactory.newInstance(workflowClient);
        Worker worker = factory.newWorker(WeatherWorkflowService.workflowTaskList);
        worker.registerWorkflowImplementationTypes(WeatherWorkflowServiceImpl.class);
    }

}





