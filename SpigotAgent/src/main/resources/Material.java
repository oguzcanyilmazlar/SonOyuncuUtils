package org.bukkit;

import com.google.common.collect.Maps;
import java.lang.reflect.Constructor;
import java.util.Map;
import org.apache.commons.lang.Validate;
import org.bukkit.material.Banner;
import org.bukkit.material.Bed;
import org.bukkit.material.Button;
import org.bukkit.material.Cake;
import org.bukkit.material.Cauldron;
import org.bukkit.material.Chest;
import org.bukkit.material.Coal;
import org.bukkit.material.CocoaPlant;
import org.bukkit.material.Command;
import org.bukkit.material.Crops;
import org.bukkit.material.DetectorRail;
import org.bukkit.material.Diode;
import org.bukkit.material.Dispenser;
import org.bukkit.material.Door;
import org.bukkit.material.Dye;
import org.bukkit.material.EnderChest;
import org.bukkit.material.FlowerPot;
import org.bukkit.material.Furnace;
import org.bukkit.material.Gate;
import org.bukkit.material.Ladder;
import org.bukkit.material.Lever;
import org.bukkit.material.LongGrass;
import org.bukkit.material.MaterialData;
import org.bukkit.material.MonsterEggs;
import org.bukkit.material.Mushroom;
import org.bukkit.material.NetherWarts;
import org.bukkit.material.PistonBaseMaterial;
import org.bukkit.material.PistonExtensionMaterial;
import org.bukkit.material.PoweredRail;
import org.bukkit.material.PressurePlate;
import org.bukkit.material.Pumpkin;
import org.bukkit.material.Rails;
import org.bukkit.material.RedstoneTorch;
import org.bukkit.material.RedstoneWire;
import org.bukkit.material.Sandstone;
import org.bukkit.material.Sign;
import org.bukkit.material.Skull;
import org.bukkit.material.SmoothBrick;
import org.bukkit.material.SpawnEgg;
import org.bukkit.material.Stairs;
import org.bukkit.material.Step;
import org.bukkit.material.Torch;
import org.bukkit.material.TrapDoor;
import org.bukkit.material.Tree;
import org.bukkit.material.Tripwire;
import org.bukkit.material.TripwireHook;
import org.bukkit.material.Vine;
import org.bukkit.material.WoodenStep;
import org.bukkit.material.Wool;
import org.bukkit.util.Java15Compat;

