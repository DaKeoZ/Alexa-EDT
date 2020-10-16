package graphtutorial;

import com.amazon.ask.dispatcher.request.handler.HandlerInput;
import com.amazon.ask.dispatcher.request.handler.RequestHandler;
import com.amazon.ask.model.LaunchRequest;
import com.amazon.ask.model.Response;
import com.amazon.ask.request.Predicates;

import java.util.Optional;

import static com.amazon.ask.request.Predicates.intentName;

public class LaunchRequestHandler implements RequestHandler {

    @Override
    public boolean canHandle(HandlerInput input) {
        return input.matches(Predicates.intentName("ImportEDTIntent"));
    }

    @Override
    public Optional<Response> handle(HandlerInput input) {
        String speechText = "Importation de l'emploi du temps en cours";
        return input.getResponseBuilder()
                .withSpeech(speechText)
                .withSimpleCard("ImportEDT", speechText)
                .withReprompt(speechText)
                .build();
    }

}
