package graphtutorial;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

public class ImportEDTIntentHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("ImportEDTIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        new App();

        String speechText = "Importe EDT";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("ImportEDT", speechText)
                .build();
    }

}
