package org.sarath.javabrains.messenger.resources;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.core.UriInfo;

import org.sarath.javabrains.messenger.model.Message;
import org.sarath.javabrains.messenger.resources.beans.MessageFilterBean;
import org.sarath.javabrains.messenger.service.MessageService;

/* Message Resource
 * ****************
 * Consumes - JSON, Response - JSON
 * 
 * @BeanParam is used to wrap the different @Params such as QueryParams in a specific class and
 * access those from MessageFilterBean class
 * 
 * 
 * */

@Path("/messages")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class MessageResource {

	MessageService messageService = new MessageService();

	@GET
	public List<Message> getMessages(@BeanParam MessageFilterBean filterBean) { 
		if (filterBean.getYear() > 0) {
			return messageService.getAllMessageForYear(filterBean.getYear());
		}
		if (filterBean.getStart() >= 0 && filterBean.getSize() > 0) {
			return messageService.getAllMessagesPaginated(filterBean.getStart(), filterBean.getSize());
		}
		return messageService.getAllMessages();
	}

	@GET
	@Path("/{messageId}")
	public Message getMessage(@PathParam("messageId") long messageId) {
		return messageService.getMessage(messageId);
	}

	@POST
	public Response addMessage(Message message, @Context UriInfo uriInfo)  {		/* Returns generic response object which adds the specific status code (201-CREATED) */
		Message newMessage = messageService.addMessage(message);
		String newId = String.valueOf(newMessage.getId());
		URI url = uriInfo.getAbsolutePathBuilder().path(newId).build();
		return Response.created(url) /* Here we are sending the location along with the response. Previously it was - return Response.status(Status.CREATED).entity(newMessage).build();*/
				.entity(newMessage)
				.build();
		//return messageService.addMessage(message);
	}

	@PUT
	@Path("/{messageId}")
	public Message updateMessage(@PathParam("messageId") long id, Message message) {
		message.setId(id);
		return messageService.updateMessage(message);
	}

	@DELETE
	@Path("/{messageId}")
	public void deleteMessage(@PathParam("messageId") long id) {
		messageService.removeMessage(id);
	}
	
	@Path("/{messageId}/comments")
	public CommentResource getCommentResource(){
		return new CommentResource();
	}

}
