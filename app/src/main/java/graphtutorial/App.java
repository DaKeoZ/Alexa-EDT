package graphtutorial;

import com.microsoft.graph.models.extensions.*;
import com.microsoft.graph.requests.extensions.GraphServiceClient;

import java.io.IOException;
import java.util.Properties;

public class App {

    public App() {

        final Properties oAuthProperties = new Properties();
        try {
            oAuthProperties.load(App.class.getResourceAsStream("oAuth.properties"));
        } catch (IOException e) {
            System.out.println("Unable to read OAuth configuration. Make sure you have a properly formatted oAuth.properties file. See README for details.");
            return;
        }

        final String appId = oAuthProperties.getProperty("app.id");
        final String[] appScopes = oAuthProperties.getProperty("app.scopes").split(",");

        Authentication.initialize(appId);
        final String accessToken = Authentication.getUserAccessToken(appScopes);

        User user = Graph.getUser(accessToken);

        IGraphServiceClient graphClient = GraphServiceClient.builder().authenticationProvider( Graph.authProvider ).buildClient();

        Calendar calendar = new Calendar();
        calendar.name = "EDT";

        graphClient.me().calendar()
                .buildRequest()
                .patch(calendar);

    }

}
