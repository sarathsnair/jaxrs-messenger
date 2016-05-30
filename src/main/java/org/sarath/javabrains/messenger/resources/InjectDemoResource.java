package org.sarath.javabrains.messenger.resources;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.MatrixParam;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;

/*Different methods for accessing Params values
 * @MatrixParam, @HeaderParam and @CookieParam
 * @Context is used to get all the details of the current URL and Headers - We can get the required data such as 
 * QueryParams and HeaderInfo using getters of the class
 * */

@Path("/injectdemo")
@Consumes(MediaType.TEXT_PLAIN)
@Produces(MediaType.TEXT_PLAIN)
public class InjectDemoResource {

	@GET
	@Path("annotations")
	public String getParamsUsingAnnotations(@MatrixParam("param") String param,
			@HeaderParam("customHeaderValue") String header) {
		return "Matrix Param :" + param + " Heade Value is " + header;
	}

	@GET
	@Path("context")
	public String getParamsUsingContext(@Context UriInfo uriInfo, @Context HttpHeaders headers) {
		String path = uriInfo.getAbsolutePath().toString();
		String header = headers.getRequestHeaders().toString();
		return "Path : " + path + "\nHeaders : " + header;
	}
}
