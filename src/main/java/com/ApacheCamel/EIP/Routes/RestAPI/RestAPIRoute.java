package com.ApacheCamel.EIP.Routes.RestAPI;

import com.ApacheCamel.EIP.Entity.Student;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jackson.JacksonDataFormat;
import org.springframework.stereotype.Component;

@Component
public class RestAPIRoute extends RouteBuilder {
    @Override
    public void configure() throws Exception {
        from("timer:delayTimer?repeatCount=1")
                .to("direct:start");

//        from("direct:start")
//                .to("http://localhost:9090/JustAString")
//                .convertBodyTo(String.class)
//                .to("file:D:/dest/RestApi?fileName=restResponse.txt")
//                .to("direct:getStudents");

        from("direct:start")
                .to("http://localhost:9090/students")
                .convertBodyTo(String.class)
                .to("file:D:/dest/RestApi?fileName=JsonStudent.txt");
    }
}
