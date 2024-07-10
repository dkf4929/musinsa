package com.project.musinsa.domain.search;

import com.project.musinsa.domain.brand.Brand;
import com.project.musinsa.domain.brand.BrandRepository;
import com.project.musinsa.domain.brand.ItemCategory;
import com.project.musinsa.domain.item.Item;
import com.project.musinsa.domain.item.ItemRepository;
import com.project.musinsa.domain.search.dto.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class SearchService {
    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;

    public List<LowestPriceCategoryResponseDto> getLowestPriceByItemCategory() {
        return Arrays.stream(ItemCategory.values())
                .flatMap(category ->
                        itemRepository.findByItemCategory(category).stream()
                                .min(Comparator.comparingInt(Item::getPrice))
                                .map(item -> {
                                    Brand brand = item.getBrand();
                                    String categoryName = category.getName();
                                    String brandName = brand.getName();
                                    int lowestPrice = item.getPrice();

                                    return LowestPriceCategoryResponseDto.of(categoryName, brandName, lowestPrice);
                                })
                                .stream()
                )
                .collect(Collectors.toList());
    }

    // 1. 모든 브랜드를 조회한다.
    // 2. 각 브랜드가 모든 상품 카테고리를 포함하는지 확인
    // 3. 최저가 브랜드 찾는다.
    // 4. 총요금 계산
   public LowestPriceResponseDto getLowestPriceByBrand() {
        LowestPriceBrandResponseDto lowestPriceBrandResponseDto = brandRepository.findAll().stream()
                .filter(brand -> {
                   // 카테고리 8개가 모두 존재하는 상품만 필터링한다.
                   List<Item> findItems = itemRepository.findByBrand(brand).stream()
                           .distinct()
                           .collect(Collectors.toList());

                   return findItems.size() == 8;
               })
                .map(this::getLowestPriceForBrand)
                .min(Comparator.comparingInt(dto -> Integer.valueOf(dto.getTotalPrice().replaceAll(",", ""))))
                .orElse(null);

        return LowestPriceResponseDto.from(lowestPriceBrandResponseDto);
    }

    public ItemPriceResponseDto getMinMaxPriceByCategory(ItemCategory itemCategory) {
        List<Item> itemList = itemRepository.findByItemCategory(itemCategory);

        Item minItem = itemList.stream()
                .min(Comparator.comparing(Item::getPrice))
                .get();

        Item maxItem = itemList.stream()
                .max(Comparator.comparing(Item::getPrice))
                .get();

        return ItemPriceResponseDto.of(itemCategory,
                BrandPriceResponseDto.of(minItem.getBrand().getName(), minItem.getPrice()),
                BrandPriceResponseDto.of(maxItem.getBrand().getName(), maxItem.getPrice()));
    }

    // 브랜드별 최저가 추출
    // 합산 요금 계산
    private LowestPriceBrandResponseDto getLowestPriceForBrand(Brand brand) {
        List<Item> items = itemRepository.findByBrand(brand);

        // 카테고리명 : 가격
        Map<String, CategoryResponseDto> minPriceItemsMap = items.stream()
                .collect(Collectors.groupingBy(
                        item -> item.getItemCategory().getName(),
                        Collectors.collectingAndThen(
                                Collectors.minBy(Comparator.comparingInt(Item::getPrice)),
                                itemOptional -> itemOptional.map(item -> CategoryResponseDto.of(
                                        item.getItemCategory().getName(),
                                        item.getPrice(),
                                        item.getItemCategory().getOrder()
                                )).orElse(null)
                        )
                ));

        List<CategoryResponseDto> lowestPrices = minPriceItemsMap.values().stream()
                .filter(dto -> dto != null)
                .sorted(Comparator.comparingInt(CategoryResponseDto::getSortNumber))
                .collect(Collectors.toList());

        int totalPrice = items.stream()
                .mapToInt(Item::getPrice)
                .sum();

        return LowestPriceBrandResponseDto.of(
                brand.getName(),
                lowestPrices,
                totalPrice
        );
    }
}
