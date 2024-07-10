package com.project.musinsa.domain.item;

import com.project.musinsa.domain.brand.Brand;
import com.project.musinsa.domain.brand.BrandRepository;
import com.project.musinsa.domain.brand.dto.BrandSaveRequestDto;
import com.project.musinsa.domain.brand.dto.BrandUpdateRequestDto;
import com.project.musinsa.domain.item.dto.ItemSaveRequestDto;
import com.project.musinsa.domain.item.dto.ItemUpdateRequestDto;
import com.project.musinsa.global.exception.DuplicationDataException;
import com.project.musinsa.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ItemService {
    private final ItemRepository itemRepository;
    private final BrandRepository brandRepository;

    private Item findById(Long id) {
        return itemRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 상품을 찾을 수 없습니다."));
    }

    public Long saveItem(ItemSaveRequestDto requestDto) {
        Brand brand = brandRepository.findById(requestDto.getBrandId())
                .orElseThrow(() -> new EntityNotFoundException("해당 브랜드를 찾을 수 없습니다."));

        Item savedItem = itemRepository.save(Item.create(requestDto, brand));

        return savedItem.getId();
    }

    public void updateItem(ItemUpdateRequestDto requestDto) {
        Brand brand = brandRepository.findById(requestDto.getBrandId())
                .orElseThrow(() -> new EntityNotFoundException("해당 브랜드를 찾을 수 없습니다."));

        Item item = findById(requestDto.getItemId());

        item.updateItem(requestDto, brand);
    }

    public void deleteItem(Long itemId) {
        Item findEntity = findById(itemId);

        itemRepository.delete(findEntity);
    }
}
