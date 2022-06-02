package net.minecraft.src;

import java.util.Random;

public class SoundManager extends Block {
	private int[] a = new int[256];
	private int[] b = new int[256];

	protected SoundManager(int var1, int var2) {
		super(var1, var2, Material.fire);
		this.a(Block.planks.blockID, 5, 20);
		this.a(Block.wood.blockID, 5, 5);
		this.a(Block.leaves.blockID, 30, 60);
		this.a(Block.bookshelf.blockID, 30, 20);
		this.a(Block.tnt.blockID, 15, 100);
		this.a(Block.cloth.blockID, 30, 60);
		this.setTickOnLoad(true);
	}

	private void a(int var1, int var2, int var3) {
		this.a[var1] = var2;
		this.b[var1] = var3;
	}

	public AxisAlignedBB getCollisionBoundingBoxFromPool(World worldObj, int x, int y, int z) {
		return null;
	}

	public boolean isOpaqueCube() {
		return false;
	}

	public boolean renderAsNormalBlock() {
		return false;
	}

	public int getRenderType() {
		return 3;
	}

	public int quantityDropped(Random rand) {
		return 0;
	}

	public int tickRate() {
		return 10;
	}

	public void updateTick(World worldObj, int x, int y, int z, Random rand) {
		int var6 = worldObj.e(x, y, z);
		if(var6 < 15) {
			worldObj.setBlockMetadataWithNotify(x, y, z, var6 + 1);
			worldObj.scheduleBlockUpdate(x, y, z, this.blockID);
		}

		if(!this.h(worldObj, x, y, z)) {
			if(!worldObj.g(x, y - 1, z) || var6 > 3) {
				worldObj.setBlockWithNotify(x, y, z, 0);
			}

		} else if(!this.b(worldObj, x, y - 1, z) && var6 == 15 && rand.nextInt(4) == 0) {
			worldObj.setBlockWithNotify(x, y, z, 0);
		} else {
			if(var6 % 2 == 0 && var6 > 2) {
				this.a(worldObj, x + 1, y, z, 300, rand);
				this.a(worldObj, x - 1, y, z, 300, rand);
				this.a(worldObj, x, y - 1, z, 200, rand);
				this.a(worldObj, x, y + 1, z, 250, rand);
				this.a(worldObj, x, y, z - 1, 300, rand);
				this.a(worldObj, x, y, z + 1, 300, rand);

				for(int var7 = x - 1; var7 <= x + 1; ++var7) {
					for(int var8 = z - 1; var8 <= z + 1; ++var8) {
						for(int var9 = y - 1; var9 <= y + 4; ++var9) {
							if(var7 != x || var9 != y || var8 != z) {
								int var10 = 100;
								if(var9 > y + 1) {
									var10 += (var9 - (y + 1)) * 100;
								}

								int var11 = this.i(worldObj, var7, var9, var8);
								if(var11 > 0 && rand.nextInt(var10) <= var11) {
									worldObj.setBlockWithNotify(var7, var9, var8, this.blockID);
								}
							}
						}
					}
				}
			}

		}
	}

	private void a(World var1, int var2, int var3, int var4, int var5, Random var6) {
		int var7 = this.b[var1.a(var2, var3, var4)];
		if(var6.nextInt(var5) < var7) {
			boolean var8 = var1.a(var2, var3, var4) == Block.tnt.blockID;
			if(var6.nextInt(2) == 0) {
				var1.setBlockWithNotify(var2, var3, var4, this.blockID);
			} else {
				var1.setBlockWithNotify(var2, var3, var4, 0);
			}

			if(var8) {
				Block.tnt.onBlockDestroyedByPlayer(var1, var2, var3, var4, 0);
			}
		}

	}

	private boolean h(World var1, int var2, int var3, int var4) {
		return this.b(var1, var2 + 1, var3, var4)?true:(this.b(var1, var2 - 1, var3, var4)?true:(this.b(var1, var2, var3 - 1, var4)?true:(this.b(var1, var2, var3 + 1, var4)?true:(this.b(var1, var2, var3, var4 - 1)?true:this.b(var1, var2, var3, var4 + 1)))));
	}

