package net.minecraft.src;

public class ItemArmor extends ItemTool {
	private static Block[] aW = new Block[]{Block.v, Block.dirt, Block.sand, Block.gravel, Block.snow, Block.blockSnow, Block.blockClay};

	public ItemArmor(int var1, int var2) {
		super(var1, 1, var2, aW);
	}

	public boolean canHarvestBlock(Block block) {
		return block == Block.snow?true:block == Block.blockSnow;
	}
}
