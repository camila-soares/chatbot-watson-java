package services.handler;

import akka.actor.ActorRef;
import akka.actor.UntypedAbstractActor;


import com.ibm.watson.developer_cloud.conversation.v1.model.Context;
import com.ibm.watson.developer_cloud.conversation.v1.model.MessageResponse;
import com.ibm.watson.developer_cloud.conversation.v1.model.OutputData;

import models.chatsdk.Message;
import models.chatsdk.Payload;
import modules.UserContext;

import services.CacheApi;
import services.WatsonService;

import javax.inject.Inject;
import java.util.List;



public class MessageHandler extends UntypedAbstractActor {

    private final WatsonService watsonService;
    private final CacheApi cacheApi;


    @Inject
    public MessageHandler(WatsonService watsonService , CacheApi cacheApi) {
        this.watsonService = watsonService;
        this.cacheApi = cacheApi;
    }


    @Override
    public void onReceive(Object message)  {
            if(message instanceof UserContext){
                handleWatsonResponse ((UserContext) message );
            }else if (message instanceof Message){
                handlerUserMessage((Message) message);

            }
    }


    private void handleWatsonResponse(UserContext context) {
        MessageResponse response = context.getWatsonResponse();
        Context watsonContext = context.getContext ();
        boolean skipUserInput = Boolean.parseBoolean ( watsonContext.getOrDefault ( "skip_user_input", false ).toString () );
        if(skipUserInput)  watsonService.sendClientResponse ( context, getSender () );

        OutputData outputData = response.getOutput ();
        List<String> msg = outputData.getText ();
        msg.forEach ( text -> {
            Message message = new Message (  );

            message.setAction(Message.Action.TEXT);
            message.setText ( text );
            sendMessageToUser ( getSender (), context, null, message );
        } );

        }

    private void sendMessageToUser(ActorRef sender , UserContext context , String textForLog , Message messageCli) {
        sender.tell ( messageCli, self () );
        context.getWatsonResponse ();
    }



    private void noCommandHandler(UserContext context , String text) {
        Message message = new Message (  );
        message.setAction(Message.Action.TEXT);
        Payload payload = new Payload ();
        payload.setText ( text );
        sendMessageToUser(sender(), context, text, message);
    }


    private void handlerUserMessage(Message message) {
        UserContext context = new UserContext ();
        context.setText ( message.getText () );
        if (context != null) {
            message.setAction ( Message.Action.TEXT );
                    watsonService.sendMessageToWatson(message.getText(), context, null, null, false, getSender());
            }
         else
            watsonService.sendHi( context, getSender());
    }
}
