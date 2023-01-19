package com.redhat.ldemasi.examples;

import org.apache.camel.BindToRegistry;
import org.apache.camel.builder.RouteBuilder;

import java.util.concurrent.atomic.AtomicInteger;

public class TimerRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {
        from("timer:foo?fixedRate=true&period=6000")
                .id("timerFoo")
                .to("direct:create1")
                .to("direct:create2");

        from("direct:getId")
                .routeId("getId")
                .setHeader("id",simple("${bean:id?method=getAndIncrement}"));

        from("direct:logOriginalRequest")
                .routeId("logOriginalRequest")
                .log("${header.routeId}: This is the original request with id ${header.id}");
    }
}
