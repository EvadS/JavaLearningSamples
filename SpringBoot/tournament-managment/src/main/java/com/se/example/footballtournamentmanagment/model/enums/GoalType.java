package com.se.example.footballtournamentmanagment.model.enums;

public enum GoalType {
    // Initialize the elements from Constructor.
    // The element is always final, static
    Penalty("P", "Male"), Goal("G", "Goal"), AutoGoal("A", "AutoGoal");

    private String code;
    private String text;

    // Constructor of Enum internal use only
    // Modifier of constructor is private
    // If you do not declare private, java alway understand is private.
    private GoalType(String code, String text) {
        this.code = code;
        this.text = text;
    }


    // Static method return Gender by code.
    public static GoalType getGenderByCode(String code) {
        for (GoalType gender : GoalType.values()) {
            if (gender.code.equals(code)) {
                return gender;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        if (this == Penalty) {
            return Penalty.text;
        } else if (this == Goal) {
            return Goal.text;
        }
        else if (this == AutoGoal) {
            return AutoGoal.text;
        }
        return super.toString();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    }
