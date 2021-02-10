package the.benchmarker;

import io.helidon.config.Config;
import io.helidon.webserver.Routing;
import io.helidon.webserver.WebServer;

public final class Main {

    private Main() {
    }

    public static void main(final String[] args) {
        startServer();
    }

    static WebServer startServer() {

        // By default this will pick up application.yaml from the classpath
        Config config = Config.create();

        WebServer server = WebServer.builder(createRouting(config))
                .config(config.get("server"))
                .build();

        // Try to start the server. If successful, print some info and arrange to
        // print a message at shutdown. If unsuccessful, print the exception.
        server.start()
                .thenAccept(ws -> {
                    System.out.println(
                            "WEB server is up at port: " + ws.port());
                    ws.whenShutdown().thenRun(()
                            -> System.out.println("WEB server is DOWN. Good bye!"));
                })
                .exceptionally(t -> {
                    System.err.println("Startup failed: " + t.getMessage());
                    t.printStackTrace(System.err);
                    return null;
                });

        return server;
    }

    private static Routing createRouting(Config config) {
        RootService rootService = new RootService(config);
        UserService userService = new UserService(config);

        return Routing.builder()
                .register("/", rootService)
                .register("/user", userService)
                .build();
    }
}
