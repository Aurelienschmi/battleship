package bo;
import java.util.Random;
import java.util.Scanner;


public class Game {

    public int random(int num) {
        Random r = new Random();
        return r.nextInt(num);
    }

    public void checkBoat(Boat bo, Player J) {
        int X;
        int Y;
        int sens;
        boolean result;

        do {
            X = random(10);
            Y = random(10);
            sens = random(2);
            result = false;

            if (X + bo.getLenght() <= 10 && Y + bo.getLenght() <= 10) {
                if (sens == 1) {
                    // Vérifier si le bateau ne se superpose pas
                    boolean supperpose = false;
                    for (int y1 = X; y1 < X + bo.getLenght(); y1++) {
                        if (!J.getBoard().grilled[y1][Y].equals("~ ")) {
                            supperpose = true;
                            break;
                        }
                    }

                    if (!supperpose) {
                        // Mettre à jour les coordonnées du bateau et son sens
                        bo.setX(X);
                        bo.setY(Y);
                        bo.setDirection(sens);


                        // Placer le bateau
                        for (int y1 = X; y1 < X + bo.getLenght(); y1++) {
                            J.getBoard().grilled[y1][Y] = bo.getId();
                        }
                        result = true;
                    }
                }

                if (sens == 0) {
                    // Vérifier si le bateau ne se superpose pas
                    boolean supperpose = false;
                    for (int y2 = Y; y2 < Y + bo.getLenght(); y2++) {
                        if (!J.getBoard().grilled[X][y2].equals("~ ")) {
                            supperpose = true;
                            break;
                        }
                    }

                    if (!supperpose) {
                        // Mettre à jour les coordonnées du bateau
                        bo.setX(X);
                        bo.setY(Y);
                        bo.setDirection(sens);


                        // Placer le bateau
                        for (int y2 = Y; y2 < Y + bo.getLenght(); y2++) {
                            J.getBoard().grilled[X][y2] = bo.getId();
                        }
                        result = true;
                    }
                }
            }
        } while (!result);
    }

    public void isSunk(Boat bo, Player J1) {
        int indexHit = 0;
        int x = bo.getX();
        int y = bo.getY();
        int sens = bo.getDirection();

        for (int j = 0; j < bo.getLenght(); j++) {
            if (sens == 0) {
                if (J1.getBoard().grilled[x][y + j].equals("H ")) {
                    indexHit++;
                }
            } else {
                if (J1.getBoard().grilled[x + j][y].equals("H ")) {
                    indexHit++;
                }
            }
        }

        if (bo.getLenght() == indexHit) {
            for (int j = 0; j < bo.getLenght(); j++) {
                if (sens == 0) {
                    J1.getBoard().grilled[x][y + j] = "Z ";
                } else {
                    J1.getBoard().grilled[x + j][y] = "Z ";
                }
            }
        }
    }
    public boolean boatSunk(Boat bo, Player J) {
        int x = bo.getX();
        int y = bo.getY();
        int sens = bo.getDirection();

        for (int j = 0; j < bo.getLenght(); j++) {
            if (sens == 0) {
                if (J.getBoard().grilled[x][y + j].equals("Z ")) {
                } else {
                    return false;
                }
            } else {
                if (J.getBoard().grilled[x + j][y].equals("Z ")) {
                    continue;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
    public void chooseBoatPlacement (Boat bo, Player J) {
        int X, Y, sens;
        boolean result;
        Scanner scan = new Scanner(System.in);
        J.getBoard().display();

        do {
            System.out.println("J1, Ecrivez la coordonnée de x");
            X = Integer.parseInt(scan.nextLine()) - 1;
            System.out.println("J1, Ecrivez la coordonnée de y");
            Y = Integer.parseInt(scan.nextLine()) - 1;
            System.out.println("J1, Choisissez la direction du bateau 1: horizontale, 2: horizontale");
            sens = Integer.parseInt(scan.nextLine()) - 1;
            result = false;

            if (X + bo.getLenght() <= 10 && Y + bo.getLenght() <= 10) {
                if (sens == 1) {
                    boolean overlap = false;
                    for (int y1 = X; y1 < X + bo.getLenght(); y1++) {
                        if (!J.getBoard().grilled[y1][Y].equals("~ ")) {
                            overlap = true;
                            break;
                        }
                    }
                    if (!overlap) {
                        bo.setX(X);
                        bo.setY(Y);
                        bo.setDirection(sens);
                        for (int y1 = X; y1 < X + bo.getLenght(); y1++) {
                            J.getBoard().grilled[y1][Y] = bo.getId();
                        }
                        result = true;
                    }
                }

                if (sens == 0) {
                    // Vérifier si le bateau ne se superpose pas
                    boolean overlap = false;
                    for (int y2 = Y; y2 < Y + bo.getLenght(); y2++) {
                        if (!J.getBoard().grilled[X][y2].equals("~ ")) {
                            overlap = true;
                            break;
                        }
                    }
                    if (!overlap) {
                        bo.setX(X);
                        bo.setY(Y);
                        bo.setDirection(sens);
                        for (int y2 = Y; y2 < Y + bo.getLenght(); y2++) {
                            J.getBoard().grilled[X][y2] = bo.getId();
                        }
                        result = true;
                    }
                }
            }
        } while (!result);
    }
}


