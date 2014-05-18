package mattparks.mods.venus.client;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.util.ArrayList;
import java.util.EnumSet;

import mattparks.mods.venus.CommonProxyVenus;
import mattparks.mods.venus.GCVenus;
import mattparks.mods.venus.client.render.entities.GCVenusRenderEvolvedBlaze;
import mattparks.mods.venus.client.render.entities.GCVenusRenderVenusianVillager;
import mattparks.mods.venus.dimension.GCVenusWorldProvider;
import mattparks.mods.venus.entities.GCVenusEntityEvolvedBlaze;
import mattparks.mods.venus.entities.GCVenusEntityVenusianVillager;
import mattparks.mods.venus.items.GCVenusItemJetpack;
import mattparks.mods.venus.items.GCVenusItemPJetpack;
import mattparks.mods.venus.items.GCVenusItems;
import micdoodle8.mods.galacticraft.core.client.GCCoreCloudRenderer;
import micdoodle8.mods.galacticraft.core.util.PacketUtil;
import net.minecraft.block.material.Material;
import net.minecraft.client.Minecraft;
import net.minecraft.client.audio.SoundPoolEntry;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.network.INetworkManager;
import net.minecraft.network.packet.Packet250CustomPayload;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.world.World;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.IPacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.network.Player;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientProxyVenus extends CommonProxyVenus
{
	
    public class ClientPacketHandler implements IPacketHandler
    {
        @Override
        public void onPacketData(INetworkManager manager, Packet250CustomPayload packet, Player p)
        {
            final DataInputStream data = new DataInputStream(new ByteArrayInputStream(packet.data));
            final int packetType = PacketUtil.readPacketID(data);
            EntityPlayer player = (EntityPlayer) p;

            if (packetType == 0)
            {
                final Class<?>[] decodeAs = { Integer.class, Integer.class, Integer.class };
                final Object[] packetReadout = PacketUtil.readPacketData(data, decodeAs);

                int entityID = 0;
                Entity entity = null;
                
                switch ((Integer) packetReadout[1])
                {
                case 0:
                    entityID = (Integer) packetReadout[2];
                    entity = player.worldObj.getEntityByID(entityID);

                    {
                    	;
                    }

                    player.openContainer.windowId = (Integer) packetReadout[0];
                    break;
                case 1:
                    entityID = (Integer) packetReadout[2];
                    entity = player.worldObj.getEntityByID(entityID);

                    {
                    	;
                    }

                    player.openContainer.windowId = (Integer) packetReadout[0];
                    break;
                }
            }
        }
    }
    
    public static class TickHandlerClient implements ITickHandler
    {
        @Override
        public String getLabel()
        {
            return "Galacticraft Venus Client";
        }

        @Override
        public void tickEnd(EnumSet<TickType> type, Object... tickData)
        {
        	;
        }

        @Override
        public EnumSet<TickType> ticks()
        {
            return EnumSet.of(TickType.CLIENT);
        }

        @Override
        public void tickStart(EnumSet<TickType> type, Object... tickData)
        {
            final Minecraft minecraft = FMLClientHandler.instance().getClient();

            final WorldClient world = minecraft.theWorld;

            final EntityClientPlayerMP player = minecraft.thePlayer;
    		
    		if (type.equals(EnumSet.of(TickType.CLIENT)))
            {
        		if (player != null && world != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem().itemID == GCVenusItems.jetpack.itemID && FMLClientHandler.instance().getClient().gameSettings.keyBindJump.pressed && player.posY < 360)
        		{
        			((GCVenusItemJetpack)player.inventory.armorItemInSlot(2).getItem()).setActive();
        			player.motionY -= 0.05D;
        			player.motionY += 0.07 + player.rotationPitch * 2 / 150 * 0.063;
        			player.fallDistance = -10; //TODO: Disable all FALL damage //TODO: Allow player to look in any direction for jetpack to work
            		world.spawnParticle("largesmoke", player.posX, player.posY - 1D, player.posZ, 0, -0.5, 0);
        		}
        		else if (player != null && world != null && player.inventory.armorItemInSlot(2) != null && player.inventory.armorItemInSlot(2).getItem().itemID == GCVenusItems.pJetpack.itemID && FMLClientHandler.instance().getClient().gameSettings.keyBindJump.pressed && player.posY < 360)
        		{
        			((GCVenusItemPJetpack)player.inventory.armorItemInSlot(2).getItem()).setActive();
        			player.motionY -= 0.05D;
        			player.motionY += 0.07 + player.rotationPitch * 2 / 150 * 0.063;
        			player.fallDistance = -10; //TODO: Disable all FALL damage //TODO: Allow player to look in any direction for jetpack to work
            		world.spawnParticle("largesmoke", player.posX, player.posY - 1D, player.posZ, 0, -0.5, 0);
        		}
        		
            if (type.equals(EnumSet.of(TickType.CLIENT)))
            {
                if (world != null)
                {
                    if (world.provider instanceof GCVenusWorldProvider)
                    {
                        if (world.provider.getSkyRenderer() == null)
                        {
                            world.provider.setSkyRenderer(new GCVenusSkyProvider());
                        }

                        if (world.provider.getCloudRenderer() == null)
                        {
                            world.provider.setCloudRenderer(new GCCoreCloudRenderer());
                        }
                    }
                    
                    for (int i = 0; i < world.loadedEntityList.size(); i++)
                    {
                        final Entity e = (Entity) world.loadedEntityList.get(i);

                        if (e != null)
                        {
//                            if (e instanceof SCVenusEntityRocketT3)
                            {
//                                final SCVenusEntityRocketT3 eship = (SCVenusEntityRocketT3) e;

//                                if (eship.rocketSoundUpdater == null)
                                {
//                                    eship.rocketSoundUpdater = new GCCoreSoundUpdaterSpaceship(FMLClientHandler.instance().getClient().sndManager, eship, FMLClientHandler.instance().getClient().thePlayer);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    }
    
    public static ArrayList<SoundPoolEntry> newMusic = new ArrayList<SoundPoolEntry>();

    public static boolean handleLavaMovement(EntityPlayer player)
    {
        return player.worldObj.isMaterialInBB(player.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.lava);
    }

    public static boolean handleWaterMovement(EntityPlayer player)
    {
        return player.worldObj.isMaterialInBB(player.boundingBox.expand(-0.10000000149011612D, -0.4000000059604645D, -0.10000000149011612D), Material.water);
    }

    @Override
    public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z)
    {
        TileEntity tile = world.getBlockTileEntity(x, y, z);

        return null;
    }

    @Override
    public void init(FMLInitializationEvent event)
    {
        TickRegistry.registerTickHandler(new TickHandlerClient(), Side.CLIENT);
        NetworkRegistry.instance().registerChannel(new ClientPacketHandler(), GCVenus.CHANNEL, Side.CLIENT);
    }

    @Override
    public void preInit(FMLPreInitializationEvent event)
    {
    	MinecraftForge.EVENT_BUS.register(new GCVenusSounds());
    }

    @Override
    public void registerRenderInformation()
    {
        RenderingRegistry.addNewArmourRendererPrefix("gem");
        RenderingRegistry.addNewArmourRendererPrefix("sulfur");
        RenderingRegistry.addNewArmourRendererPrefix("jetpack");
        RenderingRegistry.addNewArmourRendererPrefix("pJetpack");

        RenderingRegistry.registerEntityRenderingHandler(GCVenusEntityVenusianVillager.class, new GCVenusRenderVenusianVillager());
        RenderingRegistry.registerEntityRenderingHandler(GCVenusEntityEvolvedBlaze.class, new GCVenusRenderEvolvedBlaze());
  
 //       IModelCustom cargoRocketModel = AdvancedModelLoader.loadModel("/assets/galacticraftmars/models/cargoRocket.obj");

//        RenderingRegistry.registerEntityRenderingHandler(SCVenusEntityRocketT3.class, new GCCoreRenderSpaceship(new SCCoreModelSpaceshipTier3(), VenusCore.TEXTURE_DOMAIN, "rocketT3"));
//        MinecraftForgeClient.registerItemRenderer(VenusItems.spaceshipT3.itemID, new SCVenusItemRendererSpaceshipT3(cargoRocketModel));
    }
}
