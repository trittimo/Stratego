package stratego.gui;

public class GameComponent {
	LoadImage piece;
	final String PATH = "/CodeCoverageExample/images";
	
	public String pickPiece(String sign){
//		sign = "0";
		switch(sign){
		case "1":
			return PATH+"/spy";
		case "2":
			return PATH+"/scout";
		case "3":
			return PATH+"/minor";
		case "4":
			return PATH+"/sergent";
		case "5":
			return PATH+"/lieutenant";
		case "6":
			return PATH+"/captain";
		case "7":
			return PATH+"/major";
		case "8":
			return PATH+"/colonel";
		case "9":
			return PATH+"/general";
		case "0":
			return PATH+"/marshall";
		case "B":
			return PATH+"/bomb";
		case "F":
			return PATH+"/flag";
		}
		return sign;
	}
}
