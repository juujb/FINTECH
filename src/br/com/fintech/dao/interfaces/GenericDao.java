package br.com.fintech.dao.interfaces;

import java.util.ArrayList;

public interface GenericDao<T> {
	ArrayList<T> getAll();
	void insert(T object);
}
