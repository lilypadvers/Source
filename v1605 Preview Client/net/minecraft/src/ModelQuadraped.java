package net.minecraft.src;

import java.io.DataInput;
import java.io.DataInputStream;
import java.io.DataOutput;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

public class ModelQuadraped {
	public static EntityItem a(InputStream var0) {
		DataInputStream var1 = new DataInputStream(new GZIPInputStream(var0));

		EntityItem var2;
		try {
			var2 = a((DataInput)var1);
		} finally {
			var1.close();
		}

		return var2;
	}

	public static void a(EntityItem var0, OutputStream var1) {
		DataOutputStream var2 = new DataOutputStream(new GZIPOutputStream(var1));

		try {
			a(var0, (DataOutput)var2);
		} finally {
			var2.close();
		}

	}

	public static EntityItem a(DataInput var0) {
		EnumSkyBlock var1 = EnumSkyBlock.b(var0);
		if(var1 instanceof EntityItem) {
			return (EntityItem)var1;
		} else {
			throw new IOException("Root tag must be a named compound tag");
		}
	}

	public static void a(EntityItem var0, DataOutput var1) {
		EnumSkyBlock.a(var0, var1);
	}
}
