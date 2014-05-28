package kata.trivia;

import java.util.LinkedList;

/**
 * Created by benwu on 14-5-28.
 */
public class QuestionMaker {
    // TODO-working-on: Move question lists to a new class QuestionMaker
    // TODO: Make question lists type-safe
    private LinkedList popQuestions = new LinkedList();
    private LinkedList scienceQuestions = new LinkedList();
    private LinkedList sportsQuestions = new LinkedList();
    private LinkedList rockQuestions = new LinkedList();

    public void addPopQuestion(String popQuestion) {
        popQuestions.add(popQuestion);
    }

    public void addScienceQuestion(String scienceQuestion) {
        scienceQuestions.add(scienceQuestion);
    }

    public void addSportsQuestion(String sportsQuestion) {
        sportsQuestions.add(sportsQuestion);
    }

    public void addRockQuestion(String rockQuestion) {
        rockQuestions.add(rockQuestion);
    }

    public String removeFirstPopQuestion() {
        return popQuestions.removeFirst().toString();
    }

    public String removeFirstScienceQuestion() {
        return scienceQuestions.removeFirst().toString();
    }

    public String removeFirstSportsQuestion() {
        return sportsQuestions.removeFirst().toString();
    }

    public String removeFirstRockQuestion() {
        return rockQuestions.removeFirst().toString();
    }
}
