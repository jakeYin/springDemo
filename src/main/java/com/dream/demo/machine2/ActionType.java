package com.dream.demo.machine2;

public enum ActionType {
    APPROVE1(1), REJECT1(11),
    APPROVE2(2), REJECT2(22),
    APPROVE3(3), REJECT3(33),
    APPROVE4(4), REJECT4(44),REJECT5(55);

    private int value;
    private ActionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
