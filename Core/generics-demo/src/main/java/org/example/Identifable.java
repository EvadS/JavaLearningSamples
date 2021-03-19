package org.example;

import java.io.Serializable;

/**
 * Created by Evgeniy Skiba on 17.03.21
 */
interface Identifable<T extends Serializable> {
    T getID();
}
