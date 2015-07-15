package net.timeless.jurassicraft.client.dinosaur.renderdef;

import net.ilexiconn.llibrary.client.model.entity.animation.IModelAnimator;
import net.ilexiconn.llibrary.client.model.tabula.ModelJson;
import net.minecraft.client.model.ModelBase;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.timeless.jurassicraft.client.model.animation.AnimationBrachiosaurus;
import net.timeless.jurassicraft.common.entity.base.JCEntityRegistry;

@SideOnly(Side.CLIENT)
public class RenderDefBrachiosaurus extends RenderDinosaurDefinition
{
    private IModelAnimator animator;
    private ModelJson model;

    public RenderDefBrachiosaurus()
    {
        super(JCEntityRegistry.brachiosaurus);

        this.animator = new AnimationBrachiosaurus();

        try
        {
            this.model = getDefaultTabulaModel();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    @Override
    //TODO offset and hitbox
    public ModelBase getModel()
    {
        return model;
    }

    @Override
    public float getAdultScaleAdjustment()
    {
        return 2.0F;
    }

    @Override
    public float getBabyScaleAdjustment()
    {
        return 0.25F;
    }

    @Override
    public float getShadowSize()
    {
        return 1.5F;
    }

    @Override
    public float getRenderXOffset()
    {
        return 0.0F;
    }

    @Override
    public float getRenderYOffset()
    {
        return 0.0F;
    }

    @Override
    public float getRenderZOffset()
    {
        return 1.0F;
    }

    @Override
    public IModelAnimator getModelAnimator()
    {
        return animator;
    }
}
