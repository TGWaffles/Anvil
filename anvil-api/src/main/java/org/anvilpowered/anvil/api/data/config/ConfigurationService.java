/*
 *   Anvil - AnvilPowered
 *   Copyright (C) 2020
 *
 *     This program is free software: you can redistribute it and/or modify
 *     it under the terms of the GNU Lesser General Public License as published by
 *     the Free Software Foundation, either version 3 of the License, or
 *     (at your option) any later version.
 *
 *     This program is distributed in the hope that it will be useful,
 *     but WITHOUT ANY WARRANTY; without even the implied warranty of
 *     MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 *     GNU Lesser General Public License for more details.
 *
 *     You should have received a copy of the GNU Lesser General Public License
 *     along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package org.anvilpowered.anvil.api.data.config;

import org.anvilpowered.anvil.api.data.registry.Registry;

public interface ConfigurationService extends Registry {

    /**
     * Updates the config with values from the registry. Will only update the file if changes were made
     *
     * @return {@code true} if there were updated values to save and they were saved successfully
     * otherwise {@code false}
     */
    boolean save();
}
