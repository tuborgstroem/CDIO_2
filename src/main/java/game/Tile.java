package game;

import gui_fields.GUI_Field;
import gui_fields.GUI_Street;

import java.awt.*;

public class Tile {

    private Player owner;
    private int number;
    private String description;
    private int rent;
    private GUI_Field gui_field;
    private Color tileColor;
    public Tile (){}
    public Tile (int number1, String description1, int effect1, GUI_Field gui_field1){
        number=number1;
        description=description1;
        rent =effect1;
        gui_field=gui_field1;
        gui_field.setTitle(description);
        gui_field.setSubText(Integer.toString(number));
        owner = null;
    }

    public Tile (int effect1, GUI_Field gui_field1){
        rent =effect1;
        gui_field=gui_field1;
        tileColor=null;
        owner = null;
    }

    public int getRent() {
        return rent;
    }

    public Player getOwner() {
        return owner;
    }

    public void setOwner(Player owner) {
        this.owner = owner;
    }

    public Color getTileColor() {
        return tileColor;
    }

    public void setTileColor(Color tileColor) {
        this.tileColor = tileColor;
    }

    public GUI_Field getGui_field() {
        return gui_field;
    }

    public void showMessage(Player player){
        System.out.println(player.getName() + this.description + "penis");
    }
}

