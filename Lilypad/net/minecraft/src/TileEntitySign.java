package net.minecraft.src;

import java.util.List;

public class TileEntitySign extends Entity implements IInventory {
	private ItemStack[] h;
	public int a;
	public int lineBeingEdited;
	public int c;
	private boolean i;
	public int d;
	public int e;
	public double f;
	public double g;
	private static final int[][][] j = new int[][][]{{{0, 0, -1}, {0, 0, 1}}, {{-1, 0, 0}, {1, 0, 0}}, {{-1, -1, 0}, {1, 0, 0}}, {{-1, 0, 0}, {1, -1, 0}}, {{0, 0, -1}, {0, -1, 1}}, {{0, -1, -1}, {0, 0, 1}}, {{0, 0, 1}, {1, 0, 0}}, {{0, 0, 1}, {-1, 0, 0}}, {{0, 0, -1}, {-1, 0, 0}}, {{0, 0, -1}, {1, 0, 0}}};
	private int k;
	private double l;
	private double m;
	private double n;
	private double o;
	private double p;

	public TileEntitySign(World var1) {
		super(var1);
		this.h = new ItemStack[36];
		this.a = 0;
		this.lineBeingEdited = 0;
		this.c = 1;
		this.i = false;
		this.preventEntitySpawning = true;
		this.setSize(0.98F, 0.7F);
		this.yOffset = this.height / 2.0F;
		this.canTriggerWalking = false;
	}

	public AxisAlignedBB getCollisionBox(Entity entity) {
		return entity.boundingBox;
	}

	public AxisAlignedBB getBoundingBox() {
		return this.boundingBox;
	}

	public boolean canBePushed() {
		return true;
	}

	public TileEntitySign(World var1, double var2, double var4, double var6, int var8) {
		this(var1);
		this.setPosition(var2, var4 + (double)this.yOffset, var6);
		this.motionX = 0.0D;
		this.motionY = 0.0D;
		this.motionZ = 0.0D;
		this.prevPosX = var2;
		this.prevPosY = var4;
		this.prevPosZ = var6;
		this.d = var8;
	}

	public double getMountedYOffset() {
		return (double)this.height * 0.0D - (double)0.3F;
	}

	public boolean attackEntityFrom(Entity entity, int damage) {
		this.c = -this.c;
		this.lineBeingEdited = 10;
		this.a += damage * 10;
		if(this.a > 40) {
			this.entityDropItem(Item.minecartEmpty.aR, 1, 0.0F);
			if(this.d == 1) {
				this.entityDropItem(Block.chest.blockID, 1, 0.0F);
			} else if(this.d == 2) {
				this.entityDropItem(Block.stoneOvenIdle.blockID, 1, 0.0F);
			}

			this.kill();
		}

		return true;
	}

	public boolean canBeCollidedWith() {
		return !this.isDead;
	}

	public void kill() {
		for(int var1 = 0; var1 < this.getSizeInventory(); ++var1) {
			ItemStack var2 = this.getStackInSlot(var1);
			if(var2 != null) {
				float var3 = this.rand.nextFloat() * 0.8F + 0.1F;
				float var4 = this.rand.nextFloat() * 0.8F + 0.1F;
				float var5 = this.rand.nextFloat() * 0.8F + 0.1F;

				while(var2.stackSize > 0) {
					int var6 = this.rand.nextInt(21) + 10;
					if(var6 > var2.stackSize) {
						var6 = var2.stackSize;
					}

					var2.stackSize -= var6;
					EntityItem var7 = new EntityItem(this.worldObj, this.posX + (double)var3, this.posY + (double)var4, this.posZ + (double)var5, new ItemStack(var2.itemID, var6, var2.itemDmg));
					float var8 = 0.05F;
					var7.motionX = (double)((float)this.rand.nextGaussian() * var8);
					var7.motionY = (double)((float)this.rand.nextGaussian() * var8 + 0.2F);
					var7.motionZ = (double)((float)this.rand.nextGaussian() * var8);
					this.worldObj.spawnEntityInWorld(var7);
				}
			}
		}

		super.kill();
	}

