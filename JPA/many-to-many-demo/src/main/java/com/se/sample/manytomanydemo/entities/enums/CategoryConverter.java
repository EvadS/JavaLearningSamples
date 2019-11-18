package com.se.sample.manytomanydemo.entities.enums;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.util.stream.Stream;

/**
 * Мы установили значение @ Converter для autoApply в true, чтобы JPA автоматически применял логику преобразования ко всем сопоставленным атрибутам типа Category. В противном случае нам пришлось бы поместить аннотацию @Converter непосредственно в поле сущности.
 */
@Converter(autoApply = true)
public class CategoryConverter implements AttributeConverter<Category, String> {

    @Override
    public String convertToDatabaseColumn(Category category) {
        if (category == null) {
            return null;
        }
        return category.getCode();
    }

    @Override
    public Category convertToEntityAttribute(String code) {
        if (code == null) {
            return null;
        }

        return Stream.of(Category.values())
                .filter(c -> c.getCode().equals(code))
                .findFirst()
                .orElseThrow(IllegalArgumentException::new);
    }
}
