package graphtutorial;

import com.amazon.ask.Skill;
import com.amazon.ask.SkillStreamHandler;
import com.amazon.ask.Skills;

public class ImportEDTStreamHandler extends SkillStreamHandler {

    private static Skill getSkill() {

        return Skills.standard().addRequestHandlers(
                new CancelAndStopHandler(),
                new LaunchRequestHandler(),
                new SessionEndedRequestHandler(),
                new HelpIntentHandler(),
                new ImportEDTIntentHandler()
        ).build();

    }

    public ImportEDTStreamHandler() {
        super(getSkill());
    }

}
