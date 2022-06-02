package net.minecraft.src;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class nj implements BlockButton {
	private Random j;
	private le k;
	private le l;
	private le m;
	private le n;
	private le o;
	public le a;
	public le b;
	public le c;
	private EntitySpider p;
	private double[] q;
	private double[] r = new double[256];
	private double[] s = new double[256];
	private double[] t = new double[256];
	double[] d;
	double[] e;
	double[] f;
	double[] g;
	double[] h;
	int[][] i = new int[32][32];
	private int time_hr = 0;
	private long lastUpdate = 0L;

	public nj(EntitySpider var1, long var2) {
		this.p = var1;
		this.j = new Random(var2);
		this.k = new le(this.j, 16);
		this.l = new le(this.j, 16);
		this.m = new le(this.j, 8);
		this.n = new le(this.j, 4);
		this.o = new le(this.j, 4);
		this.a = new le(this.j, 10);
		this.b = new le(this.j, 16);
		this.c = new le(this.j, 8);
	}

	public void a(int var1, int var2, byte[] var3) {
		this.q = this.a(this.q, var1 * 4, 0, var2 * 4, 5, 17, 5);

		for(int var9 = 0; var9 < 4; ++var9) {
			for(int var10 = 0; var10 < 4; ++var10) {
				for(int var11 = 0; var11 < 16; ++var11) {
					double var14 = this.q[((var9 + 0) * 5 + var10 + 0) * 17 + var11 + 0];
					double var16 = this.q[((var9 + 0) * 5 + var10 + 1) * 17 + var11 + 0];
					double var18 = this.q[((var9 + 1) * 5 + var10 + 0) * 17 + var11 + 0];
					double var20 = this.q[((var9 + 1) * 5 + var10 + 1) * 17 + var11 + 0];
					double var22 = (this.q[((var9 + 0) * 5 + var10 + 0) * 17 + var11 + 1] - var14) * 0.125D;
					double var24 = (this.q[((var9 + 0) * 5 + var10 + 1) * 17 + var11 + 1] - var16) * 0.125D;
					double var26 = (this.q[((var9 + 1) * 5 + var10 + 0) * 17 + var11 + 1] - var18) * 0.125D;
					double var28 = (this.q[((var9 + 1) * 5 + var10 + 1) * 17 + var11 + 1] - var20) * 0.125D;

					for(int var30 = 0; var30 < 8; ++var30) {
						double var33 = var14;
						double var35 = var16;
						double var37 = (var18 - var14) * 0.25D;
						double var39 = (var20 - var16) * 0.25D;

						for(int var41 = 0; var41 < 4; ++var41) {
							int var42 = var41 + var9 * 4 << 11 | 0 + var10 * 4 << 7 | var11 * 8 + var30;
							double var46 = var33;
							double var48 = (var35 - var33) * 0.25D;

							for(int var50 = 0; var50 < 4; ++var50) {
								int var51 = 0;
								if(var11 * 8 + var30 < 64) {
									if(this.p.d && var11 * 8 + var30 >= 63) {
										var51 = ln.aT.ba;
									} else {
										var51 = ln.B.ba;
									}
								}

								if(var46 > 0.0D) {
									var51 = ln.t.ba;
								}

								var3[var42] = (byte)var51;
								var42 += 128;
								var46 += var48;
							}

							var33 += var37;
							var35 += var39;
						}

						var14 += var22;
						var16 += var24;
						var18 += var26;
						var20 += var28;
					}
				}
			}
		}

	}

	public void b(int var1, int var2, byte[] var3) {
		this.r = this.n.a(this.r, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, 8.0D / 256D, 8.0D / 256D, 1.0D);
		this.s = this.n.a(this.s, (double)(var2 * 16), 109.0134D, (double)(var1 * 16), 16, 1, 16, 8.0D / 256D, 1.0D, 8.0D / 256D);
		this.t = this.o.a(this.t, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, 0.0625D, 0.0625D, 0.0625D);

		for(int var7 = 0; var7 < 16; ++var7) {
			for(int var8 = 0; var8 < 16; ++var8) {
				boolean var9 = this.r[var7 + var8 * 16] + this.j.nextDouble() * 0.2D > 0.0D;
				boolean var10 = this.s[var7 + var8 * 16] + this.j.nextDouble() * 0.2D > 3.0D;
				int var11 = (int)(this.t[var7 + var8 * 16] / 3.0D + 3.0D + this.j.nextDouble() * 0.25D);
				int var12 = -1;
				byte var13 = (byte)ln.u.ba;
				byte var14 = (byte)ln.v.ba;

				for(int var15 = 127; var15 >= 0; --var15) {
					int var16 = (var7 * 16 + var8) * 128 + var15;
					if(var15 <= 0 + this.j.nextInt(6) - 1) {
						var3[var16] = (byte)ln.z.ba;
					} else {
						byte var17 = var3[var16];
						if(var17 == 0) {
							var12 = -1;
						} else if(var17 == ln.t.ba) {
							if(var12 == -1) {
								if(var11 <= 0) {
									var13 = 0;
									var14 = (byte)ln.t.ba;
								} else if(var15 >= 60 && var15 <= 65) {
									var13 = (byte)ln.u.ba;
									var14 = (byte)ln.v.ba;
									if(var10) {
										var13 = 0;
									}

									if(var10) {
										var14 = (byte)ln.F.ba;
									}

									if(var9) {
										var13 = (byte)ln.E.ba;
									}

									if(var9) {
										var14 = (byte)ln.E.ba;
									}
								}

								if(var15 < 64 && var13 == 0) {
									var13 = (byte)ln.B.ba;
								}

								var12 = var11;
								if(var15 >= 63) {
									var3[var16] = var13;
								} else {
									var3[var16] = var14;
								}
							} else if(var12 > 0) {
								--var12;
								var3[var16] = var14;
							}
						}
					}
				}
			}
		}

	}

	public BlockMushroom b(int var1, int var2) {
		if(Math.abs(System.currentTimeMillis() - this.lastUpdate) > 5000L) {
			SimpleDateFormat var3 = new SimpleDateFormat("HH");
			this.time_hr = Integer.parseInt(var3.format(Calendar.getInstance().getTime()));
			this.lastUpdate = System.currentTimeMillis();
		}

		boolean var8 = this.time_hr > 22 || this.time_hr < 5;
		this.j.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
		byte[] var4 = new byte['\u8000'];
		BlockMushroom var5 = new BlockMushroom(this.p, var4, var1, var2);
		int var6 = var1 + (var8?this.j.nextInt(2000) - this.j.nextInt(1000):0);
		int var7 = var2 + (var8?this.j.nextInt(2000) - this.j.nextInt(1000):0);
		this.a(var6, var7, var4);
		this.b(var6, var7, var4);
		this.c(var6, var7, var4);
		var5.c();
		return var5;
	}

	protected void a(int var1, int var2, byte[] var3, double var4, double var6, double var8) {
		this.a(var1, var2, var3, var4, var6, var8, 1.0F + this.j.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
	}

	protected void a(int var1, int var2, byte[] var3, double var4, double var6, double var8, float var10, float var11, float var12, int var13, int var14, double var15) {
		if(Math.abs(System.currentTimeMillis() - this.lastUpdate) > 5000L) {
			SimpleDateFormat var17 = new SimpleDateFormat("HH");
			this.time_hr = Integer.parseInt(var17.format(Calendar.getInstance().getTime()));
			this.lastUpdate = System.currentTimeMillis();
		}

		boolean var63 = this.time_hr > 22 || this.time_hr < 5;
		double var18 = (double)(var1 * 16 + (var63?8:0));
		double var20 = (double)(var2 * 16 + (var63?8:0));
		float var22 = 0.0F;
		float var23 = 0.0F;
		Random var24 = new Random(0L);
		if(var14 <= 0) {
			var14 = 112 - var24.nextInt(28);
		}

		boolean var25 = false;
		if(var13 == -1) {
			var13 = var14 / 2;
			var25 = true;
		}

		int var26 = var24.nextInt(var14 / 2) + var14 / 4;

		for(boolean var27 = var24.nextInt(6) == 0; var13 < var14; ++var13) {
			double var28 = 1.5D + (double)(ModelPig.a((float)var13 * (float)Math.PI / (float)var14) * var10 * 1.0F);
			double var30 = var28 * var15;
			float var32 = ModelPig.b(var12);
			float var33 = ModelPig.a(var12);
			var4 += (double)(ModelPig.b(var11) * var32);
			var6 += (double)var33;
			var8 += (double)(ModelPig.a(var11) * var32);
			if(var27) {
				var12 *= 0.92F;
			} else {
				var12 *= 0.7F;
			}

			var12 += var23 * 0.1F;
			var11 += var22 * 0.1F;
			float var34 = var23 * 0.9F;
			float var35 = var22 * 0.75F;
			var23 = var34 + (var24.nextFloat() - var24.nextFloat()) * var24.nextFloat() * 2.0F;
			var22 = var35 + (var24.nextFloat() - var24.nextFloat()) * var24.nextFloat() * 4.0F;
			if(!var25 && var13 == var26 && var10 > 1.0F) {
				this.a(var1, var2, var3, var4, var6, var8, var24.nextFloat() * 0.5F + 0.5F, var11 - (float)Math.PI / 2F, var12 / 3.0F, var13, var14, 1.0D);
				this.a(var1, var2, var3, var4, var6, var8, var24.nextFloat() * 0.5F + 0.5F, var11 + (float)Math.PI / 2F, var12 / 3.0F, var13, var14, 1.0D);
				return;
			}

			if(var25 || var24.nextInt(4) != 0) {
				double var36 = var4 - var18;
				double var38 = var8 - var20;
				double var40 = (double)(var14 - var13);
				double var42 = (double)(var10 + 2.0F + 16.0F);
				if(var36 * var36 + var38 * var38 - var40 * var40 > var42 * var42) {
					return;
				}

				if(var4 >= var18 - 16.0D - var28 * 2.0D && var8 >= var20 - 16.0D - var28 * 2.0D && var4 <= var18 + 16.0D + var28 * 2.0D && var8 <= var20 + 16.0D + var28 * 2.0D) {
					int var44 = ModelPig.b(var4 - var28) - var1 * 16 - 1;
					int var45 = ModelPig.b(var4 + var28) - var1 * 16 + 1;
					int var46 = ModelPig.b(var6 - var30) - 1;
					int var47 = ModelPig.b(var6 + var30) + 1;
					int var48 = ModelPig.b(var8 - var28) - var2 * 16 - 1;
					int var49 = ModelPig.b(var8 + var28) - var2 * 16 + 1;
					if(var44 < 0) {
						var44 = 0;
					}

					if(var45 > 16) {
						var45 = 16;
					}

					if(var46 < 1) {
						var46 = 1;
					}

					if(var47 > 120) {
						var47 = 120;
					}

					if(var48 < 0) {
						var48 = 0;
					}

					if(var49 > 16) {
						var49 = 16;
					}

					boolean var50 = false;

					int var51;
					int var54;
					for(var51 = var44; !var50 && var51 < var45; ++var51) {
						for(int var52 = var48; !var50 && var52 < var49; ++var52) {
							for(int var53 = var47 + 1; !var50 && var53 >= var46 - 1; --var53) {
								var54 = (var51 * 16 + var52) * 128 + var53;
								if(var53 >= 0 && var53 < 128) {
									if(var3[var54] == ln.A.ba || var3[var54] == ln.B.ba) {
										var50 = true;
									}

									if(var53 != var46 - 1 && var51 != var44 && var51 != var45 - 1 && var52 != var48 && var52 != var49 - 1) {
										var53 = var46;
									}
								}
							}
						}
					}

					if(!var50) {
						for(var51 = var44; var51 < var45; ++var51) {
							double var64 = ((double)(var51 + var1 * 16) + 0.5D - var4) / var28;

							for(var54 = var48; var54 < var49; ++var54) {
								double var55 = ((double)(var54 + var2 * 16) + 0.5D - var8) / var28;
								int var57 = (var51 * 16 + var54) * 128 + var47;
								boolean var58 = false;

								for(int var59 = var47 - 1; var59 >= var46; --var59) {
									double var60 = ((double)var59 + 0.5D - var6) / var30;
									if(var60 > -0.7D && var64 * var64 + var60 * var60 + var55 * var55 < 1.0D) {
										byte var62 = var3[var57];
										if(var62 == ln.u.ba) {
											var58 = true;
										}

										if(var62 == ln.t.ba || var62 == ln.v.ba || var62 == ln.u.ba) {
											if(var59 < 10) {
												var3[var57] = (byte)ln.C.ba;
											} else {
												var3[var57] = 0;
												if(var58 && var3[var57 - 1] == ln.v.ba) {
													var3[var57 - 1] = (byte)ln.u.ba;
												}
											}
										}
									}

									--var57;
								}
							}
						}

						if(var25) {
							break;
						}
					}
				}
			}
		}

	}

	private void c(int var1, int var2, byte[] var3) {
		this.j.setSeed(this.p.r);
		long var5 = this.j.nextLong() / 2L * 2L + 1L;
		long var7 = this.j.nextLong() / 2L * 2L + 1L;

		for(int var9 = var1 - 8; var9 <= var1 + 8; ++var9) {
			for(int var10 = var2 - 8; var10 <= var2 + 8; ++var10) {
				this.j.setSeed((long)var9 * var5 + (long)var10 * var7 ^ this.p.r);
				int var11 = this.j.nextInt(this.j.nextInt(this.j.nextInt(40) + 1) + 1);
				if(this.j.nextInt(15) != 0) {
					var11 = 0;
				}

				for(int var12 = 0; var12 < var11; ++var12) {
					double var13 = (double)(var9 * 16 + this.j.nextInt(16));
					double var15 = (double)this.j.nextInt(this.j.nextInt(120) + 8);
					double var17 = (double)(var10 * 16 + this.j.nextInt(16));
					int var19 = 1;
					if(this.j.nextInt(4) == 0) {
						this.a(var1, var2, var3, var13, var15, var17);
						var19 += this.j.nextInt(4);
					}

					for(int var20 = 0; var20 < var19; ++var20) {
						this.a(var1, var2, var3, var13, var15, var17, this.j.nextFloat() * 2.0F + this.j.nextFloat(), this.j.nextFloat() * (float)Math.PI * 2.0F, (this.j.nextFloat() - 0.5F) * 2.0F / 8.0F, 0, 0, 1.0D);
					}
				}
			}
		}

	}

	private double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if(var1 == null) {
			var1 = new double[var5 * var6 * var7];
		}

		this.g = this.a.a(this.g, (double)var2, (double)var3, (double)var4, var5, 1, var7, 1.0D, 0.0D, 1.0D);
		this.h = this.b.a(this.h, (double)var2, (double)var3, (double)var4, var5, 1, var7, 100.0D, 0.0D, 100.0D);
		this.d = this.m.a(this.d, (double)var2, (double)var3, (double)var4, var5, var6, var7, 8.555150000000001D, 4.277575000000001D, 8.555150000000001D);
		this.e = this.k.a(this.e, (double)var2, (double)var3, (double)var4, var5, var6, var7, 684.412D, 684.412D, 684.412D);
		this.f = this.l.a(this.f, (double)var2, (double)var3, (double)var4, var5, var6, var7, 684.412D, 684.412D, 684.412D);
		int var12 = 0;
		int var13 = 0;

		for(int var14 = 0; var14 < var5; ++var14) {
			for(int var15 = 0; var15 < var7; ++var15) {
				double var16 = (this.g[var13] + 256.0D) / 512.0D;
				if(var16 > 1.0D) {
					var16 = 1.0D;
				}

				double var20 = this.h[var13] / 8000.0D;
				if(var20 < 0.0D) {
					var20 = -var20;
				}

				double var22 = var20 * 3.0D - 3.0D;
				double var24;
				double var26;
				if(var22 < 0.0D) {
					var26 = var22 / 2.0D;
					if(var26 < -1.0D) {
						var26 = -1.0D;
					}

					var24 = var26 / 1.4D / 2.0D;
					var16 = 0.0D;
				} else {
					if(var22 > 1.0D) {
						var22 = 1.0D;
					}

					var24 = var22 / 6.0D;
				}

				var26 = var16 + 0.5D;
				double var28 = (double)var6 / 2.0D + var24 * (double)var6 / 16.0D * 4.0D;
				++var13;

				for(int var30 = 0; var30 < var6; ++var30) {
					double var31 = ((double)var30 - var28) * 12.0D / var26;
					if(var31 < 0.0D) {
						var31 *= 4.0D;
					}

					double var33 = this.e[var12] / 512.0D;
					double var35 = this.f[var12] / 512.0D;
					double var37 = (this.d[var12] / 10.0D + 1.0D) / 2.0D;
					double var39;
					if(var37 < 0.0D) {
						var39 = var33;
					} else if(var37 > 1.0D) {
						var39 = var35;
					} else {
						var39 = var33 + (var35 - var33) * var37;
					}

					double var41 = var39 - var31;
					double var43;
					if(var30 > var6 - 4) {
						var43 = (double)((float)(var30 - (var6 - 4)) / 3.0F);
						var41 = var41 * (1.0D - var43) + -10.0D * var43;
					}

					if((double)var30 < 0.0D) {
						var43 = (0.0D - (double)var30) / 4.0D;
						if(var43 < 0.0D) {
							var43 = 0.0D;
						}

						if(var43 > 1.0D) {
							var43 = 1.0D;
						}

						var41 = var41 * (1.0D - var43) + -10.0D * var43;
					}

					var1[var12] = var41;
					++var12;
				}
			}
		}

		return var1;
	}

	public boolean a(int var1, int var2) {
		return true;
	}

	public void a(BlockButton var1, int var2, int var3) {
		Explosion.a = true;
		byte var4 = 1;
		int var5 = var2 * 16;
		int var6 = var3 * 16;
		this.j.setSeed(this.p.r);
		this.j.setSeed((long)var2 * (this.j.nextLong() / 2L * 2L + 1L) + (long)var3 * (this.j.nextLong() / 2L * 2L + 1L) ^ this.p.r);

		int var7;
		for(var7 = 0; var7 < 8 * var4; ++var7) {
			(new TextureLavaFX()).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(128), var6 + this.j.nextInt(16) + 8);
		}

		for(var7 = 0; var7 < 10 * var4; ++var7) {
			(new Session(32)).a(this.p, this.j, var5 + this.j.nextInt(16), this.j.nextInt(128), var6 + this.j.nextInt(16));
		}

		for(var7 = 0; var7 < 20 * var4; ++var7) {
			(new NBTTagByte(ln.v.ba, 32)).a(this.p, this.j, var5 + this.j.nextInt(16), this.j.nextInt(128), var6 + this.j.nextInt(16));
		}

		for(var7 = 0; var7 < 10 * var4; ++var7) {
			(new NBTTagByte(ln.F.ba, 32)).a(this.p, this.j, var5 + this.j.nextInt(16), this.j.nextInt(128), var6 + this.j.nextInt(16));
		}

		for(var7 = 0; var7 < 20 * var4; ++var7) {
			(new NBTTagByte(ln.I.ba, 16)).a(this.p, this.j, var5 + this.j.nextInt(16), this.j.nextInt(128), var6 + this.j.nextInt(16));
		}

		for(var7 = 0; var7 < 20 * var4; ++var7) {
			(new NBTTagByte(ln.H.ba, 8)).a(this.p, this.j, var5 + this.j.nextInt(16), this.j.nextInt(64), var6 + this.j.nextInt(16));
		}

		for(var7 = 0; var7 < 2 * var4; ++var7) {
			(new NBTTagByte(ln.G.ba, 8)).a(this.p, this.j, var5 + this.j.nextInt(16), this.j.nextInt(32), var6 + this.j.nextInt(16));
		}

		for(var7 = 0; var7 < 8 * var4; ++var7) {
			(new NBTTagByte(ln.aN.ba, 7)).a(this.p, this.j, var5 + this.j.nextInt(16), this.j.nextInt(16), var6 + this.j.nextInt(16));
		}

		for(var7 = 0; var7 < 1 * var4; ++var7) {
			(new NBTTagByte(ln.aw.ba, 7)).a(this.p, this.j, var5 + this.j.nextInt(16), this.j.nextInt(16), var6 + this.j.nextInt(16));
		}

		int var9 = (int)((this.c.a((double)var5 * 0.5D, (double)var6 * 0.5D) / 8.0D + this.j.nextDouble() * 4.0D + 4.0D) / 3.0D);
		if(var9 < 0) {
			var9 = 0;
		}

		if(this.j.nextInt(10) == 0) {
			++var9;
		}

		Object var10 = new nm();
		if(this.j.nextInt(10) == 0) {
			var10 = new ItemSaddle();
		}

		int var11;
		int var12;
		int var13;
		for(var11 = 0; var11 < var9; ++var11) {
			var12 = var5 + this.j.nextInt(16) + 8;
			var13 = var6 + this.j.nextInt(16) + 8;
			((ItemArmor)var10).a(1.0D, 1.0D, 1.0D);
			((ItemArmor)var10).a(this.p, this.j, var12, this.p.c(var12, var13), var13);
		}

		for(var11 = 0; var11 < 2; ++var11) {
			(new EntityGiantZombie(ln.ad.ba)).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(128), var6 + this.j.nextInt(16) + 8);
		}

		if(this.j.nextInt(2) == 0) {
			(new EntityGiantZombie(ln.ae.ba)).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(128), var6 + this.j.nextInt(16) + 8);
		}

		if(this.j.nextInt(4) == 0) {
			(new EntityGiantZombie(ln.af.ba)).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(128), var6 + this.j.nextInt(16) + 8);
		}

		if(this.j.nextInt(8) == 0) {
			(new EntityGiantZombie(ln.ag.ba)).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(128), var6 + this.j.nextInt(16) + 8);
		}

		for(var11 = 0; var11 < 10; ++var11) {
			(new FontRenderer()).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(128), var6 + this.j.nextInt(16) + 8);
		}

		for(var11 = 0; var11 < 1; ++var11) {
			(new OpenGlCapsChecker()).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(128), var6 + this.j.nextInt(16) + 8);
		}

		for(var11 = 0; var11 < 50; ++var11) {
			(new na(ln.A.ba)).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(this.j.nextInt(120) + 8), var6 + this.j.nextInt(16) + 8);
		}

		for(var11 = 0; var11 < 20; ++var11) {
			(new na(ln.C.ba)).a(this.p, this.j, var5 + this.j.nextInt(16) + 8, this.j.nextInt(this.j.nextInt(this.j.nextInt(112) + 8) + 8), var6 + this.j.nextInt(16) + 8);
		}

		if(this.p.d) {
			for(var11 = var5 + 8 + 0; var11 < var5 + 8 + 16; ++var11) {
				for(var12 = var6 + 8 + 0; var12 < var6 + 8 + 16; ++var12) {
					var13 = this.p.d(var11, var12);
					if(var13 > 0 && var13 < 128 && this.p.a(var11, var13, var12) == 0 && this.p.f(var11, var13 - 1, var12).c() && this.p.f(var11, var13 - 1, var12) != EntitySkeleton.r) {
						this.p.d(var11, var13, var12, ln.aS.ba);
					}
				}
			}
		}

		Explosion.a = false;
	}

	public boolean a(boolean var1, nh var2) {
		return true;
	}

	public boolean a() {
		return false;
	}

	public boolean b() {
		return true;
	}
}
