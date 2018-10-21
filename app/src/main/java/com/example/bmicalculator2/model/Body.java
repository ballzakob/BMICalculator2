package com.example.bmicalculator2.model;

import android.util.Log;

public class Body {
    private int height;
    private int weight;

    public Body(int height, int weight) {
        this.height = height;
        this.weight = weight;
    }

    public int getHeight() {
        return height;
    }

    public int getWeight() {
        return weight;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public float calculateBmi(){
        //bmi = kg /m^2

        float height = this.height / 100f;
        // บรรทัก 42 เติม f หลัง100 เพื่อให้ 100เป็น float
        // ถ้าใส่ 100.00 จะเป็น type double
        float bmi = this.weight / (height * height);
        return bmi;

    }
    public String getResultText(){
        float bmi =calculateBmi();
        String resultText = null;
        if (bmi < 18.5)
            resultText = "ผอมเกินไป";
        else if(bmi <25)
            resultText = "น้ำหนักปกติ";
        else if(bmi <30)
            resultText ="อ้วน";
        else
            resultText = "อ้วนมาก";
        return resultText;
    }
}
