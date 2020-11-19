package game;

public class Text {

    private Language tileTextStrings;
    private String tileString;
    private String showString;

    /* switch (player.getLocation()) {
//                    case 1:
//                        String message = tileString.getLine(1);
//                        displayMessage(message);
//                        break;
                    case 2:
                        String message = tileTextStrings.getLine(2);
                        displayMessage(message);
                        break;
                    case 3:
                        message = tileTextStrings.getLine(3);
                        displayMessage(message);
                        break;
                    case 4:
                        message = tileTextStrings.getLine(4);
                        displayMessage(message);
                        break;
                    case 5:
                        message = tileTextStrings.getLine(5);
                        displayMessage(message);
                        break;
                    case 6:
                        message = tileTextStrings.getLine(6);
                        displayMessage(message);
                        break;
                    case 7:
                        message = tileTextStrings.getLine(7);
                        displayMessage(message);
                        break;
                    case 8:
                        message = tileTextStrings.getLine(8);
                        displayMessage(message);
                        break;
                    case 9:
                        message = tileTextStrings.getLine(9);
                        displayMessage(message);
                        break;
                    case 10:
                        message = tileTextStrings.getLine(10);
                        displayMessage(message);
                        break;
                    case 11:
                        message = tileTextStrings.getLine(11);
                        displayMessage(message);
                        break;
                    case 12:
                        message = tileTextStrings.getLine(12);
                        displayMessage(message);
                        break;
                    case 13:
                        message = tileTextStrings.getLine(13);
                        displayMessage(message);
                        break;
                    case 14:
                        message = tileTextStrings.getLine(14);
                        displayMessage(message);
                        break;
                    case 15:
                        message = tileTextStrings.getLine(15);
                        displayMessage(message);
                        break;
                    case 16:
                        message = tileTextStrings.getLine(16);
                        displayMessage(message);
                        break;
                    case 17:
                        message = tileTextStrings.getLine(17);
                        displayMessage(message);
                        break;
                    case 18:
                        message = tileTextStrings.getLine(18);
                        displayMessage(message);
                        break;
                    case 19:
                        message = tileTextStrings.getLine(19);
                        displayMessage(message);
                        break;
                    case 20:
                        message = tileTextStrings.getLine(20);
                        displayMessage(message);
                        break;
                    case 21:
                        message = tileTextStrings.getLine(21);
                        displayMessage(message);
                        break;
                    case 22:
                        message = tileTextStrings.getLine(22);
                        displayMessage(message);
                        break;
                    case 23:
                        message = tileTextStrings.getLine(23);
                        displayMessage(message);
                        break;
                    case 24:
                        message = tileTextStrings.getLine(24);
                        displayMessage(message);
                        break;
                } */

    private void displayMessage(String message) {
        getGui().displayChanceCard(message);

        getGui().showMessage(showString);
    }
}