public enum Material {
    AIR(0, 0),
    STONE(1),
    GRASS(2),
    DIRT(3),
    COBBLESTONE(4),
    WOOD(5, Tree.class),
    SAPLING(6, Tree.class),
    BEDROCK(7),
    WATER(8, MaterialData.class),
    STATIONARY_WATER(9, MaterialData.class),
    LAVA(10, MaterialData.class),
    STATIONARY_LAVA(11, MaterialData.class),
    SAND(12),
    GRAVEL(13),
    GOLD_ORE(14),
    IRON_ORE(15),
    COAL_ORE(16),
    LOG(17, Tree.class),
    LEAVES(18, Tree.class),
    SPONGE(19),
    GLASS(20),
    LAPIS_ORE(21),
    LAPIS_BLOCK(22),
    DISPENSER(23, Dispenser.class),
    SANDSTONE(24, Sandstone.class),
    NOTE_BLOCK(25),
    BED_BLOCK(26, Bed.class),
    POWERED_RAIL(27, PoweredRail.class),
    DETECTOR_RAIL(28, DetectorRail.class),
    PISTON_STICKY_BASE(29, PistonBaseMaterial.class),
    WEB(30),
    LONG_GRASS(31, LongGrass.class),
    DEAD_BUSH(32),
    PISTON_BASE(33, PistonBaseMaterial.class),
    PISTON_EXTENSION(34, PistonExtensionMaterial.class),
    WOOL(35, Wool.class),
    PISTON_MOVING_PIECE(36),
    YELLOW_FLOWER(37),
    RED_ROSE(38),
    BROWN_MUSHROOM(39),
    RED_MUSHROOM(40),
    GOLD_BLOCK(41),
    IRON_BLOCK(42),
    DOUBLE_STEP(43, Step.class),
    STEP(44, Step.class),
    BRICK(45),
    TNT(46),
    BOOKSHELF(47),
    MOSSY_COBBLESTONE(48),
    OBSIDIAN(49),
    TORCH(50, Torch.class),
    FIRE(51),
    MOB_SPAWNER(52),
    WOOD_STAIRS(53, Stairs.class),
    CHEST(54, Chest.class),
    REDSTONE_WIRE(55, RedstoneWire.class),
    DIAMOND_ORE(56),
    DIAMOND_BLOCK(57),
    WORKBENCH(58),
    CROPS(59, Crops.class),
    SOIL(60, MaterialData.class),
    FURNACE(61, Furnace.class),
    BURNING_FURNACE(62, Furnace.class),
    SIGN_POST(63, 64, Sign.class),
    WOODEN_DOOR(64, Door.class),
    LADDER(65, Ladder.class),
    RAILS(66, Rails.class),
    COBBLESTONE_STAIRS(67, Stairs.class),
    WALL_SIGN(68, 64, Sign.class),
    LEVER(69, Lever.class),
    STONE_PLATE(70, PressurePlate.class),
    IRON_DOOR_BLOCK(71, Door.class),
    WOOD_PLATE(72, PressurePlate.class),
    REDSTONE_ORE(73),
    GLOWING_REDSTONE_ORE(74),
    REDSTONE_TORCH_OFF(75, RedstoneTorch.class),
    REDSTONE_TORCH_ON(76, RedstoneTorch.class),
    STONE_BUTTON(77, Button.class),
    SNOW(78),
    ICE(79),
    SNOW_BLOCK(80),
    CACTUS(81, MaterialData.class),
    CLAY(82),
    SUGAR_CANE_BLOCK(83, MaterialData.class),
    JUKEBOX(84),
    FENCE(85),
    PUMPKIN(86, Pumpkin.class),
    NETHERRACK(87),
    SOUL_SAND(88),
    GLOWSTONE(89),
    PORTAL(90),
    JACK_O_LANTERN(91, Pumpkin.class),
    CAKE_BLOCK(92, 64, Cake.class),
    DIODE_BLOCK_OFF(93, Diode.class),
    DIODE_BLOCK_ON(94, Diode.class),
    STAINED_GLASS(95),
    TRAP_DOOR(96, TrapDoor.class),
    MONSTER_EGGS(97, MonsterEggs.class),
    SMOOTH_BRICK(98, SmoothBrick.class),
    HUGE_MUSHROOM_1(99, Mushroom.class),
    HUGE_MUSHROOM_2(100, Mushroom.class),
    IRON_FENCE(101),
    THIN_GLASS(102),
    MELON_BLOCK(103),
    PUMPKIN_STEM(104, MaterialData.class),
    MELON_STEM(105, MaterialData.class),
    VINE(106, Vine.class),
    FENCE_GATE(107, Gate.class),
    BRICK_STAIRS(108, Stairs.class),
    SMOOTH_STAIRS(109, Stairs.class),
    MYCEL(110),
    WATER_LILY(111),
    NETHER_BRICK(112),
    NETHER_FENCE(113),
    NETHER_BRICK_STAIRS(114, Stairs.class),
    NETHER_WARTS(115, NetherWarts.class),
    ENCHANTMENT_TABLE(116),
    BREWING_STAND(117, MaterialData.class),
    CAULDRON(118, Cauldron.class),
    ENDER_PORTAL(119),
    ENDER_PORTAL_FRAME(120),
    ENDER_STONE(121),
    DRAGON_EGG(122),
    REDSTONE_LAMP_OFF(123),
    REDSTONE_LAMP_ON(124),
    WOOD_DOUBLE_STEP(125, WoodenStep.class),
    WOOD_STEP(126, WoodenStep.class),
    COCOA(127, CocoaPlant.class),
    SANDSTONE_STAIRS(128, Stairs.class),
    EMERALD_ORE(129),
    ENDER_CHEST(130, EnderChest.class),
    TRIPWIRE_HOOK(131, TripwireHook.class),
    TRIPWIRE(132, Tripwire.class),
    EMERALD_BLOCK(133),
    SPRUCE_WOOD_STAIRS(134, Stairs.class),
    BIRCH_WOOD_STAIRS(135, Stairs.class),
    JUNGLE_WOOD_STAIRS(136, Stairs.class),
    COMMAND(137, Command.class),
    BEACON(138),
    COBBLE_WALL(139),
    FLOWER_POT(140, FlowerPot.class),
    CARROT(141),
    POTATO(142),
    WOOD_BUTTON(143, Button.class),
    SKULL(144, Skull.class),
    ANVIL(145),
    TRAPPED_CHEST(146, Chest.class),
    GOLD_PLATE(147),
    IRON_PLATE(148),
    REDSTONE_COMPARATOR_OFF(149),
    REDSTONE_COMPARATOR_ON(150),
    DAYLIGHT_DETECTOR(151),
    REDSTONE_BLOCK(152),
    QUARTZ_ORE(153),
    HOPPER(154),
    QUARTZ_BLOCK(155),
    QUARTZ_STAIRS(156, Stairs.class),
    ACTIVATOR_RAIL(157, PoweredRail.class),
    DROPPER(158, Dispenser.class),
    STAINED_CLAY(159),
    STAINED_GLASS_PANE(160),
    LEAVES_2(161),
    LOG_2(162),
    ACACIA_STAIRS(163, Stairs.class),
    DARK_OAK_STAIRS(164, Stairs.class),
    SLIME_BLOCK(165),
    BARRIER(166),
    IRON_TRAPDOOR(167, TrapDoor.class),
    PRISMARINE(168),
    SEA_LANTERN(169),
    HAY_BLOCK(170),
    CARPET(171),
    HARD_CLAY(172),
    COAL_BLOCK(173),
    PACKED_ICE(174),
    DOUBLE_PLANT(175),
    STANDING_BANNER(176, Banner.class),
    WALL_BANNER(177, Banner.class),
    DAYLIGHT_DETECTOR_INVERTED(178),
    RED_SANDSTONE(179),
    RED_SANDSTONE_STAIRS(180, Stairs.class),
    DOUBLE_STONE_SLAB2(181),
    STONE_SLAB2(182),
    SPRUCE_FENCE_GATE(183, Gate.class),
    BIRCH_FENCE_GATE(184, Gate.class),
    JUNGLE_FENCE_GATE(185, Gate.class),
    DARK_OAK_FENCE_GATE(186, Gate.class),
    ACACIA_FENCE_GATE(187, Gate.class),
    SPRUCE_FENCE(188),
    BIRCH_FENCE(189),
    JUNGLE_FENCE(190),
    DARK_OAK_FENCE(191),
    ACACIA_FENCE(192),
    SPRUCE_DOOR(193, Door.class),
    BIRCH_DOOR(194, Door.class),
    JUNGLE_DOOR(195, Door.class),
    ACACIA_DOOR(196, Door.class),
    DARK_OAK_DOOR(197, Door.class),
    IRON_SPADE(256, 1, 250),
    IRON_PICKAXE(257, 1, 250),
    IRON_AXE(258, 1, 250),
    FLINT_AND_STEEL(259, 1, 64),
    APPLE(260),
    BOW(261, 1, 384),
    ARROW(262),
    COAL(263, Coal.class),
    DIAMOND(264),
    IRON_INGOT(265),
    GOLD_INGOT(266),
    IRON_SWORD(267, 1, 250),
    WOOD_SWORD(268, 1, 59),
    WOOD_SPADE(269, 1, 59),
    WOOD_PICKAXE(270, 1, 59),
    WOOD_AXE(271, 1, 59),
    STONE_SWORD(272, 1, 131),
    STONE_SPADE(273, 1, 131),
    STONE_PICKAXE(274, 1, 131),
    STONE_AXE(275, 1, 131),
    DIAMOND_SWORD(276, 1, 1561),
    DIAMOND_SPADE(277, 1, 1561),
    DIAMOND_PICKAXE(278, 1, 1561),
    DIAMOND_AXE(279, 1, 1561),
    STICK(280),
    BOWL(281),
    MUSHROOM_SOUP(282, 1),
    GOLD_SWORD(283, 1, 32),
    GOLD_SPADE(284, 1, 32),
    GOLD_PICKAXE(285, 1, 32),
    GOLD_AXE(286, 1, 32),
    STRING(287),
    FEATHER(288),
    SULPHUR(289),
    WOOD_HOE(290, 1, 59),
    STONE_HOE(291, 1, 131),
    IRON_HOE(292, 1, 250),
    DIAMOND_HOE(293, 1, 1561),
    GOLD_HOE(294, 1, 32),
    SEEDS(295),
    WHEAT(296),
    BREAD(297),
    LEATHER_HELMET(298, 1, 55),
    LEATHER_CHESTPLATE(299, 1, 80),
    LEATHER_LEGGINGS(300, 1, 75),
    LEATHER_BOOTS(301, 1, 65),
    CHAINMAIL_HELMET(302, 1, 165),
    CHAINMAIL_CHESTPLATE(303, 1, 240),
    CHAINMAIL_LEGGINGS(304, 1, 225),
    CHAINMAIL_BOOTS(305, 1, 195),
    IRON_HELMET(306, 1, 165),
    IRON_CHESTPLATE(307, 1, 240),
    IRON_LEGGINGS(308, 1, 225),
    IRON_BOOTS(309, 1, 195),
    DIAMOND_HELMET(310, 1, 363),
    DIAMOND_CHESTPLATE(311, 1, 528),
    DIAMOND_LEGGINGS(312, 1, 495),
    DIAMOND_BOOTS(313, 1, 429),
    GOLD_HELMET(314, 1, 77),
    GOLD_CHESTPLATE(315, 1, 112),
    GOLD_LEGGINGS(316, 1, 105),
    GOLD_BOOTS(317, 1, 91),
    FLINT(318),
    PORK(319),
    GRILLED_PORK(320),
    PAINTING(321),
    GOLDEN_APPLE(322),
    SIGN(323, 16),
    WOOD_DOOR(324, 64),
    BUCKET(325, 16),
    WATER_BUCKET(326, 1),
    LAVA_BUCKET(327, 1),
    MINECART(328, 1),
    SADDLE(329, 1),
    IRON_DOOR(330, 64),
    REDSTONE(331),
    SNOW_BALL(332, 16),
    BOAT(333, 1),
    LEATHER(334),
    MILK_BUCKET(335, 1),
    CLAY_BRICK(336),
    CLAY_BALL(337),
    SUGAR_CANE(338),
    PAPER(339),
    BOOK(340),
    SLIME_BALL(341),
    STORAGE_MINECART(342, 1),
    POWERED_MINECART(343, 1),
    EGG(344, 16),
    COMPASS(345),
    FISHING_ROD(346, 1, 64),
    WATCH(347),
    GLOWSTONE_DUST(348),
    RAW_FISH(349),
    COOKED_FISH(350),
    INK_SACK(351, Dye.class),
    BONE(352),
    SUGAR(353),
    CAKE(354, 1),
    BED(355, 1),
    DIODE(356),
    COOKIE(357),
    MAP(358, MaterialData.class),
    SHEARS(359, 1, 238),
    MELON(360),
    PUMPKIN_SEEDS(361),
    MELON_SEEDS(362),
    RAW_BEEF(363),
    COOKED_BEEF(364),
    RAW_CHICKEN(365),
    COOKED_CHICKEN(366),
    ROTTEN_FLESH(367),
    ENDER_PEARL(368, 16),
    BLAZE_ROD(369),
    GHAST_TEAR(370),
    GOLD_NUGGET(371),
    NETHER_STALK(372),
    POTION(373, 1, MaterialData.class),
    GLASS_BOTTLE(374),
    SPIDER_EYE(375),
    FERMENTED_SPIDER_EYE(376),
    BLAZE_POWDER(377),
    MAGMA_CREAM(378),
    BREWING_STAND_ITEM(379),
    CAULDRON_ITEM(380),
    EYE_OF_ENDER(381),
    SPECKLED_MELON(382),
    MONSTER_EGG(383, 64, SpawnEgg.class),
    EXP_BOTTLE(384, 64),
    FIREBALL(385, 64),
    BOOK_AND_QUILL(386, 1),
    WRITTEN_BOOK(387, 16),
    EMERALD(388, 64),
    ITEM_FRAME(389),
    FLOWER_POT_ITEM(390),
    CARROT_ITEM(391),
    POTATO_ITEM(392),
    BAKED_POTATO(393),
    POISONOUS_POTATO(394),
    EMPTY_MAP(395),
    GOLDEN_CARROT(396),
    SKULL_ITEM(397),
    CARROT_STICK(398, 1, 25),
    NETHER_STAR(399),
    PUMPKIN_PIE(400),
    FIREWORK(401),
    FIREWORK_CHARGE(402),
    ENCHANTED_BOOK(403, 1),
    REDSTONE_COMPARATOR(404),
    NETHER_BRICK_ITEM(405),
    QUARTZ(406),
    EXPLOSIVE_MINECART(407, 1),
    HOPPER_MINECART(408, 1),
    PRISMARINE_SHARD(409),
    PRISMARINE_CRYSTALS(410),
    RABBIT(411),
    COOKED_RABBIT(412),
    RABBIT_STEW(413, 1),
    RABBIT_FOOT(414),
    RABBIT_HIDE(415),
    ARMOR_STAND(416, 16),
    IRON_BARDING(417, 1),
    GOLD_BARDING(418, 1),
    DIAMOND_BARDING(419, 1),
    LEASH(420),
    NAME_TAG(421),
    COMMAND_MINECART(422, 1),
    MUTTON(423),
    COOKED_MUTTON(424),
    BANNER(425, 16),
    SPRUCE_DOOR_ITEM(427),
    BIRCH_DOOR_ITEM(428),
    JUNGLE_DOOR_ITEM(429),
    ACACIA_DOOR_ITEM(430),
    DARK_OAK_DOOR_ITEM(431),
    GOLD_RECORD(2256, 1),
    GREEN_RECORD(2257, 1),
    RECORD_3(2258, 1),
    RECORD_4(2259, 1),
    RECORD_5(2260, 1),
    RECORD_6(2261, 1),
    RECORD_7(2262, 1),
    RECORD_8(2263, 1),
    RECORD_9(2264, 1),
    RECORD_10(2265, 1),
    RECORD_11(2266, 1),
    RECORD_12(2267, 1),
    SWORD_ZEHIRLIKESKINLIK(810, 1),
    SWORD_KANKILICI(811, 1),
    SWORD_BUZPERISI(812, 1),
    SWORD_MAVIGOKYUZUKILICI(813, 1),
    GUN_T_KNIFE(883, 1),
    TITANIUM_WARAXE(806, 1),
    TITANIUM_HELMET(790, 1),
    TITANIUM_CHESTPLATE(791, 1),
    TITANIUM_LEGGINGS(792, 1),
    TITANIUM_BOOTS(793, 1),
    TITANIUM_SHOVEL(802, 1),
    TITANIUM_PICKAXE(803, 1),
    TITANIUM_AXE(804, 1),
    TITANIUM_HOE(805, 1),
    REPAIRKIT(851, 1),
    HAMMER(853, 1),
    LOCK_IRON(855, 1),
    KEY_GOLDEN(856, 1),
    TV(600, 1),
    DIGITAL_CLOCK(601, 1),
    MODERN_TV(610, 1),
    FRIDGE(611, 1),
    TV_STAND(613, 1),
    RANGE_HOOD(614, 1),
    OVEN(615, 1),
    WASHING_MACHINE(616, 1),
    STEREO(617, 1),
    PRINTER(618, 1),
    STONE_PATH(619, 1),
    GRILL(620, 1),
    BIRD_BATH(621, 1),
    PODIUM(535, 1),
    BIN(622, 1),
    TOASTER(623, 1),
    WALL_CABINET(624, 1),
    BEDSIDE_CABINET_OAK(625, 1),
    BEDSIDE_CABINET_SPRUCE(626, 1),
    BEDSIDE_CABINET_ACACIA(629, 1),
    VENT(630, 1),
    WORKTABLE(631, 1),
    SECURITY_CAMERA(632, 1),
    TELESCOPE(633, 1);

