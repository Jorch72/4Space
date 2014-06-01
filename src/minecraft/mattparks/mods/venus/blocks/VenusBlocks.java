package mattparks.mods.venus.blocks;

import mattparks.mods.MattparksCore.ConfigManager;
import mattparks.mods.venus.GCVenus;
import micdoodle8.mods.galacticraft.mars.GCMarsConfigManager;
import micdoodle8.mods.galacticraft.mars.GalacticraftMars;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlockCreeperEgg;
import micdoodle8.mods.galacticraft.mars.blocks.GCMarsBlocks;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemBlock;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemBlockMachine;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemBlockRock;
import micdoodle8.mods.galacticraft.mars.items.GCMarsItemBlockTintedGlassPane;
import net.minecraft.block.Block;
import net.minecraft.block.material.MapColor;
import net.minecraft.block.material.Material;
import net.minecraft.block.material.MaterialLiquid;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.registry.GameRegistry;

public class VenusBlocks
{
	public static Block VenusGrass;
	public static Block VenusDirt;
	public static Block VenusStone;
	public static Block VenusBrick;
	public static Block EvolvedBlazeEgg;
	public static Block VenusRedGemBlock;
	public static Block VenusMeteorBlock;
	public static Block VenusSulfurBlock;
	public static Block VenusSulfurOre;
	public static Block VenusMeteorOre;
	public static Block VenusRedGemOre;
	public static Block VenusIronOre;
	public static Block VenusCoalOre;
	public static Block VenusTinOre;
	public static Block VenusCopperOre;
	public static Block VenusCrystalOre;
	public static Block VenusGoldOre;
	public static Block FossilizedPlantOre;
	public static Block VurnBerryBush;
	
	public static void initBlocks()
	{
		VenusBlocks.VenusGrass = new GCVenusGrass(ConfigManager.idBlockVenusGrass, null).setHardness(-1.0F).setUnlocalizedName("VenusGrass").setTextureName("galacticraftvenus:grassVenus");
		
		VenusBlocks.VenusDirt = new GCVenusBlock(ConfigManager.idBlockVenusDirt, null).setHardness(-1.0F).setUnlocalizedName("VenusDirt").setTextureName("galacticraftvenus:dirtVenus");
		
		VenusBlocks.VenusStone = new GCVenusBlock(ConfigManager.idBlockVenusStone, null).setHardness(-1.0F).setUnlocalizedName("VenusStone").setTextureName("galacticraftvenus:stoneVenus");
		
		VenusBlocks.VenusBrick = new GCVenusBrick(ConfigManager.idBlockVenusBrick, null).setHardness(-1.0F).setUnlocalizedName("VenusBrick").setTextureName("galacticraftvenus:venusBrick");
		
		VenusBlocks.EvolvedBlazeEgg = new GCVenusEgg(ConfigManager.idBlockEvolvedBlazeEgg).setHardness(-1.0F).setUnlocalizedName("EvolvedBlazeEgg").setTextureName("galacticraftvenus:evolvedBlazeEgg");
	
		VenusBlocks.VenusRedGemBlock = new GCVenusBlock(ConfigManager.idBlockVenusRedGemBlock, null).setHardness(-1.0F).setUnlocalizedName("VenusGemBlock").setTextureName("galacticraftvenus:gemBlock");

		VenusBlocks.VenusMeteorBlock = new GCVenusBlock(ConfigManager.idBlockVenusMeteorBlock, null).setHardness(-1.0F).setUnlocalizedName("VenusMeteorBlock").setTextureName("galacticraftvenus:meteorBlock");

		VenusBlocks.VenusSulfurBlock = new GCVenusOre(ConfigManager.idBlockVenusSulfurBlock, null).setHardness(-1.0F).setUnlocalizedName("VenusSulfurBlock").setTextureName("galacticraftvenus:sulfurBlock");

		VenusBlocks.VenusSulfurOre = new GCVenusOre(ConfigManager.idBlockVenusSulfurOre, null).setHardness(-1.0F).setUnlocalizedName("VenusSulfurOre").setTextureName("galacticraftvenus:sulfurOre");

		VenusBlocks.VenusMeteorOre = new GCVenusOre(ConfigManager.idBlockVenusMeteorOre, null).setHardness(-1.0F).setUnlocalizedName("VenusMeteorOre").setTextureName("galacticraftvenus:meteorOre");

		VenusBlocks.VenusRedGemOre = new GCVenusOre(ConfigManager.idBlockVenusRedGemOre, null).setHardness(-1.0F).setUnlocalizedName("VenusGemOre").setTextureName("galacticraftvenus:gemOre");

		VenusBlocks.VenusIronOre = new GCVenusOre(ConfigManager.idBlockVenusIronOre, null).setHardness(-1.0F).setUnlocalizedName("VenusIronOre").setTextureName("galacticraftvenus:ironOre");

		VenusBlocks.VenusCoalOre = new GCVenusOre(ConfigManager.idBlockVenusCoalOre, null).setHardness(-1.0F).setUnlocalizedName("VenusCoalOre").setTextureName("galacticraftvenus:coalOre");

		VenusBlocks.VenusTinOre = new GCVenusOre(ConfigManager.idBlockVenusTinOre, null).setHardness(-1.0F).setUnlocalizedName("VenusTinOre").setTextureName("galacticraftvenus:tinOre");

		VenusBlocks.VenusCopperOre = new GCVenusOre(ConfigManager.idBlockVenusCopperOre, null).setHardness(-1.0F).setUnlocalizedName("VenusCopperOre").setTextureName("galacticraftvenus:copperOre");

		VenusBlocks.VenusCrystalOre = new GCVenusOre(ConfigManager.idBlockVenusCrystalOre, null).setHardness(-1.0F).setUnlocalizedName("VenusCrystalOre").setTextureName("galacticraftvenus:venusCrystalOre");
				    
		VenusBlocks.VenusGoldOre = new GCVenusOre(ConfigManager.idBlockVenusGoldOre, null).setHardness(-1.0F).setUnlocalizedName("VenusGoldOre").setTextureName("galacticraftvenus:goldOre");
			    
		VenusBlocks.FossilizedPlantOre = new GCVenusOre(ConfigManager.idBlockFossilizedPlantOre, null).setHardness(-1.0F).setUnlocalizedName("FossilizedPlantOre").setTextureName("galacticraftvenus:fossilizedPlantOre");

		VenusBlocks.VurnBerryBush = new GCVenusVurnBerryBush(ConfigManager.idBlockVurnBerryBush).setHardness(0.25F).setUnlocalizedName("VurnBerryBush").setTextureName("galacticraftvenus:VurnBerryBush");
	}

