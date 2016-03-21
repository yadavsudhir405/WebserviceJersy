package com.sudhir.webservices.jersy;

import java.util.ArrayList;
import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sudhir.model.TestModel;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
@Path("myresource")
public class MyResource {
	@Autowired
	private Hello testmodel;

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIt() {
		List<TestModel> list=new ArrayList<TestModel>();
		list.add(testmodel.getMessage());
		list.add(testmodel.getMessage());
		list.add(testmodel.getMessage());
		return Response.status(201).entity(list).build();
	}
}
