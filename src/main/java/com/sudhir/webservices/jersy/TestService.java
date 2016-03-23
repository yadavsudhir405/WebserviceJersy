package com.sudhir.webservices.jersy;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;

import org.springframework.util.MultiValueMap;

import javax.ws.rs.core.Response.Status;

import com.sudhir.model.SplitterDTO;

@Path("/test/{userName}")
@Produces("text/plain")
public class TestService {

	@GET
	public String getUserName(@PathParam("userName") String name) {
		System.out.println("Executing text plain");
		return name;

	}

	@GET
	@Produces("application/xml")
	public Response getUserNameasXML(@PathParam("userName") String name) {
		System.out.println("Executing XML");
		SplitterDTO splitterDTO = new SplitterDTO();
		splitterDTO.setUserName("Sudhiris056");
		splitterDTO.setCity("Bangalore");
		splitterDTO.setFullName("Sudhir");

		return Response.status(Status.OK).entity(splitterDTO).build();
	}

	@POST
	@Consumes({ "application/xml", "text/plain" })
	public void addSplitterDTO(String xmlSplitterDTON) {
		System.out.println(xmlSplitterDTON);
	}

	@Path("extra")
	@GET
	@Produces("text/plain")
	public String getResponse() {
		System.out.println("Executed xtra getResponse");
		return "from extra getResponse";
	}

	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Path("smooth")
	public Response getQueryParame(@DefaultValue("sudhiris056") @QueryParam("userName") String userName, @DefaultValue("Bangalore") @QueryParam("city") String city,
			@DefaultValue("Sudhir Yadav") @QueryParam("fullName") String fullName, @QueryParam("names") List<String> nameList) {
		System.out.println("Entered Parameter userName==" + userName);
		SplitterDTO splitterDTO = new SplitterDTO();
		if (nameList != null) {
			System.out.println("List Size==" + nameList.size());
		} else {
			System.out.println("nameList is null");
		}
		splitterDTO.setUserName(userName);
		splitterDTO.setCity(city);
		splitterDTO.setFullName(fullName);
		return Response.status(Status.OK).entity(splitterDTO).build();
	}

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("headerParam")
	public Response getHeaderParam(@HeaderParam("headerContent") String headerContent) {
		return Response.status(Status.OK).entity(headerContent).build();
	}
	
	@POST
	@Produces(MediaType.TEXT_PLAIN)
	@Consumes("application/x-www-form-urlencoded")
	@Path("processFormData")
	/*public Response processFormData(@FormParam("userName") String userName){
		System.out.println(userName);
		return Response.status(Status.OK).entity(userName).build();
	}*/
	public Response processFormData(@Context UriInfo uriInfo){
		MultivaluedMap<String,String> pathParameters=uriInfo.getPathParameters();
		System.out.println("Printing PathParamaters");
		System.out.println(pathParameters.get("userName").get(0));
		return Response.status(Status.OK).entity("Success").build();
	}
	@Path("processString")
	@POST
	@Consumes("text/plain")
	@Produces("text/plain")
	public Response processBodyMessage(String inputMessage){
		return Response.status(Status.OK).entity(inputMessage).build();
	}

}
