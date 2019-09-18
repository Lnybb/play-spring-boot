package com.example.tk.mybatis;

import lombok.Data;

import javax.persistence.Column;
import java.math.BigDecimal;
import java.util.Date;

@Data
public class FeaturedGoods {
    private String id;

    private String channelCode;

    private String featuredId;

    private String featuredName;

    private String optName;

    private String optNameHash;

    private Boolean selfSale;

    private String skuId;

    private String goodsName;

    private String goodsImageUrl;

    private String shopId;

    private String shopName;

    private String shopLogo;

    private BigDecimal wlPrice;

    private BigDecimal wlCommissionShare;

    private String brandId;

    private String brandName;

    private Boolean hasCoupon;

    private BigDecimal couponDiscount;

    private BigDecimal priceAfterCoupon;

    private Boolean isHot;

    private Date createdAt;

    private Date updatedAt;

    private String goodsImageUrlList;

    private String salesVolume;

    private String unionCoupon;

    /**
     * 数据顺序
     */
    @Column(name = "`order`")
    private Integer order;

    /**
     * 数据状态
     */
    private Integer state;
}