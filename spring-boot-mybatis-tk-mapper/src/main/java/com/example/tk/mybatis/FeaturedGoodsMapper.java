package com.example.tk.mybatis;

import org.apache.ibatis.annotations.*;
import org.apache.ibatis.type.JdbcType;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface FeaturedGoodsMapper extends Mapper<FeaturedGoods> {
    String FIELDS =
            "(id, channel_code, " +
                    "featured_id, featured_name, opt_name, opt_name_hash, " +
                    "self_sale, sku_id, " +
                    "goods_name, goods_image_url, " +
                    "shop_id, shop_name, " +
                    "shop_logo, wl_price, " +
                    "wl_commission_share, brand_id, " +
                    "brand_name, has_coupon, coupon_discount, price_after_coupon, " +
                    "is_hot, `order`, `state`, created_at, " +
                    "updated_at, goods_image_url_list, " +
                    "sales_volume, union_coupon)";

    String VALUES =
            "#{item.id,jdbcType=VARCHAR}, #{item.channelCode,jdbcType=VARCHAR}, " +
                    "#{item.featuredId,jdbcType=VARCHAR}, #{item.featuredName,jdbcType=VARCHAR}, #{item.optName,jdbcType=VARCHAR}, #{item.optNameHash,jdbcType=VARCHAR}, " +
                    "#{item.selfSale,jdbcType=TINYINT}, #{item.skuId,jdbcType=VARCHAR}, " +
                    "#{item.goodsName,jdbcType=VARCHAR}, #{item.goodsImageUrl,jdbcType=VARCHAR}, " +
                    "#{item.shopId,jdbcType=VARCHAR}, #{item.shopName,jdbcType=VARCHAR}, " +
                    "#{item.shopLogo,jdbcType=VARCHAR}, #{item.wlPrice,jdbcType=DECIMAL}, " +
                    "#{item.wlCommissionShare,jdbcType=DECIMAL}, #{item.brandId,jdbcType=VARCHAR}, " +
                    "#{item.brandName,jdbcType=VARCHAR}, #{item.hasCoupon,jdbcType=TINYINT}, #{item.couponDiscount,jdbcType=DECIMAL}, #{item.priceAfterCoupon,jdbcType=DECIMAL}, " +
                    "#{item.isHot,jdbcType=TINYINT}, #{item.order,jdbcType=INTEGER}, #{item.state,jdbcType=INTEGER}, #{item.createdAt,jdbcType=TIMESTAMP}, " +
                    "#{item.updatedAt,jdbcType=TIMESTAMP}, #{item.goodsImageUrlList,jdbcType=LONGVARCHAR}, " +
                    "#{item.salesVolume,jdbcType=LONGVARCHAR}, #{item.unionCoupon,jdbcType=LONGVARCHAR}";

    @Insert({
            "<script>",
            "insert into `featured_goods` ",
            FIELDS,
            "values",
            "<foreach collection='list' item='item' open='(' separator = '),(' close=')'>",
            VALUES,
            "</foreach>",
            "on duplicate key update ",
            "goods_name = values(goods_name), ",
            "wl_price = values(wl_price), ",
            "wl_commission_share = values(wl_commission_share), ",
            "coupon_discount = values(coupon_discount), ",
            "price_after_coupon = values(price_after_coupon), ",
            "sales_volume = values(sales_volume), ",
            "created_at = current_timestamp()",
            "</script>",
    })
    int insertForUpdateBatch(List<FeaturedGoods> list);

    @SelectProvider(type = FeaturedGoodsSqlProvider.class, method = "selectTopGoods")
    @Results({
            @Result(column = "number", property = "number", jdbcType = JdbcType.INTEGER),
            @Result(column = "channel_code", property = "channelCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "featured_id", property = "featuredId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "featured_name", property = "featuredName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "opt_name", property = "optName", jdbcType = JdbcType.VARCHAR),
    })
    List<TopGoodsSummary> selectTopGoods(@Param("channelCode") String channelCode, @Param("featuredId") String featuredId);

    @SelectProvider(type = FeaturedGoodsSqlProvider.class, method = "selectPriceLessThan9Point9GoodsSummary")
    @Results({
            @Result(column = "number", property = "number", jdbcType = JdbcType.INTEGER),
            @Result(column = "channel_code", property = "channelCode", jdbcType = JdbcType.VARCHAR),
            @Result(column = "featured_id", property = "featuredId", jdbcType = JdbcType.VARCHAR),
            @Result(column = "featured_name", property = "featuredName", jdbcType = JdbcType.VARCHAR),
            @Result(column = "opt_name", property = "optName", jdbcType = JdbcType.VARCHAR),
    })
    List<TopGoodsSummary> selectPriceLessThan9Point9GoodsSummary(@Param("channelCode") String channelCode, @Param("featuredIds") List<String> featuredIds);
}
