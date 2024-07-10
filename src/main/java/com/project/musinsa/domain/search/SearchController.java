package com.project.musinsa.domain.search;

import com.project.musinsa.domain.brand.ItemCategory;
import com.project.musinsa.domain.search.dto.ItemPriceResponseDto;
import com.project.musinsa.domain.search.dto.LowestPriceCategoryResponseDto;
import com.project.musinsa.domain.search.dto.LowestPriceResponseDto;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Tag(name = "LOWEST PRICE SEARCH REST API", description = "검색 API")
@RequestMapping("/musinsa/api/search")
@RestController
@RequiredArgsConstructor
public class SearchController {
    private final SearchService searchService;

    @Operation(summary = "상품 추가", description = "새로운 상품을 추가합니다.")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "새로운 상품이 추가되었습니다.", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(implementation = Long.class))),
            @ApiResponse(responseCode = "400", description = "상품 저장 실패", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(example = "{ \"message\": \"입력값 검증에 실패했습니다.\" }"))),
            @ApiResponse(responseCode = "500", description = "서버 오류", content = @Content(
                    mediaType = "application/json",
                    schema = @Schema(example = "{ \"message\": \"서버 오류 발생.\" }"))),
    })
    @GetMapping("/item-categories/lowest-price")
    public List<LowestPriceCategoryResponseDto> getLowestPriceByItemCategory() {
        return searchService.getLowestPriceByItemCategory();
    }

    @GetMapping("/brand/lowest-price")
    public LowestPriceResponseDto getLowestPriceByBrand() {
        return searchService.getLowestPriceByBrand();
    }

    @GetMapping("/lowest-price/{itemCategory}")
    public ItemPriceResponseDto getMinMaxPriceByCategory(@PathVariable ItemCategory itemCategory) {
        return searchService.getMinMaxPriceByCategory(itemCategory);
    }
}
