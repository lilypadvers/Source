package net.minecraft.src;

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
		byte var4 = 4;
		byte var5 = 64;
		int var6 = var4 + 1;
		byte var7 = 17;
		int var8 = var4 + 1;
		this.q = this.a(this.q, var1 * var4, 0, var2 * var4, var6, var7, var8);

		for(int var9 = 0; var9 < var4; ++var9) {
			for(int var10 = 0; var10 < var4; ++var10) {
				for(int var11 = 0; var11 < 16; ++var11) {
					double var12 = 0.125D;
					double var14 = this.q[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 0];
					double var16 = this.q[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 0];
					double var18 = this.q[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 0];
					double var20 = this.q[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 0];
					double var22 = (this.q[((var9 + 0) * var8 + var10 + 0) * var7 + var11 + 1] - var14) * var12;
					double var24 = (this.q[((var9 + 0) * var8 + var10 + 1) * var7 + var11 + 1] - var16) * var12;
					double var26 = (this.q[((var9 + 1) * var8 + var10 + 0) * var7 + var11 + 1] - var18) * var12;
					double var28 = (this.q[((var9 + 1) * var8 + var10 + 1) * var7 + var11 + 1] - var20) * var12;

					for(int var30 = 0; var30 < 8; ++var30) {
						double var31 = 0.25D;
						double var33 = var14;
						double var35 = var16;
						double var37 = (var18 - var14) * var31;
						double var39 = (var20 - var16) * var31;

						for(int var41 = 0; var41 < 4; ++var41) {
							int var42 = var41 + var9 * 4 << 11 | 0 + var10 * 4 << 7 | var11 * 8 + var30;
							short var43 = 128;
							double var44 = 0.25D;
							double var46 = var33;
							double var48 = (var35 - var33) * var44;

							for(int var50 = 0; var50 < 4; ++var50) {
								int var51 = 0;
								if(var11 * 8 + var30 < var5) {
									if(this.p.d && var11 * 8 + var30 >= var5 - 1) {
										var51 = ln.aT.ba;
									} else {
										var51 = ln.B.ba;
									}
								}

								if(var46 > 0.0D) {
									var51 = ln.t.ba;
								}

								var3[var42] = (byte)var51;
								var42 += var43;
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
		byte var4 = 64;
		double var5 = 8.0D / 256D;
		this.r = this.n.a(this.r, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var5, var5, 1.0D);
		this.s = this.n.a(this.s, (double)(var2 * 16), 109.0134D, (double)(var1 * 16), 16, 1, 16, var5, 1.0D, var5);
		this.t = this.o.a(this.t, (double)(var1 * 16), (double)(var2 * 16), 0.0D, 16, 16, 1, var5 * 2.0D, var5 * 2.0D, var5 * 2.0D);

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
								} else if(var15 >= var4 - 4 && var15 <= var4 + 1) {
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

								if(var15 < var4 && var13 == 0) {
									var13 = (byte)ln.B.ba;
								}

								var12 = var11;
								if(var15 >= var4 - 1) {
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
		this.j.setSeed((long)var1 * 341873128712L + (long)var2 * 132897987541L);
		byte[] var3 = new byte['\u8000'];
		BlockMushroom var4 = new BlockMushroom(this.p, var3, var1, var2);
		this.a(var1, var2, var3);
		this.b(var1, var2, var3);
		this.c(var1, var2, var3);
		var4.c();
		return var4;
	}

	protected void a(int var1, int var2, byte[] var3, double var4, double var6, double var8) {
		this.a(var1, var2, var3, var4, var6, var8, 1.0F + this.j.nextFloat() * 6.0F, 0.0F, 0.0F, -1, -1, 0.5D);
	}

	protected void a(int var1, int var2, byte[] var3, double var4, double var6, double var8, float var10, float var11, float var12, int var13, int var14, double var15) {
		double var17 = (double)(var1 * 16 + 8);
		double var19 = (double)(var2 * 16 + 8);
		float var21 = 0.0F;
		float var22 = 0.0F;
		Random var23 = new Random(this.j.nextLong());
		if(var14 <= 0) {
			byte var24 = 112;
			var14 = var24 - var23.nextInt(var24 / 4);
		}

		boolean var52 = false;
		if(var13 == -1) {
			var13 = var14 / 2;
			var52 = true;
		}

		int var25 = var23.nextInt(var14 / 2) + var14 / 4;

		for(boolean var26 = var23.nextInt(6) == 0; var13 < var14; ++var13) {
			double var27 = 1.5D + (double)(ModelPig.a((float)var13 * (float)Math.PI / (float)var14) * var10 * 1.0F);
			double var29 = var27 * var15;
			float var31 = ModelPig.b(var12);
			float var32 = ModelPig.a(var12);
			var4 += (double)(ModelPig.b(var11) * var31);
			var6 += (double)var32;
			var8 += (double)(ModelPig.a(var11) * var31);
			if(var26) {
				var12 *= 0.92F;
			} else {
				var12 *= 0.7F;
			}

			var12 += var22 * 0.1F;
			var11 += var21 * 0.1F;
			var22 *= 0.9F;
			var21 *= 0.75F;
			var22 += (var23.nextFloat() - var23.nextFloat()) * var23.nextFloat() * 2.0F;
			var21 += (var23.nextFloat() - var23.nextFloat()) * var23.nextFloat() * 4.0F;
			if(!var52 && var13 == var25 && var10 > 1.0F) {
				this.a(var1, var2, var3, var4, var6, var8, var23.nextFloat() * 0.5F + 0.5F, var11 - (float)Math.PI / 2F, var12 / 3.0F, var13, var14, 1.0D);
				this.a(var1, var2, var3, var4, var6, var8, var23.nextFloat() * 0.5F + 0.5F, var11 + (float)Math.PI / 2F, var12 / 3.0F, var13, var14, 1.0D);
				return;
			}

			if(var52 || var23.nextInt(4) != 0) {
				double var33 = var4 - var17;
				double var35 = var8 - var19;
				double var37 = (double)(var14 - var13);
				double var39 = (double)(var10 + 2.0F + 16.0F);
				if(var33 * var33 + var35 * var35 - var37 * var37 > var39 * var39) {
					return;
				}

				if(var4 >= var17 - 16.0D - var27 * 2.0D && var8 >= var19 - 16.0D - var27 * 2.0D && var4 <= var17 + 16.0D + var27 * 2.0D && var8 <= var19 + 16.0D + var27 * 2.0D) {
					int var53 = ModelPig.b(var4 - var27) - var1 * 16 - 1;
					int var34 = ModelPig.b(var4 + var27) - var1 * 16 + 1;
					int var54 = ModelPig.b(var6 - var29) - 1;
					int var36 = ModelPig.b(var6 + var29) + 1;
					int var55 = ModelPig.b(var8 - var27) - var2 * 16 - 1;
					int var38 = ModelPig.b(var8 + var27) - var2 * 16 + 1;
					if(var53 < 0) {
						var53 = 0;
					}

					if(var34 > 16) {
						var34 = 16;
					}

					if(var54 < 1) {
						var54 = 1;
					}

					if(var36 > 120) {
						var36 = 120;
					}

					if(var55 < 0) {
						var55 = 0;
					}

					if(var38 > 16) {
						var38 = 16;
					}

					boolean var56 = false;

					int var40;
					int var43;
					for(var40 = var53; !var56 && var40 < var34; ++var40) {
						for(int var41 = var55; !var56 && var41 < var38; ++var41) {
							for(int var42 = var36 + 1; !var56 && var42 >= var54 - 1; --var42) {
								var43 = (var40 * 16 + var41) * 128 + var42;
								if(var42 >= 0 && var42 < 128) {
									if(var3[var43] == ln.A.ba || var3[var43] == ln.B.ba) {
										var56 = true;
									}

									if(var42 != var54 - 1 && var40 != var53 && var40 != var34 - 1 && var41 != var55 && var41 != var38 - 1) {
										var42 = var54;
									}
								}
							}
						}
					}

					if(!var56) {
						for(var40 = var53; var40 < var34; ++var40) {
							double var57 = ((double)(var40 + var1 * 16) + 0.5D - var4) / var27;

							for(var43 = var55; var43 < var38; ++var43) {
								double var44 = ((double)(var43 + var2 * 16) + 0.5D - var8) / var27;
								int var46 = (var40 * 16 + var43) * 128 + var36;
								boolean var47 = false;

								for(int var48 = var36 - 1; var48 >= var54; --var48) {
									double var49 = ((double)var48 + 0.5D - var6) / var29;
									if(var49 > -0.7D && var57 * var57 + var49 * var49 + var44 * var44 < 1.0D) {
										byte var51 = var3[var46];
										if(var51 == ln.u.ba) {
											var47 = true;
										}

										if(var51 == ln.t.ba || var51 == ln.v.ba || var51 == ln.u.ba) {
											if(var48 < 10) {
												var3[var46] = (byte)ln.C.ba;
											} else {
												var3[var46] = 0;
												if(var47 && var3[var46 - 1] == ln.v.ba) {
													var3[var46 - 1] = (byte)ln.u.ba;
												}
											}
										}
									}

									--var46;
								}
							}
						}

						if(var52) {
							break;
						}
					}
				}
			}
		}

	}

	private void c(int var1, int var2, byte[] var3) {
		byte var4 = 8;
		this.j.setSeed(this.p.r);
		long var5 = this.j.nextLong() / 2L * 2L + 1L;
		long var7 = this.j.nextLong() / 2L * 2L + 1L;

		for(int var9 = var1 - var4; var9 <= var1 + var4; ++var9) {
			for(int var10 = var2 - var4; var10 <= var2 + var4; ++var10) {
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
						float var21 = this.j.nextFloat() * (float)Math.PI * 2.0F;
						float var22 = (this.j.nextFloat() - 0.5F) * 2.0F / 8.0F;
						float var23 = this.j.nextFloat() * 2.0F + this.j.nextFloat();
						this.a(var1, var2, var3, var13, var15, var17, var23, var21, var22, 0, 0, 1.0D);
					}
				}
			}
		}

	}

	private double[] a(double[] var1, int var2, int var3, int var4, int var5, int var6, int var7) {
		if(var1 == null) {
			var1 = new double[var5 * var6 * var7];
		}

		double var8 = 684.412D;
		double var10 = 684.412D;
		this.g = this.a.a(this.g, (double)var2, (double)var3, (double)var4, var5, 1, var7, 1.0D, 0.0D, 1.0D);
		this.h = this.b.a(this.h, (double)var2, (double)var3, (double)var4, var5, 1, var7, 100.0D, 0.0D, 100.0D);
		this.d = this.m.a(this.d, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8 / 80.0D, var10 / 160.0D, var8 / 80.0D);
		this.e = this.k.a(this.e, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
		this.f = this.l.a(this.f, (double)var2, (double)var3, (double)var4, var5, var6, var7, var8, var10, var8);
		int var12 = 0;
		int var13 = 0;

		for(int var14 = 0; var14 < var5; ++var14) {
			for(int var15 = 0; var15 < var7; ++var15) {
				double var16 = (this.g[var13] + 256.0D) / 512.0D;
				if(var16 > 1.0D) {
					var16 = 1.0D;
				}

				double var18 = 0.0D;
				double var20 = this.h[var13] / 8000.0D;
				if(var20 < 0.0D) {
					var20 = -var20;
				}

				var20 = var20 * 3.0D - 3.0D;
				if(var20 < 0.0D) {
					var20 /= 2.0D;
					if(var20 < -1.0D) {
						var20 = -1.0D;
					}

					var20 /= 1.4D;
					var20 /= 2.0D;
					var16 = 0.0D;
				} else {
					if(var20 > 1.0D) {
						var20 = 1.0D;
					}

					var20 /= 6.0D;
				}

				var16 += 0.5D;
				var20 = var20 * (double)var6 / 16.0D;
				double var22 = (double)var6 / 2.0D + var20 * 4.0D;
				++var13;

				for(int var24 = 0; var24 < var6; ++var24) {
					double var25 = 0.0D;
					double var27 = ((double)var24 - var22) * 12.0D / var16;
					if(var27 < 0.0D) {
						var27 *= 4.0D;
					}

					double var29 = this.e[var12] / 512.0D;
					double var31 = this.f[var12] / 512.0D;
					double var33 = (this.d[var12] / 10.0D + 1.0D) / 2.0D;
					if(var33 < 0.0D) {
						var25 = var29;
					} else if(var33 > 1.0D) {
						var25 = var31;
					} else {
						var25 = var29 + (var31 - var29) * var33;
					}

					var25 -= var27;
					double var35;
					if(var24 > var6 - 4) {
						var35 = (double)((float)(var24 - (var6 - 4)) / 3.0F);
						var25 = var25 * (1.0D - var35) + -10.0D * var35;
					}

					if((double)var24 < var18) {
						var35 = (var18 - (double)var24) / 4.0D;
						if(var35 < 0.0D) {
							var35 = 0.0D;
						}

						if(var35 > 1.0D) {
							var35 = 1.0D;
						}

						var25 = var25 * (1.0D - var35) + -10.0D * var35;
					}

					var1[var12] = var25;
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
		int var4 = var2 * 16;
		int var5 = var3 * 16;
		this.j.setSeed(this.p.r);
		long var6 = this.j.nextLong() / 2L * 2L + 1L;
		long var8 = this.j.nextLong() / 2L * 2L + 1L;
		this.j.setSeed((long)var2 * var6 + (long)var3 * var8 ^ this.p.r);
		double var10 = 0.25D;

		int var12;
		int var13;
		int var14;
		int var15;
		for(var12 = 0; var12 < 8; ++var12) {
			var13 = var4 + this.j.nextInt(16) + 8;
			var14 = this.j.nextInt(128);
			var15 = var5 + this.j.nextInt(16) + 8;
			(new TextureLavaFX()).a(this.p, this.j, var13, var14, var15);
		}

		for(var12 = 0; var12 < 10; ++var12) {
			var13 = var4 + this.j.nextInt(16);
			var14 = this.j.nextInt(128);
			var15 = var5 + this.j.nextInt(16);
			(new Session(32)).a(this.p, this.j, var13, var14, var15);
		}

		for(var12 = 0; var12 < 20; ++var12) {
			var13 = var4 + this.j.nextInt(16);
			var14 = this.j.nextInt(128);
			var15 = var5 + this.j.nextInt(16);
			(new NBTTagByte(ln.v.ba, 32)).a(this.p, this.j, var13, var14, var15);
		}

		for(var12 = 0; var12 < 10; ++var12) {
			var13 = var4 + this.j.nextInt(16);
			var14 = this.j.nextInt(128);
			var15 = var5 + this.j.nextInt(16);
			(new NBTTagByte(ln.F.ba, 32)).a(this.p, this.j, var13, var14, var15);
		}

		for(var12 = 0; var12 < 20; ++var12) {
			var13 = var4 + this.j.nextInt(16);
			var14 = this.j.nextInt(128);
			var15 = var5 + this.j.nextInt(16);
			(new NBTTagByte(ln.I.ba, 16)).a(this.p, this.j, var13, var14, var15);
		}

		for(var12 = 0; var12 < 20; ++var12) {
			var13 = var4 + this.j.nextInt(16);
			var14 = this.j.nextInt(64);
			var15 = var5 + this.j.nextInt(16);
			(new NBTTagByte(ln.H.ba, 8)).a(this.p, this.j, var13, var14, var15);
		}

		for(var12 = 0; var12 < 2; ++var12) {
			var13 = var4 + this.j.nextInt(16);
			var14 = this.j.nextInt(32);
			var15 = var5 + this.j.nextInt(16);
			(new NBTTagByte(ln.G.ba, 8)).a(this.p, this.j, var13, var14, var15);
		}

		for(var12 = 0; var12 < 8; ++var12) {
			var13 = var4 + this.j.nextInt(16);
			var14 = this.j.nextInt(16);
			var15 = var5 + this.j.nextInt(16);
			(new NBTTagByte(ln.aN.ba, 7)).a(this.p, this.j, var13, var14, var15);
		}

		for(var12 = 0; var12 < 1; ++var12) {
			var13 = var4 + this.j.nextInt(16);
			var14 = this.j.nextInt(16);
			var15 = var5 + this.j.nextInt(16);
			(new NBTTagByte(ln.aw.ba, 7)).a(this.p, this.j, var13, var14, var15);
		}

		var10 = 0.5D;
		var12 = (int)((this.c.a((double)var4 * var10, (double)var5 * var10) / 8.0D + this.j.nextDouble() * 4.0D + 4.0D) / 3.0D);
		if(var12 < 0) {
			var12 = 0;
		}

		if(this.j.nextInt(10) == 0) {
			++var12;
		}

		Object var18 = new nm();
		if(this.j.nextInt(10) == 0) {
			var18 = new ItemSaddle();
		}

		int var16;
		for(var14 = 0; var14 < var12; ++var14) {
			var15 = var4 + this.j.nextInt(16) + 8;
			var16 = var5 + this.j.nextInt(16) + 8;
			((ItemArmor)var18).a(1.0D, 1.0D, 1.0D);
			((ItemArmor)var18).a(this.p, this.j, var15, this.p.c(var15, var16), var16);
		}

		int var17;
		for(var14 = 0; var14 < 2; ++var14) {
			var15 = var4 + this.j.nextInt(16) + 8;
			var16 = this.j.nextInt(128);
			var17 = var5 + this.j.nextInt(16) + 8;
			(new EntityGiantZombie(ln.ad.ba)).a(this.p, this.j, var15, var16, var17);
		}

		if(this.j.nextInt(2) == 0) {
			var14 = var4 + this.j.nextInt(16) + 8;
			var15 = this.j.nextInt(128);
			var16 = var5 + this.j.nextInt(16) + 8;
			(new EntityGiantZombie(ln.ae.ba)).a(this.p, this.j, var14, var15, var16);
		}

		if(this.j.nextInt(4) == 0) {
			var14 = var4 + this.j.nextInt(16) + 8;
			var15 = this.j.nextInt(128);
			var16 = var5 + this.j.nextInt(16) + 8;
			(new EntityGiantZombie(ln.af.ba)).a(this.p, this.j, var14, var15, var16);
		}

		if(this.j.nextInt(8) == 0) {
			var14 = var4 + this.j.nextInt(16) + 8;
			var15 = this.j.nextInt(128);
			var16 = var5 + this.j.nextInt(16) + 8;
			(new EntityGiantZombie(ln.ag.ba)).a(this.p, this.j, var14, var15, var16);
		}

		for(var14 = 0; var14 < 10; ++var14) {
			var15 = var4 + this.j.nextInt(16) + 8;
			var16 = this.j.nextInt(128);
			var17 = var5 + this.j.nextInt(16) + 8;
			(new FontRenderer()).a(this.p, this.j, var15, var16, var17);
		}

		for(var14 = 0; var14 < 1; ++var14) {
			var15 = var4 + this.j.nextInt(16) + 8;
			var16 = this.j.nextInt(128);
			var17 = var5 + this.j.nextInt(16) + 8;
			(new OpenGlCapsChecker()).a(this.p, this.j, var15, var16, var17);
		}

		for(var14 = 0; var14 < 50; ++var14) {
			var15 = var4 + this.j.nextInt(16) + 8;
			var16 = this.j.nextInt(this.j.nextInt(120) + 8);
			var17 = var5 + this.j.nextInt(16) + 8;
			(new na(ln.A.ba)).a(this.p, this.j, var15, var16, var17);
		}

		for(var14 = 0; var14 < 20; ++var14) {
			var15 = var4 + this.j.nextInt(16) + 8;
			var16 = this.j.nextInt(this.j.nextInt(this.j.nextInt(112) + 8) + 8);
			var17 = var5 + this.j.nextInt(16) + 8;
			(new na(ln.C.ba)).a(this.p, this.j, var15, var16, var17);
		}

		if(this.p.d) {
			for(var14 = var4 + 8 + 0; var14 < var4 + 8 + 16; ++var14) {
				for(var15 = var5 + 8 + 0; var15 < var5 + 8 + 16; ++var15) {
					var16 = this.p.d(var14, var15);
					if(var16 > 0 && var16 < 128 && this.p.a(var14, var16, var15) == 0 && this.p.f(var14, var16 - 1, var15).c() && this.p.f(var14, var16 - 1, var15) != EntitySkeleton.r) {
						this.p.d(var14, var16, var15, ln.aS.ba);
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
