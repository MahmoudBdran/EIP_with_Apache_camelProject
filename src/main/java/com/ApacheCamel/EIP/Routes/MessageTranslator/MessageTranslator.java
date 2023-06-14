package com.ApacheCamel.EIP.Routes.MessageTranslator;

import org.apache.camel.builder.RouteBuilder;
import org.springframework.stereotype.Component;

//@Component
public class MessageTranslator extends RouteBuilder {
    //in this task I will append or prepend a string to file content and move it to our dest. folder

    @Override
    public void configure() throws Exception {

        from("file:D:/tryToLearnCamel/MessageTranslator?delete=true")
                .transform(body().prepend("Custom Message: "))
                .to("file:D:/dest/MessageTranslator");
    }
}
