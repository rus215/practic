package com.rusl215.model.mapper;

import java.util.List;

/**
 * Фасад для преобразования классов
 */
public interface MapperFacade {

    /**
     * Проеобоазование source в обьект класса destinationClass
     * @param source           - объект источник
     * @param destinationClass - класс, в который преобразуется source
     * @param <S>              - тип исходного объекта
     * @param <D>              - тип объекта в который проеобразуется ихсодный объект
     * @return - экземпляр класса D с данными объекта source
     */
    <S, D> D map(S source, Class<D> destinationClass);

    /**
     * Запись данных из source объекта в destination объект
     * @param source      - объект источник
     * @param destination - объект в который запишутся данные источника
     * @param <S>         - класс источника
     * @param <D>         - класс объекта в который запишутся данные источника
     */
    <S, D> void map(S source, D destination);

    /**
     * Преобразование списков
     * @param source      - список исходный объектов
     * @param destination - класс объектов в которые запишутся данные из исходных объектов
     * @param <S>         - класс исходных объектов
     * @param <D>         - класс объектов в которые запишутся данных из source
     * @return - список объекто класса D
     */
    <S, D> List<D> mapAsList(List<S> source, Class<D> destination);
}
