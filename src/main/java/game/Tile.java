package game;

import gui_fields.GUI_Field;

public class Tile {

    private Player owner;
    private int number;
    private String description;
    private int effect;
    private boolean extraTurn;
    private GUI_Field gui_field;
    private String flavor;
    public Tile (){}
    public Tile (int number1, String description1, int effect1, GUI_Field gui_field1, String flavor1){
        number=number1;
        description=description1;
        effect=effect1;
        gui_field=gui_field1;
        flavor=flavor1;
        gui_field.setTitle(description);
        gui_field.setSubText(Integer.toString(number));
        gui_field.setDescription(flavor);
        owner = null;

    }

    public int getEffect() {
        return effect;
    }

    public boolean getExtraTurn() {
        return extraTurn;
    }

    public GUI_Field getGui_field() {
        return gui_field;
    }
}

