
package io.helidon.examples.quickstart.se;

import io.helidon.config.Config;
import io.helidon.webserver.Routing;
import io.helidon.webserver.ServerRequest;
import io.helidon.webserver.ServerResponse;
import io.helidon.webserver.Service;

public class BenchmarkService implements Service {

    BenchmarkService(Config config) {
        super();
    }

    @Override
    public void update(Routing.Rules rules) {
        rules
            .get("/", this::getRoot)
            .get("/user/{id}", this::getUser)
            .post("/user", this::postUser);
    }

    private void getRoot(ServerRequest request, ServerResponse response) {
        sendResponse(response, "");
    }

    private void getUser(ServerRequest request, ServerResponse response) {
        sendResponse(response, request.path().segments().get(1)); //TODO there might be better ways
    }

    private void postUser(ServerRequest request, ServerResponse response) {
        sendResponse(response, "");
    }

    private void sendResponse(ServerResponse response, String name) {
        response.send(name);
    }

}