	public void onUpdate() {
		double var7;
		if(this.worldObj.multiplayerWorld) {
			if(this.k > 0) {
				double var41 = this.posX + (this.l - this.posX) / (double)this.k;
				double var42 = this.posY + (this.m - this.posY) / (double)this.k;
				double var5 = this.posZ + (this.n - this.posZ) / (double)this.k;

				for(var7 = this.o - (double)this.rotationYaw; var7 < -180.0D; var7 += 360.0D) {
				}

				while(var7 >= 180.0D) {
					var7 -= 360.0D;
				}

				this.rotationYaw = (float)((double)this.rotationYaw + var7 / (double)this.k);
				this.rotationPitch = (float)((double)this.rotationPitch + (this.p - (double)this.rotationPitch) / (double)this.k);
				--this.k;
				this.setPosition(var41, var42, var5);
				this.setRotation(this.rotationYaw, this.rotationPitch);
			} else {
				this.setPosition(this.posX, this.posY, this.posZ);
				this.setRotation(this.rotationYaw, this.rotationPitch);
			}

		} else {
			if(this.lineBeingEdited > 0) {
				--this.lineBeingEdited;
			}

			if(this.a > 0) {
				--this.a;
			}

			this.prevPosX = this.posX;
			this.prevPosY = this.posY;
			this.prevPosZ = this.posZ;
			this.motionY -= (double)0.04F;
			int var1 = MathHelper.floor_double(this.posX);
			int var2 = MathHelper.floor_double(this.posY);
			int var3 = MathHelper.floor_double(this.posZ);
			if(this.worldObj.a(var1, var2 - 1, var3) == Block.minecartTrack.blockID) {
				--var2;
			}

			double var4 = 0.4D;
			boolean var6 = false;
			var7 = 2.0D / 256D;
			if(this.worldObj.a(var1, var2, var3) == Block.minecartTrack.blockID) {
				Vec3D var9 = this.g(this.posX, this.posY, this.posZ);
				int var10 = this.worldObj.e(var1, var2, var3);
				this.posY = (double)var2;
				if(var10 >= 2 && var10 <= 5) {
					this.posY = (double)(var2 + 1);
				}

				if(var10 == 2) {
					this.motionX -= var7;
				}

				if(var10 == 3) {
					this.motionX += var7;
				}

				if(var10 == 4) {
					this.motionZ += var7;
				}

				if(var10 == 5) {
					this.motionZ -= var7;
				}

				int[][] var11 = j[var10];
				double var12 = (double)(var11[1][0] - var11[0][0]);
				double var14 = (double)(var11[1][2] - var11[0][2]);
				double var16 = Math.sqrt(var12 * var12 + var14 * var14);
				double var18 = this.motionX * var12 + this.motionZ * var14;
				if(var18 < 0.0D) {
					var12 = -var12;
					var14 = -var14;
				}

				double var20 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
				this.motionX = var20 * var12 / var16;
				this.motionZ = var20 * var14 / var16;
				double var22 = 0.0D;
				double var24 = (double)var1 + 0.5D + (double)var11[0][0] * 0.5D;
				double var26 = (double)var3 + 0.5D + (double)var11[0][2] * 0.5D;
				double var28 = (double)var1 + 0.5D + (double)var11[1][0] * 0.5D;
				double var30 = (double)var3 + 0.5D + (double)var11[1][2] * 0.5D;
				var12 = var28 - var24;
				var14 = var30 - var26;
				double var32;
				double var34;
				double var36;
				if(var12 == 0.0D) {
					this.posX = (double)var1 + 0.5D;
					var22 = this.posZ - (double)var3;
				} else if(var14 == 0.0D) {
					this.posZ = (double)var3 + 0.5D;
					var22 = this.posX - (double)var1;
				} else {
					var32 = this.posX - var24;
					var34 = this.posZ - var26;
					var36 = (var32 * var12 + var34 * var14) * 2.0D;
					var22 = var36;
				}

				this.posX = var24 + var12 * var22;
				this.posZ = var26 + var14 * var22;
				this.setPosition(this.posX, this.posY + (double)this.yOffset, this.posZ);
				var32 = this.motionX;
				var34 = this.motionZ;
				if(this.riddenByEntity != null) {
					var32 *= 0.75D;
					var34 *= 0.75D;
				}

				if(var32 < -var4) {
					var32 = -var4;
				}

				if(var32 > var4) {
					var32 = var4;
				}

				if(var34 < -var4) {
					var34 = -var4;
				}

				if(var34 > var4) {
					var34 = var4;
				}

				this.moveEntity(var32, 0.0D, var34);
				if(var11[0][1] != 0 && MathHelper.floor_double(this.posX) - var1 == var11[0][0] && MathHelper.floor_double(this.posZ) - var3 == var11[0][2]) {
					this.setPosition(this.posX, this.posY + (double)var11[0][1], this.posZ);
				} else if(var11[1][1] != 0 && MathHelper.floor_double(this.posX) - var1 == var11[1][0] && MathHelper.floor_double(this.posZ) - var3 == var11[1][2]) {
					this.setPosition(this.posX, this.posY + (double)var11[1][1], this.posZ);
				}

				if(this.riddenByEntity != null) {
					this.motionX *= (double)0.997F;
					this.motionY *= 0.0D;
					this.motionZ *= (double)0.997F;
				} else {
					if(this.d == 2) {
						var36 = (double)MathHelper.sqrt_double(this.f * this.f + this.g * this.g);
						if(var36 > 0.01D) {
							var6 = true;
							this.f /= var36;
							this.g /= var36;
							double var38 = 0.04D;
							this.motionX *= (double)0.8F;
							this.motionY *= 0.0D;
							this.motionZ *= (double)0.8F;
							this.motionX += this.f * var38;
							this.motionZ += this.g * var38;
						} else {
							this.motionX *= (double)0.9F;
							this.motionY *= 0.0D;
							this.motionZ *= (double)0.9F;
						}
					}

					this.motionX *= (double)0.96F;
					this.motionY *= 0.0D;
					this.motionZ *= (double)0.96F;
				}

				Vec3D var46 = this.g(this.posX, this.posY, this.posZ);
				if(var46 != null && var9 != null) {
					double var37 = (var9.yCoord - var46.yCoord) * 0.05D;
					var20 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
					if(var20 > 0.0D) {
						this.motionX = this.motionX / var20 * (var20 + var37);
						this.motionZ = this.motionZ / var20 * (var20 + var37);
					}

					this.setPosition(this.posX, var46.yCoord, this.posZ);
				}

				int var47 = MathHelper.floor_double(this.posX);
				int var48 = MathHelper.floor_double(this.posZ);
				if(var47 != var1 || var48 != var3) {
					var20 = Math.sqrt(this.motionX * this.motionX + this.motionZ * this.motionZ);
					this.motionX = var20 * (double)(var47 - var1);
					this.motionZ = var20 * (double)(var48 - var3);
				}

				if(this.d == 2) {
					double var39 = (double)MathHelper.sqrt_double(this.f * this.f + this.g * this.g);
					if(var39 > 0.01D && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.001D) {
						this.f /= var39;
						this.g /= var39;
						if(this.f * this.motionX + this.g * this.motionZ < 0.0D) {
							this.f = 0.0D;
							this.g = 0.0D;
						} else {
							this.f = this.motionX;
							this.g = this.motionZ;
						}
					}
				}
			} else {
				if(this.motionX < -var4) {
					this.motionX = -var4;
				}

				if(this.motionX > var4) {
					this.motionX = var4;
				}

				if(this.motionZ < -var4) {
					this.motionZ = -var4;
				}

				if(this.motionZ > var4) {
					this.motionZ = var4;
				}

				if(this.onGround) {
					this.motionX *= 0.5D;
					this.motionY *= 0.5D;
					this.motionZ *= 0.5D;
				}

				this.moveEntity(this.motionX, this.motionY, this.motionZ);
				if(!this.onGround) {
					this.motionX *= (double)0.95F;
					this.motionY *= (double)0.95F;
					this.motionZ *= (double)0.95F;
				}
			}

			this.rotationPitch = 0.0F;
			double var43 = this.prevPosX - this.posX;
			double var44 = this.prevPosZ - this.posZ;
			if(var43 * var43 + var44 * var44 > 0.001D) {
				this.rotationYaw = (float)(Math.atan2(var44, var43) * 180.0D / Math.PI);
				if(this.i) {
					this.rotationYaw += 180.0F;
				}
			}

			double var13;
			for(var13 = (double)(this.rotationYaw - this.prevRotationYaw); var13 >= 180.0D; var13 -= 360.0D) {
			}

			while(var13 < -180.0D) {
				var13 += 360.0D;
			}

			if(var13 < -170.0D || var13 >= 170.0D) {
				this.rotationYaw += 180.0F;
				this.i = !this.i;
			}

			this.setRotation(this.rotationYaw, this.rotationPitch);
			List var15 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox.expand((double)0.2F, 0.0D, (double)0.2F));
			if(var15 != null && var15.size() > 0) {
				for(int var45 = 0; var45 < var15.size(); ++var45) {
					Entity var17 = (Entity)var15.get(var45);
					if(var17 != this.riddenByEntity && var17.canBePushed() && var17 instanceof TileEntitySign) {
						var17.applyEntityCollision(this);
					}
				}
			}

			if(this.riddenByEntity != null && this.riddenByEntity.isDead) {
				this.riddenByEntity = null;
			}

			if(var6 && this.rand.nextInt(4) == 0) {
				--this.e;
				if(this.e < 0) {
					this.f = this.g = 0.0D;
				}

				this.worldObj.spawnParticle("largesmoke", this.posX, this.posY + 0.8D, this.posZ, 0.0D, 0.0D, 0.0D);
			}

		}
	}

	public Vec3D a(double var1, double var3, double var5, double var7) {
		int var9 = MathHelper.floor_double(var1);
		int var10 = MathHelper.floor_double(var3);
		int var11 = MathHelper.floor_double(var5);
		if(this.worldObj.a(var9, var10 - 1, var11) == Block.minecartTrack.blockID) {
			--var10;
		}

		if(this.worldObj.a(var9, var10, var11) == Block.minecartTrack.blockID) {
			int var12 = this.worldObj.e(var9, var10, var11);
			var3 = (double)var10;
			if(var12 >= 2 && var12 <= 5) {
				var3 = (double)(var10 + 1);
			}

			int[][] var13 = j[var12];
			double var14 = (double)(var13[1][0] - var13[0][0]);
			double var16 = (double)(var13[1][2] - var13[0][2]);
			double var18 = Math.sqrt(var14 * var14 + var16 * var16);
			var14 /= var18;
			var16 /= var18;
			var1 += var14 * var7;
			var5 += var16 * var7;
			if(var13[0][1] != 0 && MathHelper.floor_double(var1) - var9 == var13[0][0] && MathHelper.floor_double(var5) - var11 == var13[0][2]) {
				var3 += (double)var13[0][1];
			} else if(var13[1][1] != 0 && MathHelper.floor_double(var1) - var9 == var13[1][0] && MathHelper.floor_double(var5) - var11 == var13[1][2]) {
				var3 += (double)var13[1][1];
			}

			return this.g(var1, var3, var5);
		} else {
			return null;
		}
	}

	public Vec3D g(double var1, double var3, double var5) {
		int var7 = MathHelper.floor_double(var1);
		int var8 = MathHelper.floor_double(var3);
		int var9 = MathHelper.floor_double(var5);
		if(this.worldObj.a(var7, var8 - 1, var9) == Block.minecartTrack.blockID) {
			--var8;
		}

		if(this.worldObj.a(var7, var8, var9) == Block.minecartTrack.blockID) {
			int var10 = this.worldObj.e(var7, var8, var9);
			var3 = (double)var8;
			if(var10 >= 2 && var10 <= 5) {
				var3 = (double)(var8 + 1);
			}

			int[][] var11 = j[var10];
			double var12 = 0.0D;
			double var14 = (double)var7 + 0.5D + (double)var11[0][0] * 0.5D;
			double var16 = (double)var8 + 0.5D + (double)var11[0][1] * 0.5D;
			double var18 = (double)var9 + 0.5D + (double)var11[0][2] * 0.5D;
			double var20 = (double)var7 + 0.5D + (double)var11[1][0] * 0.5D;
			double var22 = (double)var8 + 0.5D + (double)var11[1][1] * 0.5D;
			double var24 = (double)var9 + 0.5D + (double)var11[1][2] * 0.5D;
			double var26 = var20 - var14;
			double var28 = (var22 - var16) * 2.0D;
			double var30 = var24 - var18;
			if(var26 == 0.0D) {
				var1 = (double)var7 + 0.5D;
				var12 = var5 - (double)var9;
			} else if(var30 == 0.0D) {
				var5 = (double)var9 + 0.5D;
				var12 = var1 - (double)var7;
			} else {
				double var32 = var1 - var14;
				double var34 = var5 - var18;
				double var36 = (var32 * var26 + var34 * var30) * 2.0D;
				var12 = var36;
			}

			var1 = var14 + var26 * var12;
			var3 = var16 + var28 * var12;
			var5 = var18 + var30 * var12;
			if(var28 < 0.0D) {
				++var3;
			}

			if(var28 > 0.0D) {
				var3 += 0.5D;
			}

			return Vec3D.createVector(var1, var3, var5);
		} else {
			return null;
		}
	}

	protected void writeEntityToNBT(NBTTagCompound compoundTag) {
		compoundTag.setInteger("Type", this.d);
		if(this.d == 2) {
			compoundTag.setDouble("PushX", this.f);
			compoundTag.setDouble("PushZ", this.g);
			compoundTag.setShort("Fuel", (short)this.e);
		} else if(this.d == 1) {
			NBTTagList var2 = new NBTTagList();

			for(int var3 = 0; var3 < this.h.length; ++var3) {
				if(this.h[var3] != null) {
					NBTTagCompound var4 = new NBTTagCompound();
					var4.setByte("Slot", (byte)var3);
					this.h[var3].writeToNBT(var4);
					var2.setTag(var4);
				}
			}

			compoundTag.setTag("Items", var2);
		}

	}

	protected void readEntityFromNBT(NBTTagCompound compoundTag) {
		this.d = compoundTag.getInteger("Type");
		if(this.d == 2) {
			this.f = compoundTag.getDouble("PushX");
			this.g = compoundTag.getDouble("PushZ");
			this.e = compoundTag.getShort("Fuel");
		} else if(this.d == 1) {
			NBTTagList var2 = compoundTag.getTagList("Items");
			this.h = new ItemStack[this.getSizeInventory()];

			for(int var3 = 0; var3 < var2.tagCount(); ++var3) {
				NBTTagCompound var4 = (NBTTagCompound)var2.tagAt(var3);
				int var5 = var4.getByte("Slot") & 255;
				if(var5 >= 0 && var5 < this.h.length) {
					this.h[var5] = new ItemStack(var4);
				}
			}
		}

	}

	public float getShadowSize() {
		return 0.0F;
	}

	public void applyEntityCollision(Entity entity) {
		if(entity != this.riddenByEntity) {
			if(entity instanceof EntityLiving && !(entity instanceof EntityPlayer) && this.d == 0 && this.motionX * this.motionX + this.motionZ * this.motionZ > 0.01D && this.riddenByEntity == null && entity.ridingEntity == null) {
				entity.mountEntity(this);
			}

			double var2 = entity.posX - this.posX;
			double var4 = entity.posZ - this.posZ;
			double var6 = var2 * var2 + var4 * var4;
			if(var6 >= 9.999999747378752E-5D) {
				var6 = (double)MathHelper.sqrt_double(var6);
				var2 /= var6;
				var4 /= var6;
				double var8 = 1.0D / var6;
				if(var8 > 1.0D) {
					var8 = 1.0D;
				}

				var2 *= var8;
				var4 *= var8;
				var2 *= (double)0.1F;
				var4 *= (double)0.1F;
				var2 *= (double)(1.0F - this.entityCollisionReduction);
				var4 *= (double)(1.0F - this.entityCollisionReduction);
				var2 *= 0.5D;
				var4 *= 0.5D;
				if(entity instanceof TileEntitySign) {
					double var10 = entity.motionX + this.motionX;
					double var12 = entity.motionZ + this.motionZ;
					if(((TileEntitySign)entity).d == 2 && this.d != 2) {
						this.motionX *= (double)0.2F;
						this.motionZ *= (double)0.2F;
						this.addVelocity(entity.motionX - var2, 0.0D, entity.motionZ - var4);
						entity.motionX *= (double)0.7F;
						entity.motionZ *= (double)0.7F;
					} else if(((TileEntitySign)entity).d != 2 && this.d == 2) {
						entity.motionX *= (double)0.2F;
						entity.motionZ *= (double)0.2F;
						entity.addVelocity(this.motionX + var2, 0.0D, this.motionZ + var4);
						this.motionX *= (double)0.7F;
						this.motionZ *= (double)0.7F;
					} else {
						var10 /= 2.0D;
						var12 /= 2.0D;
						this.motionX *= (double)0.2F;
						this.motionZ *= (double)0.2F;
						this.addVelocity(var10 - var2, 0.0D, var12 - var4);
						entity.motionX *= (double)0.2F;
						entity.motionZ *= (double)0.2F;
						entity.addVelocity(var10 + var2, 0.0D, var12 + var4);
					}
				} else {
					this.addVelocity(-var2, 0.0D, -var4);
					entity.addVelocity(var2 / 4.0D, 0.0D, var4 / 4.0D);
				}
			}

		}
	}

	public int getSizeInventory() {
		return 27;
	}

	public ItemStack getStackInSlot(int slot) {
		return this.h[slot];
	}

	public ItemStack decrStackSize(int slot, int stackSize) {
		if(this.h[slot] != null) {
			ItemStack var3;
			if(this.h[slot].stackSize <= stackSize) {
				var3 = this.h[slot];
				this.h[slot] = null;
				return var3;
			} else {
				var3 = this.h[slot].splitStack(stackSize);
				if(this.h[slot].stackSize == 0) {
					this.h[slot] = null;
				}

				return var3;
			}
		} else {
			return null;
		}
	}

	public void setInventorySlotContents(int slot, ItemStack itemStack) {
		this.h[slot] = itemStack;
		if(itemStack != null && itemStack.stackSize > this.getInventoryStackLimit()) {
			itemStack.stackSize = this.getInventoryStackLimit();
		}

	}

	public String getInvName() {
		return "Minecart";
	}

	public int getInventoryStackLimit() {
		return 64;
	}

	public void onInventoryChanged() {
	}

	public boolean interact(EntityPlayer entityPlayer) {
		if(this.d == 0) {
			entityPlayer.mountEntity(this);
		} else if(this.d == 1) {
			entityPlayer.displayGUIChest(this);
		} else if(this.d == 2) {
			ItemStack var2 = entityPlayer.inventory.getCurrentItem();
			if(var2 != null && var2.itemID == Item.coal.aR) {
				if(--var2.stackSize == 0) {
					entityPlayer.inventory.setInventorySlotContents(entityPlayer.inventory.currentItem, (ItemStack)null);
				}

				this.e += 1200;
			}

			this.f = this.posX - entityPlayer.posX;
			this.g = this.posZ - entityPlayer.posZ;
		}

		return true;
	}

	public void setPositionAndRotation(double x, double y, double z, float rotationYaw, float rotationPitch, int newPosRotationIncrements) {
		this.l = x;
		this.m = y;
		this.n = z;
		this.o = (double)rotationYaw;
		this.p = (double)rotationPitch;
		this.k = newPosRotationIncrements;
	}
}
