package interfaces;

/**
 * Interface for plugins with ONE input arguments.
 * 
 * Note:
 * The Argument is *always* from type "String".
 * If, for example, "int" is desired, it has to be converted from int to String
 * before being send with by the interface and afterwards back to int.
 *
 */
public interface OneArgument {
	
	String calculate(String argumentOne);
	
}
