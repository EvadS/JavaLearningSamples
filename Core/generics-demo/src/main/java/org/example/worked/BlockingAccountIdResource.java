package org.example.worked;

/**
 * Created by Evgeniy Skiba on 17.03.21
 */
public class BlockingAccountIdResource<T> extends  BlockedResourceId<T> {

    private T id;

    public BlockingAccountIdResource(T id) {
        this.id = id;
    }

    @Override
    public T accountId() {
        return id;
    }
}
