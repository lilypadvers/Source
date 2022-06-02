package net.minecraft.src;

import java.util.Random;

public class Packet255KickDisconnect extends Block {
	private boolean a;

	public Packet255KickDisconnect(int var1, boolean var2) {
		super(var1, 6, Material.rock);
		this.a = var2;
		if(!var2) {
			this.setBlockBounds(0.0F, 0.0F, 0.0F, 1.0F, 0.5F, 1.0F);
		}

		this.setLightOpacity(255);
	}

	public int getBlockTextureFromSide(int side) {
		return side <= 1?6:5;
	}

	public boolean isOpaqueCube() {
		return this.a;
	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		if(this == Block.stairSingle) {
		}
	}

	public void onBlockAdded(World worldObj, int x, int y, int z) {
		if(this != Block.stairSingle) {
			super.onBlockAdded(worldObj, x, y, z);
		}

		int var5 = worldObj.a(x, y - 1, z);
		if(var5 == stairSingle.blockID) {
			worldObj.setBlockWithNotify(x, y, z, 0);
			worldObj.setBlockWithNotify(x, y - 1, z, Block.stairDouble.blockID);
		}

	}

	public int idDropped(int metadata, Random rand) {
		return Block.stairSingle.blockID;
	}

	public boolean renderAsNormalBlock() {
		return this.a;
	}

	public boolean c(EntitySmokeFX var1, int var2, int var3, int var4, int var5) {
		if(this != Block.stairSingle) {
			super.c(var1, var2, var3, var4, var5);
		}

		return var5 == 1?true:(!super.c(var1, var2, var3, var4, var5)?false:(var5 == 0?true:var1.a(var2, var3, var4) != this.blockID));
	}
}
