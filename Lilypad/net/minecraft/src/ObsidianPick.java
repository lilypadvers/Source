package net.minecraft.src;

public class ObsidianPick extends ItemTool {
	private static Block[] aW = new Block[]{Block.cobblestone, Block.bedrock, Block.stairDouble, Block.stairSingle, Block.stone, Block.cobblestoneMossy, Block.oreIron, Block.blockSteel, Block.oreCoal, Block.blockGold, Block.oreGold, Block.oreDiamond, Block.blockDiamond, Block.ice};
	private int aX;

	public ObsidianPick(int var1, int var2) {
		super(var1, 2, var2, aW);
		this.aX = var2;
	}

	public boolean canHarvestBlock(Block block) {
		return block == Block.bedrock?true:(block == Block.obsidian?this.aX == 3:(block != Block.blockDiamond && block != Block.oreDiamond?(block != Block.blockGold && block != Block.oreGold?(block != Block.blockSteel && block != Block.oreIron?(block != Block.oreRedstone && block != Block.oreRedstoneGlowing?block.material == Material.rock || block.material == Material.iron:this.aX >= 2):this.aX >= 1):this.aX >= 2):this.aX >= 2));
	}
}
