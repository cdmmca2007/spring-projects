package com.example.restapi.springbootapp.controller.v1;

import com.example.restapi.springbootapp.dto.Greeting;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;

import java.util.concurrent.atomic.AtomicLong;

@RestController
///@RequestMapping("v1/greeting")
@SecurityRequirement(name = "javainuseapi")
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();

    @Operation(summary = "Returns a greeting message")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(type = "object"))) })
    @GetMapping(value = "/message", produces = { "application/json" })
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @Operation(summary = "Returns a greeting message from Chandra")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "successful operation", content = @Content(schema = @Schema(type = "object"))) })
    @GetMapping(value = "/messageTest", produces = { "application/json" })
    public Greeting greetingFromChandra(@RequestParam(value = "name", defaultValue = "World") String name) {
        return new Greeting(counter.incrementAndGet(), String.format(template, name));
    }
    
    @ResponseBody
    @GetMapping(value = "/swagger/test")
    public String getMessage(){
    	return "Hello Chandra";
    }
    
    
}
