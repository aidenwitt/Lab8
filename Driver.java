
public class Driver {
	public static void main(String[] args) {
		/*System.out.println("THIMBLE ------> " + Shape.THIMBLE.toString());
		System.out.println("BOOT    ------> " + Shape.BOOT.toString());
		System.out.println("RACECAR ------> " + Shape.RACECAR.toString());
		System.out.println("----------------------------------------------------------------");
		System.out.println(Color.RED + ":             (" + Color.RED.getR() + ", " + Color.RED.getG() + ", " + Color.RED.getB() + ")");
		System.out.println(Color.BLUE + ":            (" + Color.BLUE.getR() + ", " + Color.BLUE.getG() + ", " + Color.BLUE.getB() + ")");
		System.out.println(Color.GREEN + ":           (" + Color.GREEN.getR() + ", " + Color.GREEN.getG() + ", " + Color.GREEN.getB() + ")");
		System.out.println(Color.YELLOW + ":        (" + Color.YELLOW.getR() + ", " + Color.YELLOW.getG() + ", " + Color.YELLOW.getB() + ")");
		System.out.println(Color.CYAN + ":          (" + Color.CYAN.getR() + ", " + Color.CYAN.getG() + ", " + Color.CYAN.getB() + ")");
		System.out.println(Color.MAGENTA + ":       (" + Color.MAGENTA.getR() + ", " + Color.MAGENTA.getG() + ", " + Color.MAGENTA.getB() + ")"); 
		System.out.println("----------------------------------------------------------------");
		GamePieceAppearance newPiece1 = new GamePieceAppearance(Color.RED, Shape.THIMBLE);
		System.out.println(newPiece1.getColor() + " " + newPiece1.getShape());
		GamePieceAppearance newPiece2 = new GamePieceAppearance(Color.GREEN, Shape.BOOT);
		System.out.println(newPiece2.getColor() + " " + newPiece2.getShape());
		GamePieceAppearance newPiece3 = new GamePieceAppearance(Color.BLUE, Shape.RACECAR);
		System.out.println(newPiece3.getColor() + " " + newPiece3.getShape());
		GamePieceAppearance newPiece4 = new GamePieceAppearance(Color.YELLOW, Shape.THIMBLE);
		System.out.println(newPiece4.getColor() + " " + newPiece4.getShape());
		GamePieceAppearance newPiece5 = new GamePieceAppearance(Color.CYAN, Shape.BOOT);
		System.out.println(newPiece5.getColor() + " " + newPiece5.getShape());
		GamePieceAppearance newPiece6 = new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR);
		System.out.println(newPiece6.getColor() + " " + newPiece6.getShape());
		System.out.println("----------------------------------------------------------------");
		GamePiece p1 = GamePiece.BLUE_RACER;
		System.out.println(p1.toString());
		GamePiece p2 = GamePiece.GREEN_BOOT;
		System.out.println(p2.toString());
		GamePiece p3 = GamePiece.RED_THIMBLE;
		System.out.println(p3.toString());
		System.out.println("----------------------------------------------------------------");
		*/GamePiece ap = GamePiece.MAGENTA_RACER;
		GamePiece mp = GamePiece.YELLOW_BOOT;
		BoardGame game = new BoardGame();
		game.addPlayer("aiden", ap, Location.HALL);
		game.addPlayer("marcos", mp, Location.BILLIARD_ROOM);
		game.addPlayer("aiden", ap, Location.HALL); //successfully not added
		game.addPlayer("john", ap, Location.KITCHEN); // successfully not added
		/*System.out.println(game.getPlayers());
		System.out.println(game.getPlayerGamePiece("aiden"));
		System.out.println(game.getPlayerGamePiece("marcos"));
		System.out.println(game.getPlayerWithGamePiece(GamePiece.MAGENTA_RACER));
		System.out.println(game.getPlayerWithGamePiece(GamePiece.YELLOW_BOOT));
		System.out.println(game.getPlayersLocation("aiden"));
		System.out.println(game.getPlayersLocation("marcos"));
		*/System.out.println(game.getPlayerLocations());
		game.movePlayer("aiden", Location.CONSERVATORY);
		System.out.println(game.getPlayersLocation("aiden"));
		String[] playersToMove = {"aiden", "marcos"};
		Location[] newLocations = {Location.LIBRARY, Location.LIBRARY};
		game.moveTwoPlayers(playersToMove, newLocations);
		System.out.println(game.getPlayerLocations());
		System.out.println(game.getPlayersAtLocation(Location.LIBRARY));
		System.out.println(game.getGamePiecesAtLocation(Location.LIBRARY));
		System.out.println(game.getPlayers());
		System.out.println(game.getPlayerLocations());
		System.out.println(game.getPlayerPieces());
		
		System.out.println(GamePiece.movesFirst(ap, mp).toString());
		System.out.println(GamePiece.movesFirst(mp, ap).toString());
		System.out.println(game.getPlayerWithGamePiece(GamePiece.GREEN_BOOT));
		
		String[] playersToMove2 = {"marcos", "aiden"};
		Location[] newLocations2 = {Location.LIBRARY, Location.LIBRARY};
		game.moveTwoPlayers(playersToMove2, newLocations2);
		
		System.out.println(ap.getColor());
		System.out.println(ap.getShape());
		
		GamePiece bb = GamePiece.BLUE_BOOT;
		System.out.println(bb.toString());
	}
}
