package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class NetworkReaderThread extends PlayerController {
	private int c = -1;
	private int d = -1;
	private int e = -1;
	private float f = 0.0F;
	private float g = 0.0F;
	private float h = 0.0F;
	private int i = 0;
	private boolean j = false;
	private NetClientHandler k;
	private int l = 0;

	public NetworkReaderThread(Minecraft var1, NetClientHandler var2) {
		super(var1);
		this.k = var2;
	}

	public void flipPlayer(EntityPlayer entityPlayer) {
		entityPlayer.rotationYaw = -180.0F;
	}

	public boolean sendBlockRemoved(int x, int y, int z, int side) {
		this.k.addToSendQueue(new Packet14BlockDig(3, x, y, z, side));
		int var5 = this.mc.theWorld.a(x, y, z);
		int var6 = this.mc.theWorld.e(x, y, z);
		boolean var7 = super.sendBlockRemoved(x, y, z, side);
		ItemStack var8 = this.mc.thePlayer.s();
		if(var8 != null) {
			var8.onDestroyBlock(var5, x, y, z);
			if(var8.stackSize == 0) {
				var8.onItemDestroyedByUse(this.mc.thePlayer);
				this.mc.thePlayer.t();
			}
		}

		if(var7 && this.mc.thePlayer.canHarvestBlock(Block.blocksList[var5])) {
			Block.blocksList[var5].dropBlockAsItem(this.mc.theWorld, x, y, z, var6);
		}

		return var7;
	}

	public void clickBlock(int x, int y, int z, int side) {
		this.j = true;
		this.k.addToSendQueue(new Packet14BlockDig(0, x, y, z, side));
		int var5 = this.mc.theWorld.a(x, y, z);
		if(var5 > 0 && this.f == 0.0F) {
			Block.blocksList[var5].onBlockClicked(this.mc.theWorld, x, y, z, this.mc.thePlayer);
		}

		if(var5 > 0 && Block.blocksList[var5].blockStrength(this.mc.thePlayer) >= 1.0F) {
			this.sendBlockRemoved(x, y, z, side);
		}

	}

	public void resetBlockRemoving() {
		if(this.j) {
			this.j = false;
			this.k.addToSendQueue(new Packet14BlockDig(2, 0, 0, 0, 0));
			this.f = 0.0F;
			this.i = 0;
		}
	}

	public void sendBlockRemoving(int x, int y, int z, int side) {
		this.j = true;
		this.e();
		this.k.addToSendQueue(new Packet14BlockDig(1, x, y, z, side));
		if(this.i > 0) {
			--this.i;
		} else {
			if(x == this.c && y == this.d && z == this.e) {
				int var5 = this.mc.theWorld.a(x, y, z);
				if(var5 == 0) {
					return;
				}

				Block var6 = Block.blocksList[var5];
				this.f += var6.blockStrength(this.mc.thePlayer);
				if(this.h % 4.0F == 0.0F && var6 != null) {
					this.mc.A.b(var6.stepSound.getStepSound(), (float)x + 0.5F, (float)y + 0.5F, (float)z + 0.5F, (var6.stepSound.getVolume() + 1.0F) / 8.0F, var6.stepSound.getPitch() * 0.5F);
				}

				++this.h;
				if(this.f >= 1.0F) {
					this.sendBlockRemoved(x, y, z, side);
					this.f = 0.0F;
					this.g = 0.0F;
					this.h = 0.0F;
					this.i = 5;
				}
			} else {
				this.f = 0.0F;
				this.g = 0.0F;
				this.h = 0.0F;
				this.c = x;
				this.d = y;
				this.e = z;
			}

		}
	}

	public void setPartialTime(float renderPartialTick) {
		if(this.f <= 0.0F) {
			this.mc.ingameGUI.damageGuiPartialTime = 0.0F;
			this.mc.renderGlobal.damagePartialTime = 0.0F;
		} else {
			float var2 = this.g + (this.f - this.g) * renderPartialTick;
			this.mc.ingameGUI.damageGuiPartialTime = var2;
			this.mc.renderGlobal.damagePartialTime = var2;
		}

	}

	public float getBlockReachDistance() {
		return 4.0F;
	}

	public void onWorldChange(World world) {
		super.onWorldChange(world);
	}

	public void onUpdate() {
		this.e();
		this.g = this.f;
	}

	private void e() {
		ItemStack var1 = this.mc.thePlayer.inventory.getCurrentItem();
		int var2 = 0;
		if(var1 != null) {
			var2 = var1.itemID;
		}

		if(var2 != this.l) {
			this.l = var2;
			this.k.addToSendQueue(new Packet16BlockItemSwitch(0, this.l));
		}

	}

	public boolean onPlayerRightClick(EntityPlayer entityPlayer, World world, ItemStack itemStack, int x, int y, int z, int side) {
		this.e();
		this.k.addToSendQueue(new Packet15Place(itemStack != null?itemStack.itemID:-1, x, y, z, side));
		return super.onPlayerRightClick(entityPlayer, world, itemStack, x, y, z, side);
	}

	public EntityPlayer createPlayer(World world) {
		return new EntityClientPlayerMP(this.mc, world, this.mc.session, this.k);
	}
}
