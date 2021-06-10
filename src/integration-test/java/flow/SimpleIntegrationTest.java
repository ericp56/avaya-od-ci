package flow;
import com.nextivr.vxml.browser.AodBrowser;
import com.nextivr.vxml.browser.HttpResponse;
import com.nextivr.vxml.validator.VxmlValidator;

import org.junit.Test;
import org.junit.experimental.categories.Category;

@Category(IntegrationTest.class)
public class SimpleIntegrationTest {
    private static final String SRC = "src";
    private static final String VXML_AUDIO = "vxml:audio";
    private static final String VXML_PROMPT = "vxml:prompt";

    @Test
    public void simpleTest() throws Exception{
        System.out.println("*********INTEGRATION TEST*********");
        AodBrowser browser = new AodBrowser();

        //Fetch a new session of the AOD app
        HttpResponse fetchDocument = browser.initApp("localhost", "8080", "MyMathQuiz", "");

        VxmlValidator validator = new VxmlValidator(fetchDocument.getMessage());

        //Start the session with an ANI and DNIS
        //Validate that the initial page has a Welcome prompt.
        validator = browser.start("919411234", "1234")
        .xpElementContainsText(VXML_PROMPT, "Welcome");
        
        //Get the next page of the app and verify it is the choices prompt.
        validator = browser.getDefaultNext(validator)        
        .xpElementContainsText(VXML_PROMPT, "Would you like to be quizzed on Addition, Subtraction, Multiplication or Division");
        
        
        //"Select" addition and validate it proceeds to the addition question
        validator = browser.choosePromptCollect(validator, "addition", "addition", "dtmf")
        .xpElementContainsText(VXML_PROMPT, "What is")
        .xpElementContainsText(VXML_PROMPT, "plus");

    }
}
