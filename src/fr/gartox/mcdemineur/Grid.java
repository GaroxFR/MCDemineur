package fr.gartox.mcdemineur;

import fr.gartox.mcdemineur.utils.SquareType;
import fr.gartox.mcdemineur.utils.Utils;
import org.bukkit.*;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Firework;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.FireworkMeta;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by GartoxFR on 07/05/2017.
 */
public class Grid {

    private int height;
    private Square squares[][];
    private Player player;
    private Inventory inventory;
    private boolean lose = false;
    private List<Inventory> spectators = new ArrayList<Inventory>();

    public Grid(int y, Player player) {
        this.setSquares(new Square[9][y]);
        this.setPlayer(player);
        this.height = y;
    }

    public void open(){
        setInventory(Bukkit.createInventory(getPlayer(), 9*height, "Démineur"));
        init(getInventory());
        for(int y = 0 ; y < height ; y++){
            for(int x = 0 ; x < 9 ; x++) {
                squares[x][y].draw(getInventory());
            }
        }
        getPlayer().openInventory(this.getInventory());
    }

    public void init(Inventory inventory){
        int i = 0;
        for(int y = 0 ; y < height ; y++){
            for(int x = 0 ; x < 9 ; x++){
                squares[x][y] = new Square(SquareType.UNGENGERATED, i, inventory);
                squares[x][y].setDiscover(false);
                i++;
            }
        }
        for(int a = 0 ; a < 10 ; a++){
            Random rand = new Random();
            int x;
            int y;
            do{
                x = rand.nextInt(9);
                y = rand.nextInt(height);
                if(squares[x][y].getType() != SquareType.BOMB)squares[x][y].setType(SquareType.BOMB);
            }while (squares[x][y].getType() != SquareType.BOMB);

        }

        for(int x = 0 ; x < 9 ; x++){
            for(int y = 0; y < height ; y++){
                if(squares[x][y].getType() != SquareType.BOMB) {
                    int buffer = 0;
                    if (x == 0) {
                        if (y == 0) {
                            if(squares[x+1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y+1].getType() == SquareType.BOMB)buffer++;
                        } else if (y == height - 1) {
                            if(squares[x+1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y-1].getType() == SquareType.BOMB)buffer++;
                        } else {
                            if(squares[x+1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y-1].getType() == SquareType.BOMB)buffer++;
                        }
                    } else if (x == 8) {
                        if (y == 0) {
                            if(squares[x-1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x-1][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y+1].getType() == SquareType.BOMB)buffer++;
                        } else if (y == height - 1) {
                            if(squares[x-1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x-1][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y-1].getType() == SquareType.BOMB)buffer++;
                        } else {
                            if(squares[x-1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x-1][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x-1][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y-1].getType() == SquareType.BOMB)buffer++;
                        }
                    } else {
                        if (y == 0) {
                            if(squares[x-1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x-1][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y+1].getType() == SquareType.BOMB)buffer++;
                        } else if (y == height - 1) {
                            if(squares[x-1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x-1][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y-1].getType() == SquareType.BOMB)buffer++;
                        } else {
                            if(squares[x-1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y].getType() == SquareType.BOMB)buffer++;
                            if(squares[x-1][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y-1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x-1][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x][y+1].getType() == SquareType.BOMB)buffer++;
                            if(squares[x+1][y+1].getType() == SquareType.BOMB)buffer++;
                        }
                    }
                 squares[x][y].setType(Utils.getType(buffer));
                }
            }
        }

    }

    public void draw(){
        for(int x = 0 ; x < 9 ; x++){
            for(int y = 0; y < height ; y++){
                squares[x][y].draw(getInventory());
                for(Inventory inventory : spectators){
                    squares[x][y].draw(inventory);
                }
            }
        }
    }

    public void discover(int slot) {
        int x = slot % 9;
        int y = slot / 9;
        discover(x, y);
    }

