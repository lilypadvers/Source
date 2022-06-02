package net.minecraft.src;

import java.io.InputStream;
import paulscode.sound.codecs.CodecJOrbis;

public class ModelZombie extends CodecJOrbis {
	protected InputStream openInputStream() {
		return new BlockSapling(this, this.url, this.urlConnection.getInputStream());
	}
}
