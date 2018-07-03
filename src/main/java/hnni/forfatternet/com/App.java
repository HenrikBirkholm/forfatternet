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

        //Route to author and authors
        post("/author", (request, response) -> new Author(request.queryParams("name")), new JsonTransformer());
        post("/authors", (request, response) -> new Authors(request.queryParams("list")), new JsonTransformer());


    }
}