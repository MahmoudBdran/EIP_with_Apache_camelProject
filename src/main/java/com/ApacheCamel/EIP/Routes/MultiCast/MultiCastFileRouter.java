package com.ApacheCamel.EIP.Routes.MultiCast;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MultiCastFileRouter extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:D:/tryToLearnCamel/MultiCastRouter")
                .multicast()
                .to("direct:append","direct:prepend").end();

        //first route (append)
        from("direct:append")
                .transform(body().append(": appended message"))
                .to("file:D:/dest/MultiCastRouter/appendedMessageFolder");

        //sec. route (prepend)
        from("direct:prepend")
                .transform(body().prepend("prepended message : "))
                .to("file:D:/dest/MultiCastRouter/prependedMessageFolder");


    }
}
