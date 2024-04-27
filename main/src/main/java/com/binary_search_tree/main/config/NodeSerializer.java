package com.binary_search_tree.main.config;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.binary_search_tree.main.BinarySearchTree.Node;

import java.io.IOException;

public class NodeSerializer extends JsonSerializer<Node> {

    @Override
    public void serialize(Node node, JsonGenerator jsonGenerator, SerializerProvider serializerProvider) throws IOException {
        jsonGenerator.writeStartObject();
        jsonGenerator.writeNumberField("value", node.getValue());
        if (node.getLeft() != null) {
            jsonGenerator.writeObjectField("left", node.getLeft());
        }
        if (node.getRight() != null) {
            jsonGenerator.writeObjectField("right", node.getRight());
        }
        jsonGenerator.writeEndObject();
    }
}
