package game;
import gui_fields.GUI_Field;
import gui_fields.*;
import gui_main.GUI;

public class Passive extends SpecialFields{
        private String fieldNavn;

        public Passive(int fields, GUI gui) {
            super(fields, gui);
            switch(fields){
                case 6: fieldNavn = "On visit"; break;
                case 12: fieldNavn = "Parking lot"; break;
                default:
                    break;
            }
        }
        /**
         * toString til udskrivning af tekst, når en spiller lander enten på "på besøg i fængsel"-feltet
         * eller gratis parkering feltet.
         *
         * @return String
         */
        @Override
        public String toString(){
            if(fieldNavn.equals("On visit"))
                return "You are just " + fieldNavn;
            else
                return fieldNavn + ", You don't have to do anything just take a break";
        }
    @Override
    public void landOnField(Player player) {
        gui.showMessage(toString());

        }
}
