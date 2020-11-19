package game;

import gui_main.GUI;
import gui_fields.*;
import gui_main.GUI;
import game.Player;
import java.awt.*;
public abstract class SpecialFields {

        /**Protected, så de er synlige for pakken, og for nedarvede klasser
         */
        protected int fields;
        protected GUI gui;


        public SpecialFields(int fields, GUI gui)
        {
            this.fields = fields;
            this.gui = gui;
        }


        public abstract String toString();


        public abstract void landOnField(Player player);




    }

