/**
 * Copyright (c) 2010-2024 Contributors to the openHAB project
 *
 * See the NOTICE file(s) distributed with this work for additional
 * information.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License 2.0 which is available at
 * http://www.eclipse.org/legal/epl-2.0
 *
 * SPDX-License-Identifier: EPL-2.0
 */
package org.openhab.binding.serial.internal;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.Charset;
import java.util.Arrays;
import java.util.LinkedList;

/**
 * Provides an InputStream implementation that reads from a list of byte arrays.
 *
 * @author Roland Tapken - Initial contribution
 */
public class ByteBufferInputStream extends InputStream {

    private final LinkedList<byte[]> bufferQueue = new LinkedList<>();

    int available = 0;

    int pos = 0;

    public void appendBuffer(byte[] bytes) {
        bufferQueue.add(bytes);
        available += bytes.length;
    }

    public void appendBuffer(byte[] bytes, int from, int to) {
        appendBuffer(Arrays.copyOfRange(bytes, from, to));
    }

    public void appendString(String str, Charset charset) {
        appendBuffer(str.getBytes(charset));
    }

    @Override
    public int read() throws IOException {
        if (available <= 0) {
            throw new IOException("Nothing to read, on a socket input stream this would block");
        }

        byte[] buffer = bufferQueue.get(0);
        int result = buffer[pos++];
        available -= 1;
        if (pos == buffer.length) {
            bufferQueue.remove(0);
            pos = 0;
        }
        return result;
    }

    @Override
    public int available() throws IOException {
        return available;
    }
}
