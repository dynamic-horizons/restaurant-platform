package net.dynamichorizons.rp.rest.service;

import java.util.List;

public interface BaseCrudWebService<K, T>
{
    public List<T> getAll();

    public T getOne( K key );

    public T create( T object );

    public T modify( K key, T object );

    public void delete( K key );
}
