
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.player.PlayerDropItemEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;

public class GUIopenerDevKit implements Listener {

    public void onEnable() {
        Bukkit.getPluginManager().registerEvents((Listener) this, (Plugin) this);
    }
    Player player;

    Inventory myinv = Bukkit.createInventory(player, 54, ChatColor.BLUE + "ModMenu");

    //space to code your GUI


    //this below info is what you want your key to be.
    //keyType needs a variable and keyName needs a string.

    Material keyType = Material.NETHER_STAR;
    String keyName = "Menu";


    @EventHandler



    public void onInteract(PlayerInteractEvent e){

        Player clicker = e.getPlayer();
        if (e.getHand().equals(EquipmentSlot.HAND)){

            if (e.hasItem()){

                if (e.getItem().getType().equals(keyType)){

                    if (e.getItem().getItemMeta().getDisplayName() == keyName){

                        clicker.openInventory(myinv);

                    }

                }

            }

        }

    }

    public void onInventoryInteract(InventoryClickEvent e){



        ItemMeta clickmeta = e.getCurrentItem().getItemMeta();
        if (e.getCurrentItem().getType() == keyType){

            if(clickmeta.getDisplayName() == "Menu"){

                Player invclicked = (Player) e.getWhoClicked();
                invclicked.openInventory(myinv);
                e.setCancelled(true);

            }


        }

    }
    public void onDrop(PlayerDropItemEvent e){

        ItemMeta dropMeta = e.getItemDrop().getItemStack().getItemMeta();
        if (dropMeta.getDisplayName() == keyName){

            if (e.getItemDrop().getItemStack().getType() == keyType) {

                e.setCancelled(true);

            }

        }

    }
}


}
