package viceCity.models.guns;

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
        bulletsInBarrel = this.bulletsPerBarrel;
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()) {
            throw new NullPointerException("Name cannot be null or a whitespace!");
        }
        this.name = name;
    }

    private void setBulletsPerBarrel(int bulletsPerBarrel) {
        checkBulletsCountIsNotNegative(bulletsPerBarrel, "Bullets cannot be below zero!");
        this.bulletsPerBarrel = bulletsPerBarrel;
    }

    private void setTotalBullets(int totalBullets) {
        checkBulletsCountIsNotNegative(totalBullets, "Total bullets cannot be below zero!");
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

    public void setBulletsInBarrel(int bulletsInBarrel) {
        this.bulletsInBarrel = bulletsInBarrel;
    }

    @Override
    public int fire() {
        int bulletsToShoot = bulletsPerShot();
        if (bulletsInBarrel - bulletsToShoot < 0) {
            reload();
        }
        bulletsInBarrel -= bulletsToShoot;
        return bulletsToShoot;
    }

    private void reload() {
        int bulletsForReload = bulletsPerBarrel - bulletsInBarrel;
        if (bulletsForReload <= totalBullets) {
            bulletsInBarrel = bulletsPerBarrel;
            totalBullets -= bulletsForReload;
        } else {
            bulletsInBarrel += totalBullets;
            totalBullets = 0;
        }
    }

    protected abstract int bulletsPerShot();
}
