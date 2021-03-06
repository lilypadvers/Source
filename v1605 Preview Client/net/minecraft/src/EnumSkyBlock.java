package net.minecraft.src;

import java.io.DataInput;
import java.io.DataOutput;

public abstract class EnumSkyBlock {
	private String a = null;

	abstract void a(DataOutput var1);

	abstract void a(DataInput var1);

	public abstract byte a();

	public String b() {
		return this.a == null?"":this.a;
	}

	public EnumSkyBlock a(String var1) {
		this.a = var1;
		return this;
	}

	public static EnumSkyBlock b(DataInput var0) {
		byte var1 = var0.readByte();
		if(var1 == 0) {
			return new RenderManager();
		} else {
			EnumSkyBlock var2 = a(var1);
			var2.a = var0.readUTF();
			var2.a(var0);
			return var2;
		}
	}

	public static void a(EnumSkyBlock var0, DataOutput var1) {
		var1.writeByte(var0.a());
		if(var0.a() != 0) {
			var1.writeUTF(var0.b());
			var0.a(var1);
		}
	}

	public static EnumSkyBlock a(byte var0) {
		switch(var0) {
		case 0:
			return new RenderManager();
		case 1:
			return new BlockGrass();
		case 2:
			return new lh();
		case 3:
			return new EntityList();
		case 4:
			return new GuiInventory();
		case 5:
			return new RenderPig();
		case 6:
			return new MovementInputFromOptions();
		case 7:
			return new BlockFluid();
		case 8:
			return new mr();
		case 9:
			return new ItemPainting();
		case 10:
			return new EntityItem();
		default:
			return null;
		}
	}

	public static String b(byte var0) {
		switch(var0) {
		case 0:
			return "TAG_End";
		case 1:
			return "TAG_Byte";
		case 2:
			return "TAG_Short";
		case 3:
			return "TAG_Int";
		case 4:
			return "TAG_Long";
		case 5:
			return "TAG_Float";
		case 6:
			return "TAG_Double";
		case 7:
			return "TAG_Byte_Array";
		case 8:
			return "TAG_String";
		case 9:
			return "TAG_List";
		case 10:
			return "TAG_Compound";
		default:
			return "UNKNOWN";
		}
	}
}
