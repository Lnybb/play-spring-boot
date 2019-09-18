package com.example.tk.mybatis;

import org.apache.ibatis.jdbc.SQL;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class FeaturedGoodsSqlProvider {
    public String selectTopGoods() {
        String s = new SQL() {{
            SELECT("count(sku_id) as number, channel_code, featured_id, featured_name, opt_name");
            FROM("featured_goods");
            WHERE("channel_code = #{channelCode}");
            WHERE("featured_id = #{featuredId}");
            WHERE("opt_name is not null");
            GROUP_BY("opt_name");
            ORDER_BY("number desc");
        }}.toString();
        s = s + " LIMIT 10";
        return s;
    }

    @SuppressWarnings("unchecked")
    public String selectPriceLessThan9Point9GoodsSummary(Map<String, Object> parameter) {
        List<String> featuredIds = (List<String>) parameter.get("featuredIds");

        List<String> collect = featuredIds.stream()
                .map(o -> "'" + o + "'")
                .collect(Collectors.toList());
        String str = String.join(",", collect);
        str = "(" + str + ")";
        String finalStr = str;

        String s = new SQL() {{
            SELECT("count(sku_id) as number, channel_code, featured_id, featured_name, opt_name");
            FROM("featured_goods");
            WHERE("channel_code = #{channelCode}");
            WHERE("featured_id in " + finalStr);
            WHERE("wl_price <= 9.9");
            WHERE("opt_name is not null");
            GROUP_BY("opt_name");
            ORDER_BY("number desc");
        }}.toString();
        s = s + " LIMIT 10";
        return s;
    }
}