package rocks.milspecsg.msrepository.api.repository;

import rocks.milspecsg.msrepository.api.cache.RepositoryCacheService;
import rocks.milspecsg.msrepository.model.data.dbo.ObjectWithId;

import java.util.List;
import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;

public interface Repository<TKey, T extends ObjectWithId<TKey>> {

    /**
     * Represents the default singular identifier for a {@link ObjectWithId}
     * <p>
     * Should be overridden by other plugins who change the name of the object.
     * Examples: "Clan", "Faction", "Guild", "Member", ... etc
     * </p>
     * <p>
     * Used in text sent to the player
     * </p>
     */
    String getDefaultIdentifierSingularUpper();

    /**
     * Represents the default plural identifier for a {@link ObjectWithId}
     * <p>
     * Should be overridden by other plugins who change the name of party.
     * Examples: "Clans", "Factions", "Guilds", "Members" ... etc
     * </p>
     * <p>
     * Used in text sent to the player
     * </p>
     */
    String getDefaultIdentifierPluralUpper();

    /**
     * Represents the default singular identifier for a {@link ObjectWithId}
     * <p>
     * Should be overridden by other plugins who change the name of party.
     * Examples: "clan", "faction", "guild", "member" ... etc
     * </p>
     * <p>
     * Used in text sent to the player
     * </p>
     */
    String getDefaultIdentifierSingularLower();

    /**
     * Represents the default plural identifier for a {@link ObjectWithId}
     * <p>
     * Should be overridden by other plugins who change the name of party.
     * Examples: "clans", "factions", "guilds", "members" ... etc
     * </p>
     * <p>
     * Used in text sent to the player
     * </p>
     */
    String getDefaultIdentifierPluralLower();

    /**
     * @return An empty {@link T}
     */
    T generateEmpty();

    /**
     * @param item Object to insert
     * @return The inserted item with {@link T#getId()} ()} set
     */
    CompletableFuture<Optional<T>> insertOneIntoDS(T item);

    /**
     * @param item Object to insert
     * @return The inserted item with {@link T#getId()} ()} set
     */
    CompletableFuture<Optional<T>> insertOne(T item);

    /**
     * @param id {@link TKey} to query repository with
     * @return The first item that satisfies {@link T#getId()} == {@param id}
     */
    CompletableFuture<Optional<T>> getOneFromDS(TKey id);

    /**
     * @param id {@link TKey} to query repository with
     * @return The first item that satisfies {@link T#getId()} == {@param id}
     */
    CompletableFuture<Optional<T>> getOne(TKey id);

    /**
     * @return A list of all {@link TKey} ids in the repository
     */
    CompletableFuture<List<TKey>> getAllIds();

    /**
     * Deletes the first item that satisfies {@link T#getId()} == {@param id}
     *
     * @param id {@link TKey} to query repository with
     * @return Whether or not an item was found and deleted
     */
    CompletableFuture<Boolean> deleteOneFromDS(TKey id);

    /**
     * Deletes the first item that satisfies {@link T#getId()} == {@param id}
     *
     * @param id {@link TKey} to query repository with
     * @return Whether or not an item was found and deleted
     */
    CompletableFuture<Boolean> deleteOne(TKey id);

    default Optional<? extends RepositoryCacheService<TKey, T>> getRepositoryCacheService() {
        return Optional.empty();
    }

}