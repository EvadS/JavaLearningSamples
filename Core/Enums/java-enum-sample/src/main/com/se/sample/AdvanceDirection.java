package com.se.sample;

public enum AdvanceDirection implements Direction  {
    SOUTHEAST, SOUTHWEST,NORTHEAST,NORTHWEST;

    @Override
    public void showDirection() {
        switch (this){
            case SOUTHEAST:
                System.out.println("I am SOUTH-EAST");
                break;
            case SOUTHWEST:
                System.out.println("I am SOUTH-WEST");
                break;
            case NORTHEAST:
                System.out.println("I am NORTH-EAST");
                break;
            case NORTHWEST:
                System.out.println("I am NORTH-WEST");
                break;
        }
    }
}
