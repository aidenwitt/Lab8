public enum GamePiece {
	/**
	 * all of the available GamePieces (comprised of color, shape and priority)
	 */
	RED_RACER(new GamePieceAppearance(Color.RED, Shape.RACECAR), 0), 
	BLUE_RACER(new GamePieceAppearance(Color.BLUE, Shape.RACECAR), 2), 
	MAGENTA_RACER(new GamePieceAppearance(Color.MAGENTA, Shape.RACECAR), 1), 
	RED_THIMBLE(new GamePieceAppearance(Color.RED, Shape.THIMBLE), 10), 
	BLUE_BOOT(new GamePieceAppearance(Color.BLUE, Shape.BOOT), 5), 
	GREEN_BOOT(new GamePieceAppearance(Color.GREEN, Shape.BOOT), 8), 
	YELLOW_BOOT(new GamePieceAppearance(Color.YELLOW, Shape.BOOT), 7);
	
	private GamePieceAppearance appearance;
	private int priority;
	
	/**
	 * constructor used above for creating the GamePieces
	 * @param appearance
	 * @param priority
	 */
	private GamePiece(GamePieceAppearance appearance, int priority) {
		this.appearance = appearance;
		this.priority = priority;
	}
	
	/**
	 * @return color of the GamePiece
	 */
	public Color getColor() {
		return this.appearance.getColor();
	}
	/**
	 * @return shape of the GamePiece
	 */
	public Shape getShape() {
		return this.appearance.getShape();
	}
	/**
	 * @param a GamePiece to be compared with another
	 * @param b Second GamePiece to be compared
	 * @return GamePiece with highest priority (lowest number)
	 */
	public static GamePiece movesFirst(GamePiece a, GamePiece b) {
		if (a.priority > b.priority) {
			return b;
		}
		else {
			return a;
		}
	}
	
	/**
	 * returns string describing the GamePiece in the form: [Name of GamePiece]: a [Color of GamePiece] [Shape of GamePiece] with priority [Priority of GamePiece]
	 */
	public String toString() {
		return String.format("%s: a %s %s with priority %d", this.name(), this.getColor(), this.getShape(), this.priority);
	}
}
