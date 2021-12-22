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

import org.bukkit.inventory.ItemStack;

/**
 * @author Daniel
 */
public class TrackedItemStack {

    private static int lastId;

    private int id;
    private CustomItem base;
    private ItemStack wrapped;

    public TrackedItemStack(int id) {
        this.id = id;
        if (id > lastId) {
            lastId = id;
        }
        
    }

    public TrackedItemStack(CustomItem item, int amount) {
        id = lastId++;
        base = item;
        wrapped = item.toItemStack(amount);
    }

    public long getId() {
        return id;
    }

    public CustomItem getBase() {
        return base;
    }

    public ItemStack getWrapped() {
        return wrapped;
    }

}
