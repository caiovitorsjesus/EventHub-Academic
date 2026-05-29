package model;

public class Lecture extends Activity {

    public Lecture(String code, String title, int workloadHours, int maxCapacity, Speaker speaker) {
        super(code, title, workloadHours, maxCapacity, speaker);
    }

    @Override
    public double calculateCost() {
        return 0.0;
    }

    @Override
    public String getActivityType() {
        return "Lecture";
    }

    @Override
    public String toString() {
        return "Lecture{" +
                "code='" + getCode() + '\'' +
                ", title='" + getTitle() + '\'' +
                ", speaker='" + getSpeaker().getName() + '\'' +
                '}';
    }
}