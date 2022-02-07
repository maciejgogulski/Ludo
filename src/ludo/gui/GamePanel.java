package ludo.gui;

import ludo.enums.PieceColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayDeque;
import java.util.LinkedList;

public class GamePanel extends JPanel {

    public class Field extends JLabel implements MouseListener {
        private Color color;
        private LinkedList<Piece> pieces;
        private int ID;

        public Field(int posX, int posY, int id) {
            super();
            setLocation(posX, posY);
            setSize(35, 35);
            setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            setOpaque(true);
            color = new Color(255, 242, 230);
            pieces = new LinkedList<>();
            ID = id;
            setBackground(color);
            addMouseListener(this);
        }

        public Field(int posX, int posY, Color color, int id) {
            super();
            this.color = color;
            setLocation(posX, posY);
            setSize(35, 35);
            setBorder(BorderFactory.createMatteBorder(1, 1, 1, 1, Color.BLACK));
            pieces = new LinkedList<>();
            ID = id;
            setBackground(color);
            setOpaque(true);
            addMouseListener(this);
        }

        public void addPiece(Piece piece) {
            pieces.add(piece);
            repaint();
        }

        public void removePiece() {
            if (hasPiece()) {
                pieces.remove();
                setBackground(color);
                repaint();
            }
        }

        public void take(Field field) {
            switch (field.getPiece().getColor()){
                case RED ->{
                    while(field.getPieces().size() != 0){
                        for(int i = 0; i < RED_BASE.length; i++){
                            if(!RED_BASE[i].hasPiece()){
                                RED_BASE[i].addPiece(field.getPiece());
                                break;
                            }
                        }
                        field.removePiece();
                    }
                }
                case BLUE -> {
                    while(field.getPieces().size() != 0){
                        for(int i = 0; i < RED_BASE.length; i++){
                            if(!BLUE_BASE[i].hasPiece()){
                                BLUE_BASE[i].addPiece(field.getPiece());
                                break;
                            }
                        }
                        field.removePiece();
                    }
                }
                case GREEN -> {
                    while(field.getPieces().size() != 0){
                        for(int i = 0; i < RED_BASE.length; i++){
                            if(!GREEN_BASE[i].hasPiece()){
                                GREEN_BASE[i].addPiece(field.getPiece());
                                break;
                            }
                        }
                        field.removePiece();
                    }
                }
                case YELLOW ->{
                    while(field.getPieces().size() != 0){
                        for(int i = 0; i < RED_BASE.length; i++){
                            if(!YELLOW_BASE[i].hasPiece()){
                                YELLOW_BASE[i].addPiece(field.getPiece());
                                break;
                            }
                        }
                        field.removePiece();
                    }
                }
            }
        }

        public void movePiece() {
            int cord = ID + dice.getValue();
            if (hasPiece()) {
                switch (getPiece().getColor()) {
                    case RED -> {
                        if(ID >= 68 && ID <= 73){
                            cord = cord - 68;
                            if(cord < 6) {
                                RED_HOUSE[cord].addPiece(getPiece());
                                removePiece();
                            }
                            if(RED_HOUSE[5].getPieces().size() == 4){
                                gameWon(PieceColor.RED);
                            }
                            switchQueue();
                            return;
                        }else{
                            if (ID >= 52 && ID <= 55) {
                                if (dice.getValue() == 6) {
                                    if(BOARD[0].hasPiece() && !BOARD[0].getPiece().getColor().equals(PieceColor.RED)){
                                        take(BOARD[0]);
                                    }
                                    BOARD[0].addPiece(getPiece());
                                    removePiece();
                                    switchQueue();
                                }
                                return;
                            }
                            if (ID < 51 && cord > 50) {
                                cord = cord - 51;
                                RED_HOUSE[cord].addPiece(getPiece());
                                removePiece();
                                switchQueue();
                                return;
                            }
                        }
                    }
                    case BLUE -> {
                        if(ID >= 74 && ID <= 79){
                            cord = cord - 74;
                            if(cord < 6) {
                                BLUE_HOUSE[cord].addPiece(getPiece());
                                removePiece();
                            }
                            if(BLUE_HOUSE[5].getPieces().size() == 4){
                                gameWon(PieceColor.BLUE);
                            }
                            switchQueue();
                            return;
                        }else {
                            if (ID >= 56 && ID <= 59) {
                                if (dice.getValue() == 6) {
                                    if(BOARD[13].hasPiece() && !BOARD[13].getPiece().getColor().equals(PieceColor.BLUE)){
                                        take(BOARD[13]);
                                    }
                                    BOARD[13].addPiece(getPiece());
                                    removePiece();
                                    switchQueue();
                                }
                                return;
                            }
                            if (ID < 12 && cord > 11) {
                                cord = cord - 12;
                                BLUE_HOUSE[cord].addPiece(getPiece());
                                removePiece();
                                switchQueue();
                                return;
                            }
                        }
                    }
                    case GREEN -> {
                        if(ID >= 80 && ID <= 85){
                            cord = cord - 80;
                            if(cord < 6) {
                                GREEN_HOUSE[cord].addPiece(getPiece());
                                removePiece();
                            }
                            if(GREEN_HOUSE[5].getPieces().size() == 4){
                                gameWon(PieceColor.GREEN);
                            }
                            switchQueue();
                            return;
                        }else {
                            if (ID >= 60 && ID <= 63) {
                                if (dice.getValue() == 6) {
                                    if(BOARD[26].hasPiece() && !BOARD[26].getPiece().getColor().equals(PieceColor.GREEN)){
                                        take(BOARD[26]);
                                    }
                                    BOARD[26].addPiece(getPiece());
                                    removePiece();
                                    switchQueue();
                                }
                                return;
                            }
                            if (ID < 25 && cord > 24) {
                                cord = cord - 25;
                                GREEN_HOUSE[cord].addPiece(getPiece());
                                removePiece();
                                switchQueue();
                                return;
                            }
                        }
                    }
                    case YELLOW -> {
                        if (ID >= 86 && ID <= 91) {
                            cord = cord - 86;
                            if(cord < 6) {
                                YELLOW_HOUSE[cord].addPiece(getPiece());
                                removePiece();
                            }
                            if(YELLOW_HOUSE[5].getPieces().size() == 4){
                                gameWon(PieceColor.YELLOW);
                            }
                            switchQueue();
                            return;
                        } else {
                            if (ID >= 64 && ID <= 67) {
                                if (dice.getValue() == 6) {
                                    if(BOARD[39].hasPiece() && !BOARD[39].getPiece().getColor().equals(PieceColor.YELLOW)){
                                        take(BOARD[39]);
                                    }
                                    BOARD[39].addPiece(getPiece());
                                    removePiece();
                                    switchQueue();
                                }
                                return;
                            }
                            if (ID < 38 && cord > 37) {
                                cord = cord - 38;
                                YELLOW_HOUSE[cord].addPiece(getPiece());
                                removePiece();
                                switchQueue();
                                return;
                            }
                        }
                    }
                }

                if (cord >= BOARD.length) {
                    cord = cord - BOARD.length;
                }
                if(BOARD[cord].hasPiece() && !BOARD[cord].getPiece().getColor().equals(getPiece().getColor())){
                    take(BOARD[cord]);
                }
                BOARD[cord].addPiece(getPiece());
                removePiece();
                switchQueue();
            }
        }

