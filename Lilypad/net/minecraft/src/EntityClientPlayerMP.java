package net.minecraft.src;

import net.minecraft.client.Minecraft;

public class EntityClientPlayerMP extends EntityPlayerSP {
	private NetClientHandler sendQueue;
	private int motionUpdateCounter = 0;
	private double oldPosX;
	private double oldBasePos;
	private double oldPosY;
	private double oldPosZ;
	private float oldRotationYaw;
	private float oldRotationPitch;
	private InventoryPlayer serverSideInventory = new InventoryPlayer((EntityPlayer)null);

	public EntityClientPlayerMP(Minecraft minecraft, World worldObj, Session session, NetClientHandler sendQueue) {
		super(minecraft, worldObj, session);
		this.sendQueue = sendQueue;
	}

	public void onUpdate() {
		super.onUpdate();
		this.I();
	}

	public void onPlayerUpdate() {
		this.I();
	}

	public void I() {
		if(this.motionUpdateCounter++ == 20) {
			if(!this.inventory.getInventoryEqual(this.serverSideInventory)) {
				this.sendQueue.addToSendQueue(new Packet5PlayerInventory(-1, this.inventory.mainInventory));
				this.sendQueue.addToSendQueue(new Packet5PlayerInventory(-2, this.inventory.craftingInventory));
				this.sendQueue.addToSendQueue(new Packet5PlayerInventory(-3, this.inventory.armorInventory));
				this.serverSideInventory = this.inventory.copyInventory();
			}

			this.motionUpdateCounter = 0;
		}

		double var1 = this.posX - this.oldPosX;
		double var3 = this.boundingBox.minY - this.oldBasePos;
		double var5 = this.posY - this.oldPosY;
		double var7 = this.posZ - this.oldPosZ;
		double var9 = (double)(this.rotationYaw - this.oldRotationYaw);
		double var11 = (double)(this.rotationPitch - this.oldRotationPitch);
		boolean var13 = var3 != 0.0D || var5 != 0.0D || var1 != 0.0D || var7 != 0.0D;
		boolean var14 = var9 != 0.0D || var11 != 0.0D;
		if(var13 && var14) {
			this.sendQueue.addToSendQueue(new Packet13PlayerLookMove(this.posX, this.boundingBox.minY, this.posY, this.posZ, this.rotationYaw, this.rotationPitch, this.onGround));
		} else if(var13) {
			this.sendQueue.addToSendQueue(new Packet11PlayerPosition(this.posX, this.boundingBox.minY, this.posY, this.posZ, this.onGround));
		} else if(var14) {
			this.sendQueue.addToSendQueue(new Packet12PlayerLook(this.rotationYaw, this.rotationPitch, this.onGround));
		} else {
			this.sendQueue.addToSendQueue(new Packet10Flying(this.onGround));
		}

		if(var13) {
			this.oldPosX = this.posX;
			this.oldBasePos = this.boundingBox.minY;
			this.oldPosY = this.posY;
			this.oldPosZ = this.posZ;
		}

		if(var14) {
			this.oldRotationYaw = this.rotationYaw;
			this.oldRotationPitch = this.rotationPitch;
		}

	}

	protected void joinEntityItemWithWorld(EntityItem entityItem) {
		System.out.println("Dropping?");
		Packet21PickupSpawn var2 = new Packet21PickupSpawn(entityItem);
		this.sendQueue.addToSendQueue(var2);
		entityItem.posX = (double)var2.xPosition / 32.0D;
		entityItem.posY = (double)var2.yPosition / 32.0D;
		entityItem.posZ = (double)var2.zPosition / 32.0D;
		entityItem.motionX = (double)var2.rotation / 128.0D;
		entityItem.motionY = (double)var2.pitch / 128.0D;
		entityItem.motionZ = (double)var2.roll / 128.0D;
	}

	public void sendChatMessage(String chatMessage) {
		this.sendQueue.addToSendQueue(new Packet3Chat(chatMessage));
	}

	public void v() {
		super.v();
		this.sendQueue.addToSendQueue(new Packet18ArmAnimation(this, 1));
	}
}
