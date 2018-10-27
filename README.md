# Ayte :: Utility :: Collection

Yet another collection framework for our internal needs.

Since all other solutions were not invented here, we did our own. The
ultimate goal is quite the same: tie all boilerplate operations in one
place.

Main classes this provided by this framework are AmplifiedCollections 
(since Collections is already taken), Sets, Maps and Lists, which 
expose simple but boilerplateful operations.

Look into javadoc for details.

## Common patterns

### Materialization

Materialization implies simply checking input value for null and 
returning it if it is not null / return empty instance if it is null.

### Parameterized operations

Sometimes it is necessary to perform `? extends X` operations, for
example you may want both to partition list and downgrade it's generic
type from `StringBuilder` to `CharSequence` at the same time (e.g. for
concatenation of list of strings later). Signature for such operation
would be:

```
<E> Function<List<? extends E>, List<List<E>>> partition(int size);
```

If such function would be submitted to `.map()` operation, it's not
clear what `E` should be without explicit typing. Compiler has full 
right to treat `E` as `Object`, which is probably not what you've
wanted:

```
Optional.of(stringBuilderList)
  .map(ListOperations.partition(4))
  // List<List<Object>>, this is totally legal but not very usable
  .map(lists -> ???)
```

To overcome this, you have to explicitly state `E` to compiler:

```
Optional.of(stringBuilderList)
  .map(ListOperations.<CharSequence>partition(4))
  // List<List<CharSequence>>, great success
  .map(charSequenceLists -> ???)
```

This is cumbersome, but sometimes it is just needed to evade 
`.map(x -> x)` calls and whiny unchecked casts. Since it is totally 
confusing for everyday use but sometimes required, such operations are 
packed in `ParameterizedXOperations` classes.

## Conventions

- Reduce as much boilerplate for end user as possible.
- Strive to expose all standard function-alike operations as separate
classes, so it would be easy to see what happens in debugger.
- Keep it simple and semantically correct.
- When in doubt, implement new benchmark in 
[perfomance repository][benchmark-repository].

## Licensing

MIT / Ayte Labs, 2018

  [benchmark-repository]: https://github.com/ayte-io/java-performance-breakdown
