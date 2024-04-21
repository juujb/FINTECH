package br.com.fintech.dao.interfaces;

import java.util.List;

public interface GenericDao<T> {
	List<T> getAll();
	void insert(T object);
}
