package com.example.tk.mybatis;

import lombok.Data;

@Data
public class TopGoodsSummary implements Comparable<TopGoodsSummary> {
    private String channelCode;
    private String featuredId;
    private String featuredName;
    private String optName;
    private Integer number;

    @Override
    public int compareTo(TopGoodsSummary o) {
        return this.getNumber().compareTo(o.getNumber());
    }
}
