package com.redhat.ldemasi.examples;

import org.apache.camel.model.RouteDefinition;

public class MyRouteBuilder2 extends MyAbstractRouteBuilder {


    @Override
    protected String getRouteId() {
        return "create2";
    }

    @Override
    protected String getFrom() {
        return "direct:create2";
    }

    @Override
    protected void extendRoute(RouteDefinition route) {
        route
                .setHeader("route2",constant("This is Route 2"))
                .log("This is route 2");

    }
}
