package by.weather.service;
import byb.weather.cadence.liba.workflow.service.WeatherWorkflowService;
import com.uber.cadence.client.WorkflowClient;
import com.uber.cadence.client.WorkflowClientOptions;
import com.uber.cadence.serviceclient.ClientOptions;
import com.uber.cadence.serviceclient.WorkflowServiceTChannel;
import org.springframework.stereotype.Service;


@Service
public class MainWorkerService {

    public Long getCityTemperature(String cityName) {

        WorkflowClient workflowClient = WorkflowClient.newInstance(
                new WorkflowServiceTChannel(ClientOptions.defaultInstance()),
                WorkflowClientOptions.newBuilder().setDomain("test-domain").build());

        WeatherWorkflowService weatherWorkflow = workflowClient.newWorkflowStub(WeatherWorkflowService.class);

        return weatherWorkflow.getWeatherByCity(cityName, "url");


    }
}
