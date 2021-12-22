/*
 * Copyright (C) 2015-2021 Daniel Saukel.
 *
 * This library is free software: you can redistribute it and/or modify it under the
 * terms of the GNU Lesser General Public License as published by the Free Software
 * Foundation, either version 3 of the License, or (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT ANY
 * WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS FOR A
 * PARTICULAR PURPOSE. See the GNULesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 */
package de.erethon.caliburn.item;

import de.erethon.caliburn.item.actionhandler.DamageHandler;
import de.erethon.caliburn.item.actionhandler.DropHandler;
import de.erethon.caliburn.item.actionhandler.HitHandler;
import de.erethon.caliburn.item.actionhandler.RightClickHandler;
import java.util.ArrayList;
import java.util.List;

/**
 * An attribute type.
 * <p>
 * {@link de.erethon.caliburn.item.ItemAttribute.Instance} represents the attribute as it is applied to {@link TrackedItemStack}s.
 *
 * @param <V> the attribute type
 * @author Daniel
 */
public abstract class ItemAttribute<V> {

    /**
     * An instance of an attribute on a {@link TrackedItemStack}.
     */
    public class Instance {
        private V value;

        private Instance(V value) {
            this.value = value;
        }

        /**
         * Returns the attribute value.
         *
         * @return the attribute value
         */
        public V getValue() {
            return value;
        }

        /**
         * Adds the attribute to an item stack and, if necessary, updates its description.
         *
         * @param stack the item stack
         */
        public void apply(TrackedItemStack stack) {
            ItemAttribute.this.apply(this, stack);
        }
    }

    private String key;
    private final List<DamageHandler> damageHandlers = new ArrayList<>();
    private final List<DropHandler> dropHandlers = new ArrayList<>();
    private final List<HitHandler> hitHandlers = new ArrayList<>();
    private final List<RightClickHandler> rightClickHandlers = new ArrayList<>();

    public ItemAttribute(String key) {
        this.key = key;
    }

    /**
     * Returns the attribute's database key.
     *
     * @return the attribute's database key
     */
    public String getKey() {
        return key;
    }

    /* Events */
    /**
     * Returns if the attribute has a DamageHandler.
     *
     * @return if the attribute has a DamageHandler
     */
    public boolean hasDamageHandler() {
        return !damageHandlers.isEmpty();
    }

    /**
     * Returns the DamageHandlers.
     *
     * @return the DamageHandlers
     */
    public List<DamageHandler> getDamageHandlers() {
        return damageHandlers;
    }

    /**
     * Returns if the attribute has a DropHandler.
     *
     * @return if the attribute has a DropHandler
     */
    public boolean hasDropHandler() {
        return !dropHandlers.isEmpty();
    }

    /**
     * Returns the DropHandlers.
     *
     * @return the DropHandlers
     */
    public List<DropHandler> getDropHandlers() {
        return dropHandlers;
    }

    /**
     * Returns if the attribute has a HitHandler.
     *
     * @return if the attribute has a HitHandler
     */
    public boolean hasHitHandler() {
        return !hitHandlers.isEmpty();
    }

    /**
     * Returns the HitHandlers.
     *
     * @return the HitHandlers
     */
    public List<HitHandler> getHitHandlers() {
        return hitHandlers;
    }

    /**
     * Returns if the attribute has a RightClickHandler.
     *
     * @return if the attribute has a RightClickHandler
     */
    public boolean hasRightClickHandler() {
        return !rightClickHandlers.isEmpty();
    }

    /**
     * Returns the RightClickHandlers.
     *
     * @return the RightClickHandlers
     */
    public List<RightClickHandler> getRightClickHandlers() {
        return rightClickHandlers;
    }

    /**
     * Returns an {@link de.erethon.caliburn.item.ItemAttribute.Instance} of this attribute.
     *
     * @param value the value
     * @return an {@link de.erethon.caliburn.item.ItemAttribute.Instance} of this attribute
     */
    public Instance create(V value) {
        return new Instance(value);
    }

    /**
     * Adds the attribute to an item stack and, if necessary, updates its description.
     *
     * @param instance the instance
     * @param stack    the item stack
     */
    public abstract void apply(Instance instance, TrackedItemStack stack);

}
