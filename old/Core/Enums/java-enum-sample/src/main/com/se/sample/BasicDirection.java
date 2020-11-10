package com.se.sample;

public enum BasicDirection  implements Direction {
    NORTH {
        @Override
        public void showDirection() {
            System.out.println("I am NORTH");
        }
    },
    SOUTH {
        @Override
        public void showDirection() {
            System.out.println("I am South");
        }
    },
    EAST {
        @Override
        public void showDirection() {
            System.out.println("I am EAST");
        }
    },
    WEST {
//        @Override
//        public void showDirection() {
//            System.out.println("I am WEST");
//        }
    };


    @Override
    public void showDirection() {
        System.out.println("default ");
    }
}
