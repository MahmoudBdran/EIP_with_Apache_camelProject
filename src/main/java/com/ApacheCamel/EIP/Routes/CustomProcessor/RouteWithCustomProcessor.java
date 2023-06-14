package com.ApacheCamel.EIP.Routes.CustomProcessor;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class RouteWithCustomProcessor extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("file:D:/tryToLearnCamel/CustomProcessor")
                .process(new CustomProcessor())
                .to("file:D:/dest/CustomeProcessor");
    }
}
