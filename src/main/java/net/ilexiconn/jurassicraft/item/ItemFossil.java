package net.ilexiconn.jurassicraft.item;

import java.util.List;

import net.ilexiconn.jurassicraft.dinosaur.Dinosaur;
import net.ilexiconn.jurassicraft.entity.base.JCEntityRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemFossil extends Item
{

    public ItemFossil()
    {
        this.setUnlocalizedName("item_fossil");
        this.setHasSubtypes(true);
    }

    @Override
    public String getItemStackDisplayName(ItemStack stack)
    {
        Dinosaur dinosaur = this.getDinosaur(stack);

        if (dinosaur != null)
            return (StatCollector.translateToLocal("entity." + dinosaur.getName().replace(" ", "_").toLowerCase() + ".name") + " " + StatCollector.translateToLocal("item.item_fossil.name")).trim();

        return super.getItemStackDisplayName(stack);
    }

    public Dinosaur getDinosaur(ItemStack stack)
    {
        return JCEntityRegistry.getDinosaurById(stack.getItemDamage());
    }

    @Override
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs tab, List subtypes)
    {
        int i = 0;
        for (Dinosaur dino : JCEntityRegistry.getDinosaurs())
        {
            if (dino.shouldRegister())
            {
                subtypes.add(new ItemStack(item, 1, i));
                i++;
            }
        }
    }
}