        public void setColor(Color color) {
            this.color = color;
            setBackground(color);
        }

        public Color getColor() {
            return color;
        }

        public Piece getPiece() {
            return pieces.getLast();
        }

        public LinkedList<Piece> getPieces() {
            return pieces;
        }

        public boolean hasPiece() {
            return pieces.size() != 0;
        }

        @Override
        public void mouseClicked(MouseEvent e) {
            if(!isWon && hasPiece() && queue.peek().equals(getPiece().getColor())){
                movePiece();
            }
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {

        }

        @Override
        public void mouseExited(MouseEvent e) {

        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            if (pieces.size() >= 1) {
                g2d.drawImage(getPiece().getImage(), 7, 5, null);
                if (pieces.size() > 1) {
                    String s = "";
                    s += pieces.size();
                    g2d.drawString(s, 1, 10);
                }
            }
            repaint();
        }
    }


    private final Field[] BOARD = new Field[52];

    private final Field[] RED_BASE = new Field[4];
    private final Field[] BLUE_BASE = new Field[4];
    private final Field[] GREEN_BASE = new Field[4];
    private final Field[] YELLOW_BASE = new Field[4];

    private final Field[] RED_HOUSE = new Field[6];
    private final Field[] BLUE_HOUSE = new Field[6];
    private final Field[] GREEN_HOUSE = new Field[6];
    private final Field[] YELLOW_HOUSE = new Field[6];

    private final Color RED = new Color(136, 0, 0);
    private final Color BLUE = new Color(0, 102, 255);
    private final Color YELLOW = new Color(255, 220, 26);
    private final Color GREEN = new Color(0, 204, 0);

    public Dice dice;
    public ArrayDeque<PieceColor> queue = new ArrayDeque<>();
    public boolean isWon;
    public PieceColor winner;


    public GamePanel() {
        super();
        setSize(512, 512);
        setLayout(null);
        drawBases();
        drawHouses();
        drawBoard();
        fillQueue();
        isWon = false;
        dice = new Dice();
        add(dice);

        // Jeżeli nie można wykonać ruchu, trzeba spasować :(
        JButton pass = new JButton("Pass");
        pass.addActionListener(e -> {
            switchQueue();
            dice.setRolled(false);
        });
        pass.setBackground(new Color(255,170,0));
        pass.setBounds(5, 5, 70, 34);
        add(pass);

    }

