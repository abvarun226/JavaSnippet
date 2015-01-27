# ByteBuffer

`ByteBuffer` is an abstract class and extends `Buffer` class. This class is defined in the `java.nio` package.

A buffer is a container for a fixed amount of data for a specific primitive type. There is a `Buffer` class for each non-boolean primitive type. A `ByteBuffer` is a subclass of `Buffer` of `byte` primitive type.

## Direct and Non-direct Byte Buffers

For a direct byte buffer, the JVM will make a best effort to perform native I/O operations directly upon it. That is, it will attempt to avoid copying the buffer's content to an intermediate buffer before each invocation of one of the underlying operating system's native I/O operations. It is recommended that direct buffers be allocated primarily for large, long-lived buffers that are subject to the underlying system's native I/O operations.

A direct byte buffer may also be created by mapping a region of a file directly into memory

More details [here](http://examples.javacodegeeks.com/core-java/nio/bytebuffer/java-direct-bytebuffer-example/) and [here](https://docs.oracle.com/javase/7/docs/api/java/nio/ByteBuffer.html)