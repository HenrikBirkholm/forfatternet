package hnni.forfatternet.com;

import static spark.Spark.*;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {
        //Spark uses filters to intercept any route, lets add a filter for "before" we need to register a Filter that sets the JSON Content-Type.
        before((request, response) -> response.type("application/json"));

        //Route to greeting
        get("/greeting", (request, response) -> new Greeting(1, "Hello, World!"), new JsonTransformer());
        post("/greeting", (request, response) -> new Greeting(2, "Hello I'm Adding, " + request.queryParams("name")), new JsonTransformer());
        put("/greeting", (request, response) -> new Greeting(3, "Hello I'm Updating, " + request.queryParams("name")), new JsonTransformer());
        delete("/greeting", (request, response) -> new Greeting(4, "Hello I'm Deleting, " + request.queryParams("name")), new JsonTransformer());

        post("/author", (request, response) -> new Author(request.queryParams("name")), new JsonTransformer());
        post("/authors", (request, response) -> new Authors(request.queryParams("list")), new JsonTransformer());


    }
}