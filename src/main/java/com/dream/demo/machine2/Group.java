package com.dream.demo.machine2;

import lombok.Data;

@Data
public class Group {
    private int groupId;
    private String groupName;
    private int state;
    private boolean isAdvance;

    public Group(int groupId, String groupName) {
        this.groupId = groupId;
        this.groupName = groupName;
    }
}
