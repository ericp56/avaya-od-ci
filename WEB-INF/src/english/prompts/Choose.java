/**
 * Last generated by Avaya Dialog Designer at: 2005-MAY-04  11:38:48 AM
 */
package english.prompts;

public class Choose extends com.avaya.sce.runtime.Prompt {

	//{{START:CLASS:FIELDS
	//}}END:CLASS:FIELDS

	/**
	 * Constructor for Choose.
	 */
	public Choose() {
		//{{START:CLASS:CONSTRUCTOR
		super();
		//}}END:CLASS:CONSTRUCTOR
	}


	/**
	 * This method is generated automatically and should not be manually edited
	 * To manually edit the prompt, override:
	 * void updatePrompt()
	 * Last generated by Orchestration Designer at: (timestamp generation disabled)
	 */
	public void buildPrompt(){
		com.avaya.sce.runtime.Format format = null;
		com.avaya.sce.runtime.RenderHint hint = null;
		com.avaya.sce.runtime.MediaPage mediaPage = null;
		setBarginType(com.avaya.sce.runtimecommon.SCERT.BARGIN_SPEECH);
		setName("Choose");
		setOrder(com.avaya.sce.runtime.Prompt.STANDARD);

		// Prompt level 1
		setTimeout(1,8000);
		setBargin(1,true);

		add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT,"What is ", null));

		if ( new com.avaya.sce.runtime.Condition( "condition", "MathQuizChoice:value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "subtraction", false, null ).evaluate(getSession()) == true ) {
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_TEXT);
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,"Num2", format));
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT," minus ", null));
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_TEXT);
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,"Num1", format));
		}

		if ( new com.avaya.sce.runtime.Condition( "condition", "MathQuizChoice:value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "addition", false, null ).evaluate(getSession()) == true ) {
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_TEXT);
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,"Num1", format));
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT," plus ", null));
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_TEXT);
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,"Num2", format));
		}

		if ( new com.avaya.sce.runtime.Condition( "condition", "MathQuizChoice:value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "multiplication", false, null ).evaluate(getSession()) == true ) {
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_TEXT);
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,"Num1", format));
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT," times ", null));
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_TEXT);
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,"Num2", format));
		}

		if ( new com.avaya.sce.runtime.Condition( "condition", "MathQuizChoice:value", com.avaya.sce.runtime.Expression.STRING_EQUAL_IGNORE, "division", false, null ).evaluate(getSession()) == true ) {
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_TEXT);
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,"Num2", format));
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT," divided by ", null));
			format = new com.avaya.sce.runtime.Format();
			format.add(com.avaya.sce.runtime.Format.FORMAT,com.avaya.sce.runtime.Format.FMT_TEXT);
			add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.VARIABLE_TEXT,"Num1", format));
		}

		add(1, new com.avaya.sce.runtime.PromptElement(com.avaya.sce.runtime.PromptElement.TEXT,"?", null));

	}

































































































}
