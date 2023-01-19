package com.redhat.ldemasi.examples;

import org.apache.camel.model.RouteDefinition;

public class MyRouteBuilder1 extends MyAbstractRouteBuilder {


    @Override
    protected String getRouteId() {
        return "create1";
    }

    @Override
    protected String getFrom() {
        return "direct:create1";
    }

    @Override
    protected void extendRoute(RouteDefinition route) {
        route
                .setHeader("route1",constant("This is Route 1"))
                .log("This is route 1");
    }
}
