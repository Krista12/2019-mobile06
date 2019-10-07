package id.ac.polinema.idealbodyweight.util;

public class BodyMassIndex {
    private float height;
    private float weight;
    private float index;

    public BodyMassIndex (float height, float weight){
        this.height = height;
        this.weight = weight;
        this.calculate();
    }

    private float calculate() {
        return this.index = this.weight / (this.height * this.height);}
    public String BBIdeal() {
        String b = "";
        if (this.index < 18.50) {
            b = "Underwight";
        } else if (this.index >= 18.50 && this.index <= 24.99) {
            b = "Healty Weight";
        } else if (this.index >= 25 && this.index <= 29.99) {
            b = "Pre-Obese";
        } else if (this.index >= 30 && this.index <= 34.99){
            b = "Obese class 1";
        } else if (this.index >= 40 && this.index <= 39.99) {
            b = "Obese class 2";
        } else if (this.index >= 40){
            b = "Obese class 3";
        }
        return  b;
    }
}
