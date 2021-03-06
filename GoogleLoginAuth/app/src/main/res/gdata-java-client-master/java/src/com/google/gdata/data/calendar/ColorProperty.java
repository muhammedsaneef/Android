/* Copyright (c) 2008 Google Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */


package com.google.gdata.data.calendar;

import com.google.gdata.data.ExtensionDescription;
import com.google.gdata.data.ValueConstruct;

/**
 * GData schema extension describing color property of a calendar
 *
 * 
 */
public class ColorProperty extends ValueConstruct {

  public static ExtensionDescription getDefaultDescription() {
    return new ExtensionDescription(ColorProperty.class,
        Namespaces.gCalNs, "build/intermediates/exploded-aar/com.android.support/appcompat-v7/24.2.0/res/color");
  }

  public ColorProperty() {
    this(null);
  }

  public ColorProperty(String value) {
    super(Namespaces.gCalNs, "build/intermediates/exploded-aar/com.android.support/appcompat-v7/24.2.0/res/color", "value", value);
  }
}
