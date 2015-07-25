package net.timeless.animationapi;

import net.minecraft.entity.Entity;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.network.simpleimpl.SimpleNetworkWrapper;
import net.minecraftforge.fml.relauncher.Side;
import net.timeless.animationapi.packet.PacketAnim;

@Mod(modid = "JCAnimationAPI", name = "JurassiCraft AnimationAPI", version = "1.2.5")
public class AnimationAPI
{

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e)
    {
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e)
    {
        wrapper = NetworkRegistry.INSTANCE.newSimpleChannel("AnimAPI");
        wrapper.registerMessage(PacketAnim.Handler.class, PacketAnim.class, 0, Side.CLIENT);
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e)
    {
        proxy.initTimer();
    }

    public static boolean isClient()
    {
        return FMLCommonHandler.instance().getSide().isClient();
    }

    public static boolean isEffectiveClient()
    {
        return FMLCommonHandler.instance().getEffectiveSide().isClient();
    }

    public static void sendAnimPacket(IAnimatedEntity entity, int animID)
    {
        if (isEffectiveClient())
            return;
        entity.setAnimID(animID);
        wrapper.sendToAll(new PacketAnim((byte) animID, ((Entity) entity).getEntityId()));
    }

    @Mod.Instance("AnimationAPI")
    public static AnimationAPI instance;
    @SidedProxy(clientSide = "net.timeless.animationapi.client.ClientProxy", serverSide = "net.timeless.animationapi.CommonProxy")
    public static CommonProxy proxy;
    public static SimpleNetworkWrapper wrapper;

    public static final String[] fTimer;

    static
    {
        fTimer = new String[] { "field_71428_T", "S", "timer" };
    }

    public static CommonProxy getProxy()
    {
        return proxy;
    }

    public static String[] getFTimer()
    {
        return fTimer;
    }
}
