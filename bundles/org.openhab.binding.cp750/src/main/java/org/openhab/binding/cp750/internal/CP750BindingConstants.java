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
package org.openhab.binding.cp750.internal;

import org.eclipse.jdt.annotation.NonNullByDefault;
import org.openhab.core.thing.ThingTypeUID;

/**
 * The {@link CP750BindingConstants} class defines common constants, which are
 * used across the whole binding.
 *
 * @author Roland Tapken - Initial contribution
 */
@NonNullByDefault
public class CP750BindingConstants {

    private static final String BINDING_ID = "cp750";

    // List of all Thing Type UIDs
    public static final ThingTypeUID THING_TYPE_SAMPLE = new ThingTypeUID(BINDING_ID, "connection");

    // List of all Channel ids
    public static final String CHANNEL_FADER = "channel-fader";
    public static final String CHANNEL_MUTE = "channel-mute";
    public static final String CHANNEL_INPUT = "channel-input";
    public static final String CHANNEL_ANALOG = "channel-analog";
    public static final String CHANNEL_DIG1 = "channel-dig1";
    public static final String CHANNEL_DIG2 = "channel-dig2";
    public static final String CHANNEL_DIG3 = "channel-dig3";
    public static final String CHANNEL_DIG4 = "channel-dig4";
    public static final String CHANNEL_NONSYNC = "channel-nonsync";
    public static final String CHANNEL_MIC = "channel-mic";
    public static final String CHANNEL_VERSION = "channel-version";
}
