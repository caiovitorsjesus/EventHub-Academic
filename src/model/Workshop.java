package model;

import utils.ValidationUtils;

public class Workshop extends Activity {

    private double materialCost;

    private double[] ratings;

    private int ratingsCount;

    public Workshop(String code, String title, int workloadHours, int maxCapacity, Speaker speaker, double materialCost) {
        super(code, title, workloadHours, maxCapacity, speaker);
        setMaterialCost(materialCost);
        ratings = new double[5];
        ratingsCount = 0;
    }

    @Override
    public double calculateCost() {
        return materialCost;
    }

    @Override
    public String getActivityType() {
        return "Workshop";
    }

    public boolean addRating(double rating) {
        if (ratingsCount >= ratings.length) {
            return false;
        }
        ratings[ratingsCount] = rating;
        ratingsCount++;
        return true;
    }

    public double calculateAverageRating() {
        if (ratingsCount == 0) {
            return 0;
        }
        double total = 0;
        for (int i = 0; i < ratingsCount; i++) {
            total += ratings[i];
        }
        return total / ratingsCount;
    }

    public double getMaterialCost() {
        return materialCost;
    }

    public void setMaterialCost(double materialCost) {
        ValidationUtils.validatePositiveNumber(materialCost, "Material Cost");
        this.materialCost = materialCost;
    }

    @Override
    public String toString() {
        return "Workshop: " +
                "code='" + getCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", materialCost=" + materialCost +
                ", averageRating=" + calculateAverageRating();
    }
}