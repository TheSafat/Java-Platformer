package GameState;

import TileMap.Background;
import java.awt.*;
import java.awt.event.KeyEvent;

public class MenuState extends GameState{

    private Background bg;

    private int currentChoice = 0;
    private String[] option = {"Start", "Help", "Quit"};

    private Color titleColor;
    private Font titleFont;

    private Font font;

    public MenuState(GameStateManager gsm){
        this.gsm = gsm;
        try{
            bg = new Background("/Backgrounds/menubg.gif", 1);
            bg.setVector(-0.1, 0);

            titleColor = new Color(128,0,0);
            titleFont = new Font("Century Gothic", Font.PLAIN, 28 );

            font = new Font("Arial", Font.PLAIN, 12);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Override
    public void init() {

    }

    @Override
    public void update() {
        bg.update();

    }

    @Override
    public void draw(Graphics2D g) {
        // draw bg
        bg.draw(g);

        // draw Title
        g.setColor(titleColor);
        g.setFont(titleFont);
        g.drawString("Dragon Tale", 80, 70);

        // draw menu options
        g.setFont(font);
        for(int i=0; i< option.length; i++){
            if(i== currentChoice){
                g.setColor(Color.BLACK);
            } else {
                g.setColor(Color.RED);
            }
            g.drawString(option[i], 145, 140+i*15);
        }

    }

    private void select(){
        if(currentChoice == 0){

            gsm.setState(GameStateManager.LEVEL1STATE);
            System.out.println("select 1");
        }
        if(currentChoice == 1){

        }
        if(currentChoice == 2){
            System.exit(0);
        }
    }

    @Override
    public void keyPressed(int k) {
        if(k== KeyEvent.VK_ENTER){
            select();
        }
        if(k == KeyEvent.VK_UP){
            currentChoice--;
            if(currentChoice == -1){
                currentChoice = option.length - 1;
            }
        }
        if(k == KeyEvent.VK_DOWN){
            currentChoice++;
            if(currentChoice == option.length){
                currentChoice = 0;
            }
        }

    }

    @Override
    public void keyReleased(int k) {

    }
}
