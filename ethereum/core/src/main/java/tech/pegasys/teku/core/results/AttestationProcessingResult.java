/*
 * Copyright 2020 ConsenSys AG.
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 */

package tech.pegasys.teku.core.results;

import java.util.function.Supplier;

public enum AttestationProcessingResult {
  SUCCESSFUL,
  UNKNOWN_BLOCK,
  SAVED_FOR_FUTURE,
  INVALID;

  public AttestationProcessingResult ifSuccessful(Supplier<AttestationProcessingResult> nextStep) {
    return isSuccessful() ? nextStep.get() : this;
  }

  public boolean isSuccessful() {
    return this == SUCCESSFUL;
  }
}
