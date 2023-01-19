package com.redhat.ldemasi.examples;

import org.apache.camel.BindToRegistry;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.model.RouteDefinition;

import java.util.concurrent.atomic.AtomicInteger;

public abstract class MyAbstractRouteBuilder extends RouteBuilder {


    @BindToRegistry("id")
    private AtomicInteger id = new AtomicInteger(1);

    @Override
    public void configure() throws Exception {
        RouteDefinition route = from(getFrom()).routeId(getRouteId())
                .setHeader("routeId",constant(getRouteId()))
                .to("direct:getId")
                .to("direct:logOriginalRequest");

        extendRoute(route);
    }

    protected abstract String getRouteId();

    protected abstract String getFrom();

    protected abstract void extendRoute(RouteDefinition route);

}
