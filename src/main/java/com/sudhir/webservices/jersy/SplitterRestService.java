package com.sudhir.webservices.jersy;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;
import com.sudhir.dao.entity.SplitterEntity;
import com.sudhir.dao.service.SplitterEntityService;
import com.sudhir.model.SplitterDTO;
import com.sudhir.model.services.SplitterDTOService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
@Path("myresource")
public class SplitterRestService {

	//private SplitterEntityService splitterEntityService = (SplitterEntityService) ApplicationContextUtil.ctx.getBean("splitterEntityService");
	@Autowired
	private SplitterEntityService splitterEntityService;
	
	private static final Gson GSON=new Gson();
	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIt() {
		System.out.println("Inside WebService");
		List<SplitterEntity> list = splitterEntityService.getAllSplitter();
		return Response.status(javax.ws.rs.core.Response.Status.ACCEPTED).entity(list).build();
	}
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public Response add(String inputJson){
		System.out.println(inputJson);
		SplitterDTO splitterDTO=SplitterDTOService.getSplitterDTO(inputJson);
		SplitterEntity splitterEntity=new SplitterEntity();
		splitterEntity.setUserName(splitterDTO.getUserName());
		splitterEntity.setCity(splitterDTO.getCity());
		splitterEntity.setFullName(splitterDTO.getFullName());
		try{
			splitterEntityService.addSplitter(splitterEntity);
			return Response.status(Status.OK).entity("Success").build();
		}catch(Exception e){
			return Response.status(Status.INTERNAL_SERVER_ERROR).build();
		}
		
	}
}
