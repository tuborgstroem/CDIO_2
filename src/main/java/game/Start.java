package game;
import gui_fields.*;
import gui_main.GUI;

import java.awt.*;

    public class Start extends SpecialFields {

        private final int startbonus = 2;

        public Start (int fields, GUI gui) {

            super(fields, gui);
        }
        /**
         * toString til udskrivning af besked, når spilleren lander på start, eller passerer start
         */
        @Override
        public String toString(){
            if(fields == 0){
                return "Du har landet på start, og modtager en startbonus på " + startbonus + "M";
            }
            else{
                return "Du har passeret start, og modtager en startbonus på " + startbonus + "M";
            }
        }

        @Override
        public void landOnField(Player player) {
            gui.showMessage(toString());
        }
    }

