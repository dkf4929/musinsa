package com.project.musinsa.domain.brand;

import com.project.musinsa.domain.brand.dto.BrandSaveRequestDto;
import com.project.musinsa.domain.brand.dto.BrandUpdateRequestDto;
import com.project.musinsa.global.exception.DuplicationDataException;
import com.project.musinsa.global.exception.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BrandService {
    private final BrandRepository brandRepository;

    private Brand findById(Long id) {
        return brandRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("해당 브랜드를 찾을 수 없습니다."));
    }

    public Long saveBrand(BrandSaveRequestDto requestDto) {
        Brand brand = null;

        try {
            brand = brandRepository.save(Brand.create(requestDto));
        } catch (DataIntegrityViolationException e) {
            throw new DuplicationDataException("중복 데이터가 삽입되었습니다.");
        }

        return brand.getId();
    }

    public void updateBrand(BrandUpdateRequestDto requestDto) {
        Brand findEntity = findById(requestDto.getBrandId());

        try {
            findEntity.updateBrand(requestDto);
        } catch (DataIntegrityViolationException e) {
            throw new DuplicationDataException("중복 데이터가 존재합니다.");
        }
    }

    public void deleteBrand(Long brandId) {
        Brand findEntity = findById(brandId);

        brandRepository.delete(findEntity);
    }
}
