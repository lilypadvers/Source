package net.minecraft.src;

import java.util.ArrayList;
import java.util.List;

public class EntityPainting extends Entity {
	private int tickCounter;
	public int direction;
	private int xPosition;
	private int yPosition;
	private int zPosition;
	public EnumArt art;

	public EntityPainting(World var1) {
		super(var1);
		this.tickCounter = 0;
		this.direction = 0;
		this.yOffset = 0.0F;
		this.setSize(0.5F, 0.5F);
	}

	public EntityPainting(World worldObj, int xPosition, int yPosition, int zPosition, int direction) {
		this(worldObj);
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.zPosition = zPosition;
		ArrayList var6 = new ArrayList();
		EnumArt[] var7 = EnumArt.values();
		int var8 = var7.length;

		for(int var9 = 0; var9 < var8; ++var9) {
			EnumArt var10 = var7[var9];
			this.art = var10;
			this.setDirection(direction);
			if(this.onValidSurface()) {
				var6.add(var10);
			}
		}

		if(var6.size() > 0) {
			this.art = (EnumArt)var6.get(this.rand.nextInt(var6.size()));
		}

		this.setDirection(direction);
	}

	public void setDirection(int direction) {
		this.direction = direction;
		this.prevRotationYaw = this.rotationYaw = (float)(direction * 90);
		float var2 = (float)this.art.u;
		float var3 = (float)this.art.v;
		float var4 = (float)this.art.u;
		if(direction != 0 && direction != 2) {
			var2 = 0.5F;
		} else {
			var4 = 0.5F;
		}

		var2 /= 32.0F;
		var3 /= 32.0F;
		var4 /= 32.0F;
		float var5 = (float)this.xPosition + 0.5F;
		float var6 = (float)this.yPosition + 0.5F;
		float var7 = (float)this.zPosition + 0.5F;
		float var8 = 0.5625F;
		if(direction == 0) {
			var7 -= var8;
		}

		if(direction == 1) {
			var5 -= var8;
		}

		if(direction == 2) {
			var7 += var8;
		}

		if(direction == 3) {
			var5 += var8;
		}

		if(direction == 0) {
			var5 -= this.getArtSize(this.art.u);
		}

		if(direction == 1) {
			var7 += this.getArtSize(this.art.u);
		}

		if(direction == 2) {
			var5 += this.getArtSize(this.art.u);
		}

		if(direction == 3) {
			var7 -= this.getArtSize(this.art.u);
		}

		var6 += this.getArtSize(this.art.v);
		this.setPosition((double)var5, (double)var6, (double)var7);
		float var9 = -0.00625F;
		this.boundingBox.setBounds((double)(var5 - var2 - var9), (double)(var6 - var3 - var9), (double)(var7 - var4 - var9), (double)(var5 + var2 + var9), (double)(var6 + var3 + var9), (double)(var7 + var4 + var9));
	}

	private float getArtSize(int pixelSize) {
		return pixelSize == 32?0.5F:(pixelSize == 64?0.5F:0.0F);
	}

	public void onUpdate() {
		if(this.tickCounter++ == 100 && !this.onValidSurface()) {
			this.tickCounter = 0;
			this.kill();
			this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Item.painting)));
		}

	}

	public boolean onValidSurface() {
		if(this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() > 0) {
			return false;
		} else {
			int var1 = this.art.u / 16;
			int var2 = this.art.v / 16;
			int var3 = this.xPosition;
			int var4 = this.yPosition;
			int var5 = this.zPosition;
			if(this.direction == 0) {
				var3 = MathHelper.floor_double(this.posX - (double)((float)this.art.u / 32.0F));
			}

			if(this.direction == 1) {
				var5 = MathHelper.floor_double(this.posZ - (double)((float)this.art.u / 32.0F));
			}

			if(this.direction == 2) {
				var3 = MathHelper.floor_double(this.posX - (double)((float)this.art.u / 32.0F));
			}

			if(this.direction == 3) {
				var5 = MathHelper.floor_double(this.posZ - (double)((float)this.art.u / 32.0F));
			}

			var4 = MathHelper.floor_double(this.posY - (double)((float)this.art.v / 32.0F));

			int var7;
			for(int var6 = 0; var6 < var1; ++var6) {
				for(var7 = 0; var7 < var2; ++var7) {
					Material var8;
					if(this.direction != 0 && this.direction != 2) {
						var8 = this.worldObj.f(this.xPosition, var4 + var7, var5 + var6);
					} else {
						var8 = this.worldObj.f(var3 + var6, var4 + var7, this.zPosition);
					}

					if(!var8.isSolid()) {
						return false;
					}
				}
			}

			List var9 = this.worldObj.getEntitiesWithinAABBExcludingEntity(this, this.boundingBox);

			for(var7 = 0; var7 < var9.size(); ++var7) {
				if(var9.get(var7) instanceof EntityPainting) {
					return false;
				}
			}

			return true;
		}
	}

	public boolean canBeCollidedWith() {
		return true;
	}

	public boolean attackEntityFrom(Entity entity, int damage) {
		this.kill();
		this.worldObj.spawnEntityInWorld(new EntityItem(this.worldObj, this.posX, this.posY, this.posZ, new ItemStack(Item.painting)));
		return true;
	}

	public void writeEntityToNBT(NBTTagCompound compoundTag) {
		compoundTag.setByte("Dir", (byte)this.direction);
		compoundTag.setString("Motive", this.art.t);
		compoundTag.setInteger("TileX", this.xPosition);
		compoundTag.setInteger("TileY", this.yPosition);
		compoundTag.setInteger("TileZ", this.zPosition);
	}

	public void readEntityFromNBT(NBTTagCompound compoundTag) {
		this.direction = compoundTag.getByte("Dir");
		this.xPosition = compoundTag.getInteger("TileX");
		this.yPosition = compoundTag.getInteger("TileY");
		this.zPosition = compoundTag.getInteger("TileZ");
		String var2 = compoundTag.getString("Motive");
		EnumArt[] var3 = EnumArt.values();
		int var4 = var3.length;

		for(int var5 = 0; var5 < var4; ++var5) {
			EnumArt var6 = var3[var5];
			if(var6.t.equals(var2)) {
				this.art = var6;
			}
		}

		if(this.art == null) {
			this.art = EnumArt.Kebab;
		}

		this.setDirection(this.direction);
	}
}
