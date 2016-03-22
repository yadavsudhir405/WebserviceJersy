package com.sudhir.webservices.jersy;

import java.util.List;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sudhir.common.ApplicationContextUtil;
import com.sudhir.dao.entity.SplitterEntity;
import com.sudhir.dao.service.SplitterEntityService;

/**
 * Root resource (exposed at "myresource" path)
 */
@Component
@Path("myresource")
public class SplitterRestService {

	//private SplitterEntityService splitterEntityService = (SplitterEntityService) ApplicationContextUtil.ctx.getBean("splitterEntityService");
	@Autowired
	private SplitterEntityService splitterEntityService;
	/**
	 * Method handling HTTP GET requests. The returned object will be sent to
	 * the client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIt() {

		List<SplitterEntity> list = splitterEntityService.getAllSplitter();
		return Response.status(201).entity(list).build();
	}
}
