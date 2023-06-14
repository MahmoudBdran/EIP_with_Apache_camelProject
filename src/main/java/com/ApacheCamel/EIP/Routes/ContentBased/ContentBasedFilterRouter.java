package com.ApacheCamel.EIP.Routes.ContentBased;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class ContentBasedFilterRouter extends RouteBuilder {
//which routes a message to its dest. accordin to message header, payload or its content.

    @Override
    public void configure() throws Exception {
        from("file:D:/tryToLearnCamel/contentBasedRouter")
                .choice()
                .when(simple("${file:ext} == 'txt'"))
                .to("file:D:/dest/contentBasedRouter/txtfiles").otherwise()
                .to("file:D:/dest/contentBasedRouter/otherfiles");


    }
}
