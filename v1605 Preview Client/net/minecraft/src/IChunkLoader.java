package net.minecraft.src;

import java.util.Random;

public class IChunkLoader extends ChunkProviderLoadOrGenerate {
	protected IChunkLoader(int var1, int var2) {
		super(var1, var2, EntitySkeleton.d);
	}

	protected EntityCreature a_() {
		return new PlayerControllerSP();
	}

	public int a(int var1, Random var2) {
		return 0;
	}

	public int a(Random var1) {
		return 0;
	}

	public boolean b() {
		return false;
	}
}
