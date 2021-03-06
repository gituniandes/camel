/**
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.apache.camel.opentracing.decorators;

import org.apache.camel.Endpoint;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.assertEquals;

public class MqttSpanDecoratorTest {

    @Test
    public void testGetOperationName() {
        Endpoint endpoint = Mockito.mock(Endpoint.class);

        Mockito.when(endpoint.getEndpointUri()).thenReturn("mqtt://hello?publishTopicName=world");

        MqttSpanDecorator decorator = new MqttSpanDecorator();

        assertEquals("hello", decorator.getOperationName(null, endpoint));
    }

    @Test
    public void testGetDestinationPublish() {
        Endpoint endpoint = Mockito.mock(Endpoint.class);

        Mockito.when(endpoint.getEndpointUri()).thenReturn("mqtt://hello?publishTopicName=world");

        MqttSpanDecorator decorator = new MqttSpanDecorator();

        assertEquals("world", decorator.getDestination(null, endpoint));
    }

    @Test
    public void testGetDestinationSubscribe() {
        Endpoint endpoint = Mockito.mock(Endpoint.class);

        Mockito.when(endpoint.getEndpointUri()).thenReturn("mqtt://hello?subscribeTopicNames=world");

        MqttSpanDecorator decorator = new MqttSpanDecorator();

        assertEquals("world", decorator.getDestination(null, endpoint));
    }

}
