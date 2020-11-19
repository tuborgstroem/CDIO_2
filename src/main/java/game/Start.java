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
                return "You landed on start and will receive a bonus on your next turn" + startbonus + "M";
            }
            else{
                return "You've passed start and will receive a bonus" + startbonus + "M";
            }
        }

        @Override
        public void landOnField(Player player) {
            gui.showMessage(toString());
        }
    }