    public void discover(int x, int y){
        if (squares[x][y].isFlag()) return;
        if(squares[x][y].getType() == SquareType.BOMB){
            if(!lose)
                lose();
        } else if(squares[x][y].getType() == SquareType.ZERO){
            squares[x][y].setDiscover(true);
            if (x == 0) {
                if (y == 0) {
                    if(!squares[x][y+1].isDiscover())
                        discover(x, y+1);
                    if(!squares[x+1][y+1].isDiscover())
                        discover(x+1, y+1);
                    if(!squares[x+1][y].isDiscover())
                        discover(x+1, y);
                } else if (y == height - 1) {
                    if(!squares[x][y-1].isDiscover())
                        discover(x, y-1);
                    if(!squares[x+1][y-1].isDiscover())
                        discover(x+1, y-1);
                    if(!squares[x+1][y].isDiscover())
                        discover(x+1, y);
                } else {
                    if(!squares[x][y+1].isDiscover())
                        discover(x, y+1);
                    if(!squares[x+1][y+1].isDiscover())
                        discover(x+1, y+1);
                    if(!squares[x+1][y].isDiscover())
                        discover(x+1, y);
                    if(!squares[x][y-1].isDiscover())
                        discover(x, y-1);
                    if(!squares[x+1][y-1].isDiscover())
                        discover(x+1, y-1);
                }
            } else if (x == 8) {
                if (y == 0) {
                    if(!squares[x][y+1].isDiscover())
                        discover(x, y+1);
                    if(!squares[x-1][y+1].isDiscover())
                        discover(x-1, y+1);
                    if(!squares[x-1][y].isDiscover())
                        discover(x-1, y);
                } else if (y == height - 1) {
                    if(!squares[x][y-1].isDiscover())
                        discover(x, y-1);
                    if(!squares[x-1][y-1].isDiscover())
                        discover(x-1, y-1);
                    if(!squares[x-1][y].isDiscover())
                        discover(x-1, y);
                } else {
                    if(!squares[x][y+1].isDiscover())
                        discover(x, y+1);
                    if(!squares[x-1][y+1].isDiscover())
                        discover(x-1, y+1);
                    if(!squares[x-1][y].isDiscover())
                        discover(x-1, y);
                    if(!squares[x][y-1].isDiscover())
                        discover(x, y-1);
                    if(!squares[x-1][y-1].isDiscover())
                        discover(x-1, y-1);
                }
            } else {
                if (y == 0) {
                    if(!squares[x+1][y+1].isDiscover())
                        discover(x+1, y+1);
                    if(!squares[x-1][y+1].isDiscover())
                        discover(x-1, y+1);
                    if(!squares[x+1][y].isDiscover())
                        discover(x+1, y);
                    if(!squares[x-1][y].isDiscover())
                        discover(x-1, y);
                    if(!squares[x][y+1].isDiscover())
                        discover(x, y+1);
                } else if (y == height - 1) {
                    if(!squares[x+1][y-1].isDiscover())
                        discover(x+1, y-1);
                    if(!squares[x-1][y-1].isDiscover())
                        discover(x-1, y-1);
                    if(!squares[x+1][y].isDiscover())
                        discover(x+1, y);
                    if(!squares[x-1][y].isDiscover())
                        discover(x-1, y);
                    if(!squares[x][y-1].isDiscover())
                        discover(x, y-1);
                } else {
                    if(!squares[x+1][y+1].isDiscover())
                        discover(x+1, y+1);
                    if(!squares[x-1][y+1].isDiscover())
                        discover(x-1, y+1);
                    if(!squares[x+1][y].isDiscover())
                        discover(x+1, y);
                    if(!squares[x-1][y].isDiscover())
                        discover(x-1, y);
                    if(!squares[x][y+1].isDiscover())
                        discover(x, y+1);
                    if(!squares[x+1][y-1].isDiscover())
                        discover(x+1, y-1);
                    if(!squares[x-1][y-1].isDiscover())
                        discover(x-1, y-1);
                    if(!squares[x][y-1].isDiscover())
                        discover(x, y-1);
                }
            }

        } else {
            squares[x][y].setDiscover(true);
        }

        draw();
        if (verifyWin()) win();
    }

    private void win() {
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < height; y++) {
                squares[x][y].setDiscover(true);
            }
        }
        getPlayer().playSound(getPlayer().getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 1);

        for (int i = 5; i >= 0; i--) {
            Firework f = ((Firework) getPlayer().getWorld().spawnEntity(getPlayer().getLocation(), EntityType.FIREWORK));
            FireworkMeta fm = f.getFireworkMeta();
            fm.addEffect(FireworkEffect.builder().flicker(false).trail(true).with(FireworkEffect.Type.BALL_LARGE).withColor(Color.AQUA).withColor(Color.WHITE).build());
            fm.setPower(0);
            f.setFireworkMeta(fm);
        }

        getPlayer().sendMessage(ChatColor.GOLD + "[MCDémineur]" + ChatColor.YELLOW + "Vous avez gagné");
        Utils.removeGrid(getPlayer());
    }

    private boolean verifyWin() {
        if (lose) return false;
        boolean cond = true;
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < height; y++) {
                if (squares[x][y].getType() != SquareType.BOMB && !(squares[x][y].isDiscover())) {
                    cond = false;
                }

            }
        }
        return cond;
    }

    private void lose() {
        lose = true;
        for(int x = 0 ; x < 9 ; x++){
            for(int y = 0 ; y < height  ; y++){
                squares[x][y].setDiscover(true);
            }
        }
        draw();
        getPlayer().playSound(getPlayer().getLocation(), Sound.ENTITY_GENERIC_EXPLODE, 1, 1);
        getPlayer().sendMessage(ChatColor.GOLD + "[MCDémineur]" + ChatColor.YELLOW + "Vous avez perdu");
        Utils.removeGrid(getPlayer());
    }

    public void addSpectator(Inventory inventory, Player owner){
        spectators.add(inventory);
        owner.openInventory(inventory);
        draw();
    }

    public Square[][] getSquares() {
        return squares;
    }

    public void setSquares(Square[][] squares) {
        this.squares = squares;
    }

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

}
