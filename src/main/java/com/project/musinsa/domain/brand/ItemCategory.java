package com.project.musinsa.domain.brand;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum ItemCategory {
    TOP("상의", 0),
    OUTER("아우터", 1),
    PANTS("바지", 2),
    SNEAKERS("스니커즈", 3),
    BAG("가방", 4),
    HAT("모자", 5),
    SOCKS("양말", 6),
    ACCESSORIES("액세서리", 7);

    private final String name;
    private final int order;
}
