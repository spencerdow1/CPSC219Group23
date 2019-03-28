package GUI;

public class Console {

	private Piece currentPiece;
	private String displayName;

	/**
	 * This is the default which is an empty board
	 **/
	public static void displayEmpty() {

		// This is the i'th row
		for (int i = 1; i < 12; i++) {

			// this is the j'th column
			for (int j = 1; j < 12; j++) {

				// This handles the rows of vertical thingies
				if (i % 2 != 0) {
					// System.out.println("P2");
					if (j % 2 != 0) {
						if (j != 11) {
							System.out.print("-");
						} else {
							System.out.println("---");
						}
					} else {
						System.out.print("-----");
					}
				}

				// this handles the rows where we need to put pieces in
				else {

					if (j % 2 != 0) {

						if (j != 11) {
							System.out.print("|");
						} else {
							System.out.println("|");
						}
					}

					else {
						System.out.print("   ");
					}

				}

			}
		}

	}

	public static void main(String args[]) {
		displayEmpty();
	}

}