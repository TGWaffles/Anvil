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

package org.anvilpowered.anvil.sponge.util;

import com.flowpowered.math.vector.Vector3d;
import com.google.inject.Inject;
import org.anvilpowered.anvil.api.util.TeleportationService;
import org.anvilpowered.anvil.api.util.UserService;
import org.spongepowered.api.entity.living.player.Player;
import org.spongepowered.api.entity.living.player.User;

import java.util.Optional;
import java.util.UUID;

public class SpongeTeleportationService implements TeleportationService {

    @Inject
    UserService<User, Player> userService;

    @Override
    public boolean teleport(UUID teleportingUserUUID, UUID targetUserUUID) {
        final Optional<User> teleporter = userService.get(teleportingUserUUID);
        final Optional<User> target = userService.get(targetUserUUID);

        if (!teleporter.isPresent() || !target.isPresent()) {
            return false;
        }

        return target.flatMap(User::getWorldUniqueId)
            .filter(uuid -> teleporter.get().setLocation(target.get().getPosition(), uuid))
            .isPresent();
    }

    @Override
    public Optional<String> getPosition(UUID userUUID) {
        return userService.get(userUUID).map(u -> {
            Vector3d v = u.getPosition();
            return "(" + v.getFloorX()
                + ", " + v.getFloorY()
                + ", " + v.getFloorZ() + ")";
        });
    }
}
