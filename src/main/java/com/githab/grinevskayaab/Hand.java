package com.githab.grinevskayaab;

import java.util.Objects;

public enum Hand {
    ROCK("Камень") {
        @Override
        public Boolean beats(Hand otherHand) {
            return Objects.equals(otherHand.getName(), SCISSORS.name);
        }
    },
    PAPER("Бумага") {
        @Override
        public Boolean beats(Hand otherHand) {
            return Objects.equals(otherHand.getName(), ROCK.name) || Objects.equals(otherHand.getName(), WELL.name);
        }
    },
        WELL("Колодец") {
        @Override
        public Boolean beats(Hand otherHand) {
            return Objects.equals(otherHand.getName(), ROCK.name) || Objects.equals(otherHand.getName(), SCISSORS.name);
        }
    },
    SCISSORS("Ножницы") {
        @Override
        public Boolean beats(Hand otherHand) {
            return Objects.equals(otherHand.getName(), PAPER.name);
        }
    };

    private final String name;

    Hand(String name) {
        this.name = name;
    }

    public abstract Boolean beats(Hand otherHand);


    public String getName() {
        return this.name;
    }

    public boolean equals(Hand otherHand) {
        return Objects.equals(otherHand.getName(), getName());
    }
}