	public static void setHarvestLevels()
	{
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusGrass, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusDirt, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusStone, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusBrick, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.EvolvedBlazeEgg, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusRedGemBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusMeteorBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusSulfurBlock, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusSulfurOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusMeteorOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusRedGemOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusIronOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusCoalOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusTinOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusCopperOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusCrystalOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VenusGoldOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.FossilizedPlantOre, "pickaxe", 1);
		MinecraftForge.setBlockHarvestLevel(VenusBlocks.VurnBerryBush, "pickaxe", 1);
	}

	public static void registerBlocks()
	{
		GameRegistry.registerBlock(VenusBlocks.VenusGrass, ItemBlock.class, VenusBlocks.VenusGrass.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusDirt, ItemBlock.class, VenusBlocks.VenusDirt.getUnlocalizedName(), GCVenus.MODID);

		GameRegistry.registerBlock(VenusBlocks.VenusStone, ItemBlock.class, VenusBlocks.VenusStone.getUnlocalizedName(), GCVenus.MODID);

		GameRegistry.registerBlock(VenusBlocks.VenusBrick, ItemBlock.class, VenusBlocks.VenusBrick.getUnlocalizedName(), GCVenus.MODID);

		GameRegistry.registerBlock(VenusBlocks.EvolvedBlazeEgg, ItemBlock.class, VenusBlocks.EvolvedBlazeEgg.getUnlocalizedName(), GCVenus.MODID);
		
		GameRegistry.registerBlock(VenusBlocks.VenusRedGemBlock, ItemBlock.class, VenusBlocks.VenusRedGemBlock.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusMeteorBlock, ItemBlock.class, VenusBlocks.VenusMeteorBlock.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusSulfurBlock, ItemBlock.class, VenusBlocks.VenusSulfurBlock.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusSulfurOre, ItemBlock.class, VenusBlocks.VenusSulfurOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusMeteorOre, ItemBlock.class, VenusBlocks.VenusMeteorOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusRedGemOre, ItemBlock.class, VenusBlocks.VenusRedGemOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusIronOre, ItemBlock.class, VenusBlocks.VenusIronOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusCoalOre, ItemBlock.class, VenusBlocks.VenusCoalOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusTinOre, ItemBlock.class, VenusBlocks.VenusTinOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusCopperOre, ItemBlock.class, VenusBlocks.VenusCopperOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusCrystalOre, ItemBlock.class, VenusBlocks.VenusCrystalOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VenusGoldOre, ItemBlock.class, VenusBlocks.VenusGoldOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.FossilizedPlantOre, ItemBlock.class, VenusBlocks.FossilizedPlantOre.getUnlocalizedName(), GCVenus.MODID);
		GameRegistry.registerBlock(VenusBlocks.VurnBerryBush, ItemBlock.class, VenusBlocks.VurnBerryBush.getUnlocalizedName(), GCVenus.MODID);
	}
}