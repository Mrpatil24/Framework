package genericUtility;

import java.time.LocalDateTime;

public class JavaUtility {
	/**
	 * It Captures current System date and Time and returns to the caller
	 * @return
	 */
	
	public String getSystemtime() {
	return LocalDateTime.now().toString().replace(":", "-");
	}

}
