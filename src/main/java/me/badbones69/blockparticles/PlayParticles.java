package me.badbones69.blockparticles;

import org.bukkit.*;
import org.bukkit.plugin.Plugin;
import org.bukkit.util.Vector;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class PlayParticles {
    // TODO: configurable
    private static final int RANGE = 25;

    public static HashMap<String, Integer> Blocks = new HashMap<>();
    private static Plugin plugin;

    public PlayParticles(Plugin plugin) {
        this.plugin = plugin;
    }

    private static Location Drop(Location loc) {
        Random r = new Random();
        Random rr = new Random();
        double x = r.nextInt(100) / 100.0 - .50;
        double z = rr.nextInt(100) / 100.0 - .50;
        return loc.add(x, 0, z);
    }

    private static float Vec() {
        return (float) -.05 + (float) (Math.random() * ((.05 - -.05)));
    }

    private static Location RanSpawn(Location loc, double X, double Y, double Z) {
        Random r = new Random();
        Random rr = new Random();
        Random rrr = new Random();
        double x = (r.nextInt(100) / 100.0 - .50) * X;
        double y = (rr.nextInt(100) / 100.0 - .50) * Y;
        double z = (rrr.nextInt(100) / 100.0 - .50) * Z;
        return loc.add(x, y, z);
    }

    public static void playVolcano(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .8, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.LAVA, l, 10, 0, 0, 0, 0);
            }
        }, 0, 4));
    }

    public static void playBigFlame(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                for (Location loc : getCircle(l, 1, 15))
                    l.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                for (Location loc : getCircle(l, 2, 25))
                    l.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
            }
        }, 0, 5));
    }

    public static void playFlame(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                for (Location loc : getCircle(l, .6, 15))
                    l.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
                for (Location loc : getCircle(l, 1, 20))
                    l.getWorld().spawnParticle(Particle.FLAME, loc, 1, 0, 0, 0, 0);
            }
        }, 0, 5));
    }

    public static void playDoubleSpiral(final Location loc, String L, Particle particle, int amount) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .7, .5);
            int time = 16;

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                if (time == 15) {
                    l.getWorld().spawnParticle(particle, l.clone().add(.8, 0, 0), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(-.8, 0, 0), amount, 0, 0, 0, 0);
                }
                if (time == 14) {
                    l.getWorld().spawnParticle(particle, l.clone().add(.75, 0, .43), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(-.75, 0, -.43), amount, 0, 0, 0, 0);
                }
                if (time == 13) {
                    l.getWorld().spawnParticle(particle, l.clone().add(.65, 0, .65), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(-.65, 0, -.65), amount, 0, 0, 0, 0);
                }
                if (time == 12) {
                    l.getWorld().spawnParticle(particle, l.clone().add(.43, 0, .75), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(-.43, 0, -.75), amount, 0, 0, 0, 0);
                }
                if (time == 11) {
                    l.getWorld().spawnParticle(particle, l.clone().add(0, 0, .8), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(0, 0, -.8), amount, 0, 0, 0, 0);
                }
                if (time == 10) {
                    l.getWorld().spawnParticle(particle, l.clone().add(-.43, 0, .75), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(.43, 0, -.75), amount, 0, 0, 0, 0);
                }
                if (time == 9) {
                    l.getWorld().spawnParticle(particle, l.clone().add(-.65, 0, .65), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(.65, 0, -.65), amount, 0, 0, 0, 0);
                }
                if (time == 8) {
                    l.getWorld().spawnParticle(particle, l.clone().add(-.75, 0, .43), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(.75, 0, -.43), amount, 0, 0, 0, 0);
                }
                if (time == 7) {
                    l.getWorld().spawnParticle(particle, l.clone().add(-.8, 0, 0), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(.8, 0, 0), amount, 0, 0, 0, 0);
                }
                if (time == 6) {
                    l.getWorld().spawnParticle(particle, l.clone().add(-.75, 0, -.43), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(.75, 0, .43), amount, 0, 0, 0, 0);
                }
                if (time == 5) {
                    l.getWorld().spawnParticle(particle, l.clone().add(-.65, 0, -.65), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(.65, 0, .65), amount, 0, 0, 0, 0);
                }
                if (time == 4) {
                    l.getWorld().spawnParticle(particle, l.clone().add(-.43, 0, -.75), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(.43, 0, .75), amount, 0, 0, 0, 0);
                }
                if (time == 3) {
                    l.getWorld().spawnParticle(particle, l.clone().add(0, 0, -.8), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(0, 0, .8), amount, 0, 0, 0, 0);
                }
                if (time == 2) {
                    l.getWorld().spawnParticle(particle, l.clone().add(.43, 0, -.75), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(-.43, 0, .75), amount, 0, 0, 0, 0);
                }
                if (time == 1) {
                    l.getWorld().spawnParticle(particle, l.clone().add(.65, 0, -.65), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(-.65, 0, .65), amount, 0, 0, 0, 0);
                }
                if (time == 0) {
                    l.getWorld().spawnParticle(particle, l.clone().add(.75, 0, -.43), amount, 0, 0, 0, 0);
                    l.getWorld().spawnParticle(particle, l.clone().add(-.75, 0, .43), amount, 0, 0, 0, 0);
                    time = 16;
                }
                time--;
            }
        }, 0, 2));
    }

    public static void playSpiral(final Location loc, String L, Particle particle, int amount) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .7, .5);
            int time = 16;

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                if (time == 15) l.getWorld().spawnParticle(particle, l.clone().add(.8, 0, 0), amount, 0, 0, 0, 0);
                if (time == 14) l.getWorld().spawnParticle(particle, l.clone().add(.75, 0, .43), amount, 0, 0, 0, 0);
                if (time == 13) l.getWorld().spawnParticle(particle, l.clone().add(.65, 0, .65), amount, 0, 0, 0, 0);
                if (time == 12) l.getWorld().spawnParticle(particle, l.clone().add(.43, 0, .75), amount, 0, 0, 0, 0);
                if (time == 11) l.getWorld().spawnParticle(particle, l.clone().add(0, 0, .8), amount, 0, 0, 0, 0);
                if (time == 10) l.getWorld().spawnParticle(particle, l.clone().add(-.43, 0, .75), amount, 0, 0, 0, 0);
                if (time == 9) l.getWorld().spawnParticle(particle, l.clone().add(-.65, 0, .65), amount, 0, 0, 0, 0);
                if (time == 8) l.getWorld().spawnParticle(particle, l.clone().add(-.75, 0, .43), amount, 0, 0, 0, 0);
                if (time == 7) l.getWorld().spawnParticle(particle, l.clone().add(-.8, 0, 0), amount, 0, 0, 0, 0);
                if (time == 6) l.getWorld().spawnParticle(particle, l.clone().add(-.75, 0, -.43), amount, 0, 0, 0, 0);
                if (time == 5) l.getWorld().spawnParticle(particle, l.clone().add(-.65, 0, -.65), amount, 0, 0, 0, 0);
                if (time == 4) l.getWorld().spawnParticle(particle, l.clone().add(-.43, 0, -.75), amount, 0, 0, 0, 0);
                if (time == 3) l.getWorld().spawnParticle(particle, l.clone().add(0, 0, -.8), amount, 0, 0, 0, 0);
                if (time == 2) l.getWorld().spawnParticle(particle, l.clone().add(.43, 0, -.75), amount, 0, 0, 0, 0);
                if (time == 1) l.getWorld().spawnParticle(particle, l.clone().add(.65, 0, -.65), amount, 0, 0, 0, 0);
                if (time == 0) {
                    l.getWorld().spawnParticle(particle, l.clone().add(.75, 0, -.43), amount, 0, 0, 0, 0);
                    time = 16;
                }
                time--;
            }
        }, 0, 2));
    }

    public static void playCrit(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1.1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.CRIT, l.clone(), 1, 0, 0, 0, 0);
            }
        }, 0, 2));
    }

    public static void playBigCrit(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                for (Location loc : getCircle(l, 2, 20))
                    l.getWorld().spawnParticle(Particle.CRIT, loc, 1, 0, 0, 0, 0);
            }
        }, 0, 2));
    }

    public static void playStorm(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 2, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.CLOUD, l.clone(), 15, .3f, 0, 0.3f, 0);
                l.getWorld().spawnParticle(Particle.WATER_DROP, l.clone().add(0, 0, .1), 10, 0.2f, 0, 0.2f, 0);
            }
        }, 0, 2));
    }

    public static void playFog(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.CLOUD, l, 20, .3f, 0, .3f, 0.05f);
            }
        }, 0, 2));
    }

    public static void playEnchant(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1.5, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.ENCHANTMENT_TABLE, l, 20, 0, 0, 0, 2);
            }
        }, 0, 2));
    }

    public static void playChains(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(1, 0, 1), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.9, .1, .9), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.8, .2, .8), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.7, .3, .7), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.6, .4, .6), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.5, .6, .5), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.4, .8, .4), 1, 0, 0, 0, 0);

                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-1, 0, 1), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.9, .1, .9), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.8, .2, .8), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.7, .3, .7), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.6, .4, .6), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.5, .6, .5), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.4, .8, .4), 1, 0, 0, 0, 0);

                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-1, 0, -1), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.9, .1, -.9), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.8, .2, -.8), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.7, .3, -.7), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.6, .4, -.6), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.5, .6, -.5), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(-.4, .8, -.4), 1, 0, 0, 0, 0);

                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(1, 0, -1), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.9, .1, -.9), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.8, .2, -.8), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.7, .3, -.7), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.6, .4, -.6), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.5, .6, -.5), 1, 0, 0, 0, 0);
                l.getWorld().spawnParticle(Particle.FLAME, l.clone().add(.4, .8, -.4), 1, 0, 0, 0, 0);
            }
        }, 0, 5));
    }

    public static void playFireStorm(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 2, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.SMOKE_LARGE, l, 15, 0.3f, 0, 0.3f);
                l.getWorld().spawnParticle(Particle.FLAME, Drop(l.clone()), 15, 0, -0.2f, 0);
                l.getWorld().spawnParticle(Particle.FLAME, Drop(l.clone()), 15, 0, -0.2f, 0);
                /*ParticleEffect.FLAME.display(new Vector(0, -.2, 0), 1, Drop(l.clone()), 100);
                ParticleEffect.FLAME.display(new Vector(0, -.2, 0), 1, Drop(l.clone()), 100);*/
            }
        }, 0, 2));
    }

    public static void playSnow(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 2, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, l, 1, .7f, .7f, .7f, 0);
            }
        }, 0, 2));
    }

    public static void playSpew(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, l, 1, Vec(), .1f, Vec(), 1);
            }
        }, 0, 2));
    }

    public static void playPotion(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .2, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.SPELL_MOB, l, 6, .3f, 0, .3f, Methods.randomColor());
                l.getWorld().spawnParticle(Particle.SPELL_MOB, l, 6, .3f, 0, .3f, Methods.randomColor());
                l.getWorld().spawnParticle(Particle.SPELL_MOB, l, 6, .3f, 0, .3f, Methods.randomColor());
            }
        }, 0, 2));
    }

    public static void playMusic(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .2, .5);
            ArrayList<Location> locs = getCircle(l, 1, 16);
            int time = 0;

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                int i = time;
                if (time == 15) {
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                    time = -1;
                }
                if (time == 14)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 13)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 12)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 11)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 10)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 9)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 8)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 7)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 6)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 5)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 4)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 3)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 2)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 1)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                if (time == 0)
                    l.getWorld().spawnParticle(Particle.NOTE, locs.get(i), 1, 0, 0, 0, Methods.randomColor());
                time++;
                i++;
            }
        }, 0, 2));
    }

    public static void playMagic(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);
            int time = 16;

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                if (time == 15) l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, .8, 0), 5, 0, 0, 0, 0);
                if (time == 0)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, .75, .43), 5, 0, 0, 0, 0);
                if (time == 1)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, .65, .65), 5, 0, 0, 0, 0);
                if (time == 2)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, .43, .75), 5, 0, 0, 0, 0);
                if (time == 3) l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, 0, .8), 5, 0, 0, 0, 0);
                if (time == 4)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, -.43, .75), 5, 0, 0, 0, 0);
                if (time == 5)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, -.65, .65), 5, 0, 0, 0, 0);
                if (time == 86)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, -.75, .43), 5, 0, 0, 0, 0);
                if (time == 7) l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, -.8, 0), 5, 0, 0, 0, 0);
                if (time == 8)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, -.75, -.43), 5, 0, 0, 0, 0);
                if (time == 9)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, -.65, -.65), 5, 0, 0, 0, 0);
                if (time == 10)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, -.43, -.75), 5, 0, 0, 0, 0);
                if (time == 11)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, 0, -.8), 5, 0, 0, 0, 0);
                if (time == 12)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, .43, -.75), 5, 0, 0, 0, 0);
                if (time == 13)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, .65, -.65), 5, 0, 0, 0, 0);
                if (time == 14)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, .75, -.43), 5, 0, 0, 0, 0);

                if (time == 15) l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(.8, 0, 0), 5, 0, 0, 0, 0);
                if (time == 14)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(.75, 0, .43), 5, 0, 0, 0, 0);
                if (time == 13)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(.65, 0, .65), 5, 0, 0, 0, 0);
                if (time == 12)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(.43, 0, .75), 5, 0, 0, 0, 0);
                if (time == 11) l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, 0, .8), 5, 0, 0, 0, 0);
                if (time == 10)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(-.43, 0, .75), 5, 0, 0, 0, 0);
                if (time == 9)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(-.65, 0, .65), 5, 0, 0, 0, 0);
                if (time == 8)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(-.75, 0, .43), 5, 0, 0, 0, 0);
                if (time == 7) l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(-.8, 0, 0), 5, 0, 0, 0, 0);
                if (time == 6)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(-.75, 0, -.43), 5, 0, 0, 0, 0);
                if (time == 5)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(-.65, 0, -.65), 5, 0, 0, 0, 0);
                if (time == 4)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(-.43, 0, -.75), 5, 0, 0, 0, 0);
                if (time == 3) l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(0, 0, -.8), 5, 0, 0, 0, 0);
                if (time == 2)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(.43, 0, -.75), 5, 0, 0, 0, 0);
                if (time == 1)
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(.65, 0, -.65), 5, 0, 0, 0, 0);
                if (time == 0) {
                    l.getWorld().spawnParticle(Particle.CRIT_MAGIC, l.clone().add(.75, 0, -.43), 5, 0, 0, 0, 0);
                    time = 16;
                }
                time--;
            }
        }, 0, 2));
    }

    public static void playSnowStorm(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 2, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.CLOUD, l, 15, .3f, 0, .3f, 0);
                l.getWorld().spawnParticle(Particle.FIREWORKS_SPARK, l, 2, .3f, 0, .3f, 0);
            }
        }, 0, 2));
    }

    public static void playFireSpew(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.FLAME, l, 1, Vec(), .1f, Vec(), 1.5f);
                l.getWorld().spawnParticle(Particle.FLAME, l, 1, Vec(), .1f, Vec(), 1.5f);
                l.getWorld().spawnParticle(Particle.FLAME, l, 1, Vec(), .1f, Vec(), 1.5f);
            }
        }, 0, 2));
    }

    public static void playFootPrint(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.TOWN_AURA, l, 3, 1, 0, 1, 0);
            }
        }, 0, 20));
    }

    public static void playHappyVillager(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                loc.getWorld().spawnParticle(Particle.VILLAGER_HAPPY, l, 10, .5f, .5f, .5f, 0);
            }
        }, 0, 5));
    }

    public static void playAngryVillager(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.VILLAGER_ANGRY, l, 5, .5f, .5f, .5f, 0);
            }
        }, 0, 10));
    }

    public static void playMobSpawner(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.FLAME, l, 15, .5f, .5f, .5f, 0);
            }
        }, 0, 8));
    }

    public static void startWater(final Location loc, String L) {
        PlayParticles.Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .8, .6);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                loc.getWorld().spawnParticle(Particle.WATER_DROP, l.clone().add(0, .1, 0), 10, 0, 0, 0, 0);
                loc.getWorld().spawnParticle(Particle.WATER_DROP, l.clone().add(0, .5, 0), 10, 0, 0, 0, 0);
                loc.getWorld().spawnParticle(Particle.WATER_DROP, l.clone().add(.2, .3, .2), 10, 0, 0, 0, 0);
                loc.getWorld().spawnParticle(Particle.WATER_DROP, l.clone().add(-.2, .3, .2), 10, 0, 0, 0, 0);
                loc.getWorld().spawnParticle(Particle.WATER_DROP, l.clone().add(.2, .3, -.2), 10, 0, 0, 0, 0);
                loc.getWorld().spawnParticle(Particle.WATER_DROP, l.clone().add(-.2, .3, -.2), 10, 0, 0, 0, 0);
            }
        }, 0, 2));
    }

    public static void playEnderSignal(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 0, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
                loc.getWorld().playEffect(l, Effect.ENDER_SIGNAL, 1);
            }
        }, 0, 8));
    }

    public static void playRainbow(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                Random rand = new Random();
                int r = rand.nextInt(255);
                int g = rand.nextInt(255);
                int b = rand.nextInt(255);
                Particle.DustOptions dustOptions = new Particle.DustOptions(Color.fromRGB(r, g, b), 1);
                l.getWorld().spawnParticle(Particle.REDSTONE, l, 10, .5f, .5f, .5f, 1, dustOptions);
            }
        }, 0, 5));
    }

    public static void playSnowBlast(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, .5, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                l.getWorld().spawnParticle(Particle.SNOW_SHOVEL, l, 40, 0, 0, 0, .2f);
            }
        }, 0, 2));
    }

    public static void playHalo(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.add(.5, 1.3, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                try {
                    for (int i = 0; i < 3; i++) {
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(.5, 0, 0), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(.45, 0, .13), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(.35, 0, .35), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(.13, 0, .45), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(0, 0, .5), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(-.13, 0, .45), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(-.35, 0, .35), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(-.45, 0, .13), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(-.5, 0, 0), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(-.45, 0, -.13), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(-.35, 0, -.35), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(-.13, 0, -.45), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(0, 0, -.5), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(.13, 0, -.45), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(.35, 0, -.35), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                        l.getWorld().spawnParticle(Particle.REDSTONE, l.clone().add(.45, 0, -.13), 1, 0, 0, 0, 1, new Particle.DustOptions(Color.fromRGB(255, 255, 0), 1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5));
    }

    private static ArrayList<Location> getCircle(Location center, double radius, int amount) {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            double angle = i * increment;
            double x = center.getX() + (radius * Math.cos(angle));
            double z = center.getZ() + (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
        }
        return locations;
    }

    private static ArrayList<Location> getCircleReverse(Location center, double radius, int amount) {
        World world = center.getWorld();
        double increment = (2 * Math.PI) / amount;
        ArrayList<Location> locations = new ArrayList<>();
        for (int i = 0; i < amount; i++) {
            double angle = i * increment;
            double x = center.getX() - (radius * Math.cos(angle));
            double z = center.getZ() - (radius * Math.sin(angle));
            locations.add(new Location(world, x, center.getY(), z));
        }
        return locations;
    }

    public static void playSantaHat(final Location loc, String L) {
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l1 = loc.clone().add(.5, 1, .5);
            Location l2 = l1.clone().add(0, .05, 0);
            Location l3 = l2.clone().add(0, .05, 0);
            Location l4 = l3.clone().add(0, .05, 0);
            Location l5 = l4.clone().add(0, .05, 0);
            Location l6 = l5.clone().add(0, .05, 0);
            Location l7 = l6.clone().add(0, .05, 0);
            Location l8 = l7.clone().add(0, .05, 0);
            Location l9 = l8.clone().add(0, .05, 0);
            Location l10 = l9.clone().add(0, .1, 0);
            Location l11 = l10.clone().add(0, .05, 0);

            @Override
            public void run() {
                if (Methods.noPlayers(l1.clone(), 20)) return;
                try {
                    for (int i = 0; i < 3; i++) {
                        Color red = Color.RED;
                        Color white = Color.fromRGB(255, 255, 255);
                        for (Location loc : getCircle(l1, .5, 20))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(white, 1));
                        for (Location loc : getCircle(l2, .4, 15))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(red, 1));
                        for (Location loc : getCircle(l3, .35, 15))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(red, 1));
                        for (Location loc : getCircle(l4, .3, 15))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(red, 1));
                        for (Location loc : getCircle(l5, .2, 15))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(red, 1));
                        for (Location loc : getCircle(l6, .15, 15))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(red, 1));
                        for (Location loc : getCircle(l7, .1, 15))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(red, 1));
                        for (Location loc : getCircle(l8, .05, 10))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(red, 1));
                        for (Location loc : getCircle(l9, .05, 10))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(red, 1));
                        for (Location loc : getCircle(l10, .05, 15))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(white, 1));
                        for (Location loc : getCircle(l11, .05, 15))
                            loc.getWorld().spawnParticle(Particle.REDSTONE, loc, 1, 0, 0, 0, 0, new Particle.DustOptions(white, 1));
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, 0, 5));
    }

    public static void playSoulWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startSoulWell(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 2, 50);
                        ArrayList<Location> locs2 = getCircleReverse(l, 2, 50);
                        l.getWorld().spawnParticle(Particle.SPELL_WITCH, locs.get(i), 1, 0, 0, 0, 0);
                        l.getWorld().spawnParticle(Particle.SPELL_WITCH, locs2.get(i), 1, 0, 0, 0, 0);
                        i++;
                        f++;
                        l.add(0, .035, 0);
                        if (i == 50) i = 0;
                        if (f == 75) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                startSoulWell(l, L);
            }
        }, 0, 16));
    }

    public static void playBigSoulWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startBigSoulWell(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 3.5, 75);
                        ArrayList<Location> locs2 = getCircleReverse(l, 3.5, 75);
                        l.getWorld().spawnParticle(Particle.SPELL_WITCH, locs.get(i), 1, 0, 0, 0, 0);
                        l.getWorld().spawnParticle(Particle.SPELL_WITCH, locs2.get(i), 1, 0, 0, 0, 0);
                        i++;
                        f++;
                        l.add(0, .04, 0);
                        if (i == 75) i = 0;
                        if (f == 105) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                startBigSoulWell(l, L);
            }
        }, 0, 25));
    }

    public static HashMap<String, Integer> R = new HashMap<>();

    public static void playFlameWheel(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, .1, .5);
            Random r = new Random();

            void startFlameWheel(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int o = 74;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 3.5, 75);
                        ArrayList<Location> locs2 = getCircleReverse(l, 3.5, 75);
                        float speed = (float) .1;
                        Vector v = locs.get(i).toVector().subtract(l.toVector()).normalize();
                        Vector v2 = locs2.get(i).toVector().subtract(l.toVector()).normalize();
                        Vector v3 = locs.get(o).toVector().subtract(l.toVector()).normalize();
                        Vector v4 = locs2.get(o).toVector().subtract(l.toVector()).normalize();

                        l.getWorld().spawnParticle(Particle.FLAME, locs.get(i), 1, 0, 0, 0, speed);
                        l.getWorld().spawnParticle(Particle.FLAME, locs2.get(i), 1, 0, 0, 0, speed);
                        l.getWorld().spawnParticle(Particle.FLAME, locs.get(o), 1, 0, 0, 0, speed);
                        l.getWorld().spawnParticle(Particle.FLAME, locs2.get(o), 1, 0, 0, 0, speed);
                        /*ParticleEffect.FLAME.display(v.multiply(-2), speed, locs.get(i), 100);
                        ParticleEffect.FLAME.display(v2.multiply(-2), speed, locs2.get(i), 100);
                        ParticleEffect.FLAME.display(v3.multiply(-2), speed, locs.get(o), 100);
                        ParticleEffect.FLAME.display(v4.multiply(-2), speed, locs2.get(o), 100);*/
                        i++;
                        f++;
                        o--;
                        if (i == 75) i = 0;
                        if (o == 0) o = 74;
                        if (f == 105) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                startFlameWheel(l.clone(), L);
            }
        }, 0, 25));
        R.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, .1, .5);

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                ArrayList<Location> locs = getCircle(l, 3.5, 75);
                for (Location i : locs) {
                    //ParticleEffect.FLAME.display(0, 0, 0, 0, 1, i, 100);
                }
            }
        }, 0, 10));

    }

    public static void playWitchTornado(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startWitchTornado(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone().add(0, 5, 0);
                    int i = 0;
                    int e = 0;
                    double r = 1.5;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, r, 50);
                        l.getWorld().spawnParticle(Particle.SPELL_WITCH, locs.get(1), 1, 0, 0, 0, 1);
                        i++;
                        e++;
                        f++;
                        if (i == 50) i = 0;
                        l.add(0, -.02, 0); //Controls how far each particle goes Down.
                        if (e == 7) { //Controls when diameter Changes.
                            e = 0;
                            r = r - .05; //Controls how far it goes in.
                        }
                        if (f == 207) { //Controls how far the particle effect go down.
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                startWitchTornado(l, L);
            }
        }, 0, 30));
    }

    public static void playLoveTornado(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startLoveTornado(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone().add(0, 5, 0);
                    int i = 0;
                    int e = 0;
                    double r = 1.5;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, r, 50);
                        l.getWorld().spawnParticle(Particle.HEART, locs.get(1), 1, 0, 0, 0, 1);
                        i++;
                        e++;
                        f++;
                        if (i == 50) i = 0;
                        l.add(0, -.02, 0); //Controls how far each particle goes Down.
                        if (e == 7) { //Controls when diameter Changes.
                            e = 0;
                            r = r - .05; //Controls how far it goes in.
                        }
                        if (f == 207) { //Controls how far the particle effect go down.
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                startLoveTornado(l, L);
            }
        }, 0, 30));
    }

    public static void playBigLoveWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startBigLoveWell(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 3.5, 75);
                        ArrayList<Location> locs2 = getCircleReverse(l, 3.5, 75);
                        l.getWorld().spawnParticle(Particle.HEART, locs.get(1), 1, 0, 0, 0, 0);
                        l.getWorld().spawnParticle(Particle.HEART, locs2.get(1), 1, 0, 0, 0, 0);
                        i++;
                        f++;
                        l.add(0, .04, 0);
                        if (i == 75) i = 0;
                        if (f == 105) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                startBigLoveWell(l, L);
            }
        }, 0, 25));
    }

    public static void playLoveWell(final Location loc, final String L) {
        final HashMap<Integer, Integer> S = new HashMap<>();
        Blocks.put(L, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
            Location l = loc.clone().add(.5, 0, .5);
            Random r = new Random();

            void startLoveWell(final Location loc, final String L) {
                final int num = r.nextInt(999999999);
                S.put(num, Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(plugin, new Runnable() {
                    Location l = loc.clone();
                    int i = 0;
                    int f = 0;

                    @Override
                    public void run() {
                        ArrayList<Location> locs = getCircle(l, 2, 50);
                        ArrayList<Location> locs2 = getCircleReverse(l, 2, 50);
                        l.getWorld().spawnParticle(Particle.HEART, locs.get(1), 1, 0, 0, 0, 0);
                        l.getWorld().spawnParticle(Particle.HEART, locs2.get(1), 1, 0, 0, 0, 0);
                        i++;
                        f++;
                        l.add(0, .035, 0);
                        if (i == 50) i = 0;
                        if (f == 75) {
                            Bukkit.getScheduler().cancelTask(S.get(num));
                            S.remove(num);
                        }
                    }
                }, 0, 1));
            }

            @Override
            public void run() {
                if (Methods.noPlayers(l.clone(), RANGE)) return;
                startLoveWell(l, L);
            }
        }, 0, 16));
    }
}