    private final int id;
    private final Constructor<? extends MaterialData> ctor;
    private static Material[] byId = new Material[383];
    private static final Map<String, Material> BY_NAME = Maps.newHashMap();
    private final int maxStack;
    private final short durability;

    private Material(int id) {
        this(id, 64);
    }

    private Material(int id, int stack) {
        this(id, stack, MaterialData.class);
    }

    private Material(int id, int stack, int durability) {
        this(id, stack, durability, MaterialData.class);
    }

    private Material(int id, Class data) {
        this(id, 64, data);
    }

    private Material(int id, int stack, Class data) {
        this(id, stack, 0, data);
    }

    private Material(int id, int stack, int durability, Class data) {
        this.id = id;
        this.durability = (short)durability;
        this.maxStack = stack;

        try {
            this.ctor = data.getConstructor(Integer.TYPE, Byte.TYPE);
        } catch (NoSuchMethodException var8) {
            throw new AssertionError(var8);
        } catch (SecurityException var9) {
            throw new AssertionError(var9);
        }
    }

    /** @deprecated */
    @Deprecated
    public int getId() {
        return this.id;
    }

    public int getMaxStackSize() {
        return this.maxStack;
    }

    public short getMaxDurability() {
        return this.durability;
    }

    public Class<? extends MaterialData> getData() {
        return this.ctor.getDeclaringClass();
    }

