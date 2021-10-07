package org.acme.rest.json;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

import javax.inject.Inject;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;

@Path("/customers")
public class CustomerResource {

    @Inject
    MeterRegistry registry;

    private Set<Customer> customers = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public CustomerResource() {
        customers.add(new Customer("1", "Johnny", "hoofdstraat 1", "5361AX", "Amersfoort", "0612345678", "johnny@example.com"));
        customers.add(new Customer("2", "Miep", "hoofdstraat 1", "5361AX", "Amersfoort", "0612345678", "miep@example.com"));
    }

    @GET
    public Response list() {
        registry.counter("get_all_customers_counter").increment();
        return Response.ok(customers).build();
    }

    @POST
    public Response add(Customer customer) {
        try {
            customers.add(customer);
        } catch (Exception e) {
            return Response.serverError().build();
        }
        return Response.ok(customers).build();
    }

    @DELETE
    public Response delete(Customer customer) {
        customers.removeIf(existingFruit -> existingFruit.name.contentEquals(customer.name));
        return Response.ok(customers).build();
    }
}