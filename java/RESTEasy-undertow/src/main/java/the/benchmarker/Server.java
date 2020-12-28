package the.benchmarker;

import io.undertow.Undertow;
import org.jboss.resteasy.plugins.server.undertow.UndertowJaxrsServer;

public class Server {

    public static void main(String[] args) {

        UndertowJaxrsServer server = new UndertowJaxrsServer();
        server.deploy(ExampleApplication.class);
        Undertow.Builder builder = Undertow.builder()
                .addHttpListener(3000, "localhost");

        server.start(builder);

    }

}
