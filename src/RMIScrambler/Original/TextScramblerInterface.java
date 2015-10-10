package RMIScrambler.Original;

/**
 * @author Alexandre Hudon
 * @date 18/09/2013
 * RMI-Tutorial, COMP 6231 - Text Scrambler Interface
 * This class needs to be modified by the students in order to define it as a Java RMI Interface.
 */
public interface TextScramblerInterface{

	public String testInputText(String inputText);
	public String reverse(String inputText);
	public String scramble(String inputText);
	
}
