package org.garen.tourist.swagger.api;

import io.swagger.annotations.*;
import org.garen.tourist.swagger.model.Order;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

@javax.annotation.Generated(value = "class io.swagger.codegen.languages.SpringCodegen", date = "2017-08-24T01:49:38.472Z")

@Api(value = "store", description = "the store API")
public interface StoreApi {

    @ApiOperation(value = "Delete purchase order by ID", notes = "For valid response try integer IDs with positive integer value.\\ \\ Negative or non-integer values will generate API errors", response = Void.class, tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Void.class),
        @ApiResponse(code = 404, message = "Order not found", response = Void.class) })
    @RequestMapping(value = "/store/order/{orderId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.DELETE)
    ResponseEntity<Void> deleteOrder(@ApiParam(value = "ID of the order that needs to be deleted", required = true) @PathVariable("orderId") Long orderId);


    @ApiOperation(value = "Returns pet inventories by status", notes = "Returns a map of status codes to quantities", response = Integer.class, responseContainer = "Map", authorizations = {
        @Authorization(value = "api_key")
    }, tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful tourist", response = Integer.class) })
    @RequestMapping(value = "/store/inventory",
        produces = { "application/json" }, 
        method = RequestMethod.GET)
    ResponseEntity<Map<String, Integer>> getInventory();


    @ApiOperation(value = "Find purchase order by ID", notes = "For valid response try integer IDs with value >= 1 and <= 10.\\ \\ Other values will generated exceptions", response = Order.class, tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful tourist", response = Order.class),
        @ApiResponse(code = 400, message = "Invalid ID supplied", response = Order.class),
        @ApiResponse(code = 404, message = "Order not found", response = Order.class) })
    @RequestMapping(value = "/store/order/{orderId}",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.GET)
    ResponseEntity<Order> getOrderById(@ApiParam(value = "ID of pet that needs to be fetched", required = true) @PathVariable("orderId") Long orderId);


    @ApiOperation(value = "Place an order for a pet", notes = "", response = Order.class, tags={ "store", })
    @ApiResponses(value = { 
        @ApiResponse(code = 200, message = "successful tourist", response = Order.class),
        @ApiResponse(code = 400, message = "Invalid Order", response = Order.class) })
    @RequestMapping(value = "/store/order",
        produces = { "application/json", "application/xml" }, 
        method = RequestMethod.POST)
    ResponseEntity<Order> placeOrder(@ApiParam(value = "order placed for purchasing the pet", required = true) @RequestBody Order body);

}
