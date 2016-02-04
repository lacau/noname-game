package com.noname.server.util;

import java.util.Random;

public class MathUtils {

    private static final Random RANDOM = new Random();

    private static final int CRITICAL_RATE = 50;

    private static final float CRITICAL_POWER = 1.5f;

    private static final float DAMAGE_VARIATION = 10f;

    private MathUtils() {
        throw new IllegalStateException("MathUtils class shouldn't be instantiated!");
    }

    public static long requiredXpToLvlUp(int lvl) {
        return (long) (500.0f * (lvl * lvl / 2.0f * (lvl / 100.0f)) * 10.0f + (lvl * lvl * lvl) * 100.0f);
    }

    public static float calculateXpPercent(int charLvl, long charCurrentXp, long xpToLvlUp) {
        float percent = 0.0f;

        long lastLvlXp = requiredXpToLvlUp(charLvl - 1);
        long lvlRequiredXp = xpToLvlUp - lastLvlXp;
        long currentLvlXp = charCurrentXp - lastLvlXp;

        percent = (currentLvlXp * 100) / (float) lvlRequiredXp;

        return (float) (Math.floor(percent * 100) / 100);
    }

    public static int calculateTotalHp(int lvl, int str) {
        return str * str + (str * lvl) * lvl;
    }

    public static float calculatePDef(int lvl, int str) {
        return str * str + lvl * lvl + 10 * (lvl / 1.5f);
    }

    public static float calculatePAtk(int lvl, int str) {
        return str * 5 * (lvl / 5.2f);
    }

    public static float calculateRandomDmg(float dmg) {
        int n = RANDOM.nextInt(Float.valueOf(DAMAGE_VARIATION).intValue()) + 1;
        if(n < 5)
            return (float) (dmg + dmg * Math.random() / DAMAGE_VARIATION);
        if(n > 5)
            return (float) (dmg - dmg * Math.random() / DAMAGE_VARIATION);

        return dmg;
    }

    public static float calculateCriticalHit(float number, float percentChanceIncrease, float percentDamageIncrease) {
        float factor = CRITICAL_RATE - percentChanceIncrease * .01f * CRITICAL_RATE;
        int intFactor = Float.valueOf(factor).intValue();
        int n = 1;
        if(intFactor > 0)
            n = RANDOM.nextInt(intFactor) + 1;
        if(n == 1) {
            number = number + number * CRITICAL_POWER;
            return number + (percentDamageIncrease * .01f * number);
        }

        return number;
    }
}