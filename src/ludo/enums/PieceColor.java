package ludo.enums;

import java.awt.*;

public enum PieceColor {
    RED(new Color(136, 0 ,0)),
    GREEN(new Color(0, 204 ,0)),
    BLUE(new Color(0, 102 ,255)),
    YELLOW(new Color(255, 220 ,26));

    private Color color;
    PieceColor(Color color){
        this.color = color;
    }

    public Color getColor() {
        return color;
    }
}
