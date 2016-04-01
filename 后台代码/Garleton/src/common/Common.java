package common;

public class Common {

	public enum Role {
		SA, // super admin
		WE, // web editor
		RM, // resource manager
		CM, // course manager
		U, // user
		NOVALUE;
		public static Role toRole(String str) {
			try {
				return valueOf(str);
			} catch (Exception ex) {
				return NOVALUE;
			}
		}
	}
}
