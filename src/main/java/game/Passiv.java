package game;
import gui_fields.GUI_Field;
import gui_fields.*;
import gui_main.GUI;

public class Passiv extends SpecialFields{
        private String fieldNavn;

        public Passiv (int fields, GUI gui) {
            super(fields, gui);
            switch(fields){
                case 6: fieldNavn = "på besøg"; break;
                case 12: fieldNavn = "parking lot"; break;
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
            if(fieldNavn.equals("på besøg"))
                return "Du er bare " + fieldNavn;
            else
                return fieldNavn + ", du behøver ikke gøre noget, bare snup dig en pause";
        }
    @Override
    public void landOnField(Player player) {
        gui.showMessage(toString());

        }
}
