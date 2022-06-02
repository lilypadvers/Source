package net.minecraft.src;

public class ItemTool extends Item {
	private Block[] aW;
	private float aX = 4.0F;
	private int aY;
	protected int toolMaterial;

	public ItemTool(int id, int attackDmg, int strength, Block[] blocks) {
		super(id);
		this.toolMaterial = strength;
		this.aW = blocks;
		this.shiftedIndex = 1;
		this.maxStackSize = 32 << strength;
		if(strength == 3) {
			this.maxStackSize *= 4;
		}

		this.aX = (float)((strength + 1) * 2);
		this.aY = attackDmg + strength;
	}

	public float getStrVsBlock(ItemStack itemStack, Block block) {
		for(int var3 = 0; var3 < this.aW.length; ++var3) {
			if(this.aW[var3] == block) {
				return this.aX;
			}
		}

		return 1.0F;
	}

	public void hitEntity(ItemStack itemStack, EntityLiving entityLiving) {
		itemStack.damageItem(2);
	}

	public void onBlockDestroyed(ItemStack itemStack, int id, int x, int y, int z) {
		itemStack.damageItem(1);
	}

	public int getDamageVsEntity(Entity entity) {
		return this.aY;
	}

	public boolean isFull3D() {
		return true;
	}
}