	private int i(World var1, int var2, int var3, int var4) {
		byte var5 = 0;
		if(var1.a(var2, var3, var4) != 0) {
			return 0;
		} else {
			int var6 = this.g(var1, var2 + 1, var3, var4, var5);
			var6 = this.g(var1, var2 - 1, var3, var4, var6);
			var6 = this.g(var1, var2, var3 - 1, var4, var6);
			var6 = this.g(var1, var2, var3 + 1, var4, var6);
			var6 = this.g(var1, var2, var3, var4 - 1, var6);
			var6 = this.g(var1, var2, var3, var4 + 1, var6);
			return var6;
		}
	}

	public boolean isCollidable() {
		return false;
	}

	public boolean b(EntitySmokeFX var1, int var2, int var3, int var4) {
		return this.a[var1.a(var2, var3, var4)] > 0;
	}

	public int g(World var1, int var2, int var3, int var4, int var5) {
		int var6 = this.a[var1.a(var2, var3, var4)];
		return var6 > var5?var6:var5;
	}

	public boolean canPlaceBlockAt(World world, int x, int y, int z) {
		return world.g(x, y - 1, z) || this.h(world, x, y, z);
	}

	public void onNeighborBlockChange(World worldObj, int x, int y, int z, int id) {
		if(!worldObj.g(x, y - 1, z) && !this.h(worldObj, x, y, z)) {
			worldObj.setBlockWithNotify(x, y, z, 0);
		}
	}

	public void onBlockAdded(World worldObj, int x, int y, int z) {
		if(!worldObj.g(x, y - 1, z) && !this.h(worldObj, x, y, z)) {
			worldObj.setBlockWithNotify(x, y, z, 0);
		} else {
			worldObj.scheduleBlockUpdate(x, y, z, this.blockID);
		}
	}

	public void randomDisplayTick(World worldObj, int x, int y, int z, Random rand) {
		if(rand.nextInt(24) == 0) {
			worldObj.playSoundEffect((double)((float)x + 0.5F), (double)((float)y + 0.5F), (double)((float)z + 0.5F), "fire.fire", 1.0F + rand.nextFloat(), rand.nextFloat() * 0.7F + 0.3F);
		}

		int var6;
		float var7;
		float var8;
		float var9;
		if(!worldObj.g(x, y - 1, z) && !Block.as.b(worldObj, x, y - 1, z)) {
			if(Block.as.b(worldObj, x - 1, y, z)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)x + rand.nextFloat() * 0.1F;
					var8 = (float)y + rand.nextFloat();
					var9 = (float)z + rand.nextFloat();
					worldObj.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if(Block.as.b(worldObj, x + 1, y, z)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)(x + 1) - rand.nextFloat() * 0.1F;
					var8 = (float)y + rand.nextFloat();
					var9 = (float)z + rand.nextFloat();
					worldObj.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if(Block.as.b(worldObj, x, y, z - 1)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)x + rand.nextFloat();
					var8 = (float)y + rand.nextFloat();
					var9 = (float)z + rand.nextFloat() * 0.1F;
					worldObj.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if(Block.as.b(worldObj, x, y, z + 1)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)x + rand.nextFloat();
					var8 = (float)y + rand.nextFloat();
					var9 = (float)(z + 1) - rand.nextFloat() * 0.1F;
					worldObj.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}

			if(Block.as.b(worldObj, x, y + 1, z)) {
				for(var6 = 0; var6 < 2; ++var6) {
					var7 = (float)x + rand.nextFloat();
					var8 = (float)(y + 1) - rand.nextFloat() * 0.1F;
					var9 = (float)z + rand.nextFloat();
					worldObj.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
				}
			}
		} else {
			for(var6 = 0; var6 < 3; ++var6) {
				var7 = (float)x + rand.nextFloat();
				var8 = (float)y + rand.nextFloat() * 0.5F + 0.5F;
				var9 = (float)z + rand.nextFloat();
				worldObj.spawnParticle("largesmoke", (double)var7, (double)var8, (double)var9, 0.0D, 0.0D, 0.0D);
			}
		}

	}
}