    public void drawBoard() {
        int x = 34;
        int y = 204;
        int i = 0;
        while (i <= 4) {
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            x += 34;
            i++;
        }
        while (i >= 5 && i <= 10) {
            y -= 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        while (i >= 11 && i <= 12) {
            x += 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        while (i >= 13 && i <= 17) {
            y += 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        y += 34;
        while (i >= 18 && i <= 23) {
            x += 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        while (i >= 24 && i <= 25) {
            y += 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        while (i >= 26 && i <= 30) {
            x -= 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        x -= 34;
        while (i >= 31 && i <= 36) {
            y += 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        while (i >= 37 && i <= 38) {
            x -= 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        while (i >= 39 && i <= 43) {
            y -= 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        y -= 34;
        while (i >= 44 && i <= 49) {
            x -= 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }
        while (i >= 50 && i <= 51) {
            y -= 34;
            BOARD[i] = new Field(x, y, i);
            add(BOARD[i]);
            i++;
        }

        BOARD[0].setColor(RED);
        BOARD[13].setColor(BLUE);
        BOARD[26].setColor(GREEN);
        BOARD[39].setColor(YELLOW);
    }

    public void drawBases() {
        RED_BASE[0] = new Field(51, 85, RED, 52);
        RED_BASE[1] = new Field(119, 85, RED, 53);
        RED_BASE[2] = new Field(85, 51, RED, 54);
        RED_BASE[3] = new Field(85, 119, RED, 55);

        for (int i = 0; i < 4; i++) {
            add(RED_BASE[i]);
            RED_BASE[i].addPiece(new Piece(PieceColor.RED));
        }

        BLUE_BASE[0] = new Field(391, 51, BLUE, 56);
        BLUE_BASE[1] = new Field(391, 119, BLUE, 57);
        BLUE_BASE[2] = new Field(357, 85, BLUE, 58);
        BLUE_BASE[3] = new Field(425, 85, BLUE, 59);

        for (int i = 0; i < 4; i++) {
            add(BLUE_BASE[i]);
            BLUE_BASE[i].addPiece(new Piece(PieceColor.BLUE));
        }

        GREEN_BASE[0] = new Field(391, 357, GREEN, 60);
        GREEN_BASE[1] = new Field(357, 391, GREEN, 61);
        GREEN_BASE[2] = new Field(425, 391, GREEN, 62);
        GREEN_BASE[3] = new Field(391, 425, GREEN, 63);

        for (int i = 0; i < 4; i++) {
            add(GREEN_BASE[i]);
            GREEN_BASE[i].addPiece(new Piece(PieceColor.GREEN));
        }

        YELLOW_BASE[0] = new Field(85, 357, YELLOW, 64);
        YELLOW_BASE[1] = new Field(51, 391, YELLOW, 65);
        YELLOW_BASE[2] = new Field(119, 391, YELLOW, 66);
        YELLOW_BASE[3] = new Field(85, 425, YELLOW, 67);

        for (int i = 0; i < 4; i++) {
            add(YELLOW_BASE[i]);
            YELLOW_BASE[i].addPiece(new Piece(PieceColor.YELLOW));
        }
    }

    public void drawHouses() {
        int rx = 34;
        int j = 68;
        for (int i = 0; i < 6; i++) {
            RED_HOUSE[i] = new Field(rx, 238, RED, j);
            add(RED_HOUSE[i]);
            rx += 34;
            j++;
        }

        int by = 34;
        for (int i = 0; i < 6; i++) {
            BLUE_HOUSE[i] = new Field(238, by, BLUE, j);
            add(BLUE_HOUSE[i]);
            by += 34;
            j++;
        }

        int gx = 442;
        for (int i = 0; i < 6; i++) {
            GREEN_HOUSE[i] = new Field(gx, 238, GREEN, j);
            add(GREEN_HOUSE[i]);
            gx -= 34;
            j++;
        }

        int yy = 442;
        for (int i = 0; i < 6; i++) {
            YELLOW_HOUSE[i] = new Field(238, yy, YELLOW,j);
            add(YELLOW_HOUSE[i]);
            yy -= 34;
            j++;
        }
    }

    public void fillQueue(){
        queue.add(PieceColor.RED);
        queue.add(PieceColor.BLUE);
        queue.add(PieceColor.GREEN);
        queue.add(PieceColor.YELLOW);
    }

    public void switchQueue(){
        if(dice.getValue() != 6) {
            int x = 0, y = 0;
            queue.add(queue.pop());
            switch (queue.peek()) {
                case RED -> {
                    x = 136;
                    y = 136;
                }
                case BLUE -> {
                    x = 336;
                    y = 136;
                }
                case GREEN -> {
                    x = 336;
                    y = 340;
                }
                case YELLOW -> {
                    x = 136;
                    y = 336;
                }
            }
            dice.setLocation(x, y);
        }
        dice.setRolled(false);
    }

    public void gameWon(PieceColor winner){
        this.winner = winner;
        isWon = true;
        String message = "Wygrał ";
        switch (winner){
            case RED -> {
                message += "czerwony";
            }
            case BLUE -> {
                message += "niebieski";
            }
            case GREEN -> {
                message += "zielony";
            }
            case YELLOW -> {
                message += "żółty";
            }
        }
        JOptionPane.showMessageDialog(null, message);
    }

    public boolean isWon() {
        return isWon;
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        //Graphics2D g2d = (Graphics2D) g;
        setBackground(Color.ORANGE);
    }

}
