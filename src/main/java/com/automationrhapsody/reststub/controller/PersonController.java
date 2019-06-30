package com.automationrhapsody.reststub.controller;

import com.automationrhapsody.reststub.data.Person;
import com.automationrhapsody.reststub.data.User;
import com.automationrhapsody.reststub.persistence.PersonDB;
import com.codahale.metrics.annotation.Timed;
import views.HelloView;
import views.UserView;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/person")
public class PersonController {

    public PersonController() {
    }

    @GET
    @Timed
    @Path("/hello/{name}")
    @Produces(MediaType.TEXT_HTML)
    public HelloView sayHello(@PathParam("name") String name) {
        return new HelloView(name);
    }


    @GET
    @Timed
    @Path("/get/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Person getPerson(@PathParam("id") int id) {
        return PersonDB.getById(id);
    }

    @GET
    @Timed
    @Path("/remove")
    @Produces(MediaType.TEXT_PLAIN)
    public String removePerson() {
        PersonDB.remove();
        return "Last person remove. Total count: " + PersonDB.getCount();
    }

    @GET
    @Timed
    @Path("/all")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Person> getPersons() {
        return PersonDB.getAll();
    }

    @POST
    @Timed
    @Path("/save")
    @Produces(MediaType.TEXT_PLAIN)
    @Consumes({MediaType.APPLICATION_JSON})
    public String addPerson(Person person) {
        return PersonDB.save(person);
    }


    @GET
    @Timed
    @Path("/")
    @Produces(MediaType.TEXT_HTML)
    public String index() {
        return "/form";
    }


    @GET
    @Timed
    @Path("form")
    public String formGet() {
        return "form";
    }


    @POST
    @Timed
    @Path("form")
    public UserView formPost(User user) {
        return new UserView(user);
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    @Timed
    @Path("/please")
    public Response addDocument(String myHello){
        Response response = Response.ok().build();
        return response;
    }
}