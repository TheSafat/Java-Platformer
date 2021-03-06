package GameState;

import Main.GamePanel;
import TileMap.*;
import java.awt.*;

public class Level1State extends GameState{

    private TileMap tileMap;

    public Level1State(GameStateManager gsm){
        this.gsm = gsm;
        init();
    }


    @Override
    public void init() {
        tileMap = new TileMap(30);
        tileMap.loadTiles("/Tilesets/grasstileset.gif");
        tileMap.loadMap("/Maps/level1-1.map");
        tileMap.setPosition(0, 0);

    }

    @Override
    public void update() {

    }

    @Override
    public void draw(Graphics2D g) {
        // clear screen
        g.setColor(Color.WHITE);
        g.fillRect(0, 0, GamePanel.WIDTH, GamePanel.HEIGHT);

        // draw Tilemap
        tileMap.draw(g);
    }

    @Override
    public void keyPressed(int k) {

    }

    @Override
    public void keyReleased(int k) {

    }
}
