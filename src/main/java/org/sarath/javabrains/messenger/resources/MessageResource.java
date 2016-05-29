package org.sarath.javabrains.messenger.resources;

import java.util.List;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

import org.sarath.javabrains.messenger.model.Message;
import org.sarath.javabrains.messenger.service.MessageService;

@Path("/messages")
public class MessageResource {

	MessageService messageService = new MessageService();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Message> getMessages() {
		return messageService.getAllMessages();
	}
	
	@GET
	@Path("/{messageId}")
	@Produces (MediaType.APPLICATION_JSON)
	public Message getMessage(@PathParam("messageId") long  messageId){
		return messageService.getMessage(messageId);
	}
}
