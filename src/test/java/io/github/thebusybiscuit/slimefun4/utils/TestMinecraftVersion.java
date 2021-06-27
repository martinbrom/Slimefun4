package io.github.thebusybiscuit.slimefun4.utils;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import io.github.thebusybiscuit.slimefun4.api.MinecraftVersion;

class TestMinecraftVersion {

    @Test
    @DisplayName("Test if Minecraft versions match themselves")
    void testMatches() {
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_14.isMinecraftVersion(14));
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_15.isMinecraftVersion(15));
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_16.isMinecraftVersion(16));
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_17.isMinecraftVersion(17));

        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_17.isMinecraftVersion(16));
        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_16.isMinecraftVersion(15));
        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_15.isMinecraftVersion(14));
        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_14.isMinecraftVersion(0));
    }

    @Test
    @DisplayName("Test if Minecraft versions are ordered correctly (#isAtLeast)")
    void testAtLeast() {
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_16.isAtLeast(MinecraftVersion.MINECRAFT_1_14));
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_15.isAtLeast(MinecraftVersion.MINECRAFT_1_14));
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_15.isAtLeast(MinecraftVersion.MINECRAFT_1_15));

        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_15.isAtLeast(MinecraftVersion.MINECRAFT_1_16));
    }

    @Test
    @DisplayName("Test correct behaviour for (#isAtLeast) with integer overload")
    void testAtLeastNumeric() {
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_14.isAtLeast(13));
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_14.isAtLeast(14));
        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_14.isAtLeast(15));
    }

    @Test
    @DisplayName("Test correct behaviour for virtual versions (#isAtLeast)")
    void testAtLeastVirtual() {
        // Virtual versions should always fall back to false
        Assertions.assertFalse(MinecraftVersion.UNKNOWN.isAtLeast(MinecraftVersion.MINECRAFT_1_14));
        Assertions.assertFalse(MinecraftVersion.UNKNOWN.isAtLeast(MinecraftVersion.MINECRAFT_1_15));
        Assertions.assertFalse(MinecraftVersion.UNKNOWN.isAtLeast(MinecraftVersion.MINECRAFT_1_16));
        Assertions.assertFalse(MinecraftVersion.UNKNOWN.isAtLeast(MinecraftVersion.MINECRAFT_1_17));

        Assertions.assertFalse(MinecraftVersion.UNIT_TEST.isAtLeast(MinecraftVersion.MINECRAFT_1_14));
        Assertions.assertFalse(MinecraftVersion.UNIT_TEST.isAtLeast(MinecraftVersion.MINECRAFT_1_15));
        Assertions.assertFalse(MinecraftVersion.UNIT_TEST.isAtLeast(MinecraftVersion.MINECRAFT_1_16));
        Assertions.assertFalse(MinecraftVersion.UNIT_TEST.isAtLeast(MinecraftVersion.MINECRAFT_1_17));

        Assertions.assertThrows(IllegalArgumentException.class, () -> MinecraftVersion.MINECRAFT_1_14.isAtLeast(null));
    }

    @Test
    @DisplayName("Test if Minecraft versions are ordered correctly (#isBefore)")
    void testIsBefore() {
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_14.isBefore(MinecraftVersion.MINECRAFT_1_15));
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_14.isBefore(MinecraftVersion.MINECRAFT_1_16));

        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_15.isBefore(MinecraftVersion.MINECRAFT_1_15));
        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_15.isBefore(MinecraftVersion.MINECRAFT_1_14));
    }

    @Test
    @DisplayName("Test correct behaviour for (#isBefore) with integer overload")
    void testIsBeforeNumeric() {
        Assertions.assertTrue(MinecraftVersion.MINECRAFT_1_14.isBefore(15));
        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_14.isBefore(14));
        Assertions.assertFalse(MinecraftVersion.MINECRAFT_1_14.isBefore(13));
    }

    @Test
    @DisplayName("Test correct behaviour for virtual version (#isBefore)")
    void testIsBeforeVirtual() {
        // Virtual versions should always fall back to true
        Assertions.assertTrue(MinecraftVersion.UNKNOWN.isBefore(MinecraftVersion.MINECRAFT_1_14));
        Assertions.assertTrue(MinecraftVersion.UNKNOWN.isBefore(MinecraftVersion.MINECRAFT_1_15));
        Assertions.assertTrue(MinecraftVersion.UNKNOWN.isBefore(MinecraftVersion.MINECRAFT_1_16));
        Assertions.assertTrue(MinecraftVersion.UNKNOWN.isBefore(MinecraftVersion.MINECRAFT_1_17));

        Assertions.assertTrue(MinecraftVersion.UNIT_TEST.isBefore(MinecraftVersion.MINECRAFT_1_14));
        Assertions.assertTrue(MinecraftVersion.UNIT_TEST.isBefore(MinecraftVersion.MINECRAFT_1_15));
        Assertions.assertTrue(MinecraftVersion.UNIT_TEST.isBefore(MinecraftVersion.MINECRAFT_1_16));
        Assertions.assertTrue(MinecraftVersion.UNIT_TEST.isBefore(MinecraftVersion.MINECRAFT_1_17));

        Assertions.assertThrows(IllegalArgumentException.class, () -> MinecraftVersion.MINECRAFT_1_14.isBefore(null));
    }

}
