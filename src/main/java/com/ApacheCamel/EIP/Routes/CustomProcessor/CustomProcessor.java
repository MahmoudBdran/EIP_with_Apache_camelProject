package com.ApacheCamel.EIP.Routes.CustomProcessor;


import org.apache.camel.Exchange;
import org.apache.camel.Processor;

public class CustomProcessor implements Processor {
    @Override
    public void process(Exchange exchange) throws Exception {
        String originalText = exchange.getIn().getBody(String.class);
        String modifiedText = originalText.toUpperCase();
        exchange.getIn().setBody(modifiedText);
    }
}
