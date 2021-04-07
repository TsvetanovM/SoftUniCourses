package viceCity.models.guns;

import static viceCity.common.ExceptionMessages.*;

public abstract class BaseGun implements Gun {
    private String name;
    private int bulletsPerBarrel;
    private int bulletsInBarrel;
    private int totalBullets;
    private boolean canFire;

    public BaseGun(String name, int bulletsPerBarrel, int totalBullets) {
        setName(name);
        setBulletsPerBarrel(bulletsPerBarrel);
        setTotalBullets(totalBullets);
        setBulletsInBarrel();
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException(NAME_NULL);
        }
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        checkBulletsCountIsNotNegative(bulletsPerBarrel, BULLETS_LESS_THAN_ZERO);
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        checkBulletsCountIsNotNegative(totalBullets, TOTAL_BULLETS_LESS_THAN_ZERO);
        this.totalBullets = totalBullets;
    }

    private void checkBulletsCountIsNotNegative(int bulletsCount, String s) {
        if (bulletsCount < 0) {
            throw new IllegalArgumentException(s);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public int getBulletsPerBarrel() {
        return bulletsPerBarrel;
    }

    @Override
    public boolean canFire() {
        return totalBullets > 0;
    }

    @Override
    public int getTotalBullets() {
        return totalBullets;
    }

    public int getBulletsInBarrel() {
        return bulletsInBarrel;
    }

    public void setBulletsInBarrel() {
        this.bulletsInBarrel = this.bulletsPerBarrel;
    }

    @Override
    public int fire() {
        //Todo - implement what happens when we run out of bullets
        int bulletsToShoot = bulletsPerShot();
        if (bulletsInBarrel - bulletsToShoot < 0) {
            reload();
        }
        bulletsInBarrel -= bulletsToShoot;
        return bulletsToShoot;
    }

    private void reload() {
        if (totalBullets > 0) {
            setBulletsInBarrel();
        }
    }

    protected abstract int bulletsPerShot();
}
