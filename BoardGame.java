import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

/**
 * @author Aiden
 *
 */
public class BoardGame {
	/**
	 * map that will hold the playernames as keys and their corresponding Pieces
	 */
	protected LinkedHashMap<String, GamePiece> playerPieces;
	
	/**
	 * map that will hold the playernames as keys and their corresponding Locations
	 */
	protected LinkedHashMap<String, Location> playerLocations;
	
	/**
	 * initializes the maps, getting ready for a new game
	 */
	public BoardGame() {
		 playerPieces = new LinkedHashMap<String, GamePiece>();
		 playerLocations = new LinkedHashMap<String, Location>();
	}
	
	/**
	 * @param playerName name of player to be added (string)
	 * @param gamePiece the players selected GamePiece (i.e. GamePiece.YELLOW_BOOT)
	 * @param initialLocation the starting Location of the player (i.e. KITCHEN)
	 * @return true if the player was added to the game, false if the player added was a duplicate
	 */
	public boolean addPlayer(String playerName, GamePiece gamePiece, Location initialLocation) {
		if(playerPieces.containsValue(gamePiece)) {
			return false;
		}
		else {
			playerPieces.put(playerName, gamePiece);
			playerLocations.put(playerName, initialLocation);
		}
		return true;
	}
	
	/**
	 * @param playerName name of player to which the method will return their associated Piece
	 * @return GamePiece assigned to the player 
	 */
	public GamePiece getPlayerGamePiece(String playerName) {
		return playerPieces.get(playerName);
	}
	
	/**
	 * @param gamePiece GamePiece to which the associated player will be returned
	 * @return the name of the player associated with the GamePiece, or null if the player is not found
	 */
	public String getPlayerWithGamePiece(GamePiece gamePiece) {
		for (String key : playerPieces.keySet()) {
			if ((playerPieces.get(key)).equals(gamePiece)) {
				return key;
			}
		}
		return null;
	}
	
	/**
	 * moves the player to the specified location
	 * @param playerName
	 * @param newLocation
	 */
	public void movePlayer(String playerName, Location newLocation) {
		playerLocations.put(playerName, newLocation);
	}
	
	/**
	 * moves two players at once, depending on priority
	 * @param playerNames names of players (String), stored in an array
	 * @param newLocations new locations for players (Location), stored in an array
	 * @return array containing player names
	 */
	public String[] moveTwoPlayers(String[] playerNames, Location[] newLocations) {
		if((GamePiece.movesFirst(playerPieces.get(playerNames[0]), playerPieces.get(playerNames[1]))).equals(playerPieces.get(playerNames[1]))){
			String tempNam = playerNames[1];
			playerNames[1] = playerNames[0];
			playerNames[0] = tempNam;
			
			Location tempLoc = newLocations[1];
			newLocations[1] = newLocations[0];
			newLocations[0] = tempLoc;
		}
		//Array now in order
		movePlayer(playerNames[0], newLocations[0]);
		movePlayer(playerNames[1], newLocations[1]);
		return playerNames;
	}
	
	/**
	 * @param player
	 * @return location of the given player
	 */
	public Location getPlayersLocation(String player) {
		return playerLocations.get(player);
	}
	
	/**
	 * 
	 * @param loc location to analyze
	 * @return ArrayList of players in the given location
	 */
	public ArrayList<String> getPlayersAtLocation(Location loc){
		ArrayList<String> players = new ArrayList<String>();
		for (String key : playerLocations.keySet()) {
			if ((playerLocations.get(key)).equals(loc)) {
				players.add(key);
			}
		}
		return players;
	}
	
	/**
	 * 
	 * @param loc
	 * @return ArrayList of GamePieces at the given location
	 */
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc){
		ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
		for (String key : playerLocations.keySet()) {
			if ((playerLocations.get(key)).equals(loc)) {
				pieces.add(playerPieces.get(key));
			}
		}
		return pieces;
	}
	
	/**
	 * returns a HashSet containing the names of all the players in the game
	 */
	public Set<String> getPlayers() {
		Set<String> players = new HashSet<String>();
		for (String key : playerPieces.keySet()) {
			players.add(key);
		}
		return players;
	}
	
	/**
	 * @return HashSet containing all of the locations that players currently reside in
	 */
	public Set<Location> getPlayerLocations() {
		Set<Location> locations = new HashSet<Location>();
		for (String key : playerLocations.keySet()) {
			locations.add(playerLocations.get(key));
		}
		return locations;
	}
	
	/**
	 * @return HashSet containing all of the Pieces that are being used by each player
	 */
	public Set<GamePiece> getPlayerPieces() {
		Set<GamePiece> pieces = new HashSet<GamePiece>();
		for (String key : playerPieces.keySet()) {
			pieces.add(playerPieces.get(key));
		}
		return pieces;
	}
}
