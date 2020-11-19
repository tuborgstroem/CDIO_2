package game;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;
import gui_fields.GUI_Field;

    public class Prison extends SpecialFields {

        public Prison(int fields, GUI gui){
            super(fields, gui);
        }
        /**
         * toString til udskrivning af besked, når spilleren lander på feltet.
         */
        @Override
        public String toString(){
            return "Du er blevet taget for at stjæle slik, og skal i fængsel";
        }

        public void setIPrison(Player player){
            player.setPlacering(6);
        }

        /**
         * landOnFiels indeholder fængselfeltets spil logik
         * @param
         */
        @Override
        public void landOnField(Player player) {
            gui.showMessage(toString());
            setIPrison(player);
            player.setPrison(true);
        }


    }

