

public aspect UpperCase {
	
	after(): call(boolean startPlugins()) {
		System.out.println("Erfolg!");
	}

}
