/**
 * This package provides utility classes and functionality for working
 * with collections. Regular conventions are quite same: Xs class is
 * helping to deal with X, everything is exposed as static methods,
 * main purpose of the whole thing - reduce the end user common (and
 * not only common) pain.
 *
 * ## Common concepts
 *
 * ### Materialization
 *
 * Materialization corresponds to it's name very well and stands for
 * null-defense functionality of "if X is null, please kindly return me
 * empty instance of X". Materialization is exposed as
 * `Xs.materialize(X)` methods for all common collection interfaces.
 *
 * Please note that returned instances are immutable.
 *
 * ### Downcast
 *
 * From time to time end developer has to use `Generic<Y extends X>` as
 * `Generic<X>`. This is perfectly legal covariant conversion, so there
 * is no harm in doing so. To counter `(List<X>)(List) list` casts
 * as well as warning suppression, such functionality is provided in
 * `.downcast()` methods for all common interfaces.
 *
 * @see io.ayte.utility.collection.AmplifiedCollections
 * @see io.ayte.utility.collection.Lists
 * @see io.ayte.utility.collection.Maps
 * @see io.ayte.utility.collection.Sets
 * @see io.ayte.utility.collection.Queues
 * @see io.ayte.utility.collection.Deques
 * @see io.ayte.utility.collection.Iterators
 * @see io.ayte.utility.collection.Iterables
 * @see io.ayte.utility.collection.CollectionOperations
 * @see io.ayte.utility.collection.ListOperations
 * @see io.ayte.utility.collection.ParameterizedListOperations
 * @see io.ayte.utility.collection.SetOperations
 * @see io.ayte.utility.collection.MapOperations
 */
package io.ayte.utility.collection;