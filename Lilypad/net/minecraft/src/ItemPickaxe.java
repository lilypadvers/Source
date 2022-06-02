package net.minecraft.src;

public class ItemPickaxe extends ItemTool {
	private static Block[] aW = new Block[]{Block.cobblestone, Block.stairDouble, Block.stairSingle, Block.stone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice};
	private int aX;

	public ItemPickaxe(int id, int harvestLevel) {
		super(id, 2, harvestLevel, aW);
		this.aX = harvestLevel;
	}

	public boolean canHarvestBlock(Block block) {
		return block == Block.obsidian?this.aX == 3:(block != Block.blockDiamond && block != Block.oreDiamond?(block != Block.blockGold && block != Block.oreGold?(block != Block.blockSteel && block != Block.oreIron?(block != Block.oreRedstone && block != Block.oreRedstoneGlowing?(block.material == Material.rock?true:block.material == Material.iron):this.aX >= 2):this.aX >= 1):this.aX >= 2):this.aX >= 2);
	}
}
