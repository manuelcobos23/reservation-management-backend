/*******************************************************************************
 * 
 * Autor: manuelcobos66@gmail.com
 * 
 * © Axpe Consulting S.L. 2025. Todos los derechos reservados.
 * 
 ******************************************************************************/

package com.bookandgo.reservation.infra.api.mapper;

import java.util.List;

/**
 * Generic interface of mappers between domain and DTO Models
 * 
 * @author manuelcobos66@gmail.com
 *
 * @param <S>
 * @param <T>
 */
public interface ApplicationGenericMapper<S, T> {

	T toDTO(S s);

	S toModel(T t);

	List<T> toDTOList(List<S> sList);

	List<S> toModelList(List<T> tList);

}
