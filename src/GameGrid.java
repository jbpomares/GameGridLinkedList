import java.security.SecureRandom;
import java.util.Scanner;

public class GameGrid {

    public void runGameGrid(){

        int[][] aiGrid = new int[10][10];
        int iUserRow = 0;
        int iUserCol = 0;
        int iWallChance = 15;
        boolean run = true;
        LinkedList oLinkedList = new LinkedList();
        Node oNode;
        int counter = 0;

        SecureRandom oRand = new SecureRandom();
        Scanner kb = new Scanner(System.in);

        for( int y=0; y < aiGrid[0].length; y++ ) {
            for (int x=0; x < aiGrid.length; x++) {

                int iChance = oRand.nextInt(100);

                if (iChance < iWallChance) {
                    aiGrid[x][y] = 1;
                } else {
                    aiGrid[x][y] = 0;
                }
            }
        }
        aiGrid[0][0] = 5;

        while(run) {
            System.out.println("Would you like to move down or right? 2 for down, 3 for right");
            int userInput = kb.nextInt();
            if (userInput == 2) {
                iUserCol++;
            } else if (userInput == 3) {
                iUserRow++;
            } else {
                System.out.println("Please enter a valid selection");
            }
            oLinkedList.addHeadNode(iUserRow, iUserCol);
            if (aiGrid[iUserRow][iUserCol] == 1) {

                System.out.println("You lose!");
                run = false;
            } else if (iUserCol == 9 || iUserRow == 9) {

                System.out.println("You won! You have crossed the grid successfully");
                run = false;
            }
        }

        while((oNode = oLinkedList.removeHeadNode()) != null) {
            aiGrid[oNode.xPosition][oNode.yPosition] = 5;
            counter++;
        }

        for( int y=0; y < aiGrid[0].length; y++ ) {
            for (int x=0; x < aiGrid.length; x++) {

                if (x == iUserRow && y == iUserCol ) {

                    System.out.print("X ");
                }
                else {
                    System.out.print(aiGrid[x][y] + " ");
                }
            }

            System.out.println();
        }
        System.out.println("The number of player moves is: " + counter);
        kb.close();
    }
}
