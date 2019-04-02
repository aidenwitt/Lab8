import static org.junit.Assert.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Assert;
import org.junit.Test;

public class test {

	@Test
	public void BoardGameTest() {
		BoardGame game = new BoardGame();
		GamePiece magrac = GamePiece.MAGENTA_RACER;
		GamePiece yelboo = GamePiece.YELLOW_BOOT;
		
		game.addPlayer("player1", magrac, Location.HALL);
		game.addPlayer("player2", yelboo, Location.BILLIARD_ROOM);
		game.addPlayer("player1", magrac, Location.HALL);
		game.addPlayer("player3", magrac, Location.KITCHEN);
		
		Assert.assertEquals("[player1, player2]", game.getPlayers().toString());
		Assert.assertEquals("MAGENTA_RACER: a MAGENTA racecar with priority 1", (game.getPlayerGamePiece("player1")).toString());
		Assert.assertEquals("YELLOW_BOOT: a YELLOW boot with priority 7", (game.getPlayerGamePiece("player2")).toString());
		Assert.assertEquals("player1", game.getPlayerWithGamePiece(GamePiece.MAGENTA_RACER));
		Assert.assertEquals("player2", game.getPlayerWithGamePiece(GamePiece.YELLOW_BOOT));
		Assert.assertEquals(null, game.getPlayerWithGamePiece(GamePiece.GREEN_BOOT));
		Assert.assertEquals("HALL", game.getPlayersLocation("player1").toString());
		Assert.assertEquals("BILLIARD_ROOM", game.getPlayersLocation("player2").toString());
		
		Set<Location> test = new HashSet<Location>();
		test.add(Location.HALL); test.add(Location.BILLIARD_ROOM);
		Assert.assertEquals(test, game.getPlayerLocations());
		
		game.movePlayer("player1", Location.CONSERVATORY);
		Assert.assertEquals("CONSERVATORY", game.getPlayersLocation("player1").toString());
		
		String[] playersToMove = {"player1", "player2"};
		Location[] newLocations = {Location.LIBRARY, Location.STUDY};
		game.moveTwoPlayers(playersToMove, newLocations);
		
		Set<Location> test2 = new HashSet<Location>();
		test2.add(Location.LIBRARY); test2.add(Location.STUDY);
		
		Assert.assertEquals(test2, game.getPlayerLocations());
		Assert.assertEquals("[player1]", game.getPlayersAtLocation(Location.LIBRARY).toString());
		Assert.assertEquals("[player2]", game.getPlayersAtLocation(Location.STUDY).toString());
		Assert.assertEquals("[player1, player2]", game.getPlayers().toString());
		//
		Set<GamePiece> gptest = new HashSet<GamePiece>();
		gptest.add(GamePiece.MAGENTA_RACER); gptest.add(GamePiece.YELLOW_BOOT);
		Assert.assertEquals(gptest, game.getPlayerPieces());
		//
		Set<GamePiece> gptest2 = new HashSet<GamePiece>();
		gptest2.add(GamePiece.MAGENTA_RACER);
		Assert.assertEquals(gptest2.toString(), game.getGamePiecesAtLocation(Location.LIBRARY).toString());
	}
	
	@Test
	public void IsolatedMoveTwoPlayersTest() {
		BoardGame game = new BoardGame();
		GamePiece magrac = GamePiece.MAGENTA_RACER;
		GamePiece yelboo = GamePiece.YELLOW_BOOT;
		game.addPlayer("player1", magrac, Location.HALL);
		game.addPlayer("player2", yelboo, Location.BILLIARD_ROOM);
		String[] playersToMove = {"player2", "player1"};
		Location[] newLocations = {Location.LOUNGE, Location.BALLROOM};
		
		game.moveTwoPlayers(playersToMove, newLocations);
		
		Set<Location> test = new HashSet<Location>();
		test.add(Location.BALLROOM); test.add(Location.LOUNGE);
		
		Assert.assertEquals(test, game.getPlayerLocations());
		Assert.assertEquals("[player1]", game.getPlayersAtLocation(Location.BALLROOM).toString());
		Assert.assertEquals("[player2]", game.getPlayersAtLocation(Location.LOUNGE).toString());
	}

	@Test
	public void GamePieceTest() {
		GamePiece p1 = GamePiece.BLUE_BOOT;
		GamePiece p2 = GamePiece.BLUE_RACER;
		GamePiece p3 = GamePiece.RED_RACER; // 0
		GamePiece p4 = GamePiece.MAGENTA_RACER;// 1
		GamePiece p5 = GamePiece.YELLOW_BOOT;// 7
		
		Assert.assertEquals("BLUE", p1.getColor().toString());
		Assert.assertEquals("racecar", p2.getShape().toString());
		
		Assert.assertEquals(p3, GamePiece.movesFirst(p3, p5));
		Assert.assertEquals(p4, GamePiece.movesFirst(p5, p4));
		
		Assert.assertEquals("BLUE_BOOT: a BLUE boot with priority 5", p1.toString());
		Assert.assertEquals("BLUE_RACER: a BLUE racecar with priority 2", p2.toString());
	}
	
	@Test
	public void ShapeTest() {
		Shape.THIMBLE.toString();
		Shape.BOOT.toString();
		Shape.RACECAR.toString();
	}
	
	@Test
	public void ColorTest() {
		Assert.assertEquals(255, Color.BLUE.getB());
		Assert.assertEquals(255, Color.MAGENTA.getR());
		Assert.assertEquals(0, Color.MAGENTA.getG());
		Assert.assertEquals(255, Color.YELLOW.getR());
		
	}
}

