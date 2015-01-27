# Serializing an object

Serialization of object is representing an object as sequence of bytes that includes the object’s data, information about the object’s type and types of data stored in the object.

ObjectInputStream and ObjectOutputStream are high-level streams that contain the methods for serializing and deserializing an object.

For a class to be serialized successfully, two conditions must be met,
* The class must implement `java.io.Serializable`
* All of the fields in the class must be serializable. If field is not serializable, it must be marked `transient`

For a JVM to be able to deserialize an object, it must be able to find the `bytecode` for the class. If the JVM can't find a class during the deserialization of an object, it throws a `ClassNotFoundException`.

The `transient` field of an object when deserialized gives a value of 0.