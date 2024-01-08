package go;

import bo.Boat;
import bo.Player;
import bo.Game;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        System.out.println("Bienvenue dans le jeu de bataille navale !\n ");
        System.out.println("La bataille navale se joue sur une grille de 10x10.");
        System.out.println("Chaque joueur place ses bateaux sur sa grille.");
        System.out.println("Les bateaux peuvent être de tailles différentes.");
        System.out.println("Le jeu se déroule en alternant les attaques entre les joueurs.");
        System.out.println("Le premier joueur à couler tous les bateaux de l'adversaire gagne.");
        System.out.println("\n Vous possedez 5 bateaux:");
        System.out.println("1) Le portes avions (5 cases) representé par un 'P'");
        System.out.println("2) Un croiseur (4 cases) representé par un 'X'");
        System.out.println("3) Un contre-torpilleur (3 cases) representé par un 'C'");
        System.out.println("4) Un sous-marin (3 cases) representé par un 'S'");
        System.out.println("5) Un torpilleur (2 cases) representé par un 'T'");
        System.out.println("\n \n Vous aurez 2 grilles : la première où tous vos bateaux sont placés \n (où vous pourrez voir les attaques que l'ennemi exécute) et une seconde pour répertorier toutes vos attaques ");
        System.out.println("\n Vous pourrez retrouver les initiales suivantes:");
        System.out.println("'W' signifie qu'un tir est mis dans l'eau");
        System.out.println("'H' signifie qu'un tir a touché un ennemi");
        System.out.println("'Z' signifie qu'un bateau est coulé");
        System.out.println("\n Ecrivez 1 pour lancer le jeu");


        Scanner menuScanner = new Scanner(System.in);
        int choice = Integer.parseInt(menuScanner.nextLine());

        if (choice == 1) {
            startGame();
        }
    }
    private static void startGame() {
        boolean gameEnd = false;

        List<Boolean> indexBoatSunkJ1 = new ArrayList<>();
        boolean indexBoat1SunkJ1 = false;
        boolean indexBoat2SunkJ1 = false;
        boolean indexBoat3SunkJ1 = false;
        boolean indexBoat4SunkJ1 = false;
        boolean indexBoat5SunkJ1 = false;

        indexBoatSunkJ1.add(indexBoat1SunkJ1);
        indexBoatSunkJ1.add(indexBoat2SunkJ1);
        indexBoatSunkJ1.add(indexBoat3SunkJ1);
        indexBoatSunkJ1.add(indexBoat4SunkJ1);
        indexBoatSunkJ1.add(indexBoat5SunkJ1);

        List<Boolean> indexBoatSunkJ2 = new ArrayList<>();
        boolean indexBoat1SunkJ2 = false;
        boolean indexBoat2SunkJ2 = false;
        boolean indexBoat3SunkJ2 = false;
        boolean indexBoat4SunkJ2 = false;
        boolean indexBoat5SunkJ2 = false;

        indexBoatSunkJ2.add(indexBoat1SunkJ2);
        indexBoatSunkJ2.add(indexBoat2SunkJ2);
        indexBoatSunkJ2.add(indexBoat3SunkJ2);
        indexBoatSunkJ2.add(indexBoat4SunkJ2);
        indexBoatSunkJ2.add(indexBoat5SunkJ2);

        Boat porte_avion = new Boat("porte_avion", "P ", 5, 1, 1, 1);
        Boat croiseur = new Boat("croiseur", "X ", 4, 1, 1, 1);
        Boat contre_torpilleur = new Boat("contre_torpieur", "C ", 3, 1, 1, 1);
        Boat sous_marin = new Boat("sous_marin", "S ", 3, 1, 1, 1);
        Boat torpilleur = new Boat("torpilleur", "T ", 2, 1, 1, 1);

        Boat porte_avion2 = new Boat("porte_avion", "P ", 5, 1, 1, 1);
        Boat croiseur2 = new Boat("croiseur", "X ", 4, 1, 1, 1);
        Boat contre_torpilleur2 = new Boat("contre_torpieur", "C ", 3, 1, 1, 1);
        Boat sous_marin2 = new Boat("sous_marin", "S ", 3, 1, 1, 1);
        Boat torpilleur2 = new Boat("torpilleur", "T ", 2, 1, 1, 1);

        List<Boat> boatsJ1 = new ArrayList<>();
        List<Boat> boatsJ2 = new ArrayList<>();


        boatsJ1.add(porte_avion);
        boatsJ1.add(croiseur);
        boatsJ1.add(contre_torpilleur);
        boatsJ1.add(sous_marin);
        boatsJ1.add(torpilleur);
        boatsJ2.add(porte_avion2);
        boatsJ2.add(croiseur2);
        boatsJ2.add(contre_torpilleur2);
        boatsJ2.add(sous_marin2);
        boatsJ2.add(torpilleur2);

        Game j = new Game();
        Player J1 = new Player();
        Player J2 = new Player();

        Scanner scan = new Scanner(System.in);
        int z1;
        System.out.println("J1, \n Ecrivez 1 pour placer vos bateaux aléatoirement \n ou 2 pour les placer manuellement");
        z1 = Integer.parseInt(scan.nextLine());
        if (z1 == 1){
            for (int i = 0; i < 5; i++){
                j.checkBoat(boatsJ1.get(i),J1);
            }
        }else if (z1 == 2){
            System.out.println("J1, Placez le porte-avion\n");
            j.chooseBoatPlacement(porte_avion, J1);

            System.out.println("J1, Placez le croiseur\n");
            j.chooseBoatPlacement(croiseur, J1);

            System.out.println("J1, Placez le contre_torpilleur\n");
            j.chooseBoatPlacement(contre_torpilleur, J1);

            System.out.println("J1, Placez le sous_marin\n");
            j.chooseBoatPlacement(sous_marin, J1);

            System.out.println("J1, Placez le torpilleur\n");
            j.chooseBoatPlacement(torpilleur, J1);
        }


        for (int i = 0; i < 5; i++){
            j.checkBoat(boatsJ2.get(i),J2);
        }

        List<String> positionsChoisiesJ1 = new ArrayList<>();
        List<String> positionsChoisiesJ2 = new ArrayList<>();


        System.out.println("\nPlateau du Joueur 1 !\n");
        J1.getBoard().display();

        System.out.println("\nPlateau d'attaque du Joueur 1 !\n");
        J1.getAttackBoard().displayAttackBoard();  // Afficher l'attackBoard du joueur J1

        //System.out.println("\nPlateau du Joueur 2 !\n");
        //J2.getBoard().display();

        //System.out.println("\nPlateau d'attaque du Joueur 2 !\n");
        //J2.getAttackBoard().displayAttackBoard();  // Afficher l'attackBoard du joueur J2

        Scanner scanner = new Scanner(System.in);

        while (!gameEnd) {
            int x1, y1;
            System.out.println("J1, c'est à vous de jouer !");

            do {
                System.out.println("Entrez l'ordonnée : ");
                x1 = Integer.parseInt(scanner.nextLine()) - 1;
                System.out.println("Entrez l'abscisse : ");
                y1 = Integer.parseInt(scanner.nextLine()) - 1;
            } while (positionsChoisiesJ1.contains(x1 + "," + y1));

            positionsChoisiesJ1.add(x1 + "," + y1);

            J1.getAttackBoard().checkAttack(J2.getBoard(), x1, y1);
            J2.getBoard().checkAttack(J1.getAttackBoard(), x1, y1);

            System.out.println("J2, c'est à vous de jouer !");
            int x2, y2;
            do {
                x2 = j.random(10);
                y2 = j.random(10);
            } while (positionsChoisiesJ2.contains(x2 + "," + y2));

            positionsChoisiesJ2.add(x2 + "," + y2);

            J2.getAttackBoard().checkAttack(J1.getBoard(), x2, y2);
            J1.getBoard().checkAttack(J2.getAttackBoard(), x2, y2);

            for (int i = 0; i < 5 ; i++){
                j.isSunk(boatsJ1.get(i), J1);
                if(j.boatSunk(boatsJ1.get(i), J1)){
                    indexBoatSunkJ1.set(i, true);
                    J2.updateAttackBoardOnSunk(boatsJ1.get(i));
                }
            }

            for (int i = 0; i < 5 ; i++){
                j.isSunk(boatsJ2.get(i), J2);
                if(j.boatSunk(boatsJ2.get(i), J2)){
                    indexBoatSunkJ2.set(i, true);
                    J1.updateAttackBoardOnSunk(boatsJ2.get(i));
                }
            }


            System.out.println("\nPlateau du Joueur 1 !\n");
            J1.getBoard().display();

            System.out.println("\nPlateau d'attaque du Joueur 1 !\n");
            J1.getAttackBoard().display();  // Afficher l'attackBoard du joueur J1

            //System.out.println("\nPlateau du Joueur 2 !\n");
            //J2.getBoard().display();

            //System.out.println("\nPlateau d'attaque du Joueur 2 !\n");
            //J2.getAttackBoard().display();  // Afficher l'attackBoard du joueur J2

            if (indexBoatSunkJ2.get(0) && indexBoatSunkJ2.get(1) && indexBoatSunkJ2.get(2) && indexBoatSunkJ2.get(3) && indexBoatSunkJ2.get(4)){
                System.out.println("le joueur 1 à gagné la partie !");
                gameEnd = true;
            }
            if (indexBoatSunkJ1.get(0) && indexBoatSunkJ1.get(1) && indexBoatSunkJ1.get(2) && indexBoatSunkJ1.get(3) && indexBoatSunkJ1.get(4)){
                System.out.println("le joueur 2 à gagné la partie !");
                gameEnd = true;
            }
        }
    }
}