    /** @deprecated */
    @Deprecated
    public MaterialData getNewData(byte raw) {
        try {
            return (MaterialData)this.ctor.newInstance(this.id, raw);
        } catch (InstantiationException var4) {
            Throwable t = var4.getCause();
            if (t instanceof RuntimeException) {
                throw (RuntimeException)t;
            } else if (t instanceof Error) {
                throw (Error)t;
            } else {
                throw new AssertionError(t);
            }
        } catch (Throwable var5) {
            throw new AssertionError(var5);
        }
    }

    public boolean isBlock() {
        return this.id < 256;
    }

    public boolean isEdible() {
        switch (this.ordinal()) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
            case 23:
            case 24:
            case 25:
            case 26:
            case 27:
                return true;
            default:
                return false;
        }
    }

    /** @deprecated */
    @Deprecated
    public static Material getMaterial(int id) {
        return byId.length > id && id >= 0 ? byId[id] : null;
    }

    public static Material getMaterial(String name) {
        return (Material)BY_NAME.get(name);
    }

    public static Material matchMaterial(String name) {
        Validate.notNull(name, "Name cannot be null");
        Material result = null;

        try {
            result = getMaterial(Integer.parseInt(name));
        } catch (NumberFormatException var3) {
        }

        if (result == null) {
            String filtered = name.toUpperCase();
            filtered = filtered.replaceAll("\\s+", "_").replaceAll("\\W", "");
            result = (Material)BY_NAME.get(filtered);
        }

        return result;
    }

    public boolean isRecord() {
        return this.id >= GOLD_RECORD.id && this.id <= RECORD_12.id;
    }

    public boolean isSolid() {
        if (this.isBlock() && this.id != 0) {
            switch (this.ordinal()) {
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 40:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 48:
                case 49:
                case 50:
                case 51:
                case 52:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 59:
                case 60:
                case 61:
                case 62:
                case 63:
                case 64:
                case 65:
                case 66:
                case 67:
                case 68:
                case 69:
                case 70:
                case 71:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 85:
                case 86:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 94:
                case 95:
                case 96:
                case 97:
                case 98:
                case 99:
                case 100:
                case 101:
                case 102:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 117:
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 123:
                case 124:
                case 125:
                case 126:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 142:
                case 143:
                case 144:
                case 145:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 155:
                case 156:
                case 157:
                case 158:
                case 159:
                case 160:
                case 161:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                    return true;
                case 177:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                case 190:
                case 191:
                case 192:
                case 193:
                case 194:
                case 195:
                case 196:
                case 197:
                case 198:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                case 205:
                case 206:
                case 207:
                case 208:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                case 220:
                case 221:
                case 222:
                case 223:
                case 224:
                default:
                    return false;
            }
        } else {
            return false;
        }
    }

    public boolean isTransparent() {
        if (!this.isBlock()) {
            return false;
        } else {
            switch (this.ordinal()) {
                case 177:
                case 182:
                case 183:
                case 185:
                case 186:
                case 187:
                case 188:
                case 189:
                case 190:
                case 191:
                case 192:
                case 193:
                case 194:
                case 195:
                case 196:
                case 197:
                case 198:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                case 205:
                case 206:
                case 207:
                case 208:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                case 220:
                case 221:
                case 222:
                case 223:
                case 224:
                case 225:
                    return true;
                case 178:
                case 179:
                case 180:
                case 181:
                case 184:
                default:
                    return false;
            }
        }
    }

    public boolean isFlammable() {
        if (!this.isBlock()) {
            return false;
        } else {
            switch (this.ordinal()) {
                case 32:
                case 39:
                case 40:
                case 47:
                case 48:
                case 52:
                case 59:
                case 60:
                case 64:
                case 65:
                case 68:
                case 72:
                case 73:
                case 75:
                case 78:
                case 85:
                case 86:
                case 94:
                case 97:
                case 98:
                case 102:
                case 117:
                case 118:
                case 123:
                case 124:
                case 125:
                case 130:
                case 133:
                case 142:
                case 143:
                case 144:
                case 145:
                case 155:
                case 156:
                case 157:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
                case 172:
                case 173:
                case 174:
                case 175:
                case 176:
                case 185:
                case 186:
                case 208:
                case 223:
                case 224:
                    return true;
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 41:
                case 42:
                case 43:
                case 44:
                case 45:
                case 46:
                case 49:
                case 50:
                case 51:
                case 53:
                case 54:
                case 55:
                case 56:
                case 57:
                case 58:
                case 61:
                case 62:
                case 63:
                case 66:
                case 67:
                case 69:
                case 70:
                case 71:
                case 74:
                case 76:
                case 77:
                case 79:
                case 80:
                case 81:
                case 82:
                case 83:
                case 84:
                case 87:
                case 88:
                case 89:
                case 90:
                case 91:
                case 92:
                case 93:
                case 95:
                case 96:
                case 99:
                case 100:
                case 101:
                case 103:
                case 104:
                case 105:
                case 106:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 112:
                case 113:
                case 114:
                case 115:
                case 116:
                case 119:
                case 120:
                case 121:
                case 122:
                case 126:
                case 127:
                case 128:
                case 129:
                case 131:
                case 132:
                case 134:
                case 135:
                case 136:
                case 137:
                case 138:
                case 139:
                case 140:
                case 141:
                case 146:
                case 147:
                case 148:
                case 149:
                case 150:
                case 151:
                case 152:
                case 153:
                case 154:
                case 158:
                case 159:
                case 160:
                case 161:
                case 177:
                case 178:
                case 179:
                case 180:
                case 181:
                case 182:
                case 183:
                case 184:
                case 187:
                case 188:
                case 189:
                case 190:
                case 191:
                case 192:
                case 193:
                case 194:
                case 195:
                case 196:
                case 197:
                case 198:
                case 199:
                case 200:
                case 201:
                case 202:
                case 203:
                case 204:
                case 205:
                case 206:
                case 207:
                case 209:
                case 210:
                case 211:
                case 212:
                case 213:
                case 214:
                case 215:
                case 216:
                case 217:
                case 218:
                case 219:
                case 220:
                case 221:
                case 222:
                default:
                    return false;
            }
        }
    }

    public boolean isBurnable() {
        if (!this.isBlock()) {
            return false;
        } else {
            switch (this.ordinal()) {
                case 32:
                case 39:
                case 40:
                case 52:
                case 59:
                case 60:
                case 64:
                case 86:
                case 102:
                case 117:
                case 118:
                case 123:
                case 124:
                case 125:
                case 142:
                case 143:
                case 151:
                case 153:
                case 162:
                case 163:
                case 164:
                case 165:
                case 166:
                case 167:
                case 168:
                case 169:
                case 170:
                case 171:
                case 185:
                case 186:
                case 187:
                case 188:
                case 208:
                case 223:
                case 224:
                    return true;
                default:
                    return false;
            }
        }
    }

    public boolean isOccluding() {
        if (!this.isBlock()) {
            return false;
        } else {
            switch (this.ordinal()) {
                case 28:
                case 29:
                case 30:
                case 31:
                case 32:
                case 33:
                case 34:
                case 35:
                case 36:
                case 37:
                case 38:
                case 39:
                case 41:
                case 43:
                case 44:
                case 45:
                case 46:
                case 47:
                case 52:
                case 54:
                case 55:
                case 56:
                case 58:
                case 60:
                case 61:
                case 62:
                case 63:
                case 66:
                case 67:
                case 68:
                case 70:
                case 71:
                case 79:
                case 80:
                case 82:
                case 84:
                case 85:
                case 87:
                case 88:
                case 89:
                case 91:
                case 95:
                case 96:
                case 97:
                case 98:
                case 101:
                case 105:
                case 106:
                case 112:
                case 113:
                case 115:
                case 116:
                case 117:
                case 120:
                case 122:
                case 126:
                case 135:
                case 137:
                case 139:
                case 140:
                case 143:
                case 146:
                case 147:
                case 149:
                case 151:
                case 152:
                case 153:
                case 154:
                case 158:
                case 160:
                    return true;
                case 40:
                case 42:
                case 48:
                case 49:
                case 50:
                case 51:
                case 53:
                case 57:
                case 59:
                case 64:
                case 65:
                case 69:
                case 72:
                case 73:
                case 74:
                case 75:
                case 76:
                case 77:
                case 78:
                case 81:
                case 83:
                case 86:
                case 90:
                case 92:
                case 93:
                case 94:
                case 99:
                case 100:
                case 102:
                case 103:
                case 104:
                case 107:
                case 108:
                case 109:
                case 110:
                case 111:
                case 114:
                case 118:
                case 119:
                case 121:
                case 123:
                case 124:
                case 125:
                case 127:
                case 128:
                case 129:
                case 130:
                case 131:
                case 132:
                case 133:
                case 134:
                case 136:
                case 138:
                case 141:
                case 142:
                case 144:
                case 145:
                case 148:
                case 150:
                case 155:
                case 156:
                case 157:
                case 159:
                default:
                    return false;
            }
        }
    }

    public boolean hasGravity() {
        if (!this.isBlock()) {
            return false;
        } else {
            switch (this.ordinal()) {
                case 34:
                case 35:
                case 129:
                    return true;
                default:
                    return false;
            }
        }
    }

    static {
        Material[] var0;
        int var1 = (var0 = values()).length;

        for(int var2 = 0; var2 < var1; ++var2) {
            Material material = var0[var2];
            if (byId.length > material.id) {
                byId[material.id] = material;
            } else {
                byId = (Material[])Java15Compat.Arrays_copyOfRange(byId, 0, material.id + 2);
                byId[material.id] = material;
            }

            BY_NAME.put(material.name(), material);
        }

    }
}

