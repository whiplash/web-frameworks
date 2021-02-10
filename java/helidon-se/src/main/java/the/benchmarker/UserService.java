package the.benchmarker;

import io.helidon.config.Config;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class UserService implements Service {

    UserService(Config config) {
        super();
    }

    @Override
    public void update(Routing.Rules rules) {
        rules
                .get("/{id}", this::getMessageHandler)
                .post("/", this::updateGreetingHandler);
    }

    private void getMessageHandler(ServerRequest request, ServerResponse response) {
        String id = request.path().param("id");
        sendResponse(response, id);
    }

    private void updateGreetingHandler(ServerRequest request,
                                       ServerResponse response) {
        response.send("");
    }

    private void sendResponse(ServerResponse response, String name) {
        response.send(name);
    }

}