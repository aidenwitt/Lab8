import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.Set;

public class BoardGame {
	protected LinkedHashMap<String, GamePiece> playerPieces;
	protected LinkedHashMap<String, Location> playerLocations;
	
	public BoardGame() {
		 playerPieces = new LinkedHashMap<String, GamePiece>();
		 playerLocations = new LinkedHashMap<String, Location>();
	}
	
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
	public GamePiece getPlayerGamePiece(String playerName) {
		return playerPieces.get(playerName);
	}
	
	public String getPlayerWithGamePiece(GamePiece gamePiece) {
		for (String key : playerPieces.keySet()) {
			if ((playerPieces.get(key)).equals(gamePiece)) {
				return key;
			}
		}
		return null;
	}
	
	public void movePlayer(String playerName, Location newLocation) {
		playerLocations.put(playerName, newLocation);
	}
	
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
	
	public Location getPlayersLocation(String player) {
		return playerLocations.get(player);
	}
	
	public ArrayList<String> getPlayersAtLocation(Location loc){
		ArrayList<String> players = new ArrayList<String>();
		for (String key : playerLocations.keySet()) {
			if ((playerLocations.get(key)).equals(loc)) {
				players.add(key);
			}
		}
		return players;
	}
	
	public ArrayList<GamePiece> getGamePiecesAtLocation(Location loc){
		ArrayList<GamePiece> pieces = new ArrayList<GamePiece>();
		for (String key : playerLocations.keySet()) {
			if ((playerLocations.get(key)).equals(loc)) {
				pieces.add(playerPieces.get(key));
			}
		}
		return pieces;
	}
	
	public Set<String> getPlayers() {
		Set<String> players = new HashSet<String>();
		for (String key : playerPieces.keySet()) {
			players.add(key);
		}
		return players;
	}
	
	public Set<Location> getPlayerLocations() {
		Set<Location> locations = new HashSet<Location>();
		for (String key : playerLocations.keySet()) {
			locations.add(playerLocations.get(key));
		}
		return locations;
	}
	
	public Set<GamePiece> getPlayerPieces() {
		Set<GamePiece> pieces = new HashSet<GamePiece>();
		for (String key : playerPieces.keySet()) {
			pieces.add(playerPieces.get(key));
		}
		return pieces;
	}
}
